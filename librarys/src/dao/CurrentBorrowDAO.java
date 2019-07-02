package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import entity.CurrentBorrow;
import utils.DBHelper;

public class CurrentBorrowDAO {

	private CurrentBorrowDAO() {
	}

	public static CurrentBorrowDAO getInstance() {
		return new CurrentBorrowDAO();
	}

	public int getTotal() {
		int total = 0;
		try {

			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			String sql = "select count(*) from currentborrow";
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				total = rs.getInt(1);
				
			}

			System.out.println("total:" + total);

			DBHelper.closeConnection(c, s, rs);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}


	public CurrentBorrow get(long stunumber) {
		CurrentBorrow history=null;
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			String sql = "select * from currentborrow where stunumber = " + stunumber;
			ResultSet rs = s.executeQuery(sql);

			
			if (rs.next()) {
				history=new CurrentBorrow();
				String ISBN=rs.getString("ISBN");
				int ID=rs.getInt("ID");
				Timestamp borrowtime=rs.getTimestamp("borrowtime");
				String bookname=rs.getString("bookname");
				history.setISBN(ISBN);
				history.setID(ID);
				history.setBorrowtime(borrowtime);
				history.setBookname(bookname);
				history.setStunumber(stunumber);
			}

			DBHelper.closeConnection(c, s, rs);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return history;
	}

	public CurrentBorrow get(int ID) {
		CurrentBorrow history=null;
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			String sql = "select * from currentborrow where ID = " + ID;
			ResultSet rs = s.executeQuery(sql);

			
			if (rs.next()) {
				history=new CurrentBorrow();
				String ISBN=rs.getString("ISBN");
				long stunumber=rs.getLong("stunumber");
				Timestamp borrowtime=rs.getTimestamp("borrowtime");
				String bookname=rs.getString("bookname");
				history.setISBN(ISBN);
				history.setID(ID);
				history.setBorrowtime(borrowtime);
				history.setBookname(bookname);
				history.setStunumber(stunumber);
			}

			DBHelper.closeConnection(c, s, rs);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return history;
	}

	public void add(String ISBN,int ID,Timestamp borrowtime,String bookname,long stunumber) {

		try {

			Connection c = DBHelper.getInstance().getConnection();

			String sql = "insert into currentborrow values(?,?,?,?,?)";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1,ISBN);
			ps.setInt(2, ID);
			ps.setTimestamp(3, borrowtime);
			ps.setString(4, bookname);
			ps.setLong(5, stunumber);
			ps.execute();
			
			DBHelper.closeConnection(c, ps, null);
       
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<CurrentBorrow> list(int start, int count,long stunumber1) {
		List<CurrentBorrow>history1 = new ArrayList<CurrentBorrow>();

		try {

			Connection c = DBHelper.getInstance().getConnection();
			String sql = "select * from currentborrow order by ID desc limit ?,? ";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, count);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				if(rs.getLong("stunumber")==stunumber1){
				CurrentBorrow history2 = new CurrentBorrow();
				String ISBN=rs.getString("ISBN");
				int ID=rs.getInt("ID");
				Timestamp borrowtime=rs.getTimestamp("borrowtime");
				String bookname=rs.getString("bookname");
				history2.setISBN(ISBN);
				history2.setID(ID);
				history2.setBorrowtime(borrowtime);
				history2.setBookname(bookname);
				history2.setStunumber(stunumber1);
				history1.add(history2);}
			}
			DBHelper.closeConnection(c, ps, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return history1;
	}
	
	public List<CurrentBorrow> list1(int start, int count,long stunumber2,int ID,String ISBN,Timestamp borrowtime,String bookname) {
		List<CurrentBorrow>history1 = new ArrayList<CurrentBorrow>();

		try {

			Connection c = DBHelper.getInstance().getConnection();
			String sql = "select * from currentborrow order by ID desc limit ?,? ";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, count);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				if(rs.getInt("stunumber")==stunumber2){
				CurrentBorrow history2 = new CurrentBorrow();
				history2.setISBN(ISBN);
				history2.setID(ID);
				history2.setBorrowtime(borrowtime);
				history2.setBookname(bookname);
				history2.setStunumber(stunumber2);
				history1.add(history2);}
			}
			DBHelper.closeConnection(c, ps, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return history1;
	}
	public void update1(int ID ) {
		try {

			Connection c = DBHelper.getInstance().getConnection();
			String sql="update book set isborrow=?,isorder=? where ID = "+ID;
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, 1);
			ps.setInt(2, 1);
			
			ps.execute();
			DBHelper.closeConnection(c, ps, null);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void delete(int ID) {
		try {

			Connection c = DBHelper.getInstance().getConnection();

			Statement s = c.createStatement();

			String sql = "delete from currentborrow where ID = " + ID ;

			s.execute(sql);

			DBHelper.closeConnection(c, s, null);

		} catch (Exception e) {
			e.printStackTrace();
		}
		update1(ID);
	}

}

