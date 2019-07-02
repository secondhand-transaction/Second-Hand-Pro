package business;

import java.util.List;

import domain.CurrentBorrow;
import domain.Customer;
import domain.Manager;
import domain.Setdata;
import page.Page;

public interface Business {

	void registCustomer(Customer customer);
	
	void activeCustomer(Customer customer);
	
	Customer findCustomerById(int id);
	
	Setdata findSetDataById(int id);
	
	Customer loginCustomer(String username, String password);
	
	List<Customer> findAllCustomer();
	
	List<Setdata> findAllSetData();
	
	List<Customer> findAllOverdueCustomer();

	List<CurrentBorrow > findAllCurrentBorrow();
	
	void addUser(Customer customer);

	void deleteCustomer(Customer customer);

	void editUser(Customer c);
	
	void editSetData(Setdata s);
	
	Page findCustomerpage(String num);
	
	Page findSetDatapage(String num);
	
	Page findCurrentBorrowpage(String num);
	
	/*Page findOverdueCustomerpage(String num);*/
	
	void overdueAmount();
	
    void registManager(Manager manager);
	
	void activeManager(Manager manager);
	
	Manager findManagerById(int id);
	
	Manager loginManager(String username, String password);
	
	CurrentBorrow findCurrentById(int id);
	
	List<Manager> findAllManager();

	void addManager(Manager manager);

	void deleteManager(Manager manager);

	void editManager(Manager manager);
	
	Page findManagerpage(String num);

	Page findOverdueCustomerpage(String num);
	
	Page findOverdueCustomerpageById(String num,int id);
	
	
}
