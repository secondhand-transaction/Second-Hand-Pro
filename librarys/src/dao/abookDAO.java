package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.xml.crypto.Data;

import entity.aBook;
import entity.acurrent;
import entity.ahistorycurrent;
import utils.DBHelper;

public class abookDAO {

	private abookDAO() {
	}

	public static abookDAO getInstance() {
		return new abookDAO();
	}

	public int getTotal(String ISBN) {
		int total = 0;

		try {

			Connection c = DBHelper.getInstance().getConnection();

			Statement s = c.createStatement();

			String sql = "select count(*) from book where ISBN = " + ISBN;

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

	public void update(String ISBN, int ID) {
		try {

			Connection c = DBHelper.getInstance().getConnection();

			String sql = "update book set isorder = 0 where ISBN = ? and ID =?";

			PreparedStatement ps = c.prepareStatement(sql);

			ps.setString(1, ISBN);

			ps.setInt(2, ID);

			ps.execute();

			String sql1 = "  CREATE EVENT e_test" + Count.getCount()
					+ " ON SCHEDULE AT CURRENT_TIMESTAMP + INTERVAL 10 SECOND" + " DO CALL timerr(" + ID + "," + ISBN
					+ ");";
			PreparedStatement ps1 = c.prepareStatement(sql1);
			ps1.execute();

			DBHelper.closeConnection(c, ps, null);
			DBHelper.closeConnection(c, ps1, null);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String yes(String ISBN) {
		int i = 0;
		String yes = "no";

		try {

			Connection c = DBHelper.getInstance().getConnection();

			String sql = "select isborrow from book where ISBN = " + ISBN;

			PreparedStatement ps = c.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				int isborrow = rs.getInt("isborrow");

				if (isborrow != 0 && i == 0) {
					yes = "yes";
					i = 1;
				}

			}
			DBHelper.closeConnection(c, ps, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return yes;

	}

	public List<aBook> list(String ISBN) {
		List<aBook> abooks = new ArrayList<aBook>();
		try {

			Connection c = DBHelper.getInstance().getConnection();

			String sql = "select * from book where ISBN = " + ISBN;

			PreparedStatement ps = c.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String borrow = null;
				String order = null;
				String yu = null;
				aBook abook = new aBook();
				int ID = rs.getInt("ID");
				String id = String.format("%013d", ID);
				System.out.println(id);
				int isorder = rs.getInt("isorder");
				if (isorder == 1) {
					order = "yes";
					yu = "order";
				} else
					order = "no";
				int isborrow = rs.getInt("isborrow");
				if (isborrow == 0)
					borrow = "no";
				else
					borrow = "yes";
				String tt = rs.getString("ISBN");
				String author = rs.getString("author");
				String bookname = rs.getString("bookname");
				String version = rs.getString("version");
				String introduction = rs.getString("introduction");
				String location = rs.getString("location");
				String press = rs.getString("press");
				Date printdate = rs.getDate("printdate");
				double price = rs.getDouble("price");
				abook.setISBN(tt);
				abook.setID(id);
				abook.setIsorder(order);
				abook.setIsborrow(borrow);
				abook.setAuthor(author);
				abook.setBookname(bookname);
				abook.setVersion(version);
				abook.setIntroduction(introduction);
				abook.setLocation(location);
				abook.setPrintdate(printdate);
				abook.setPress(press);
				abook.setYu(yu);
				abook.setPrice(price);
				abook.setBorrow(borrow);
				abooks.add(abook);

			}
			DBHelper.closeConnection(c, ps, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return abooks;
	}

	public int getcount() {
		int count = 0;
		try {

			Connection c = DBHelper.getInstance().getConnection();

			Statement s = c.createStatement();

			String sql = "select count(*) from historyborrow";

			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt(1);
			}

			DBHelper.closeConnection(c, s, rs);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	public int getcount1() {
		int count = 0;
		try {

			Connection c = DBHelper.getInstance().getConnection();

			Statement s = c.createStatement();

			String sql = "select count(*) from currentborrow";

			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt(1);
			}

			DBHelper.closeConnection(c, s, rs);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	public List<ahistorycurrent> list(int start, int cnt, long stunumber) {
		List<ahistorycurrent> historys = new ArrayList<ahistorycurrent>();

		try {

			Connection c = DBHelper.getInstance().getConnection();

			String sql = "select * from historyborrow where (stunumber = ? ) order by ID desc limit ?,? ";

			PreparedStatement ps = c.prepareStatement(sql);

			ps.setLong(1, stunumber);
			ps.setInt(2, start);
			ps.setInt(3, cnt);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ahistorycurrent history = new ahistorycurrent();
				String ISBN = rs.getString("ISBN");
				int ID = rs.getInt("ID");
				String id = String.format("%013d", ID);
				Date borrowtime = rs.getDate("borrowtime");
				Date returntime = rs.getDate("returntime");
				String bookname = rs.getString("bookname");
				double historyfine = rs.getDouble("historyfine");
				history.setBookname(bookname);
				history.setBorrowtime(borrowtime);
				history.setID(id);
				history.setISBN(ISBN);
				history.setReturntime(returntime);
				history.setHistoryfine(historyfine);
				historys.add(history);

			}
			DBHelper.closeConnection(c, ps, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return historys;
	}

	public List<acurrent> list1(int start, int cnt, long stunumber) {
		List<acurrent> currents = new ArrayList<acurrent>();
		try {

			Connection c = DBHelper.getInstance().getConnection();

			String sql = "select * from currentborrow where (stunumber = ? ) order by ID desc limit ?,? ";

			PreparedStatement ps = c.prepareStatement(sql);

			ps.setLong(1, stunumber);
			ps.setInt(2, start);
			ps.setInt(3, cnt);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				acurrent current = new acurrent();
				String ISBN = rs.getString("ISBN");
				int ID = rs.getInt("ID");
				String id = String.format("%013d", ID);
				Date borrowtime = rs.getDate("borrowtime");				
				Calendar calendar =Calendar.getInstance();
		        calendar.setTime(borrowtime);
		        calendar.add(Calendar.MONTH, 1);
		        java.util.Date date = calendar.getTime();
		        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		        String d = df.format(date);
				String bookname = rs.getString("bookname");
				current.setBookname(bookname);
				current.setBorrowtime(borrowtime);
				current.setReturntime(d);
				current.setID(id);
				current.setISBN(ISBN);
				currents.add(current);

			}

			DBHelper.closeConnection(c, ps, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return currents;
	}
	public void add(int bookid,long phone) {

		try {

			Connection c = DBHelper.getInstance().getConnection();

			String sql = "insert into reserve values(?,?)";
			PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, bookid);
			ps.setLong(2, phone);
			

			ps.execute();

			DBHelper.closeConnection(c, ps, null);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
