package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Book;
import entity.Income;
import utils.DBHelper;

public class IncomeRecordDAO {
	public static List<Income> finelist(int start, int count) {
		List<Income> incomes = new ArrayList<Income>();

		try {

			Connection c = DBHelper.getInstance().getConnection();

			String sql = "select * from income where type = 1 order by id desc limit ?,? ";

			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, count);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Income income=new Income();
				long stunumber=rs.getLong("stunumber");
			    Date time=rs.getDate("time");
			    int type=rs.getInt("type");
			    double money=rs.getDouble("money");
			    int ID=rs.getInt("ID");
			    
	            income.setMoney(money);
	            income.setStunumber(stunumber);
	            income.setTime(time);
	            income.setType(type);
				incomes.add(income);
			}
			DBHelper.closeConnection(c, ps, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return incomes;
	}
	public static int getTotal1() {
		int total = 0;
		try {

			Connection c = DBHelper.getInstance().getConnection();

			Statement s = c.createStatement();

			String sql = "select count(*) from income where type = 1";

			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				total = rs.getInt(1);
			}

			System.out.println("total:" + total);

			DBHelper.closeConnection(c, s, rs);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}
	public static List<Income> depositelist(int start, int count) {
		List<Income> incomes = new ArrayList<Income>();

		try {

			Connection c = DBHelper.getInstance().getConnection();

			String sql = "select * from income where type = 2 order by id desc limit ?,? ";

			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, count);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Income income=new Income();
				long stunumber=rs.getLong("stunumber");
			    Date time=rs.getDate("time");
			    int type=rs.getInt("type");
			    double money=rs.getDouble("money");
			    int ID=rs.getInt("ID");
			    
	            income.setMoney(money);
	            income.setStunumber(stunumber);
	            income.setTime(time);
	            income.setType(type);
				incomes.add(income);
			}
			DBHelper.closeConnection(c, ps, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return incomes;
	}
	public static int getTotal2() {
		int total = 0;
		try {

			Connection c = DBHelper.getInstance().getConnection();

			Statement s = c.createStatement();

			String sql = "select count(*) from income where type = 2 ";

			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				total = rs.getInt(1);
			}

			System.out.println("total:" + total);

			DBHelper.closeConnection(c, s, rs);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}
	public static double[] getTotal1(int y,int m,int d) {
		int total = 0;
		double[] total1=new double[3];
		try {

			Connection c = DBHelper.getInstance().getConnection();

			Statement s = c.createStatement();

			String sql = "select * from income";

			ResultSet rs = s.executeQuery(sql);
			int year=0;
			int month=0;
			int day=0;
			double money=0;

			while (rs.next()) {
				
				year=rs.getDate("time").getYear()+1900;
				
				month=rs.getDate("time").getMonth()+1;
				
				day=rs.getDate("time").getDate();
				
				money=rs.getDouble("money");
				if(year==y) {total1[0]+=money;
				if(month==m){
					total1[1]+=money;
					if(day==d){total1[2]+=money;}
				}
				}
				
			}

			DBHelper.closeConnection(c, s, rs);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return total1;
	}
}
