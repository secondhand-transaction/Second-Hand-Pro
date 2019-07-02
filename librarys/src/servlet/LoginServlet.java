package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RegisterDAO;
import entity.Announcement;
import entity.Readerx;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RegisterDAO registerDAO = RegisterDAO.getInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */ 
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     request.setCharacterEncoding("UTF-8");  
	        response.setContentType("text/html;charset=UTF-8");
	        response.setHeader( " content-type", "text/html; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
		String name = request.getParameter("user"); 
		
		String password = request.getParameter("pwd"); 
		Readerx reader = null;
		HttpSession session =request.getSession(true);
		List<Announcement> ans = registerDAO.geta();
		Announcement an = new Announcement(1,"none");
		for (int i = 0; i < ans.size(); i++) {
			 if(an.getID()<=ans.get(i).getID()){
				 
				 an = ans.get(i);
			 }
			
        }
		session.setAttribute("an", an.getContent());
		PrintWriter out = response.getWriter();
		int i = registerDAO.login(name, password);
		
		 if(i==1){ 
			  reader = new Readerx();
		
			  reader = registerDAO.get(Long.parseLong(name));
			  
			  session.setAttribute("stunumber", reader.getStunumber());
			  session.setAttribute("name", reader.getName());
			  session.setAttribute("password", reader.getPassword());
		
			  response.sendRedirect("IndexServlet"); 
			 }else if(i==0){ 
			  System.out.println("Login failure！"); 
			  out.print("<script type='text/javascript' charset='utf-8'> alert('Incorrect student account or password.');</script>");
		      response.setHeader("refresh", "0;url=login.jsp");  
			 } 
			 else if(i==2){
				 reader = new Readerx();
				 reader = registerDAO.get(Long.parseLong(name));
				 int account=(int) reader.getStunumber();
				 session.setAttribute("account", account);
				  session.setAttribute("Librarianname", reader.getName());
				  session.setAttribute("Librarianpassword", reader.getPassword());
			  response.sendRedirect("BookListServlet");  
			 }
			 else if(i==3){
			  response.sendRedirect("manager/index.jsp");
			 }
	}

}
