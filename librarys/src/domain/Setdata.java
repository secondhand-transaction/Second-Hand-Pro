package domain;

public class Setdata {
     
	public double fine;
	public int id;
	public int day;
	public int deposit;
	
	public Setdata(){
		
	}
	public Setdata(int id,double fine,int day,int deposit)
	{	
		this.id=id;
		this.fine=fine;
		this.day=day;
		this.deposit=deposit;
	}
	public double getFine() {
		return fine;
	}
	public void setFine(double fine) {
		this.fine = fine;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getDeposit() {
		return deposit;
	}
	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
}
