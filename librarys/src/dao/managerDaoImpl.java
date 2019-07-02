package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import domain.Customer;
import domain.Manager;
import utils.DBHelper;

public class managerDaoImpl implements managerDao {
	PreparedStatement ps;
	ResultSet rs;
	
	@Override
	public void addManager(Manager manager) {
		
		
		int idd=manager.getId();
		boolean b=true;
		customerDao cDao = new customerDaoImpl();
		List<Manager> managers=this.findAllManager();
		List<Customer> customers = cDao.findAllCustomer();
		for (int i = 0; i < managers.size(); i++) {
			if (idd==managers.get(i).getId()) {
				b=false;
				System.out.println("弹框");
				JOptionPane.showMessageDialog(null, "ErrorAdd", "repeat Add", JOptionPane.ERROR_MESSAGE);
				break;
			}
		}
		for (int i = 0; i<customers.size(); i++) {
			if (idd==customers.get(i).getId()) {
				b=false;
				JOptionPane.showMessageDialog(null, "ErrorAdd", "repeat Add", JOptionPane.ERROR_MESSAGE);
				break;
			}
		}
		if (b==true) {
			
			try {
				Connection conn = DBHelper.getInstance().getConnection();
				String sql = "insert into librarian (account,name,password,phone,address,email) values (?,?,?,?,?,?)";
				ps = conn.prepareStatement(sql);
				
				ps.setInt(1, manager.getId());
				ps.setString(2, manager.getUsername());
				ps.setString(3, manager.getPassword());
				ps.setString(4, manager.getPhone());
				ps.setString(5, manager.getAddress());
				ps.setString(6, manager.getEmail());
				
				ps.execute();
				
				DBHelper.closeConnection(conn, ps, rs);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}

	@Override
	public void update(Manager manager) {
		try {
			Connection conn = DBHelper.getInstance().getConnection();
			String sql = "update librarian set name=?,password=?,phone=?,address=?,email=? where account="+manager.getId();
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, manager.getUsername());
			ps.setString(2, manager.getPassword());
			ps.setString(3, manager.getPhone());
			ps.setString(4, manager.getAddress());
			ps.setString(5, manager.getEmail());
			
			ps.execute();
			
			DBHelper.closeConnection(conn, ps, rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public Manager findManagerById(int id) {
		Manager manager = null;
		
		try {
			Connection conn = DBHelper.getInstance().getConnection();
			String sql = "select * from librarian where account="+id;
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				manager = new Manager();
				String username = rs.getString("name");
				String password = rs.getString("password");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				String email = rs.getString("email");
//				String code = rs.getString("code");
				
				manager.setAddress(address);
//				customer.setCode(code);
				manager.setEmail(email);
				manager.setId(id);
				manager.setPassword(password);
				manager.setPhone(phone);
				manager.setUsername(username);
			}
			DBHelper.closeConnection(conn, ps, rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return manager;
	}

	@Override
	public Manager findManager(String username, String password) {
		Manager manager = null;
		try {
			Connection conn = DBHelper.getInstance().getConnection();
			String sql = "select * from librarian where name=? and password=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				manager = new Manager();
				int id = rs.getInt("account");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				String email = rs.getString("email");
//				String code = rs.getString("code");
				
				manager.setAddress(address);
//				customer.setCode(code);
				manager.setEmail(email);
				manager.setId(id);
				manager.setPassword(password);
				manager.setPhone(phone);
				manager.setUsername(username);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return manager;
	}

	@Override
	public void deleteManager(Manager manager) {
		try {
			Connection conn = DBHelper.getInstance().getConnection();
			String sql = "delete from librarian where account="+manager.getId();
			ps = conn.prepareStatement(sql);
			
			ps.execute();
			
			DBHelper.closeConnection(conn, ps, rs);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Manager> findAllManager() {
		List<Manager> managers = new ArrayList<Manager>();
		Manager manager = null;
		String sql = "select * from librarian";
		try {
			Connection conn = DBHelper.getInstance().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				manager = new Manager();
				int id = rs.getInt("account");
				String username = rs.getString("name");
				String password = rs.getString("password");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				String email = rs.getString("email");
				
				manager.setAddress(address);
				manager.setEmail(email);
				manager.setId(id);
				manager.setPassword(password);
				manager.setPhone(phone);
				manager.setUsername(username);
				
				managers.add(manager);
			}
			DBHelper.closeConnection(conn, ps, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return managers;
	}

	@Override
	public List<Manager> findPageManager(int startIndex, int size) {
		List<Manager> managers = new ArrayList<Manager>();
		try {
			Connection conn = DBHelper.getInstance().getConnection();
			String sql = "select * from librarian limit ?,?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, startIndex);
			ps.setInt(2, size);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Manager manager = new Manager();
				
				int id = rs.getInt("account");
				String username = rs.getString("name");
				String password = rs.getString("password");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				String email = rs.getString("email");
				
				manager.setAddress(address);
				manager.setEmail(email);
				manager.setId(id);
				manager.setPassword(password);
				manager.setPhone(phone);
				manager.setUsername(username);
				
				managers.add(manager);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return managers;
	}

	@Override
	public int getTotalManager() {
		String sql = "select count(*) from librarian";
		int total = 0;
		try {
			Connection conn = DBHelper.getInstance().getConnection();
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				total = rs.getInt(1);
			}
			DBHelper.closeConnection(conn, ps, rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
	}

}
