package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RegisterDAO;
import entity.Announcement;

/**
 * Servlet implementation class SeServlet
 */
@WebServlet("/SeServlet")
public class SeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RegisterDAO registerDAO = RegisterDAO.getInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	     request.setCharacterEncoding("UTF-8");  
	        response.setContentType("text/html;charset=UTF-8");
	        response.setHeader( " content-type", "text/html; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
		HttpSession session =request.getSession(true);
		List<Announcement> ans = registerDAO.geta();
		Announcement an = new Announcement(1,"none");
		for (int i = 0; i < ans.size(); i++) {
			 if(an.getID()<=ans.get(i).getID()){
				 
				 an = ans.get(i);
			 }
			
        }
		session.setAttribute("an", an.getContent());
		response.sendRedirect("IndexServlet1");

		
	}

}
