package dao;

import java.util.List;

import domain.Manager;

public interface managerDao {
	void addManager(Manager manager);
	
	void update(Manager manager);
	
	Manager findManagerById(int id);
	
	Manager findManager(String username, String password);	//閫氳繃鐢ㄦ埛鍚嶅拰瀵嗙爜鏉ュ鎵剧敤浜庣櫥褰曠殑妫�鏌�
	
	void deleteManager(Manager manager);
	
	List<Manager> findPageManager(int startIndex,int size);

	List<Manager> findAllManager();

	int getTotalManager();
}
