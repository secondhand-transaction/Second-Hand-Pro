package entity;

public class Reader {
	
	private String name;
	private long stunumber;
	private String password;
	private double fine;
	private String email;
	private int overduebooks;
	private String address;
	private int deposit;
	
	public Reader() {}
	
	public Reader(String name, int stunumber, String password, double fine, String email, int overduebooks,
			String address, int deposit) {
		super();
		this.name = name;
		this.stunumber = stunumber;
		this.password = password;
		this.fine = fine;
		this.email = email;
		this.overduebooks = overduebooks;
		this.address = address;
		this.deposit = deposit;
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

	public int getOverduebooks() {
		return overduebooks;
	}

	public void setOverduebooks(int overduebooks) {
		this.overduebooks = overduebooks;
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
	
	

}
