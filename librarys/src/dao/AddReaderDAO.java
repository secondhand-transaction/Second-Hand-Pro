package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import entity.Reader1;
import utils.DBHelper;

public class AddReaderDAO {
	
	public static void add(Reader1 reader) {

		try {

			Connection c = DBHelper.getInstance().getConnection();

			String sql = "insert into reader values(?,?,?,?,?,0,?,?)";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, reader.getName());
			ps.setLong(2, reader.getStunumber());
			ps.setString(3, reader.getPassword());
			ps.setDouble(4, reader.getFine());
			ps.setString(5, reader.getEmail());
			ps.setString(6, reader.getAddress());
			ps.setInt(7, reader.getDeposit());
			ps.execute();
			addmoney(reader.getStunumber(),reader.getDeposit());
			

			DBHelper.closeConnection(c, ps, null);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void addmoney(Long stunumber,int money  ) {

		try {

			Connection c = DBHelper.getInstance().getConnection();
            double money1 = money;
			String sql = "insert into income values(?,?,?,?,null)";
			PreparedStatement ps = c.prepareStatement(sql);
			Date current=new Date(System.currentTimeMillis());
			ps.setLong(1, stunumber);
			ps.setDate(2, current);
			ps.setInt(3,2);
			ps.setDouble(4,money1);
			ps.execute();	

			DBHelper.closeConnection(c, ps, null);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static int register(long stunumber) {
		ResultSet rs1 = null;

		int i = 0;
		System.out.println(i);
		try {

			Connection c = DBHelper.getInstance().getConnection();

			String sql1 = "select * from reader where stunumber=?";

			
			PreparedStatement ps1 = c.prepareStatement(sql1);

			
			  ps1.setLong(1, stunumber); 

			  
			  rs1 = ps1.executeQuery();

			  
			  if (rs1.next()){
			      i=1;
			  }
			   DBHelper.closeConnection(c, ps1, rs1);

			

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(i);
		}
		return i;
	} 

}
