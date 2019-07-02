package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.abookDAO;
import entity.aBook;
import entity.ahistorycurrent;

public class ahistoryServelt extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private abookDAO aBookDAO = abookDAO.getInstance();

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		//HttpSession session = request.getSession(true);
		//long i = (long) session.getAttribute("stunumber");

		int start = 0;
		int cnt = 5;

		try {
			start = Integer.parseInt(request.getParameter("start"));
		} catch (NumberFormatException e) {
			// 当浏览器没有传参数start时
		}

		int next = start + cnt;
		int pre = start - cnt;

		int count = aBookDAO.getcount();

		int last=0;
		if(count!=0)
		{
		if (0 == count % cnt)
			last = count - cnt;
		else
			last = count - count % cnt;
		}
		pre = pre < 0 ? 0 : pre;
		next = next > last ? last : next;

		request.setAttribute("next", next);
		request.setAttribute("pre", pre);
		request.setAttribute("last", last);

		List<ahistorycurrent> historys = aBookDAO.list(start, cnt, 2016303234);

		request.setAttribute("historys", historys);

		request.getRequestDispatcher("history.jsp").forward(request, response);

	}

}
