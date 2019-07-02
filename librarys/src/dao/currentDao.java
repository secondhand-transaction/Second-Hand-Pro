package dao;

import java.util.List;

import domain.CurrentBorrow;

public interface currentDao {
	void addCurrentBorrow(CurrentBorrow currentBorrow);
	
	void update(CurrentBorrow currentBorrow);
	
	CurrentBorrow findCurrentBorrowById(int id);
	
	void deleteCurrentBorrow(CurrentBorrow CurrentBorrow);
	
	List<CurrentBorrow> findPageCurrentBorrow(int startIndex,int size);

	List<CurrentBorrow> findAllCurrentBorrow();
	
	int getTotalCurrentBorrow();
	
	int getCurrentNumById(int id);

	List<CurrentBorrow> findCurrentBorrowsById(int id);
}

