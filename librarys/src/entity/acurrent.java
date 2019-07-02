package entity;

import java.sql.Date;

public class acurrent {

	private String ISBN;
	private String bookname;
	private Date borrowtime;
	private String ID;
	private long stunumber;
	private String returntime;
	
	public acurrent() {

	}

	public acurrent(String iSBN, String bookname, Date borrowtime, String iD, long stunumber) {
		super();
		ISBN = iSBN;
		this.bookname = bookname;
		this.borrowtime = borrowtime;
		ID = iD;
		this.stunumber = stunumber;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getReturntime() {
		return returntime;
	}

	public void setReturntime(String d) {
		this.returntime = d;
	}
	
	public Date getBorrowtime() {
		return borrowtime;
	}

	public void setBorrowtime(Date borrowtime) {
		this.borrowtime = borrowtime;
	}

	public String getID() {
		return ID;
	}

	public void setID(String id2) {
		ID = id2;
	}

	public long getStunumber() {
		return stunumber;
	}

	public void setStunumber(long stunumber) {
		this.stunumber = stunumber;
	}

}