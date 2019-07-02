package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.abookDAO;
import entity.aBook;

public class abookmassageServelt1 extends HttpServlet {
	
	  
	private static final long serialVersionUID = 1L;
	
	private abookDAO aBookDAO = abookDAO.getInstance();

	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		String i =  (String) request.getParameter("ISBN");
		
		System.out.println(i);
		int total = aBookDAO.getTotal(i);
		String yes = aBookDAO.yes(i);

		List<aBook> abooks = aBookDAO.list(i);
		
		request.setAttribute("abooks", abooks);
		
		request.setAttribute("total", total);
		
		request.setAttribute("yes", yes);
		
		
		request.getRequestDispatcher("book1.jsp").forward(request, response);

	}

}
