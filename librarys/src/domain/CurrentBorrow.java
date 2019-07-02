package domain;

import java.sql.Date;

public class CurrentBorrow {
	private String ISBN;
	private int ID;
	private Date borrowtime;
	private String bookname;
	private int stunumber;
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
	public Date getBorrowtime() {
		return borrowtime;
	}
	public void setBorrowtime(Date borrowtime) {
		this.borrowtime = borrowtime;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public int getStunumber() {
		return stunumber;
	}
	public void setStunumber(int stunumber) {
		this.stunumber = stunumber;
	}
	
}

