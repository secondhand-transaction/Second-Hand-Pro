package entity;

import java.sql.Timestamp;

public class CurrentBorrow {

	private String ISBN;
	private int ID;
	private Timestamp borrowtime;
	private String bookname;
	private long stunumber;
	
	
	public CurrentBorrow() {

	}
	
	public CurrentBorrow(String iSBN, int iD, Timestamp borrowtime, String bookname,
			long stunumber) {
		super();
		ISBN = iSBN;
		ID = iD;
		this.borrowtime = borrowtime;
		this.bookname = bookname;
		this.stunumber = stunumber;
	}
	
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public Timestamp getBorrowtime() {
		return borrowtime;
	}
	public void setBorrowtime(Timestamp borrowtime) {
		this.borrowtime = borrowtime;
	}

	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public Long getStunumber() {
		return stunumber;
	}
	public void setStunumber(long stunumber) {
		this.stunumber = stunumber;
	}
	
	
	
	
	
}
