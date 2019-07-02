package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import domain.CurrentBorrow;
import domain.Customer;
import utils.DBHelper;

public class currentDaoImpl implements currentDao {
	PreparedStatement ps;
	ResultSet rs;
	
	@Override
	public void addCurrentBorrow(CurrentBorrow currentBorrow) {
		try {
			Connection conn = DBHelper.getInstance().getConnection();
			String sql = "insert into currentBorrows (ISBN, ID,Borrowtime,Bookname,Stunumber) values (?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, currentBorrow.getISBN());
			ps.setInt(2, currentBorrow.getID());
			ps.setDate(3, currentBorrow.getBorrowtime());
			ps.setString(4, currentBorrow.getBookname());
			ps.setInt(5, currentBorrow.getStunumber());
			
			ps.execute();
			
			DBHelper.closeConnection(conn, ps, rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void update(CurrentBorrow currentBorrow) {
		try {
			Connection conn = DBHelper.getInstance().getConnection();
			String sql = "update currentBorrows set ISBN=?,borrowtime=?,bookname=?,stunumber=? where ID="+currentBorrow.getID();
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, currentBorrow.getISBN());
			ps.setDate(3, currentBorrow.getBorrowtime());
			ps.setString(4, currentBorrow.getBookname());
			ps.setInt(5, currentBorrow.getStunumber());
			
			ps.execute();
			
			DBHelper.closeConnection(conn, ps, rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public CurrentBorrow findCurrentBorrowById(int id) {
		CurrentBorrow currentBorrow = null;
		
		try {
			Connection conn = DBHelper.getInstance().getConnection();
			String sql = "select * from currentBorrows where id="+id;
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				currentBorrow = new CurrentBorrow();
				String ISBN = rs.getString("ISBN");
				int ID = rs.getInt("ID");
				Date borrowtime = rs.getDate("borrowtime");
				String bookname = rs.getString("bookname");
				int stunumber = rs.getInt("stunumber");
				
				currentBorrow.setISBN(ISBN);
				currentBorrow.setID(ID);
//				customer.setCode(code);
				currentBorrow.setBorrowtime(borrowtime);
				currentBorrow.setBookname(bookname);
				currentBorrow.setStunumber(stunumber);
			}
			DBHelper.closeConnection(conn, ps, rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return currentBorrow;
	}

	

	@Override
	public void deleteCurrentBorrow(CurrentBorrow currentBorrow) {
		try {
			Connection conn = DBHelper.getInstance().getConnection();
			String sql = "delete from currentBorrows where id="+currentBorrow.getID();
			ps = conn.prepareStatement(sql);
			
			ps.execute();
			
			DBHelper.closeConnection(conn, ps, rs);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<CurrentBorrow> findAllCurrentBorrow() {
		List<CurrentBorrow> currentBorrows = new ArrayList<CurrentBorrow>();
		CurrentBorrow currentBorrow = null;
		String sql = "select * from currentBorrows";
		try {
			Connection conn = DBHelper.getInstance().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				currentBorrow = new CurrentBorrow();
				String ISBN = rs.getString("ISBN");
				int ID = rs.getInt("ID");
				Date borrowtime = rs.getDate("borrowtime");
				String bookname = rs.getString("bookname");
				int stunumber = rs.getInt("stunumber");
				
				currentBorrow.setISBN(ISBN);
				currentBorrow.setID(ID);
//				customer.setCode(code);
				currentBorrow.setBorrowtime(borrowtime);
				currentBorrow.setBookname(bookname);
				currentBorrow.setStunumber(stunumber);
				
				currentBorrows.add(currentBorrow);
			}
			DBHelper.closeConnection(conn, ps, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return currentBorrows;
	}

	@Override
	public List<CurrentBorrow> findPageCurrentBorrow(int startIndex, int size) {
		List<CurrentBorrow> currentBorrows = new ArrayList<CurrentBorrow>();
		try {
			Connection conn = DBHelper.getInstance().getConnection();
			String sql = "select * from currentBorrows limit ?,?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, startIndex);
			ps.setInt(2, size);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				CurrentBorrow currentBorrow = new CurrentBorrow();
				
				String ISBN = rs.getString("ISBN");
				int ID = rs.getInt("ID");
				Date borrowtime = rs.getDate("borrowtime");
				String bookname = rs.getString("bookname");
				int stunumber = rs.getInt("stunumber");
				
				currentBorrow.setISBN(ISBN);
				currentBorrow.setID(ID);
//				customer.setCode(code);
				currentBorrow.setBorrowtime(borrowtime);
				currentBorrow.setBookname(bookname);
				currentBorrow.setStunumber(stunumber);
				
				currentBorrows.add(currentBorrow);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return currentBorrows;
	}

	@Override
	public int getTotalCurrentBorrow() {
		String sql = "select count(*) from currentBorrows";
		int total = 0;
		try {
			Connection conn = DBHelper.getInstance().getConnection();
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				total = rs.getInt(1);
			}
			DBHelper.closeConnection(conn, ps, rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
	}

	@Override
	public List<CurrentBorrow> findCurrentBorrowsById(int id) {
		List<CurrentBorrow> currentBorrows = new ArrayList<CurrentBorrow>();
		CurrentBorrow currentBorrow = null;
		String sql = "select * from currentBorrows where stunumber ="+id;
		try {
			Connection conn = DBHelper.getInstance().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				currentBorrow = new CurrentBorrow();
				String ISBN = rs.getString("ISBN");
				int ID = rs.getInt("ID");
				Date borrowtime = rs.getDate("borrowtime");
				String bookname = rs.getString("bookname");
				int stunumber = rs.getInt("stunumber");
				
				currentBorrow.setISBN(ISBN);
				currentBorrow.setID(ID);
//				customer.setCode(code);
				currentBorrow.setBorrowtime(borrowtime);
				currentBorrow.setBookname(bookname);
				currentBorrow.setStunumber(stunumber);
				
				currentBorrows.add(currentBorrow);
			}
			DBHelper.closeConnection(conn, ps, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return currentBorrows;
	}

	@Override
	public int getCurrentNumById(int id) {
		String sql = "select count(ID) from currentBorrows where stunumber="+id;
		int total = 0;
		try {
			Connection conn = DBHelper.getInstance().getConnection();
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				total = rs.getInt(1);
			}
			DBHelper.closeConnection(conn, ps, rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
	}

}
