package servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReplyDAO;
import entity.Reply;
public class ReplyServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setHeader("content-type", "text/html;charset=UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    request.setCharacterEncoding("UTF-8");
		int start = 0;
		int count = 5;
        int ID=0;
        String content;
		try {
			start = Integer.parseInt(request.getParameter("start"));
			ID=Integer.parseInt(request.getParameter("ID"));
			content=request.getParameter("content");
		} catch (NumberFormatException e) {
			// 褰撴祻瑙堝櫒娌℃湁浼犲弬鏁皊tart鏃�
		}
		
	    

		
		int next = start + count;
		int pre = start - count;
		int total;

		total = ReplyDAO.getTotal();
		ReplyDAO.delete(ID);
		System.out.println(ID);
	
		
		 
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
		List<Reply> replys;
		
      
		new ReplyDAO();
		replys = ReplyDAO.list(start, count);
      
		request.setAttribute("replys", replys);
		request.setAttribute("start", start); 
		request.setAttribute("total", total); 
		

		request.getRequestDispatcher("ReaderResponse.jsp").forward(request, response);

	}

}
