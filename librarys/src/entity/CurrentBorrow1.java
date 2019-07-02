package entity;

import java.sql.Timestamp;

public class CurrentBorrow1 {

	private String ISBN;
	private String ID;
	private Timestamp borrowtime;
	private String bookname;
	private long stunumber;
	
	
	public CurrentBorrow1() {

	}
	
	public CurrentBorrow1(String iSBN, String iD, Timestamp borrowtime, String bookname,
			long stunumber) {
		super();
		ISBN = iSBN;
		ID = iD;
		this.borrowtime = borrowtime;
		this.bookname = bookname;
		this.stunumber = stunumber;
	}
	
	public void Current1_Current(CurrentBorrow currentBorrow){
		this.ISBN = currentBorrow.getISBN();
		this.ID=String.format("%013d", currentBorrow.getID());
		this.borrowtime = currentBorrow.getBorrowtime();
		this.bookname = currentBorrow.getBookname();
		this.stunumber = currentBorrow.getStunumber();
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
	public void setID(String iD) {
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
