package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAOs;
import dao.CurrentBorrowDAO;
import dao.DataDao;
import dao.HistoryBorrowDAOs;
import dao.ReaderDAO1;
import domain.Setdata;
import entity.Book;
import entity.CurrentBorrow;
import entity.Reader1;


public class ReturnBookServlet extends HttpServlet {
    private ReaderDAO1 reader= ReaderDAO1.getInstance();
    private CurrentBorrowDAO currentborrow=CurrentBorrowDAO.getInstance();
    private BookDAOs book=BookDAOs.getInstance();
    private HistoryBorrowDAOs history=HistoryBorrowDAOs.getInstance();

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
	    response.setHeader("content-type", "text/html;charset=UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    request.setCharacterEncoding("UTF-8");
	    int lend=0;
	    try{
	    	
	    	int ID=0;
	    	int tag=0;
	    	String a=null;
	    	a=request.getParameter("bookid");
	    	ID=Integer.parseInt(a);

	    	tag=Integer.parseInt(request.getParameter("tag"));
	    	Timestamp borrowtime=new Timestamp(System.currentTimeMillis());
	    	Timestamp returntime=new Timestamp(System.currentTimeMillis());
	    	double fine=0.0;
	    	if(currentborrow.get(ID)!=null)
	    	{
	    	borrowtime=currentborrow.get(ID).getBorrowtime();

	    	Setdata setdata= new DataDao().selectone();
	    	fine=(double) ((returntime.getTime()-borrowtime.getTime())*1.0*setdata.getFine()/(60*60*24*1000));
	    	System.out.println(setdata.getDay());
	    	if(fine>setdata.getFine()*setdata.getDay())
	    	{
	    	ReaderDAO1.addfine(fine-setdata.getFine()*setdata.getDay(),currentborrow.get(ID).getStunumber());
	    	
	    	}
	    	if(fine<setdata.getFine()*setdata.getDay())fine=0;
	    	}
	    	System.out.println(currentborrow.get(ID));
	    	System.out.println(tag);
	    	if(currentborrow.get(ID)!=null)
	    	{
	    	     history.add(currentborrow.get(ID).getISBN(), ID, borrowtime, returntime, currentborrow.get(ID).getBookname(), currentborrow.get(ID).getStunumber(), fine);
	    	     currentborrow.delete(ID);
	    	lend=1;
	    	}
	    	else if(currentborrow.get(ID)==null&&tag==1)lend=2;
	    	else lend=0;
	    	
	 
	    }
	    catch(NumberFormatException e)
		{	
		}
	    request.setAttribute("lend", lend);
    request.getRequestDispatcher("returnBook.jsp").forward(request, response);
	}
}
