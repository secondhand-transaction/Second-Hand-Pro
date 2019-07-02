package dao;

import java.util.List;

import domain.Customer;

public interface customerDao {
	void addCustomer(Customer customer);
	
	void update(Customer customer);
	
	Customer findCustomerById(int id);
	
	Customer findCustomer(String username, String password);	//閫氳繃鐢ㄦ埛鍚嶅拰瀵嗙爜鏉ュ鎵剧敤浜庣櫥褰曠殑妫�鏌�
	
	void deleteCustomer(Customer customer);
	
	List<Customer> findPageCustomer(int startIndex,int size);

	List<Customer> findAllCustomer();

	List<Customer> findAllOverdueCustomer();
	
	int getTotalCustomer();

	int getTotalOverdueCustomer();

	List<Customer> findPageOverdueCustomer(int startIndex, int size);

}
