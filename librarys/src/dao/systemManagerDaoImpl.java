package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.SystemManager;
import utils.DBHelper;

public class systemManagerDaoImpl implements systemManangerDao{
	PreparedStatement ps;
	ResultSet rs;
	
	@Override
	public void update(SystemManager systemManager) {
		try {
			Connection conn = DBHelper.getInstance().getConnection();
			String sql = "update admin set password=? where account='admin'";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, systemManager.getPassword());
			
			ps.execute();
			
			DBHelper.closeConnection(conn, ps, rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
	}
	
	@Override
	public SystemManager findSystemManager() {
		SystemManager systemManager=new SystemManager();
		String sql = "select * from admin";
		
		try {
			Connection conn = DBHelper.getInstance().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String account = rs.getString("account");
				String password = rs.getString("password");
				
				systemManager.setAccount(account);
				systemManager.setPassword(password);

			}
			DBHelper.closeConnection(conn, ps, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return systemManager;
	}
	
}
