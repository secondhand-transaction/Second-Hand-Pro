package servlet;
import java.io.IOException;

import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AnnouncementDAO;
import dao.BookDAO;
import entity.Announcement;
import entity.Book;
public class AnnouncementListServlet extends HttpServlet{
	private AnnouncementDAO announcementDAO = AnnouncementDAO.getInstance();
	private Announcement announcement = new Announcement();
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setHeader("content-type", "text/html;charset=UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    request.setCharacterEncoding("UTF-8");
		int start = 0;
		int count = 5;
		int ID=0;
		try {

			
			ID=Integer.parseInt(request.getParameter("ID"));
			
			
			
		} catch (NumberFormatException e) {
			// 褰撴祻瑙堝櫒娌℃湁浼犲弬鏁皊tart鏃�
		}
		System.out.println(start);
		System.out.println(start);
		System.out.println(start);
		System.out.println(start);
		
		String content=null;
		content=request.getParameter("content");
		int tag=-1;
		String tag1=null;
		tag1=request.getParameter("tag");
		if(tag1!=null&&tag1!="")
			tag=Integer.parseInt(tag1);
		if(tag==0){
			announcement.setID(ID);
			announcement.setContent(content);
			announcementDAO.update(announcement);
		}
		if(tag==1)
		{
			announcementDAO.delete(ID);
		}
		String announcement=null;
		announcement=request.getParameter("announcement");
		if(announcement!=null)
			AnnouncementDAO.sendAnnouncement(announcement);
		try {
			start = Integer.parseInt(request.getParameter("start"));
		} catch (NumberFormatException e) {
			// 褰撴祻瑙堝櫒娌℃湁浼犲弬鏁皊tart鏃�
		}
		int next = start + count;
		int pre = start - count;
		int total = 0;
		total=AnnouncementDAO.getTotal();
		int last =0;
		if(total!=0){
		if (0 == total % count)
			last = total - count;
		else
			last = total - total % count;
		}
		pre = pre < 0 ? 0 : pre;
		next = next > last ? last : next;
		List<Announcement> announcements ;
		announcements = AnnouncementDAO.list(start, count);
		request.setAttribute("all", total);
		request.setAttribute("announcements", announcements);
		request.setAttribute("next", next);
		request.setAttribute("pre", pre);
		request.setAttribute("last", last);
		
		request.getRequestDispatcher("announcement.jsp").forward(request, response);
	}
}
