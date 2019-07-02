package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import entity.Announcement;
import entity.Book;
import utils.DBHelper;
import java.sql.Date;
public class AnnouncementDAO {
	private AnnouncementDAO() {
	}
	public static AnnouncementDAO getInstance() {
		return new AnnouncementDAO();
	}
	
	public static int getTotal() {
		int total = 0;
		try {

			Connection c = DBHelper.getInstance().getConnection();

			Statement s = c.createStatement();

			String sql = "select count(*) from announcement";

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
	
	public static void sendAnnouncement(String content)
	{
		try{
		Connection c = DBHelper.getInstance().getConnection();

		String sql = "insert into announcement values(null,?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, content);
		ResultSet rs1 = null;
		ps.execute();
		DBHelper.closeConnection(c, ps, rs1);
		}catch (Exception e) {
			e.printStackTrace();
			}
	}
	public void update(Announcement announcement) {
		try {

			Connection c = DBHelper.getInstance().getConnection();

			String sql = "update announcement set content= ?  where ID =?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, announcement.getContent());
			ps.setInt(2,announcement.getID() );
			ps.execute();
			DBHelper.closeConnection(c, ps, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void delete(int ID) {
		try {

			Connection c = DBHelper.getInstance().getConnection();

			Statement s = c.createStatement();

			String sql = "delete from announcement where ID = "+ID;

			s.execute(sql);

			DBHelper.closeConnection(c, s, null);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<Announcement> list() {
		return list(0, Short.MAX_VALUE);
	}
	public static List<Announcement> list(int start, int count) {
		List<Announcement> announcements = new ArrayList<Announcement>();

		try {

			Connection c = DBHelper.getInstance().getConnection();

			String sql = "select * from announcement order by ID desc limit ?,? ";

			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, count);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Announcement announcement=new Announcement();
				String content=rs.getString("content");
				int ID=rs.getInt("ID");
				announcement.setContent(content);
				announcement.setID(ID);
				announcements.add(announcement);
			}
			DBHelper.closeConnection(c, ps, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return announcements;
	}
	public static String getContent() {
		String content = null;
		try {

			Connection c = DBHelper.getInstance().getConnection();

			Statement s = c.createStatement();

			String sql = "select content from announcement where id = (select max(id) from announcement)";

			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				content = rs.getString(1);
			}

			System.out.println("content:" +content);

			DBHelper.closeConnection(c, s, rs);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return content;
	}
}
