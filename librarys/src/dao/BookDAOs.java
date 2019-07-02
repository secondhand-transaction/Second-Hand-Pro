package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Book;
import entity.Reader1;
import utils.DBHelper;

public class BookDAOs {

	private BookDAOs() {
	}

	public static BookDAOs getInstance() {
		return new BookDAOs();
	}

	public void update(int ID ) {
		try {

			Connection c = DBHelper.getInstance().getConnection();
			String sql="update book set isborrow=?,isorder=? where ID = "+ID;
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, 0);
			ps.setInt(2, 0);
			
			ps.execute();
			DBHelper.closeConnection(c, ps, null);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public Book get(int ID1) {
		Book book=null;
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			String sql = "select * from book where ID = "+ID1;
			ResultSet rs = s.executeQuery(sql);

			
			if (rs.next()) {
				
				book=new Book();
				String author=rs.getString("author");
				String press=rs.getString("press");
				String category=rs.getString("category");
				String bookname=rs.getString("bookname");
				String version=rs.getString("version");
				String introduction=rs.getString("introduction");
				String ISBN1=rs.getString("ISBN");
				int isorder=rs.getInt("isorder");
				int isborrow=rs.getInt("isborrow");
				Date printdate=rs.getDate("printdate");
				book.setAuthor(author);
				book.setPress(press);
				book.setCategory(category);
				book.setBookname(bookname);
				book.setVersion(version);
				book.setIntroduction(introduction);
				book.setIsborrow(isborrow);
				book.setPrintdate(printdate);
				book.setID(ID1);
				book.setISBN(ISBN1);
				book.setIsorder(isorder);
			}

			DBHelper.closeConnection(c, s, rs);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}

}
