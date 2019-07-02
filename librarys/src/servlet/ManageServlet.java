package servlet;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import javax.swing.text.html.HTMLDocument.HTMLReader.ParagraphAction;

import com.sun.org.apache.bcel.internal.generic.NEW;

import business.Business;
import business.BusinessImpl;
import dao.DataDao;
import dao.managerDao;
import dao.managerDaoImpl;
import dao.systemManagerDaoImpl;
import domain.CurrentBorrow;
import domain.Customer;
import domain.Manager;
import domain.Setdata;
import domain.SystemManager;
import page.Page;

/**
 * Servlet implementation class ManageServlet
 */
public class ManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Business b = new BusinessImpl();
    private DataDao dataDao= new DataDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset = UTF-8");		
		request.setCharacterEncoding("UTF-8");
		String option = request.getParameter("op");
		System.out.println(option);
		if("listManagers".equals(option)) {
			listManagers(request, response);
		}else if("addManager".equals(option)) {
			addManager(request, response);
		}else if("delManager".equals(option)) {
			delManager(request, response);
		}else if("editManager".equals(option)) {
			editManager(request, response);
		}else if("listUsers".equals(option)) {
			listUsers(request, response);
		}else if("addUser".equals(option)) {
			addUser(request, response);
		}else if("delUser".equals(option)) {
			delUser(request, response);
		}else if("editUser".equals(option)) {
			editUser(request, response);
		}else if("listOverdue".equals(option)){
			listOverdue(request,response);
		}else if("sendEmail".equals(option)){
			sendEmail(request,response);
		}else if ("currentBorrow".equals(option)) {
			currentBorrow(request,response);
		}else if("searchUser".equals(option)) {
			searchUser(request,response);
		}else if("searchUser".equals(option)) {
			searchUser(request,response);
		}else if("searchManager".equals(option)) {
			searchManager(request,response);
		}else if ("listData".equals(option)) {
			listData(request,response);
		}else if ("editData".equals(option)) {
			editData(request,response);
		}else if("systemManagerLogin".equals(option)) {
			systemManagerLogin(request,response);
	    }else if("systemManagerChangepwd".equals(option)){
	    	systemManagerChangepwd(request,response);
	    }
		
	}
	
	private void systemManagerLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		systemManagerDaoImpl systemman=new systemManagerDaoImpl();
		SystemManager systemManager=new SystemManager();
		systemManager=systemman.findSystemManager();
		String UserAccount = request.getParameter("account");
		String UserPassword=request.getParameter("password");
		String account=systemManager.getAccount();
		String password=systemManager.password;
		if(!UserAccount.equals(account)){
			System.out.println("弹框");
			JOptionPane.showMessageDialog(null, "ErrorAccount", "Error", JOptionPane.ERROR_MESSAGE);
			request.getRequestDispatcher("/manager/login.jsp").forward(request, response);
		}
		else if(!UserPassword.equals(password)){
			System.out.println("弹框");
			JOptionPane.showMessageDialog(null, "ErrorPassword", "Error", JOptionPane.ERROR_MESSAGE);
			request.getRequestDispatcher("/manager/login.jsp").forward(request, response);
		}
		else{
			request.getRequestDispatcher("/manager/index.jsp").forward(request, response);
		}
	}
	
	private void systemManagerChangepwd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String UserOldPassword=request.getParameter("oldPassword");
		String UserNewPassword=request.getParameter("newPassword");
		String UserCnewPassword=request.getParameter("cnewPassword");
		systemManagerDaoImpl systemman=new systemManagerDaoImpl();
		SystemManager systemManager=new SystemManager();
		systemManager=systemman.findSystemManager();
		String password=systemManager.password;
		if(!UserOldPassword.equals(password)){
			JOptionPane.showMessageDialog(null, "Error Old Password", "Error", JOptionPane.ERROR_MESSAGE);
			request.getRequestDispatcher("/manager/changepwd.jsp").forward(request, response);
		}
		else if(!UserNewPassword.equals(UserCnewPassword)){
			JOptionPane.showMessageDialog(null, "Inconsistent two new passwords", "Error", JOptionPane.ERROR_MESSAGE);
			request.getRequestDispatcher("/manager/changepwd.jsp").forward(request, response);
		}
		else{
			systemManager.setPassword(UserNewPassword);
		    systemman.update(systemManager);
			JOptionPane.showMessageDialog(null, "The new password is set successfully.", "successful!", JOptionPane.INFORMATION_MESSAGE);
			RequestDispatcher view=request.getRequestDispatcher("/manager/login.jsp");
			view.forward(request, response);
		}
	}
	
	private void editData(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		int id = Integer.valueOf(request.getParameter("id"));
		double fine=Double.parseDouble(request.getParameter("fine"));
		int day=Integer.valueOf(request.getParameter("day"));
		int deposit=Integer.valueOf(request.getParameter("deposit"));
		Setdata setdata=new Setdata();
		setdata.setId(id);
		setdata.setFine(fine);
		setdata.setDay(day);
		setdata.setDeposit(deposit);
		b.editSetData(setdata);
		
		request.getRequestDispatcher("/servlet/ManageServlet?op=listData").forward(request, response);
		
	}

	private void listData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		Page page = b.findSetDatapage(num);
		List<Setdata> setdatas = b.findAllSetData();
		page.setUrl("/servlet/ManageServlet?op=listData");
		request.setAttribute("page", page);
		request.getRequestDispatcher("/manager/listData.jsp").forward(request, response);
	}

	private void searchManager(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int a=1;
		managerDao mDao=new managerDaoImpl();
		List<Manager> managers=mDao.findAllManager();
		String managerId=request.getParameter("managerId");
		int id=Integer.parseInt(managerId);
		Manager manager= b.findManagerById(id);
		for (int i = 0; i < managers.size(); i++) {
			if (id==managers.get(i).getId()) {
				a=2;
				System.out.println(manager.getEmail());
				request.setAttribute("manager", manager);
				request.getRequestDispatcher("/manager/searchManager.jsp").forward(request, response);
				break;
			}
		}
		if (a==1) {
				System.out.println("弹框");
				JOptionPane.showMessageDialog(null, "no this librarian", "please input right", JOptionPane.ERROR_MESSAGE);
				request.getRequestDispatcher("/servlet/ManageServlet?op=listManagers").forward(request, response);
		}
		
		
	}

	private void searchUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String customerId = request.getParameter("customerId");
		System.out.println(customerId);
		int id = Integer.parseInt(customerId);
		Customer customer = b.findCustomerById(id);
		System.out.println(customer.getEmail());
		request.setAttribute("customer", customer);
		
		request.getRequestDispatcher("/manager/searchUser.jsp").forward(request, response);
	}

	private void currentBorrow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idstr = request.getParameter("customerId");
		int id  = Integer.parseInt(idstr);
		String num = request.getParameter("num");
		Page page = b.findOverdueCustomerpageById(num, id);
		page.setUrl("/servlet/ManageServlet?op=currentBorrow");
		request.setAttribute("page", page);
		request.getRequestDispatcher("/manager/currentBorrow.jsp").forward(request, response);
		
	}

	private void editUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int id = Integer.valueOf(request.getParameter("customerId"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		
		Customer c = new Customer();
		c.setAddress(address);
		c.setEmail(email);
		c.setId(id);
		c.setPassword(password);
		c.setPhone(phone);
		c.setPhone(phone);
		c.setUsername(username);
		
		b.editUser(c);
		
		request.getRequestDispatcher("/servlet/ManageServlet?op=listUsers").forward(request, response);
	}

	private void delUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int customerId = Integer.valueOf(request.getParameter("customerId"));
		Customer customer = b.findCustomerById(customerId);
		b.deleteCustomer(customer);
		
		request.getRequestDispatcher("/servlet/ManageServlet?op=listUsers").forward(request, response);
	}

	private void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer customer = new Customer();
		
		int id = Integer.valueOf(request.getParameter("id"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		
		customer.setId(id);
		customer.setAddress(address);
		customer.setEmail(email);
		customer.setPassword(password);
		customer.setPhone(phone);
		customer.setUsername(username);
		
		b.addUser(customer);
		
		request.getRequestDispatcher("/servlet/ManageServlet?op=listUsers").forward(request, response);
	}

	private void listUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		Page page = b.findCustomerpage(num);
		List<Customer> customers = b.findAllCustomer();
		page.setUrl("/servlet/ManageServlet?op=listUsers");
		request.setAttribute("page", page);
		request.getRequestDispatcher("/manager/listUsers.jsp").forward(request, response);
	}

	private void editManager(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int id = Integer.valueOf(request.getParameter("managerId"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		
		Manager m = new Manager();
		m.setAddress(address);
		m.setEmail(email);
		m.setId(id);
		m.setPassword(password);
		m.setPhone(phone);
		m.setPhone(phone);
		m.setUsername(username);
		
		b.editManager(m);
		
		request.getRequestDispatcher("/servlet/ManageServlet?op=listManagers").forward(request, response);
	}

	private void delManager(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int managerId = Integer.valueOf(request.getParameter("managerId"));
		Manager manager = b.findManagerById(managerId);
		b.deleteManager(manager);
		
		request.getRequestDispatcher("/servlet/ManageServlet?op=listManagers").forward(request, response);
	}

	private void addManager(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Manager manager = new Manager();
		
		int id = Integer.valueOf(request.getParameter("id"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		
		
		manager.setId(id);
		manager.setAddress(address);
		manager.setEmail(email);
		manager.setPassword(password);
		manager.setPhone(phone);
		manager.setUsername(username);
		
		b.addManager(manager);
		
		request.getRequestDispatcher("/servlet/ManageServlet?op=listManagers").forward(request, response);
	}

	private void listManagers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		Page page = b.findManagerpage(num);
		List<Manager> managers = b.findAllManager();
		page.setUrl("/servlet/ManageServlet?op=listManagers");
		request.setAttribute("page", page);
		request.getRequestDispatcher("/manager/listManagers.jsp").forward(request, response);
	}

	private void listOverdue(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		b.overdueAmount();
		String num = request.getParameter("num");
		Page page = b.findOverdueCustomerpage(num);//
		List<Customer> customers = b.findAllOverdueCustomer();//
		page.setUrl("/servlet/ManageServlet?op=listOverdue");
		request.setAttribute("page", page);
		request.getRequestDispatcher("/manager/listOverdue.jsp").forward(request, response);
	}
	
	private void sendEmail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view=request.getRequestDispatcher("testReg.do");
		view.forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
