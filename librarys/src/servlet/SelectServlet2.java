package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Reply;
import dao.AReplyDAO;
import entity.Book;

public class SelectServlet2 extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AReplyDAO replyDAO = AReplyDAO.getInstance();
	
	public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");  
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader( " content-type", "text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session =request.getSession(true);
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
		

		List<Book> book2s = null;
        String f = request.getParameter("f");
        if(f!=null){
            session.setAttribute("fenlei", f);
            }
            String f1=(String) session.getAttribute("fenlei"); 
            
            if (f1 != null && f1.length() > 0) {
            
        	try {
        		if(f1.equals("all")){
				book2s =replyDAO.select4(start, count,"");
        		}
        		else
        		book2s =replyDAO.select4(start, count,f1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        
            }
            else book2s = replyDAO.list(start, count);
        
        request.setAttribute("books", book2s);
		request.getRequestDispatcher("index1.jsp").forward(request, response);
    }

}

