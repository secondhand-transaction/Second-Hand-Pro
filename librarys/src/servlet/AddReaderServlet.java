package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.AddReaderDAO;
import dao.DataDao;
import domain.Setdata;
import entity.Reader1;

/**
 * Servlet implementation class AddReaderServlet
 */
public class AddReaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
	    response.setHeader("content-type", "text/html;charset=UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    request.setCharacterEncoding("UTF-8");
	    String name=null;
	    String stunumber1=null;
	    Setdata setdata= new DataDao().selectone();
	    int deposit=0;
	    deposit=setdata.getDeposit();
		String email=null;
		 request.setAttribute("deposit", deposit);
		 System.out.println(deposit);
		String address=null;
		System.out.println("00000000000000000");
		try{
			name = request.getParameter("name");
			stunumber1=request.getParameter("stunumber");
			email=request.getParameter("email");
			
			address=request.getParameter("address");
		}
	catch(NumberFormatException e)
	{	
		
	}
		System.out.println(name);
		System.out.println("1111111111111");
	long stunumber=Long.parseLong(stunumber1);
	
		if(stunumber!=0)
		{
			new AddReaderDAO();
			int i=AddReaderDAO.register(stunumber);
			if(i==0)
			{
			
				Reader1 reader=new Reader1(name,stunumber,"111111",0,email,address,deposit);
				new AddReaderDAO();
				AddReaderDAO.add(reader);
				i=2;
				request.setAttribute("i", i);
				request.setAttribute("stunumber",stunumber);
				request.getRequestDispatcher("ShowReaderServlet").forward(request, response);
			}
			else if(i==1)
			{
				 request.setAttribute("i", i);
				 request.getRequestDispatcher("addreader.jsp").forward(request, response);
			}
		}
		
		

	}

}
