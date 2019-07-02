package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import entity.Book;
import entity.CurrentBorrow;
import entity.DeleteBook;
import utils.DBHelper;

public class DeleteBookDao {

	private DeleteBookDao() {
	}

	public static DeleteBookDao getInstance() {
		return new DeleteBookDao();
	}
	
	public int getTotal() {
		int total = 0;
		try {

			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			String sql = "select count(*) from deletebook";
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
	
	  public List<DeleteBook> list(int start,int count)
	  {
		  List<DeleteBook>deletebook =new ArrayList<DeleteBook>();
		  try{
			  Connection c = DBHelper.getInstance().getConnection();
				String sql = "select * from deletebook order by ID desc limit ?,? ";
				PreparedStatement ps = c.prepareStatement(sql);
				ps.setInt(1, start);
				ps.setInt(2, count);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					
					DeleteBook deletebook1=new DeleteBook();
					String ISBN=rs.getString("ISBN");
					int ID=rs.getInt("ID");
					String bookname=rs.getString("bookname");
					int account=rs.getInt("account");
					int type=rs.getInt("type");
					deletebook1.setISBN(ISBN);
					deletebook1.setID(ID);
					deletebook1.setType(type);
					deletebook1.setBookname(bookname);
					deletebook1.setAccount(account);
					deletebook.add(deletebook1);

				}
				
				DBHelper.closeConnection(c, ps, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		  return deletebook;	  
	  }
	  
		public void add(Book book , int account , int type) {
	  
	  		try {
	  
	  			Connection c = DBHelper.getInstance().getConnection();
	  
	  			String sql = "insert into deletebook values(?,?,?,?,?)";
	  			PreparedStatement ps = c.prepareStatement(sql);
	  			ps.setString(1, book.getISBN());
	  			ps.setInt(2, book.getID());
	  			ps.setString(3, book.getBookname());
	  			ps.setInt(4, account);
	  			ps.setInt(5, type);
	  			
	  			ps.execute();
	  
	  			ResultSet rs = null;
	  			DBHelper.closeConnection(c, ps, rs);
	  
	  		} catch (Exception e) {
	  			e.printStackTrace();
	  		}
	  	}
		
}
