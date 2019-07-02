package servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CurrentBorrowDAO_1;
import dao.HistoryBorrowDAO_1;
import dao.PersonInformationDAO;
import entity.CurrentBorrow;
import entity.CurrentBorrow1;
import entity.HistoryBorrow;
import entity.HistoryBorrow1;
import entity.Income;
import entity.Reader;
import entity.Reader1;

/**
 * Servlet implementation class PersonInformationServlet
 */
public class PersonInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PersonInformationServlet() {
        super();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setHeader("content-type", "text/html;charset=UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    request.setCharacterEncoding("UTF-8");
	    
		CurrentBorrowDAO_1 currentborrow = new CurrentBorrowDAO_1();
		HistoryBorrowDAO_1 historyborrow = new HistoryBorrowDAO_1();
		PersonInformationDAO personDAO = new PersonInformationDAO();
		Date date = new Date();
		Reader1 reader = new Reader1();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		int start = 0;
		int count = 8;
		
	    int isPayFine = 0;
	    int isEdit = 0;
	    long Stunumber = 456;
	    Double fine = 0.0;
	    Long poNumber = (long) 0;

		if(request.getParameter("isPayFine")!=null){
			isPayFine = Integer.parseInt(request.getParameter("isPayFine"));
			fine = Double.parseDouble(request.getParameter("pofine"));
			poNumber = Long.parseLong(request.getParameter("ponumber"));
		}
		if(request.getParameter("isEdit")!=null){
			isEdit = Integer.parseInt(request.getParameter("isEdit"));
			reader.setStunumber(Long.parseLong(request.getParameter("ponumber")));
			reader.setName(request.getParameter("name_submit"));
			reader.setAddress(request.getParameter("address_submit"));
			reader.setEmail(request.getParameter("Enumber_submit"));
			String deposit_1 = request.getParameter("deposit_submit");
			int deposit_2 = Integer.parseInt(deposit_1);
			reader.setDeposit(deposit_2);
			reader.setFine(Double.parseDouble(request.getParameter("fine_submit")));
		}
		
		if(request.getParameter("ponumber")!=null){
			Stunumber = Long.parseLong(request.getParameter("ponumber").trim());
		}
		if(isPayFine == 1){
			int countOfFine = personDAO.getTotalFromIncome();
			Income income = new Income(poNumber,sqlDate,1,fine);
			personDAO.addFineRecord(income,countOfFine+1);
			personDAO.payFine(Stunumber);
		}
		if(isEdit == 1){
			personDAO.update(reader);
		}
	    
		try {

			start = Integer.parseInt(request.getParameter("start"));
		} catch (NumberFormatException e) {}
		
		int next = start + count;
		int pre = start - count;

		int total = personDAO.getTotal();

		int last;
		if (0 == total % count)
			last = total - count;
		else
			last = total - total % count;

		pre = pre < 0 ? 0 : pre;
		next = next > last ? last : next;
		request.setAttribute("next", next);
		request.setAttribute("pre", pre);
		request.setAttribute("last", last);
		
		List<CurrentBorrow1> currentBorrows = currentborrow.list(Stunumber);
		List<HistoryBorrow1> historyBorrows = historyborrow.list(start,count,Stunumber);
		List<Reader> readers = personDAO.list(Stunumber);
		request.setAttribute("currentBorrows", currentBorrows);
		request.setAttribute("historyBorrows", historyBorrows);
		
		request.setAttribute("readers", readers);
		request.getRequestDispatcher("PersonInformation.jsp").forward(request, response);
}
}
