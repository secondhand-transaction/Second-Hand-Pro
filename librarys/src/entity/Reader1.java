package entity;

public class Reader1 {

	private String name;
	private long stunumber;
	private String password;
	private double fine;
	private String email;
	private String address;
	
	
	public Reader1() {
	}
	public Reader1(String name, long stunumber, String password, int fine, String email,String address,int deposit) {
		super();
		this.name = name;
		this.stunumber = stunumber;
		this.password = password;
		this.fine = fine;
		this.email = email;
		this.address=address;
		this.deposit=deposit;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public long getStunumber() {
		return stunumber;
	}
	public void setStunumber(long stunumber) {
		this.stunumber = stunumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getFine() {
		return fine;
	}
	public void setFine(double fine) {
		this.fine = fine;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getDeposit() {
		return deposit;
	}
	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	private int deposit;
	
}
