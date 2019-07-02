package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Book;
import entity.Income;
import entity.Reader;
import entity.Reader1;
import utils.DBHelper;

public class PersonInformationDAO {

	public PersonInformationDAO() {}
	
	public int getTotal() {
		int total = 0;
		try {

			Connection c = DBHelper.getInstance().getConnection();

			Statement s = c.createStatement();

			String sql = "select count(*) from historyborrow";

			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				total = rs.getInt(1);
			}
			DBHelper.closeConnection(c, s, rs);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}
	
	public int getTotalFromIncome() {
		int total = 0;
		try {

			Connection c = DBHelper.getInstance().getConnection();

			Statement s = c.createStatement();

			String sql = "select count(*) from income";

			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				total = rs.getInt(1);
			}
			DBHelper.closeConnection(c, s, rs);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}
	
	public List<Reader> list(long Stunumber) {
		List<Reader> readers = new ArrayList<Reader>();
		Reader reader = null;
		String sql = "select * from reader where stunumber = " + Stunumber;
		try {
			Connection c = DBHelper.getInstance().getConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				reader = new Reader();
				String name = rs.getString("name");
				long stunumber = rs.getLong("stunumber");
				String password = rs.getString("password");
				double fine = rs.getDouble("fine");
				String email = rs.getString("email");
				int overduebooks = rs.getInt("overduebooks");
				String address = rs.getString("address");
				int deposit = rs.getInt("deposit");

				reader.setName(name);
				reader.setStunumber(stunumber);
				reader.setPassword(password);
				reader.setFine(fine);
				reader.setEmail(email);
				reader.setOverduebooks(overduebooks);
				reader.setAddress(address);
				reader.setDeposit(deposit);
				
				readers.add(reader);
			}
			DBHelper.closeConnection(c, ps, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return readers;
	}
	
	public void payFine(long Stunumber) {
		try {

			Connection c = DBHelper.getInstance().getConnection();

			String sql = "update reader set fine = 0  where stunumber = ? ";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setLong(1,Stunumber);
			ps.execute();
			DBHelper.closeConnection(c, ps, null);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addFineRecord(Income income , int ID){
		try {

			Connection c = DBHelper.getInstance().getConnection();

			String sql = "insert into income values(?,?,?,?,?) ";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setLong(1,income.getStunumber());
			ps.setDate(2, income.getTime());
			ps.setInt(3, 1);
			ps.setDouble(4, income.getMoney());
			ps.setInt(5, ID);
			ps.execute();
			DBHelper.closeConnection(c, ps, null);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(Reader1 reader) {
		try {
			Connection c = DBHelper.getInstance().getConnection();

			String sql = "update reader set name= ?, email = ? , address = ?,deposit=? ,fine =? where stunumber = ? ";
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setString(1,reader.getName());
			ps.setString(2,reader.getEmail());
			ps.setString(3,reader.getAddress());
			ps.setInt(4,reader.getDeposit());
			ps.setDouble(5,reader.getFine());
			ps.setLong(6,reader.getStunumber());

			ps.execute();
			
			DBHelper.closeConnection(c, ps, null);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
