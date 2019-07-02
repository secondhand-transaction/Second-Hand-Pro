package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import entity.HistoryBorrow;
import utils.DBHelper;

public class HistoryBorrowDAOs {

	private HistoryBorrowDAOs() {
	}

	public static HistoryBorrowDAOs getInstance() {
		return new HistoryBorrowDAOs();
	}

	public void add(String ISBN,int ID,Timestamp borrowtime,Timestamp returntime,String bookname,long stunumber,double historyfine) {

		try {

			Connection c = DBHelper.getInstance().getConnection();

			String sql = "insert into historyborrow values(?,?,?,?,?,?,?)";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1,ISBN);
			ps.setInt(2, ID);
			ps.setTimestamp(3, borrowtime);
			ps.setTimestamp(4,returntime);
			ps.setString(5, bookname);
			ps.setLong(6, stunumber);
			ps.setDouble(7, historyfine);
			ps.execute();
			
			DBHelper.closeConnection(c, ps, null);
       
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	



}
