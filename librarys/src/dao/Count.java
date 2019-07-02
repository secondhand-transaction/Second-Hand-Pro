package dao;

public class Count {

	private static int count = 1;
	
	public static synchronized int getCount(){
	
		return count++; 
	}
}
