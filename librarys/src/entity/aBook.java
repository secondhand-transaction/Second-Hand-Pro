package entity;

import java.sql.Date;

public class aBook {
	private String ISBN;
	private String ID;
	private String author;
	private String press;
	private String catagory;
	private String bookname;
	private String version;
	private String introduction;
	private String isborrow;
	// private date printdate;
	private String isorder;
	private String location;
	private Date printdate;
	private int cnt;
	private String yu;
	private String borrow;
	private double price;

	public aBook() {

	}

	public aBook(String iSBN, String iD, String author, String press, String catagory, String bookname, String version,
			String introduction, String isborrow, String isorder, String location, Date printdate, int cnt, String yu,
			String borrow, double price) {
		super();
		ISBN = iSBN;
		ID = iD;
		this.author = author;
		this.press = press;
		this.catagory = catagory;
		this.bookname = bookname;
		this.version = version;
		this.introduction = introduction;
		this.isborrow = isborrow;
		this.isorder = isorder;
		this.location = location;
		this.printdate = printdate;
		this.cnt = cnt;
		this.yu = yu;
		this.borrow = borrow;
		this.price = price;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPress() {
		return press;
	}

	public void setPress(String press) {
		this.press = press;
	}

	public String getCatagory() {
		return catagory;
	}

	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getIsborrow() {
		return isborrow;
	}

	public void setIsborrow(String isborrow) {
		this.isborrow = isborrow;
	}

	public String getIsorder() {
		return isorder;
	}

	public void setIsorder(String isorder) {
		this.isorder = isorder;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getPrintdate() {
		return printdate;
	}

	public void setPrintdate(Date printdate) {
		this.printdate = printdate;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public String getYu() {
		return yu;
	}

	public void setYu(String yu) {
		this.yu = yu;
	}

	public String getBorrow() {
		return borrow;
	}

	public void setBorrow(String borrow) {
		this.borrow = borrow;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	

}