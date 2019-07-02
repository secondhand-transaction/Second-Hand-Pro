package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import domain.CurrentBorrow;
import domain.Customer;
import domain.Setdata;
import utils.DBHelper;

public class DataDao {
	PreparedStatement ps;
	ResultSet rs;
	
	public void update(Setdata setdata) {
		try {
		Connection conn=DBHelper.getInstance().getConnection();
		String sql="update setdata set fine=?,day=?,deposit=? where id="+setdata.getId();
		ps=conn.prepareStatement(sql);
		
		ps.setDouble(1, setdata.getFine());
		ps.setInt(2, setdata.getDay());
		ps.setInt(3, setdata.getDeposit());
		
		ps.execute();
		DBHelper.closeConnection(conn, ps, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	
	public List<Setdata> findAllSetData() {
		List<Setdata> setdatas=new ArrayList<Setdata>();
		Setdata setdata=null;
		String sql = "select * from setdata";
		try {
			Connection conn = DBHelper.getInstance().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				setdata=new Setdata();
				int id=rs.getInt("id");
				double fine=rs.getDouble("fine");
				int day=rs.getInt("day");
				int deposit=rs.getInt("deposit");
				
				setdata.setId(id);
				setdata.setFine(fine);
				setdata.setDay(day);
				setdata.setDeposit(deposit);
				setdatas.add(setdata);
			}
			DBHelper.closeConnection(conn, ps, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return setdatas;
	}
	
	public Setdata findSetdataById (int id) {
		Setdata setdata=null;
		try {
			Connection conn = DBHelper.getInstance().getConnection();
			String sql = "select * from setdata where id="+id;
			ps = conn.prepareStatement(sql);
		    rs = ps.executeQuery();
		    if (rs.next()) {
				setdata=new Setdata();
				int idd=rs.getInt("id");
				double f=rs.getDouble("fine");
				int day= rs.getInt("day");
				int deposit=rs.getInt("deposit");
				
				setdata.setId(idd);
				setdata.setFine(f);
				setdata.setDay(day);
				setdata.setDeposit(deposit);
			}
		    DBHelper.closeConnection(conn, ps,rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return setdata;
	}
	
	public int getTotalData() {
		String sql = "select count(*) from setdata";
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
	
	public List<Setdata> findPageData(int startIndex, int size) {
		List<Setdata> setdatas = new ArrayList<Setdata>();
		try {
			Connection conn = DBHelper.getInstance().getConnection();
			String sql = "select * from setdata limit ?,?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, startIndex);
			ps.setInt(2, size);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Setdata setdata = new Setdata();
				int id=rs.getInt("id");
				double fine=rs.getDouble("fine");
				int day=rs.getInt("day");
				int deposit=rs.getInt("deposit");
				setdata.setId(id);
				setdata.setFine(fine);
				setdata.setDay(day);
				setdata.setDeposit(deposit);
				
				setdatas.add(setdata);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return setdatas;
	}
	public Setdata selectone() {
		Setdata setdata=null;
		try {
			Connection conn = DBHelper.getInstance().getConnection();
			String sql = "select * from setdata";
			ps = conn.prepareStatement(sql);
		    rs = ps.executeQuery();
		    if (rs.next()) {
				setdata=new Setdata();
				int idd=rs.getInt("id");
				double f=rs.getDouble("fine");
				int day= rs.getInt("day");
				int deposit=rs.getInt("deposit");
				
				setdata.setId(idd);
				setdata.setFine(f);
				setdata.setDay(day);
				setdata.setDeposit(deposit);
			}
		    DBHelper.closeConnection(conn, ps,rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return setdata;
	}
}
