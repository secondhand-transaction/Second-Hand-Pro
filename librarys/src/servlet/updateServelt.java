package servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.abookDAO;

public class updateServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private abookDAO aBookDAO = abookDAO.getInstance();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/*String ISBN =Integer.parseInt(request.getParameter("ISBN"));*/
		HttpSession session =request.getSession(true);
		String ISBN = request.getParameter("ISBN");
		Long ph = (Long) session.getAttribute("stunumber");
		int ID = Integer.parseInt(request.getParameter("ID"));
		aBookDAO.add(ID,ph );
		aBookDAO.update(ISBN,ID) ;
		
		System.out.println(ISBN);
		
		System.out.println(ID);
		
		
		
		request.getRequestDispatcher("abookmassageServelt").forward(request, response);
		
	}

}