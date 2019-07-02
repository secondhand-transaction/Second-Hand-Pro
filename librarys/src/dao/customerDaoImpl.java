package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import domain.CurrentBorrow;
import domain.Customer;
import domain.Manager;
import utils.DBHelper;

public class customerDaoImpl implements customerDao {
	PreparedStatement ps;
	ResultSet rs;
	
	@Override
	public void addCustomer(Customer customer) {
		int idd=customer.getId();
		boolean b=true;
		managerDao mDao=new managerDaoImpl();
		List<Customer> customers = this.findAllCustomer();
		List<Manager> managers=mDao.findAllManager();
			for (int i = 0; i < customers.size(); i++) {
				if (idd==customers.get(i).getId()) {
					b=false;
					JOptionPane.showMessageDialog(null, "Error", "repeat Add", JOptionPane.ERROR_MESSAGE);
				    break;
				}
			}
		for (int i = 0; i < managers.size(); i++) {
			if (idd==managers.get(i).getId()) {
				b=false;
				JOptionPane.showMessageDialog(null, "Error", "repeat Add", JOptionPane.ERROR_MESSAGE);
				break;
			}
		}
		if (b==true) {
			try {
				Connection conn = DBHelper.getInstance().getConnection();
				String sql = "insert into reader (stunumber,name,password,phone,address,email,overduebooks) values (?,?,?,?,?,?,?)";
				ps = conn.prepareStatement(sql);
				
				ps.setInt(1, customer.getId());
				ps.setString(2, customer.getUsername());
				ps.setString(3, customer.getPassword());
				ps.setString(4, customer.getPhone());
				ps.setString(5, customer.getAddress());
				ps.setString(6, customer.getEmail());
				ps.setInt(7, customer.getOverduebooks());
				
				ps.execute();
				
				DBHelper.closeConnection(conn, ps, rs);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}

	@Override
	public void update(Customer customer) {
		try {
			Connection conn = DBHelper.getInstance().getConnection();
			String sql = "update reader set name=?,password=?,phone=?,address=?,email=?,overduebooks=? where stunumber="+customer.getId();
			ps = conn.prepareStatement(sql);
			
		
			ps.setString(1, customer.getUsername());
			ps.setString(2, customer.getPassword());
			ps.setString(3, customer.getPhone());
			ps.setString(4, customer.getAddress());
			ps.setString(5, customer.getEmail());
			ps.setInt(6, customer.getOverduebooks());
			
			ps.execute();
			
			DBHelper.closeConnection(conn, ps, rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public Customer findCustomerById(int id) {
		Customer customer = null;
		
		try {
			Connection conn = DBHelper.getInstance().getConnection();
			String sql = "select * from reader where stunumber="+id;
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				customer = new Customer();
				String username = rs.getString("name");
				String password = rs.getString("password");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				String email = rs.getString("email");
				int overduebooks=rs.getInt("overduebooks");
				
				customer.setAddress(address);
//				customer.setCode(code);
				customer.setEmail(email);
				customer.setId(id);
				customer.setPassword(password);
				customer.setPhone(phone);
				customer.setUsername(username);
				customer.setOverduebooks(overduebooks);
			}
			DBHelper.closeConnection(conn, ps, rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public Customer findCustomer(String username, String password) {
		Customer customer = null;
		try {
			Connection conn = DBHelper.getInstance().getConnection();
			String sql = "select * from reader where name=? and password=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				customer = new Customer();
				int id = rs.getInt("stunumber");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				String email = rs.getString("email");
				int overduebooks=rs.getInt("overduebooks");
//				String code = rs.getString("code");
				
				customer.setAddress(address);
//				customer.setCode(code);
				customer.setEmail(email);
				customer.setId(id);
				customer.setPassword(password);
				customer.setPhone(phone);
				customer.setUsername(username);
				customer.setOverduebooks(overduebooks);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public void deleteCustomer(Customer customer) {
		try {
			Connection conn = DBHelper.getInstance().getConnection();
			String sql = "delete from reader where stunumber="+customer.getId();
			ps = conn.prepareStatement(sql);
			
			ps.execute();
			
			DBHelper.closeConnection(conn, ps, rs);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Customer> findAllCustomer() {
		List<Customer> customers = new ArrayList<Customer>();
		Customer customer = null;
		String sql = "select * from reader";
		try {
			Connection conn = DBHelper.getInstance().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				customer = new Customer();
				int id = rs.getInt("stunumber");
				String username = rs.getString("name");
				String password = rs.getString("password");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				String email = rs.getString("email");
				int overduebooks=rs.getInt("overduebooks");
				
				customer.setAddress(address);
				customer.setEmail(email);
				customer.setId(id);
				customer.setPassword(password);
				customer.setPhone(phone);
				customer.setUsername(username);
				customer.setOverduebooks(overduebooks);
				
				customers.add(customer);
			}
			DBHelper.closeConnection(conn, ps, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return customers;
	}

	@Override
	public List<Customer> findPageCustomer(int startIndex, int size) {
		List<Customer> customers = new ArrayList<Customer>();
		try {
			Connection conn = DBHelper.getInstance().getConnection();
			String sql = "select * from reader limit ?,?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, startIndex);
			ps.setInt(2, size);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Customer customer = new Customer();
				
				int id = rs.getInt("stunumber");
				String username = rs.getString("name");
				String password = rs.getString("password");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				String email = rs.getString("email");
				int overduebooks=rs.getInt("overduebooks");
				
				customer.setAddress(address);
				customer.setEmail(email);
				customer.setId(id);
				customer.setPassword(password);
				customer.setPhone(phone);
				customer.setUsername(username);
				customer.setOverduebooks(overduebooks);
				
				customers.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return customers;
	}
	
	@Override
	public int getTotalCustomer() {
		String sql = "select count(*) from reader";
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
	
	@Override
	public List<Customer> findPageOverdueCustomer(int startIndex, int size) {
		List<Customer> customers = new ArrayList<Customer>();
		try {
			Connection conn = DBHelper.getInstance().getConnection();
			String sql = "select * from reader limit ?,?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, startIndex);
			ps.setInt(2, size);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Customer customer = new Customer();
				
				int id = rs.getInt("stunumber");
				String username = rs.getString("name");
				String password = rs.getString("password");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				String email = rs.getString("email");
				int overduebooks=rs.getInt("overduebooks");
				
				customer.setAddress(address);
				customer.setEmail(email);
				customer.setId(id);
				customer.setPassword(password);
				customer.setPhone(phone);
				customer.setUsername(username);
				customer.setOverduebooks(overduebooks);
				
				if(customer.getOverduebooks()>0){
					customers.add(customer);}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return customers;
	}
	
	@Override
	public List<Customer> findAllOverdueCustomer() {
		List<Customer> customers = new ArrayList<Customer>();
		customers=this.findAllCustomer();
		List<Customer> overduecustomers = new ArrayList<Customer>();
		Iterator<Customer> it = customers.iterator();
		while(it.hasNext()){
			Customer customer =it.next();
			if(customer.getOverduebooks()>0){
				overduecustomers.add(customer);
			}
		}
		return overduecustomers;
	}
	
	
	@Override
	public int getTotalOverdueCustomer() {
		String sql = "select count(*) from reader where overduebooks>0";
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
