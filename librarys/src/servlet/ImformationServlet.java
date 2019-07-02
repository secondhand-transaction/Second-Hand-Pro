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
 * Servlet implementation class ImformationServlet
 */
public class ImformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RegisterDAO registerDAO = RegisterDAO.getInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImformationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	     request.setCharacterEncoding("UTF-8");  
	        response.setContentType("text/html;charset=UTF-8");
	        response.setHeader( " content-type", "text/html; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
		HttpSession session =request.getSession(true);

		long stunumber =  (long) session.getAttribute("stunumber");
		
		Readerx reader = new Readerx();
		reader = registerDAO.get(stunumber);
		request.setAttribute("reader", reader);
		request.getRequestDispatcher("imformation.jsp").forward(request, response);
	}

}
