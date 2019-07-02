package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Reader1;
import dao.CurrentBorrowDAO;
import dao.ReaderDAO1;

public class ListReaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReaderDAO1 reader= ReaderDAO1.getInstance();
	private CurrentBorrowDAO currentborrow=CurrentBorrowDAO.getInstance();
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
	    response.setHeader("content-type", "text/html;charset=UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    request.setCharacterEncoding("UTF-8");
    	int start=0;
		int count=4;
		long select=0;
		String tag=null;
		long stunumber=0;
		
		int lend=0;
	    try
	    {
	    	
			try {	
				start = Integer.parseInt(request.getParameter("start"));

			} catch (NumberFormatException e) {
				// 当浏览器没有传参数start时
			}
			try {	
				
				select=Long.parseLong(request.getParameter("select"));
				request.setAttribute("select", select);
				System.out.println(select);
			} catch (NumberFormatException e) {
				// 当浏览器没有传参数start时
			}

			try{
				tag=request.getParameter("tag");
				stunumber=Long.parseLong(request.getParameter("stunumber"));
			}
			catch (NumberFormatException e) {
				// 当浏览器没有传参数start时
			}
			System.out.println("tagissssssssssssssssssss");
			System.out.println(stunumber);
			System.out.println(tag);
			int next = start + count;
			int pre = start - count;

			int total = ReaderDAO1.getTotal();

	
			int last=0;
			if(total!=0)
			{
			if (0 == total % count)
				last = total - count;
			else
				last = total - total % count;
			}
			pre = pre < 0 ? 0 : pre;
			next = next > last ? last : next;

			request.setAttribute("next", next);
			request.setAttribute("pre", pre);
			request.setAttribute("last", last);

			List<Reader1> readers=reader.list(start, count);
			request.setAttribute("readers", readers);
	    	 System.out.println(readers.size());
	    	 if(select!=0)
	    	 {
	    		 
	    		 List<Reader1> readers1=reader.list0(start,count,select);
	    		 request.setAttribute("readers", readers1);
	    	 System.out.println("qqqqqqqqqqqqqqqqq");
	    	 System.out.println(readers.size());
	     	   }
	    	 if(tag!=null&&stunumber!=0&&reader.get(stunumber).getFine()==0&&currentborrow.get(stunumber)==null)
	    	 {
	    		 reader.delete(stunumber);
	    	     lend=1;
	    	 }
	    	 else if(tag!=null&&stunumber!=0&&(reader.get(stunumber).getFine()!=0)||currentborrow.get(stunumber)!=null)lend=2;
	    	 else lend=0;
	    }

		catch(NumberFormatException e)
		{	
		}
		 request.setAttribute("lend", lend);
		
		request.getRequestDispatcher("listReader.jsp").forward(request, response);
	}

}
