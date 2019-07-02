package business;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.NEW;

import dao.DataDao;
import dao.currentDao;
import dao.currentDaoImpl;
import dao.customerDao;
import dao.customerDaoImpl;
import dao.managerDao;
import dao.managerDaoImpl;
import domain.CurrentBorrow;
import domain.Customer;
import domain.Manager;
import domain.Setdata;
import page.Page;

public class BusinessImpl implements Business {

	customerDao customerdao = new customerDaoImpl();
	managerDao managerdao = new managerDaoImpl();
	currentDao currentdao = new currentDaoImpl();
	DataDao dataDao = new DataDao();

	@Override
	public void registCustomer(Customer customer) {
		customerdao.addCustomer(customer);
	}

	@Override
	public void activeCustomer(Customer customer) {
		// TODO Auto-generated method stub

	}

	@Override
	public Customer findCustomerById(int id) {
		return customerdao.findCustomerById(id);
	}

	@Override
	public Customer loginCustomer(String username, String password) {
		Customer customer = customerdao.findCustomer(username, password);
		return customer;
	}

	@Override
	public List<Customer> findAllCustomer() {
		return customerdao.findAllCustomer();
	}

	@Override
	public List<Customer> findAllOverdueCustomer() {
		return customerdao.findAllOverdueCustomer();
	}
	
	@Override
	public List<CurrentBorrow> findAllCurrentBorrow() {
		return currentdao.findAllCurrentBorrow();
		// TODO �Զ����ɵķ������
	}
	
	@Override
	public void addUser(Customer customer) {
		customerdao.addCustomer(customer);
	}

	@Override
	public void deleteCustomer(Customer customer) {
		customerdao.deleteCustomer(customer);
	}

	@Override
	public void editUser(Customer c) {
		customerdao.update(c);
	}

	@Override
	public Page findCustomerpage(String num) {
		int pageNum = 1;
		Page page = null;
		if (num != null) {
			pageNum = Integer.parseInt(num);
		}
		int totalcustomer = customerdao.getTotalCustomer();
		page = new Page(pageNum, totalcustomer, 5);
		List<Customer> customers = customerdao.findPageCustomer(page.getStartIndex(), page.getPageSize());
		page.setItems(customers);
		return page;
	}

	@Override
	public Page findOverdueCustomerpage(String num) {
		int pageNum = 1;
		Page page = null;
		if (num != null) {
			pageNum = Integer.parseInt(num);
		}
		int totalcustomer = customerdao.getTotalOverdueCustomer();
		page = new Page(pageNum, totalcustomer, 5);
		List<Customer> customers = customerdao.findPageOverdueCustomer(page.getStartIndex(), page.getPageSize());
		page.setItems(customers);
		return page;
	}

	@Override
	public Page findCurrentBorrowpage(String num) {
		
		int pageNum=1;
		Page page=null;
		if (num !=null) {
			pageNum = Integer.parseInt(num);
			
		}
		int totalCurrentBorrow=currentdao.getTotalCurrentBorrow();
		page = new Page(pageNum, totalCurrentBorrow,5);
		List<CurrentBorrow> currentBorrows= currentdao.findPageCurrentBorrow(page.getStartIndex(), page.getPageSize());
		page.setItems(currentBorrows);
		return page;
		
	}
	
	@Override
	public void overdueAmount() {// ���¶��߹����������ĺ���
		List<Customer> allcustomers = customerdao.findAllCustomer();
		Iterator<Customer> it = allcustomers.iterator();
		List<CurrentBorrow> allcurrentBorrows = currentdao.findAllCurrentBorrow();
		Date nowtime = new Date();// new Date()Ϊ��ȡ��ǰϵͳʱ��
		while (it.hasNext()) {
			Customer customer = it.next();
			int overduebooks = 0;
			for (int i = 0; i < allcurrentBorrows.size(); i++) {
				CurrentBorrow currentBorrow = new CurrentBorrow();
				currentBorrow = allcurrentBorrows.get(i);
				if (currentBorrow.getStunumber() == customer.getId()) {
					Date date = currentBorrow.getBorrowtime();
					int day = (int) ((nowtime.getTime() - date.getTime()) / (1000 * 60 * 60 * 24));
					if (day > 30)
						overduebooks++;
				}
			}
			customer.setOverduebooks(overduebooks);
			this.editUser(customer);
		}
	}

	@Override
	public void registManager(Manager manager) {
		managerdao.addManager(manager);
	}

	@Override
	public void activeManager(Manager manager) {
		// TODO Auto-generated method stub

	}

	@Override
	public Manager findManagerById(int id) {
		return managerdao.findManagerById(id);
	}

	@Override
	public Manager loginManager(String username, String password) {
		Manager manager = managerdao.findManager(username, password);
		return manager;
	}

	@Override
	public List<Manager> findAllManager() {
		return managerdao.findAllManager();
	}

	@Override
	public void addManager(Manager manager) {
		managerdao.addManager(manager);
	}

	@Override
	public void deleteManager(Manager manager) {
		managerdao.deleteManager(manager);
	}

	@Override
	public void editManager(Manager manager) {
		managerdao.update(manager);
	}

	@Override
	public Page findManagerpage(String num) {
		int pageNum = 1;
		Page page = null;
		if (num != null) {
			pageNum = Integer.parseInt(num);
		}
		int totalmanager = managerdao.getTotalManager();
		page = new Page(pageNum, totalmanager, 5);
		List<Manager> managers = managerdao.findPageManager(page.getStartIndex(), page.getPageSize());
		page.setItems(managers);
		return page;
	}

	@Override
	public CurrentBorrow findCurrentById(int id) {
		return currentdao.findCurrentBorrowById(id);
	}

	@Override
	public Page findOverdueCustomerpageById(String num, int id) {
		int pageNum = 1;
		Page page = null;
		if (num != null) {
			pageNum = Integer.parseInt(num);
		}
		int totalmanager = currentdao.getCurrentNumById(id);
		page = new Page(pageNum, totalmanager, 5);
		List<CurrentBorrow> currentBorrows = currentdao.findCurrentBorrowsById(id);
		
		page.setItems(currentBorrows);
		return page;
	}

	@Override
	public Setdata findSetDataById(int id) {
		return dataDao.findSetdataById(id);
	}

	@Override
	public List<Setdata> findAllSetData() {
		return dataDao.findAllSetData();
	}

	@Override
	public void editSetData(Setdata s) {
		dataDao.update(s);
	}

	@Override
	public Page findSetDatapage(String num) {
		int pageNum = 1;
		Page page = null;
		if (num != null) {
			pageNum = Integer.parseInt(num);
		}
		int totalData = dataDao.getTotalData();
		page = new Page(pageNum, totalData, 5);
		List<Setdata> setdatas = dataDao.findPageData(page.getStartIndex(), page.getPageSize());
		page.setItems(setdatas);
		return page;
	}

}
