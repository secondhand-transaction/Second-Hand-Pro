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

import org.apache.jasper.tagplugins.jstl.core.Out;

import dao.BookDAOs;
import dao.CurrentBorrowDAO;
import dao.DataDao;
import dao.HistoryBorrowDAOs;
import dao.ReaderDAO1;
import domain.Setdata;
import entity.Book;
import entity.CurrentBorrow;
import entity.Reader1;

/**
 * Servlet implementation class ReaderServlet1
 */
public class ReaderServlet1 extends HttpServlet {
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
	    
		try{
	    //接收jsp传输的stunumber值
		long stunumber=0;
		int total1=reader.getTotal();
		boolean bool1=false;

		stunumber=Long.parseLong((request.getParameter("stunumber")));
		 for(int i=0;i<total1;i++)
			 if(stunumber==reader.getAllStu()[i])bool1=true;	 
		if(bool1)
		request.setAttribute("stunumber", stunumber);
        
		//调用get()方法根据stunumber读取读者所有信息
		if(stunumber!=0)
		{
	
		String name=null;
		String email=null;
	
       int lend=0;
       
		//将读者的借阅记录显示
		int start=0;
		int count=5;
		int total=reader.getTotal();


		System.out.println(reader.getAllStu()[2]);
		 System.out.println("iloveyou");
		 boolean bool=false;
		 for(int i=0;i<total;i++)
			 if(stunumber==reader.getAllStu()[i])bool=true;	 
       if(bool){
		List<CurrentBorrow> currentborrows=currentborrow.list(start, count,stunumber);

		request.setAttribute("currentborrows", currentborrows);
		Reader1 readers=new Reader1();
		readers=reader.get(stunumber);
		request.setAttribute("name", readers.getName());
		request.setAttribute("email", readers.getEmail());
		request.setAttribute("fine", readers.getFine());
		lend=6;
       }
       else {
       	System.out.println("shurucuowu");
           lend=7;
       	}
       request.setAttribute("lend", lend);
		  try{
			    long stunumber0=0;
				int ID=0;

			    ID=Integer.parseInt(request.getParameter("userid1"));
			    stunumber0=Long.parseLong(request.getParameter("stunumber"));
				PrintWriter out = response.getWriter();
				if(ID!=0)
				{	
					System.out.println("aaaaaaaaaaaaaaaa");
					Book books=new Book();
					books=book.get(ID);
					System.out.println(books.getIsborrow());
					if(books.getIsborrow()==0)
					{
						 lend=1;
					}
					else{
						if(books.getIsorder()==0)
						{
						 lend=2;
						}
						else
						{
							if(reader.get(stunumber).getFine()>0)
							{
								lend=3;
							}
							else
							{
							    int start1=0;
							    int count1=5;
							    if(currentborrow.list(start1, count1, stunumber).size()>=3)
							    {
							    lend=4;
							   
							    }
							else{
								    book.update(ID);
								    Timestamp dateNow=new Timestamp(System.currentTimeMillis());
								    currentborrow.add(books.getISBN(), ID, dateNow, books.getBookname(), stunumber);
								    lend=5;
							}
							}
						}
						}
					
				}
				}
				catch(NumberFormatException e)
				{	
				}
			 request.setAttribute("lend", lend);
			 System.out.println("aaaaaaaaaaaaaaaaaaaa");
			    //实现还书功能
			 if(lend!=6&&lend!=7)
			 {
			 int start1=0;
			 int count1=5;
				List<CurrentBorrow> currentborrows=currentborrow.list(start, count,stunumber);

				request.setAttribute("currentborrows", currentborrows);
				Reader1 readers=new Reader1();
				readers=reader.get(stunumber);
				request.setAttribute("name", readers.getName());
				request.setAttribute("email", readers.getEmail());
				request.setAttribute("fine", readers.getFine());
			 }

		}
	    }
		catch(NumberFormatException e)
		{	
		}
	  
		request.getRequestDispatcher("borrowLend.jsp").forward(request, response);
	}
}
