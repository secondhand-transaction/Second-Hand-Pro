package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;




import entity.*;
import utils.DBHelper;

public class AReplyDAO {
	private PreparedStatement preparedStatement = null;

	private AReplyDAO() {
	}

	public static AReplyDAO getInstance() {
		return new AReplyDAO();
	}

	public int getTotal() {
		int total = 0;
		try {

			Connection c = DBHelper.getInstance().getConnection();

			Statement s = c.createStatement();

			String sql = "select count(*) from book";

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
	
	
	
	

	public void add(Reply reply) {

		try {

			Connection c = DBHelper.getInstance().getConnection();

			String sql = "insert into reply values(?,?,?,?,null)";
			PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, reply.getName());
			ps.setTimestamp(2, reply.getReplytime());
			ps.setString(3, reply.getContent());
            ps.setLong(4, reply.getStunumber());
			ps.execute();
            
			ResultSet rs = ps.getGeneratedKeys();

     
			DBHelper.closeConnection(c, ps, rs);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public List<Book> list(int start, int count) {
		List<Book> books = new ArrayList<Book>();

		try {

			Connection c = DBHelper.getInstance().getConnection();

			String sql = "select distinct ISBN,bookname,author from book order by id desc limit ?,? ";

			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, count);
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Book book = new Book();
				String ISBN = rs.getString("ISBN");
				String bookname = rs.getString("bookname");
				String author = rs.getString("author");
				book.setISBN(ISBN);
				book.setBookname(bookname);
				book.setAuthor(author);
				
				books.add(book);
				
			}
			
			DBHelper.closeConnection(c, ps, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return books;
	}		
	
	
	public List<Book> select(int start, int count,String slt) throws Exception {
		 List<Book> books = new ArrayList<Book>();
		 
		 try {
		 String sql = "select distinct ISBN,bookname,author from book where bookname like ? limit ?,? ";
		    
		    Connection c = DBHelper.getInstance().getConnection();
		    PreparedStatement ps = c.prepareStatement(sql);
		    ps.setInt(2, start);
			ps.setInt(3, count);
			ps.setString(1, "%"+slt+"%");
		    
		   
          
		    ResultSet rs = ps.executeQuery();
		    
		    while (rs.next()) {
		    	Book book = new Book();
		    	String ISBN = rs.getString("ISBN");
				String bookname = rs.getString("bookname");
				String author = rs.getString("author");
				
	        	
				book.setISBN(ISBN);
				book.setBookname(bookname);
				book.setAuthor(author);
				books.add(book);
		    }
		    
		    DBHelper.closeConnection(c, ps, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}

		    return books;
		  }
	 
	 public List<Book> select1(int start, int count,String slt) throws Exception {
		 List<Book> books = new ArrayList<Book>();
		 
		 String sql = "select distinct ISBN,bookname,author from book where author like '%"+slt+"%' limit ?,?";
		   
		    Connection c = DBHelper.getInstance().getConnection();
		    preparedStatement = c.prepareStatement(sql);
		    preparedStatement.setInt(1, start);
		    preparedStatement.setInt(2, count);
		    
		   
		 
		   
		    ResultSet rs = preparedStatement.executeQuery();
		    while (rs.next()) {
		    	Book book = new Book();
		    	String ISBN = rs.getString("ISBN");
				String bookname = rs.getString("bookname");
				String author = rs.getString("author");
				
				book.setISBN(ISBN);
				book.setBookname(bookname);
				book.setAuthor(author);
				books.add(book);
		    }
		    DBHelper.closeConnection(c, null, rs);
		    return books;
		  }
	 
	 public List<Book> select2(int start, int count,String slt) throws Exception {
		 List<Book> books = new ArrayList<Book>();
		 
		 String sql = "select distinct ISBN,bookname,author,press,category from book where ISBN like '%"+slt+"%' limit ?,? ";
		   
		    Connection c = DBHelper.getInstance().getConnection();
		    preparedStatement = c.prepareStatement(sql);
		    preparedStatement.setInt(1, start);
		    preparedStatement.setInt(2, count);
		    
		   
		 
		   
		    ResultSet rs = preparedStatement.executeQuery();
		    while (rs.next()) {
		    	Book book = new Book();
		    	String ISBN = rs.getString("ISBN");
				String bookname = rs.getString("bookname");
				String author = rs.getString("author");
				
				book.setISBN(ISBN);
				book.setBookname(bookname);
				book.setAuthor(author);
				books.add(book);
		    }
		    DBHelper.closeConnection(c, null, rs);
		    return books;
		  }
	 
	 public List<Book> select3(int start, int count,String slt) throws Exception {
		 List<Book> books = new ArrayList<Book>();
		 
		 String sql = "select distinct ISBN,bookname,author from book where press like '%"+slt+"%' limit ?,?";
		   
		    Connection c = DBHelper.getInstance().getConnection();
		    preparedStatement = c.prepareStatement(sql);
		    preparedStatement.setInt(1, start);
		    preparedStatement.setInt(2, count);
		    
		   
		 
		   
		    ResultSet rs = preparedStatement.executeQuery();
		    while (rs.next()) {
		    	Book book = new Book();
		    	String ISBN = rs.getString("ISBN");
				String bookname = rs.getString("bookname");
				String author = rs.getString("author");
				
				book.setISBN(ISBN);
				book.setBookname(bookname);
				book.setAuthor(author);
				books.add(book);
		    }
		    DBHelper.closeConnection(c, null, rs);
		    return books;
		  }
	 
	 public List<Book> select4(int start, int count,String f) throws Exception {
		 List<Book> books = new ArrayList<Book>();
		 
		 String sql = "select distinct ISBN,bookname,author from book where category = ? limit ?,?";
		   
		    Connection c = DBHelper.getInstance().getConnection();
		    preparedStatement = c.prepareStatement(sql);
		    preparedStatement.setString(1, f);
		    preparedStatement.setInt(2, start);
		    preparedStatement.setInt(3, count);
		    
		   
		 
		   
		    ResultSet rs = preparedStatement.executeQuery();
		    while (rs.next()) {
		    	Book book = new Book();
		    	String ISBN = rs.getString("ISBN");
				String bookname = rs.getString("bookname");
				String author = rs.getString("author");
				System.out.println("yes");
				book.setISBN(ISBN);
				book.setBookname(bookname);
				book.setAuthor(author);
				books.add(book);
		    }
		    DBHelper.closeConnection(c, null, rs);
		    return books;
		  }
}
