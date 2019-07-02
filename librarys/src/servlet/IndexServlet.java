package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AReplyDAO;
import entity.Book;

public class IndexServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AReplyDAO replyDAO = AReplyDAO.getInstance();
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setHeader( " content-type", "text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		int start = 0;
		int count = 6;
		try {
			start = Integer.parseInt(request.getParameter("start"));
		} catch (NumberFormatException e) {
			// 当浏览器没有传参数start时
		}

		int next = start + count;
		int pre = start - count;

		int total = replyDAO.getTotal();

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
		List<Book> books = replyDAO.list(start, count);
		
		request.setAttribute("books", books);

		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

}

