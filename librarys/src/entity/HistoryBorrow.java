package entity;

import java.sql.Timestamp;

public class HistoryBorrow {

	private String ISBN;
	private int ID;
	private Timestamp borrowtime;
	private Timestamp returntime;
	private String bookname;
	private long stunumber;
	private double historyfine;
	
	public HistoryBorrow() {

	}
	public HistoryBorrow(String iSBN, int iD, Timestamp borrowtime, Timestamp returntime, String bookname,
			long stunumber,double historyfine) {
		super();
		ISBN = iSBN;
		ID = iD;
		this.borrowtime = borrowtime;
		this.returntime = returntime;
		this.bookname = bookname;
		this.stunumber = stunumber;
		this.historyfine=historyfine;
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
	public Timestamp getReturntime() {
		return returntime;
	}
	public void setReturntime(Timestamp returntime) {
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
