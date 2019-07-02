package entity;

public class DeleteBook {

	
	private String ISBN;
	private int ID;
	private String bookname;
	private int account;
	private int type;
	
	
	public DeleteBook() {

	}

	public DeleteBook(String iSBN, int iD, String bookname, int account,int type) {
		super();
		ISBN = iSBN;
		ID = iD;
		this.bookname = bookname;
		this.account = account;
		this.type=type;
	}
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public int getAccount() {
		return account;
	}
	public void setAccount(int account) {
		this.account = account;
	}
	
	
}
