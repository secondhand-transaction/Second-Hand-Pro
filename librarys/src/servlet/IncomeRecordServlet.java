package servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IncomeRecordDAO;
import entity.Income;
@WebServlet("/IncomeRecordServlet")
public class IncomeRecordServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setHeader("content-type", "text/html;charset=UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    request.setCharacterEncoding("UTF-8");
	    
	    
		int start1 = 0;
		int count = 5;
		int select=0;
		int start2 = 0;
        Date current=new Date(System.currentTimeMillis());
        int year=current.getYear()+1900;
        int month=current.getMonth()+1;
        int day=current.getDate();
        double[] money=IncomeRecordDAO.getTotal1(year, month, day);
		try {
			
			start1 = Integer.parseInt(request.getParameter("start1"));
			select = Integer.parseInt(request.getParameter("select"));
			
			
		
			
		} catch (NumberFormatException e) {
			// 褰撴祻瑙堝櫒娌℃湁浼犲弬鏁皊tart鏃�
		}

	    

	
		int next1 = start1 + count;
		int pre1 = start1 - count;
		int total1;
		System.out.println(start1);
		System.out.println(select);
		System.out.println("111111111111111111111");
		total1 = IncomeRecordDAO.getTotal1();
		int last1=0;
		if(total1!=0)
		{
		if (0 == total1 % count)
			last1 = total1 - count;
		else
			last1 = total1 - total1 % count;
		}
		pre1 = pre1 < 0 ? 0 : pre1;
		next1 = next1 > last1 ? last1 : next1;
		request.setAttribute("next1", next1);
		request.setAttribute("pre1", pre1);
		request.setAttribute("last1", last1);
		request.setAttribute("select", select);
		List<Income> incomes1;
		incomes1 = IncomeRecordDAO.finelist(start1, count);
		request.setAttribute("incomes1", incomes1);
		request.setAttribute("start1", start1); 
		request.setAttribute("total", total1);
		
	try {
			
			start2 = Integer.parseInt(request.getParameter("start2"));	
		} catch (NumberFormatException e) {
			// 褰撴祻瑙堝櫒娌℃湁浼犲弬鏁皊tart鏃�
		}

		int next2 = start2 + count;
		int pre2 = start2 - count;
		int total2;
		total2 = IncomeRecordDAO.getTotal2();
		int last2=0;
		if(total2!=0)
		{
		if (0 == total2 % count)
			last2 = total2 - count;
		else
			last2 = total2 - total2 % count;
		}
		pre2 = pre2 < 0 ? 0 : pre2;
		next2 = next2 > last2 ? last2 : next2;
		request.setAttribute("next2", next2);
		request.setAttribute("pre2", pre2);
		request.setAttribute("last2", last2);
		List<Income> incomes2;
		incomes2 = IncomeRecordDAO.depositelist(start2, count);
		request.setAttribute("incomes2", incomes2);
		request.setAttribute("start2", start2); 
		request.setAttribute("total2", total2);
		
		request.setAttribute("year", money[0]);
		request.setAttribute("month", money[1]);
		request.setAttribute("day", money[2]);
		

	request.getRequestDispatcher("IncomeRecord.jsp").forward(request, response);

	}

}
