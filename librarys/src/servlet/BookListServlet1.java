package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test1.RetrieveDocumentByURL;

/**
 * Servlet implementation class BookListServlet1
 */

public class BookListServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookListServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ISBN=null;
		ISBN=request.getParameter("ISBN1");
		String num=null;
	
		String floor=null;
		String area=null;
		String shelf=null;
		String category=null;
		num=request.getParameter("number1");
		int number=0;
		if(num!=null)
			number=Integer.parseInt(num);
		String location=null;
		request.setAttribute("ISBN",ISBN);
	
		floor=request.getParameter("floor");
		area=request.getParameter("area");
		shelf=request.getParameter("shelf");
		category=request.getParameter("category");
		location=floor+area+shelf;
		 new RetrieveDocumentByURL("http://api.douban.com/book/subject/isbn/"+ISBN,ISBN,number,location,category);
		 
	request.getRequestDispatcher("ShowServlet").forward(request, response);
	}

}
