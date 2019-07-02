	package entity;
	
	
	import java.awt.Graphics;
import java.sql.Date;
	
	
	public class Book1 {
	private String ISBN;
	private String ID;
	private String author;
	private String press;
	private String category;
	private String bookname;
	private String version;
	private String introduction;
	private int isborrow;
	
	private Date printdate;
	private int isorder;
	private int number;
	private int borrownumber;
	private String location;
	private double price;
	private Graphics g ;
	public Book1() {
	
	}
	public Graphics getGraphics() {
		return g;
	}
	public void setGraphics(Graphics g) {
		this.g = g;
	}
	public Book1(String ISBN,String ID,String author,String press,String category,String bookname,String version,String introduction,int isborrow,Date printdate,int isorder,String location,double price) {
		super();
		this.ISBN=ISBN;
		this.ID=ID;
		this.author=author;
		this.press=press;
		this.category=category;
		this.bookname=bookname;
		this.version=version;
		this.introduction=introduction;
		this.isborrow=isborrow;
		this.printdate=printdate;
		this.isorder=isorder;
		this.location=location;
		this.price=price;
	}
	
	public void Book1_Book(Book book){
		this.ISBN=book.getISBN();
		this.ID=String.format("%013d", book.getID());
		this.author=book.getAuthor();
		this.category=book.getCategory();
		this.press=book.getPress();
		this.bookname=book.getBookname();
		this.version=book.getVersion();
		this.introduction=book.getIntroduction();
		this.isborrow=book.getIsborrow();
		this.printdate=book.getPrintdate();
		this.isorder=book.getIsorder();
		this.location=book.getLocation();
		this.price=book.getPrice();
	}
	
	/**
	 * @return the iSBN
	 */
	public String getISBN() {
		return ISBN;
	}
	
	/**
	 * @param iSBN the iSBN to set
	 */
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	
	/**
	 * @return the iD
	 */
	public String getID() {
		return ID;
	}
	
	/**
	 * @param iD the iD to set
	 */
	public void setID(String iD) {
		ID = iD;
	}
	
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	
	/**
	 * @return the press
	 */
	public String getPress() {
		return press;
	}
	
	/**
	 * @param press the press to set
	 */
	public void setPress(String press) {
		this.press = press;
	}
	
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	
	/**
	 * @return the bookname
	 */
	public String getBookname() {
		return bookname;
	}
	
	/**
	 * @param bookname the bookname to set
	 */
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	
	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}
	
	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	
	/**
	 * @return the introduction
	 */
	public String getIntroduction() {
		return introduction;
	}
	
	/**
	 * @param introduction the introduction to set
	 */
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
	/**
	 * @return the isborrow
	 */
	public int getIsborrow() {
		return isborrow;
	}
	
	/**
	 * @param isborrow the isborrow to set
	 */
	public void setIsborrow(int isborrow) {
		this.isborrow = isborrow;
	}
	
	/**
	 * @return the printdate
	 */
	public Date getPrintdate() {
		return printdate;
	}
	
	/**
	 * @param printdate the printdate to set
	 */
	public void setPrintdate(Date printdate) {
		this.printdate = printdate;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getBorrownumber() {
		return borrownumber;
	}
	public void setBorrownumber(int borrownumber) {
		this.borrownumber = borrownumber;
	}
	public int getIsorder() {
		return isorder;
	}
	public void setIsorder(int isorder) {
		this.isorder = isorder;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setTags(String string) {
		// TODO Auto-generated method stub
		
	}
	
	
	}
