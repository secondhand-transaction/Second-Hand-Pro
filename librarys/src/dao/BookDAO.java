package dao;


import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entity.Book;
import entity.Book1;
import utils.DBHelper;
import java.sql.Date;

public class BookDAO {
	private BookDAO() {
	}

	public static BookDAO getInstance() {
		return new BookDAO();
	}
	public static int getTotal() {
		int total = 0;
		try {

			Connection c = DBHelper.getInstance().getConnection();

			Statement s = c.createStatement();

			String sql = "select count(distinct ISBN) from book";

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
	public static int getTotal1(String selectL) {
		int total = 0;
		try {

			Connection c = DBHelper.getInstance().getConnection();

			Statement s = c.createStatement();

			String sql = "select count(distinct ISBN) from book where bookname LIKE '%"+selectL+"%' or ID LIKE '%"+selectL+"%'";

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
	public static int getTotal4(String ISBN) {
		int total = 0;
		try {

			Connection c = DBHelper.getInstance().getConnection();

			Statement s = c.createStatement();

			String sql = "select count(*) from book where ISBN = "+ISBN;

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
	public static int getTotal2() {
		int total = 0;
		try {

			Connection c = DBHelper.getInstance().getConnection();

			Statement s = c.createStatement();

			String sql = "select count(*) from book";

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
	public static int getTotal3() {
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
	public static String getRandom(int length){
		String val = "";
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			val += String.valueOf(random.nextInt(10));
		}
		return val;
	}
	public static String add(entity.Book book,int number) {
	 	int ID = 0;
	 	int i=0;
	 	String isbn=getRandom(13);
	 	String ISBN=null;
	 	try {
	 		for(i=0;i<number;i++){
	Connection c = DBHelper.getInstance().getConnection();

	String sql = "insert into Book values(?,?,?,?,?,?,?,?,1,?,1,?,?)";
	PreparedStatement ps = c.prepareStatement(sql);
	if(book.getISBN()!=null&&!book.getISBN().equals(""))
	{
	ps.setString(1, book.getISBN());
	ISBN=book.getISBN();
	}
	else{
		
		ps.setString(1, isbn);
		ISBN=isbn;
	}
	Connection c1 = DBHelper.getInstance().getConnection();
	Statement s = c1.createStatement();
	String str="select max(ID) from book";

	ResultSet rs = s.executeQuery(str);



	while (rs.next()) {
	ID = rs.getInt(1);

	}
	           ID++;

	           
	ps.setInt(2,ID);
	ps.setString(3, book.getAuthor());
	            ps.setString(4,book.getPress() );
	            ps.setString(5,book.getCategory() );
	            ps.setString(6,book.getBookname() );
	            ps.setString(7,book.getVersion() );
	            ps.setString(8,book.getIntroduction() );
	            ps.setDate(9,book.getPrintdate() );
	            ps.setString(10, book.getLocation());
	            ps.setDouble(11, book.getPrice());
	ps.execute();

	ResultSet rs1 = null;
	DBHelper.closeConnection(c, ps, rs1);
	DBHelper.closeConnection(c1, s, rs);
	 		}
	} catch (Exception e) {
	e.printStackTrace();
	} 	
	 	return ISBN;
	}

	
	
	public void update(Book book) {
		try {

			Connection c = DBHelper.getInstance().getConnection();

			String sql = "update book set author= ?, press = ? , category = ?,bookname=? ,version =?,introduction=?,isborrow=?,printdate=?,isorder=?,location=? where ISBN = ? and ID =?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, book.getAuthor());
			ps.setString(2,book.getPress() );
			ps.setString(3,book.getCategory() );
			ps.setString(4,book.getBookname() );
			ps.setString(5,book.getVersion() );
			ps.setString(6,book.getIntroduction() );
			ps.setInt(7,book.getIsborrow() );
			ps.setDate(8,book.getPrintdate() );
			ps.setInt(9,book.getIsorder() );
			ps.setString(10, book.getLocation());
			ps.setString(11,book.getISBN() );
			ps.setInt(12,book.getID() );
			
			ps.execute();

			DBHelper.closeConnection(c, ps, null);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	public void delete1(String ISBN) {
		try {

			Connection c = DBHelper.getInstance().getConnection();

			Statement s = c.createStatement();

			String sql = "delete from book where ISBN = " +ISBN;

			s.execute(sql);

			DBHelper.closeConnection(c, s, null);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Book get(String ISBN,int ID) {
		Book book = null;
		try {

			Connection c = DBHelper.getInstance().getConnection();

			Statement s = c.createStatement();

			String sql = "select * from book where ISBN = " +ISBN+"and ID ="+ID;

			ResultSet rs = s.executeQuery(sql);

			if (rs.next()) {
				book = new Book();
				String author = rs.getString("author");
				String press = rs.getString("press");
				String category = rs.getString("category");
				String bookname = rs.getString("bookname");
				String version = rs.getString("version");
				String introduction = rs.getString("introduction");
				int isborrow = rs.getInt("isborrow");
				Date printdate = rs.getDate("printdate");
				int isorder=rs.getInt("isorder");
				String location=rs.getString("location");
				book.setAuthor(author);
				book.setPress(press);
				book.setCategory(category);
				book.setBookname(bookname);
				book.setVersion(version);
				book.setIntroduction(introduction);
				book.setIsborrow(isborrow);
				book.setPrintdate(printdate);
				book.setIsorder(isorder);
				book.setLocation(location);
				book.setISBN(ISBN);
				book.setID(ID);
				
			}

			DBHelper.closeConnection(c, s, rs);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	public List<Book> list() {
		return list(0, Short.MAX_VALUE);
	}
	public static List<Book> list(int start, int count) {
		List<Book> books = new ArrayList<Book>();

		try {

			Connection c = DBHelper.getInstance().getConnection();

			String sql = "select distinct ISBN,author,press,category,bookname,version,introduction,printdate from book order by id desc limit ?,? ";

			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, count);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Book book=new Book();
				String ISBN=rs.getString("ISBN");
			//	int ID=rs.getInt("ID");
				String author = rs.getString("author");
				String press = rs.getString("press");
				String category = rs.getString("category");
				String bookname = rs.getString("bookname");
				String version = rs.getString("version");
				String introduction = rs.getString("introduction");
			//	int isborrow = rs.getInt("isborrow");
				Date printdate = rs.getDate("printdate");
			//	int isorder=rs.getInt("isorder");
			//	String location=rs.getString("location");
				book.setAuthor(author);
				book.setPress(press);
				book.setCategory(category);
				book.setBookname(bookname);
				book.setVersion(version);
				book.setIntroduction(introduction);
			//	book.setIsborrow(isborrow);
				book.setPrintdate(printdate);
			//	book.setIsorder(isorder);
			//	book.setLocation(location);
				book.setISBN(ISBN);
			//	book.setID(ID);
				book.setNumber(countnumber(ISBN));
				book.setBorrownumber(countborrownumber(ISBN));
				books.add(book);
			}
			DBHelper.closeConnection(c, ps, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return books;
	}


	public static List<Book> list1(int start, int count, String name) {
		List<Book> books = new ArrayList<Book>();

		try {

			Connection c = DBHelper.getInstance().getConnection();

			String sql = "select distinct ISBN,author,press,category,bookname,version,introduction,printdate from book where bookname LIKE '%"+name+"%' or ID LIKE '%"+name+"%'order by id desc limit ?,? ";

			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, count);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Book book=new Book();
				String ISBN=rs.getString("ISBN");
			//	int ID=rs.getInt("ID");
				String author = rs.getString("author");
				String press = rs.getString("press");
				String category = rs.getString("category");
				String bookname = rs.getString("bookname");
				String version = rs.getString("version");
				String introduction = rs.getString("introduction");
			//	int isborrow = rs.getInt("isborrow");
				Date printdate = rs.getDate("printdate");
			//	int isorder=rs.getInt("isorder");
			//	String location=rs.getString("location");
				book.setAuthor(author);
				book.setPress(press);
				book.setCategory(category);
				book.setBookname(bookname);
				book.setVersion(version);
				book.setIntroduction(introduction);
			//	book.setIsborrow(isborrow);
				book.setPrintdate(printdate);
			//	book.setIsorder(isorder);
			//	book.setLocation(location);
				book.setISBN(ISBN);
			//	book.setID(ID);
				book.setNumber(countnumber(ISBN));
				book.setBorrownumber(countborrownumber(ISBN));
				books.add(book);
			}
			DBHelper.closeConnection(c, ps, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return books;
	}
	public static boolean checkISBN(String isbn)
	{
		
		boolean check=true;
		try{
			Connection c = DBHelper.getInstance().getConnection();

			Statement s = c.createStatement();
			String str="select ISBN from book";
			ResultSet rs = s.executeQuery(str);
			while (rs.next()) {
				if(rs.getString("ISBN").equals(isbn)) 
				{check=false;break;}
			}

			DBHelper.closeConnection(c, s, rs);
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		return check;
	}
	public static boolean checkID(int id)
	{
		
		boolean check=true;
		try{
			Connection c = DBHelper.getInstance().getConnection();

			Statement s = c.createStatement();
			String str="select ID from book";
			ResultSet rs = s.executeQuery(str);
			while (rs.next()) {
				if(rs.getInt("ID")==id) 
				{check=false;break;}
			}

			DBHelper.closeConnection(c, s, rs);
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		return check;
	}


public static void add(Book book) {
 	int ID = 0;
try {


Connection c = DBHelper.getInstance().getConnection();

String sql = "insert into Book values(?,?,?,?,?,?,?,?,1,?,1,?)";
PreparedStatement ps = c.prepareStatement(sql);
ps.setString(1, book.getISBN());

Connection c1 = DBHelper.getInstance().getConnection();
Statement s = c1.createStatement();
String str="select max(ID) from book where ISBN = "+book.getISBN();

ResultSet rs = s.executeQuery(str);



while (rs.next()) {
ID = rs.getInt(1);

}
           ID++;

           
ps.setInt(2,ID);
ps.setString(3, book.getAuthor());
            ps.setString(4,book.getPress() );
            ps.setString(5,book.getCategory() );
            ps.setString(6,book.getBookname() );
            ps.setString(7,book.getVersion() );
            ps.setString(8,book.getIntroduction() );
            ps.setDate(9,book.getPrintdate() );
            ps.setString(10, book.getLocation());
ps.execute();

ResultSet rs1 = null;
DBHelper.closeConnection(c, ps, rs1);
DBHelper.closeConnection(c1, s, rs);

} catch (Exception e) {
e.printStackTrace();
}
}


public void update1(Book book) {
	try {
		Connection c = DBHelper.getInstance().getConnection();

		String sql = "update book set author= ?, press = ? , category = ?,bookname=? ,version =?,introduction=?,isborrow=?,printdate=?,isorder=?,price=? where ISBN = ? ";
		PreparedStatement ps = c.prepareStatement(sql);
		String str = book.getAuthor();
		ps.setString(1,book.getAuthor());
		ps.setString(2,book.getPress() );
		ps.setString(3,book.getCategory() );
		ps.setString(4,book.getBookname() );
		ps.setString(5,book.getVersion() );
		ps.setString(6,book.getIntroduction() );
		ps.setInt(7,book.getIsborrow() );
		ps.setDate(8,book.getPrintdate() );
		ps.setInt(9,book.getIsorder() );
		ps.setDouble(10, book.getPrice());
		ps.setString(11,book.getISBN() );

		if(str!=null){
			ps.execute();
		}
		DBHelper.closeConnection(c, ps, null);

	} catch (Exception e) {
		e.printStackTrace();
	}

}
public void update2(Book book) {
	try {
		Connection c = DBHelper.getInstance().getConnection();

		String sql = "update book set location=?,price=? where ISBN = ? and ID = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		String str = book.getAuthor();
		ps.setString(1, book.getLocation());
		ps.setString(2,book.getISBN());
		ps.setInt(3, book.getID());
		if(str!=null){
			ps.execute();
		}
		DBHelper.closeConnection(c, ps, null);

	} catch (Exception e) {
		e.printStackTrace();
	}

}

public void update3(Book book) {
	try {
		Connection c = DBHelper.getInstance().getConnection();

		String sql = "update book set location=? where ISBN = ? and ID = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, book.getLocation());
		ps.setString(2,book.getISBN());
		ps.setInt(3, book.getID());
		ps.execute();
		DBHelper.closeConnection(c, ps, null);

	} catch (Exception e) {
		e.printStackTrace();
	}

}


public void delete(String ISBN,int ID) {
	try {

		Connection c = DBHelper.getInstance().getConnection();

		Statement s = c.createStatement();

		String sql = "delete from book where ISBN = " +ISBN+" and ID = "+ID;

		s.execute(sql);

		DBHelper.closeConnection(c, s, null);

	} catch (Exception e) {
		e.printStackTrace();
	}
}


public static int countnumber(String ISBN)
{
	int number=0;
	try{
	Connection c = DBHelper.getInstance().getConnection();

	Statement s = c.createStatement();
	String str="select count(ID) from book where ISBN = "+ISBN;
	
	ResultSet rs = s.executeQuery(str);
	while (rs.next()) {
		number = rs.getInt(1);
	}

	DBHelper.closeConnection(c, s, rs);
	
	} catch (Exception e) {
		e.printStackTrace();
	}
	return number;
}

public static int countborrownumber(String ISBN)
{
	int number=0;
	try{
	Connection c = DBHelper.getInstance().getConnection();

	Statement s = c.createStatement();
	String str="select count(ID) from book where ISBN = "+ISBN+" and isborrow = 1";
	ResultSet rs = s.executeQuery(str);
	while (rs.next()) {
		number = rs.getInt(1);
	}
	DBHelper.closeConnection(c, s, rs);
	
	} catch (Exception e) {
		e.printStackTrace();
	}
	return number;
}



public static List<Book1> list2(String ISBN) {
	List<Book1> books = new ArrayList<Book1>();

	try {

		Connection c = DBHelper.getInstance().getConnection();

		String sql = "select * from book where ISBN = ? ";

		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, ISBN);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Book book=new Book();
			Book1 book1 = new Book1();
			int ID=rs.getInt("ID");
			String author = rs.getString("author");
			String press = rs.getString("press");
			String category = rs.getString("category");
			String bookname = rs.getString("bookname");
			String version = rs.getString("version");
			String introduction = rs.getString("introduction");
			int isborrow = rs.getInt("isborrow");
			Date printdate = rs.getDate("printdate");
			int isorder=rs.getInt("isorder");
			String location=rs.getString("location");
			double price = rs.getDouble("price");
			book.setAuthor(author);
			book.setPress(press);
			book.setCategory(category);
			book.setBookname(bookname);
			book.setVersion(version);
			book.setIntroduction(introduction);
			book.setIsborrow(isborrow);
			book.setPrintdate(printdate);
			book.setIsorder(isorder);
			book.setLocation(location);
			book.setISBN(ISBN);
			book.setID(ID);
			book.setNumber(countnumber(ISBN));
			book.setBorrownumber(countborrownumber(ISBN));
			book.setPrice(price);
			book1.Book1_Book(book);
			books.add(book1);
		}
		DBHelper.closeConnection(c, ps, rs);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return books;
}

public static String[] floor() {
String[] floor = new String[10];

	try {

		Connection c = DBHelper.getInstance().getConnection();

		String sql = "select * from floor";

		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		int i=0;
		while (rs.next()) {
			floor[i]=rs.getString("floor");
			i++;
		}
		DBHelper.closeConnection(c, ps, rs);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return floor;
}

public static String[] area() {
String[] area = new String[10];

	try {

		Connection c = DBHelper.getInstance().getConnection();

		String sql = "select * from area";

		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		int i=0;
		while (rs.next()) {
			area[i]=rs.getString("area");
			i++;
		}
		DBHelper.closeConnection(c, ps, rs);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return area;
}

public static String[] shelf() {
String[] shelf = new String[10];

	try {

		Connection c = DBHelper.getInstance().getConnection();

		String sql = "select * from shelf";

		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		int i=0;
		while (rs.next()) {
			shelf[i]=rs.getString("shelf");
			i++;
		}
		DBHelper.closeConnection(c, ps, rs);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return shelf;
}

public static String[] category() {
String[] category = new String[10];

	try {

		Connection c = DBHelper.getInstance().getConnection();

		String sql = "select * from category";

		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		int i=0;
		while (rs.next()) {
			category[i]=rs.getString("category");
			i++;
		}
		DBHelper.closeConnection(c, ps, rs);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return category;
}

public static void addFloor(String floor) {
	try{
Connection c = DBHelper.getInstance().getConnection();

String sql="insert into floor values(?,null)";
PreparedStatement ps = c.prepareStatement(sql);
          
ps.setString(1,floor);
ps.execute();


DBHelper.closeConnection(c, ps, null);
 		}

catch (Exception e) {
e.printStackTrace();
}
}
public static void addArea(String area) {
	try{
Connection c = DBHelper.getInstance().getConnection();

String sql="insert into area values(?,null)";
PreparedStatement ps = c.prepareStatement(sql);
          
ps.setString(1,area);
ps.execute();


DBHelper.closeConnection(c, ps, null);
 		}

catch (Exception e) {
e.printStackTrace();
}
}
public static void addShelf(String shelf) {
	try{
Connection c = DBHelper.getInstance().getConnection();

String sql="insert into shelf values(?,null)";
PreparedStatement ps = c.prepareStatement(sql);
          
ps.setString(1,shelf);
ps.execute();


DBHelper.closeConnection(c, ps, null);
 		}

catch (Exception e) {
e.printStackTrace();
}
}
public static void addCategory(String category) {
	try{
Connection c = DBHelper.getInstance().getConnection();

String sql="insert into category values(?,null)";
PreparedStatement ps = c.prepareStatement(sql);
          
ps.setString(1,category);
ps.execute();


DBHelper.closeConnection(c, ps, null);
 		}

catch (Exception e) {
e.printStackTrace();
}
}
}

