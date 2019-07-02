package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RegisterDAO;
import entity.Readerx;

/**
 * Servlet implementation class ImformationNewServlet
 */
public class ImformationNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RegisterDAO registerDAO = RegisterDAO.getInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImformationNewServlet() {
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
		response.setContentType("text/html; charset=UTF-8");
		response.setHeader("content-type", "text/html;charset=UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    request.setCharacterEncoding("UTF-8");   
		
	    
		    Readerx reader = new Readerx();
		    
		    HttpSession session =request.getSession(true);
		    
		    reader.setStunumber((long) session.getAttribute("stunumber"));
		    
		    String password = request.getParameter("password"); 
		    if(password.equals((String) session.getAttribute("password"))){
		    	
		    	reader.setPassword(request.getParameter("newpassword") );
		    	reader.setName(request.getParameter("name"));
		    	registerDAO.updatePa(reader);
				 session.setAttribute("password", reader.getPassword());
		    	response.sendRedirect("ImformationServlet");
		    }
		    else{
		    	reader.setName(request.getParameter("name") );
		    	
		    	reader.setEmail(request.getParameter("email") );
		    	registerDAO.updateIn(reader);
		    	 session.setAttribute("name", reader.getName());
		    	response.sendRedirect("ImformationServlet");
		    }
	}

}
