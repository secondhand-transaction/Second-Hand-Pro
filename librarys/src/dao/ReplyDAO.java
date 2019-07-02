package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import entity.Announcement;
import entity.Reply;
import utils.DBHelper;

public class ReplyDAO {

	static public int getTotal()  //���reply���ݿ����ݵ���Ŀ
	{
      int total = 0;
		
		try {

			Connection c = DBHelper.getInstance().getConnection();

			Statement s = c.createStatement();

			String sql = "select count(*) from reply";

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
	static public List<Reply> list(int start, int count) {//��url��ȡ����start��count������
		List<Reply> replys = new ArrayList<Reply>();

		try {

			Connection c = DBHelper.getInstance().getConnection();

			String sql = "select * from reply order by replytime desc limit ?,? ";

			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, count);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Reply reply = new Reply();
				String name=rs.getString("name");
				Timestamp replytime=rs.getTimestamp("replytime");
				String content=rs.getString("content");
				long stunumber=rs.getLong("stunumber");
				int ID=rs.getInt("ID");
				reply.setName(name);;
				reply.setReplytime(replytime);
				reply.setContent(content);
				reply.setStunumber(stunumber);
				reply.setID(ID);
				replys.add(reply);
		
			}
			DBHelper.closeConnection(c, ps, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return replys;
	}
	static public  void delete(int ID) {
		try {

			Connection c = DBHelper.getInstance().getConnection();

			Statement s = c.createStatement();

			String sql = "delete from reply where ID = " + ID;
			

			s.execute(sql);

			DBHelper.closeConnection(c, s, null);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void update(int ID,String content) {
		try {

			Connection c = DBHelper.getInstance().getConnection();

			String sql = "update reply set content= ?  where ID =?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, content);
			ps.setInt(2,ID );
			ps.execute();
			DBHelper.closeConnection(c, ps, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
