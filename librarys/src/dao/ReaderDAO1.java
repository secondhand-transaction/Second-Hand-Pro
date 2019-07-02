package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import domain.Setdata;
import entity.Book;
import entity.CurrentBorrow;
import entity.Reader1;
import utils.DBHelper;

public class ReaderDAO1 {

	private ReaderDAO1() {
	}

	public static ReaderDAO1 getInstance() {
		return new ReaderDAO1();
	}

	public static int getTotal() {
		int total = 0;
		try {

			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			String sql = "select count(*) from reader";
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

	public void add(Reader1 reader) {
		try {
			Connection c = DBHelper.getInstance().getConnection();
			String sql = "insert into reader values(?,null,?,?,?)";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, reader.getName());
			ps.setString(2, reader.getPassword());
			ps.setDouble(3, reader.getFine());
			ps.setString(4, reader.getEmail());
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				long id = rs.getLong(1);
				reader.setStunumber(id);
			}
			DBHelper.closeConnection(c, ps, rs);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Reader1 get(long stunumber) {
		Reader1 reader=null;
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			String sql = "select * from reader where stunumber = " + stunumber;
			ResultSet rs = s.executeQuery(sql);

			
			if (rs.next()) {
				reader=new Reader1();
				
				String name=rs.getString("name");
				String password=rs.getString("password");
				double fine=rs.getDouble("fine"); 
				String email=rs.getString("email");
				reader.setName(name);
				reader.setPassword(password);
				reader.setFine(fine);
				reader.setEmail(email);
				reader.setStunumber(stunumber);
				
			}

			DBHelper.closeConnection(c, s, rs);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return reader;
	}
	  public static void addfine(double fine, long stunumber) {
			try {

				Connection c = DBHelper.getInstance().getConnection();

				String sql = "update reader set fine = fine+? where stunumber = "+stunumber;;
				PreparedStatement ps = c.prepareStatement(sql);
				
				ps.setDouble(1,fine);		
					ps.execute();
				DBHelper.closeConnection(c, ps, null);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	
	  
	  public List<Reader1> list(int start,int count)
	  {
		  List<Reader1>reader =new ArrayList<Reader1>();
		  try{
			  Connection c = DBHelper.getInstance().getConnection();
				String sql = "select * from reader order by stunumber desc limit ?,? ";
				PreparedStatement ps = c.prepareStatement(sql);
				ps.setInt(1, start);
				ps.setInt(2, count);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					
					Reader1 reader1=new Reader1();
					String name=rs.getString("name");
					long stunumber=rs.getLong("stunumber");
					String password=rs.getString("password");
					double fine=rs.getDouble("fine");
					String email=rs.getString("email");

					String address=rs.getString("address");
					int deposit=rs.getInt("deposit");
					reader1.setName(name);
					reader1.setStunumber(stunumber);
					reader1.setPassword(password);
					reader1.setFine(fine);
					reader1.setEmail(email);

					reader1.setAddress(address);
					reader1.setDeposit(deposit);
					reader.add(reader1);
				}
				
				DBHelper.closeConnection(c, ps, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		  return reader;
		  
	  }
	  
		public List<Reader1> list0(int start,int count,long select) {
			  List<Reader1>reader =new ArrayList<Reader1>();
			try {
				Connection c = DBHelper.getInstance().getConnection();
				String sql = "select * from reader where stunumber LIKE '%"+select +"%' limit ?,? ";
				PreparedStatement ps = c.prepareStatement(sql);
				ps.setInt(1, start);
				ps.setInt(2, count);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Reader1 reader1=new Reader1();
					String name=rs.getString("name");
					System.out.println(name);
					long stunumber=rs.getLong("stunumber");
					String password=rs.getString("password");
					double fine=rs.getDouble("fine");
					String email=rs.getString("email");

					String address=rs.getString("address");
					int deposit=rs.getInt("deposit");
					reader1.setName(name);
					reader1.setStunumber(stunumber);
					reader1.setPassword(password);
					reader1.setFine(fine);
					reader1.setEmail(email);
			
					reader1.setAddress(address);
					reader1.setDeposit(deposit);
					reader.add(reader1);
				}
				DBHelper.closeConnection(c, ps, rs);

			} catch (Exception e) {
				e.printStackTrace();
			}
			return reader;
		}
	  
		public void delete(long stunumber) {
			try {

				Connection c = DBHelper.getInstance().getConnection();

				Statement s = c.createStatement();

				String sql = "delete from reader where stunumber = " +stunumber;
				System.out.println(sql);

				s.execute(sql);

				DBHelper.closeConnection(c, s, null);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		public static int getCurrent(long stunumber) {
			int total = 0;
			
			try {

				Connection c = DBHelper.getInstance().getConnection();
				Statement s = c.createStatement();

				String sql = "select * from currentborrow where stunumber = "+ stunumber;
				ResultSet rs = s.executeQuery(sql);
				
				while (rs.next()) {
					double fine=0.0;
			    	Setdata setdata= new DataDao().selectone();
			    	Timestamp borrowtime2=new Timestamp(System.currentTimeMillis());
			    	fine=(double)(((borrowtime2.getTime()-(rs.getTimestamp("borrowtime").getTime()))/(60*60*24*1000))-setdata.getDay()*1.0*setdata.getFine());
					if(fine>0)
					{
						total=1;
					}
				}
				
				System.out.println("total:11111" + total);
				

				DBHelper.closeConnection(c, s, rs);

			} catch (Exception e) {
				e.printStackTrace();
			}
			return total;
		}
		
		public List<Reader1> listfine()
		  {
			  List<Reader1>reader =new ArrayList<Reader1>();
			  try{
				  Connection c = DBHelper.getInstance().getConnection();
					String sql = "select * from reader order by stunumber";
					PreparedStatement ps = c.prepareStatement(sql);
				
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						long stunumber=rs.getLong("stunumber");
						System.out.println(stunumber);
						int total=getCurrent(stunumber);
						if(total==1)
						{
						Reader1 reader1=new Reader1();
						String name=rs.getString("name");
						
						String password=rs.getString("password");
						double fine=rs.getDouble("fine");
						String email=rs.getString("email");

						String address=rs.getString("address");
						int deposit=rs.getInt("deposit");
						reader1.setName(name);
						reader1.setStunumber(stunumber);
						reader1.setPassword(password);
						reader1.setFine(fine);
						reader1.setEmail(email);

						reader1.setAddress(address);
						reader1.setDeposit(deposit);
						reader.add(reader1);
						}
					}
					
					DBHelper.closeConnection(c, ps, rs);
				} catch (Exception e) {
					e.printStackTrace();
				}
			  return reader;
			  
		  }
		public static long[] getAllStu() {
			long[] str1=new long[100];
			try {

				Connection c = DBHelper.getInstance().getConnection();
				Statement s = c.createStatement();
				String sql = "select stunumber from reader";
				ResultSet rs = s.executeQuery(sql);
				for(int i=0;rs.next();i++)
				{
					str1[i]=rs.getLong("stunumber");
				}
				DBHelper.closeConnection(c, s, rs);

			} catch (Exception e) {
				e.printStackTrace();
			}
			return str1;
		}

	
		
}

