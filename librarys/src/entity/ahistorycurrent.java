package entity;

import java.sql.Date;

public class ahistorycurrent {

	private String ISBN;
	private String ID;
	private Date borrowtime;
	private Date returntime;
	private String bookname;
	private long stunumber;
	private double historyfine;

	public ahistorycurrent() {

	}

	public ahistorycurrent(String iSBN, String iD, Date borrowtime, Date returntime, String bookname, long stunumber,
			double historyfine) {
		super();
		ISBN = iSBN;
		ID = iD;
		this.borrowtime = borrowtime;
		this.returntime = returntime;
		this.bookname = bookname;
		this.stunumber = stunumber;
		this.historyfine = historyfine;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getID() {
		return ID;
	}

	public void setID(String id2) {
		ID = id2;
	}

	public Date getBorrowtime() {
		return borrowtime;
	}

	public void setBorrowtime(Date borrowtime) {
		this.borrowtime = borrowtime;
	}

	public Date getReturntime() {
		return returntime;
	}

	public void setReturntime(Date returntime) {
		this.returntime = returntime;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public long getStunumber() {
		return stunumber;
	}

	public void setStunumber(long stunumber) {
		this.stunumber = stunumber;
	}

	public double getHistoryfine() {
		return historyfine;
	}

	public void setHistoryfine(double historyfine) {
		this.historyfine = historyfine;
	}

}