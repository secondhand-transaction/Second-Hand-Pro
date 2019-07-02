package dao;

import entity.CurrentBorrow;
import entity.CurrentBorrow1;
import utils.DBHelper;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CurrentBorrowDAO_1 {

	public CurrentBorrowDAO_1() {}
	
	public void addCurrentBorrow(CurrentBorrow currentBorrow) {
		try {
			Connection c = DBHelper.getInstance().getConnection();
			String sql = "insert into currentborrow (ISBN, ID,Borrowtime,Bookname,Stunumber) values (?,?,?,?,?)";
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setString(1, currentBorrow.getISBN());
			ps.setInt(2, currentBorrow.getID());
			ps.setTimestamp(3, currentBorrow.getBorrowtime());
			ps.setString(4, currentBorrow.getBookname());
			ps.setLong(5, currentBorrow.getStunumber());
			
			ResultSet rs = ps.executeQuery(sql);
			
			DBHelper.closeConnection(c, ps, rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public List<CurrentBorrow1> list(long stunumber) {
		List<CurrentBorrow1> currentBorrows = new ArrayList<CurrentBorrow1>();
		CurrentBorrow currentBorrow = null;
		CurrentBorrow1 currentBorrow1 = null;
		String sql = "select * from currentborrow where stunumber = ?";
		try {
			Connection c = DBHelper.getInstance().getConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setLong(1, stunumber);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				currentBorrow = new CurrentBorrow();
				currentBorrow1 = new CurrentBorrow1();
				String ISBN = rs.getString("ISBN");
				int ID = rs.getInt("ID");
				Timestamp borrowtime = rs.getTimestamp("borrowtime");
				String bookname = rs.getString("bookname");
				Long Stunumber = rs.getLong("stunumber");

				currentBorrow.setISBN(ISBN);
				currentBorrow.setID(ID);
				currentBorrow.setBorrowtime(borrowtime);
				currentBorrow.setBookname(bookname);
				currentBorrow.setStunumber(stunumber);
				currentBorrow1.Current1_Current(currentBorrow);
				currentBorrows.add(currentBorrow1);
			}
			DBHelper.closeConnection(c, ps, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return currentBorrows;
	}
		
}
