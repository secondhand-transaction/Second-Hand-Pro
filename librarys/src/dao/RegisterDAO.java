package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Announcement;
import entity.Readerx;

import utils.DBHelper;

public class RegisterDAO {

	private RegisterDAO() {
	}

	public static RegisterDAO getInstance() {
		return new RegisterDAO();
	}


	/*public void add(Readerx reader) {

		try {

			Connection c = DBHelper.getInstance().getConnection();

			String sql = "insert into reader values(?,?,?,?,null,?,null)";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, reader.getName());
			ps.setString(2, reader.getPhone());
			ps.setInt(3, reader.getStunumber());
			ps.setString(4, reader.getPassword());
			ps.setString(5, reader.getEmail());
			ps.execute();

			

			DBHelper.closeConnection(c, ps, null);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int register(int stunumber) {
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		int i = 0;
		try {

			Connection c = DBHelper.getInstance().getConnection();

			String sql1 = "select * from reader where stunumber=?";
			String sql2 = "select * from librarian where account=?";
			
			PreparedStatement ps1 = c.prepareStatement(sql1);
			PreparedStatement ps2 = c.prepareStatement(sql2);
			
			  ps1.setInt(1, stunumber); 
			  ps2.setInt(1, stunumber); 
			  
			  rs1 = ps1.executeQuery();
			  rs2 = ps2.executeQuery();
			  
			  if (rs1.next()){
				  System.out.println("hava");
			      i=1;
			  }
			  if(rs2.next()){
				  i=1;
			  }
			   DBHelper.closeConnection(c, ps1, rs1);

			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	} */
	
	public int login(String name , String password) {
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		 System.out.println(name);
		int i = 0;
		try {

			Connection c = DBHelper.getInstance().getConnection();

			String sql1 = "select * from reader where stunumber=? and password=?";
			String sql2 = "select * from librarian where account=? and password=?";
			PreparedStatement ps1 = c.prepareStatement(sql1);
			PreparedStatement ps2 = c.prepareStatement(sql2);
			  ps1.setString(1, name); 
			  ps1.setString(2, password);
			  ps2.setString(1, name); 
			  ps2.setString(2, password);
			  rs1 = ps1.executeQuery();
			  rs2 = ps2.executeQuery();
			  if (rs1.next()){
				  System.out.println("reader");
			      i=1;
			  } 
			  else if (rs2.next()){
				  System.out.println("librarian");
			      i=2;
			  } 
			  else if(name.equals("admin")&&password.equals("111111")){
				  System.out.println("admin");
				  i=3;
			  }
	
			DBHelper.closeConnection(c, ps1, rs1);
			DBHelper.closeConnection(c, ps2, rs2);
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	} 
	public Readerx get(long stunumber) {
		Readerx reader = new Readerx("1",1,"1",1,"1", 1);
		
		try {

			Connection c = DBHelper.getInstance().getConnection();

			Statement s = c.createStatement();
			Statement s1 = c.createStatement();
			String sql = "select * from reader where stunumber = " + stunumber;
			String sql1 = "select * from librarian where account = " + stunumber;
			ResultSet rs1 = s1.executeQuery(sql1);
			ResultSet rs = s.executeQuery(sql);
            		
			if (rs.next()) {
				reader = new Readerx();
				String name = rs.getString("name");
				
				String password = rs.getString("password");
				String email = rs.getString("email");
				int fine = rs.getInt("fine");
				
				
				reader.setName(name);			
				reader.setStunumber(stunumber);
				
				reader.setPassword(password);
				reader.setEmail(email);
				reader.setFine(fine);			
			}
			if (rs1.next()) {
				reader = new Readerx();
				String name = rs1.getString("name");
				
				String password = rs1.getString("password");
				String email = rs1.getString("email");
				
				
				
				reader.setName(name);			
				reader.setStunumber(stunumber);
				
				reader.setPassword(password);
				reader.setEmail(email);
							
			}
			DBHelper.closeConnection(c, s1, rs1);
			DBHelper.closeConnection(c, s, rs);
         
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reader;
	}
	public void updateIn(Readerx reader) {
		try {

			Connection c = DBHelper.getInstance().getConnection();

			String sql = "update reader set name= ?, email = ?  where stunumber = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, reader.getName());
			ps.setString(2, reader.getEmail());			
			ps.setLong(3, reader.getStunumber());

			ps.execute();

			DBHelper.closeConnection(c, ps, null);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void updatePa(Readerx reader) {
		try {

			Connection c = DBHelper.getInstance().getConnection();

			String sql = "update reader set password = ? where stunumber = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, reader.getPassword());
			ps.setLong(2, reader.getStunumber());

			ps.execute();

			DBHelper.closeConnection(c, ps, null);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public List<Announcement> geta() {
		List<Announcement> ans = new ArrayList<Announcement>();
		Announcement an = new Announcement(1,"Nothing is new!!!");
		ans.add(an);
		try {

			Connection c = DBHelper.getInstance().getConnection();

			Statement s = c.createStatement();

			String sql = "select * from Announcement " ;

			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				an = new Announcement();
				
				
				int id = rs.getInt("ID");
				
				String co = rs.getString("content");
				
				an.setID(id);
				an.setContent(co);
				ans.add(an);				
			}
           
			

			DBHelper.closeConnection(c, s, rs);
         
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ans;
	}
}
