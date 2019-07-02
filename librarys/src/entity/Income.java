package entity;

import java.sql.Date;

public class Income {
	
	
	private long stunumber;
	private Date time;
	private int type;
	private double money;
	
	
	public Income(){
		
	}
	public Income(long stunumber, Date time, int type, double money)
	{
		this.stunumber=stunumber;
		this.time=time;
		this.type=type;
		this.money=money;
	}
	public long getStunumber() {
		return stunumber;
	}
	public void setStunumber(long stunumber) {
		this.stunumber = stunumber;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
}
