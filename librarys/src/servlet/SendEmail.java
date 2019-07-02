package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RegisterDAO;
import entity.Readerx;

/**
 * Servlet implementation class SendEmail
 */
@WebServlet("/SendEmail")
public class SendEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RegisterDAO registerDAO = RegisterDAO.getInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendEmail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");  
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader( " content-type", "text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session1 =request.getSession(true);
		session1.setMaxInactiveInterval(600);
		long account = Long.parseLong(request.getParameter("account"));
		String email = request.getParameter("email");
		Readerx reader = new Readerx();
		reader = registerDAO.get(account);
		if(reader.getEmail().equals("1")){
			out.print("<script type='text/javascript' charset='utf-8'> alert('Incorrect account!');</script>");
			response.setHeader("refresh", "0;url=register.jsp");  
		}
		else if(!reader.getEmail().equals(email)){
			out.print("<script type='text/javascript' charset='utf-8'> alert('Incorrect email!');</script>");
			response.setHeader("refresh", "0;url=register.jsp");  
		}
		else if(reader.getEmail().equals(email)){
			System.out.println(reader.getName());
			  session1.setAttribute("password1", reader.getPassword());
			  session1.setAttribute("name1", reader.getName());
			  session1.setAttribute("email1", reader.getEmail());
			request.getRequestDispatcher("Return").forward(request, response);
		}
	}

}
