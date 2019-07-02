package entity;

public class Readerx {
	private long stunumber;
	private int fine;
	private int overduebook;
	private String name;
	
	private String password;
	private String email;

	public Readerx() {

	}

	public Readerx(String name ,  long stunumber , String password , int fine , String email , int overduebook){
		super();
		this.name = name;
		this.stunumber = stunumber;
		this.password = password;
		this.fine = fine;
		this.email = email;
		this.overduebook = overduebook;
		
	}

	public long getStunumber() {
		return stunumber;
	}

	public void setStunumber(long stunumber) {
		this.stunumber = stunumber;
	}

	public int getFine() {
		return fine;
	}

	public void setFine(int fine) {
		this.fine = fine;
	}

	public int getOverduebook() {
		return overduebook;
	}

	public void setOverduebook(int overduebook) {
		this.overduebook = overduebook;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



}
