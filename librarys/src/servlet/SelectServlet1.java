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

public class SelectServlet1 extends HttpServlet {
	
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
		

		List<Book> book1s = null;
        String s = request.getParameter("s");
        String select = request.getParameter("input");
        if(s!=null&&select!=null){
        session.setAttribute("xuanxiang", s);
        session.setAttribute("shuru", select);
        }
        String s1=(String) session.getAttribute("xuanxiang");
        String select1=(String) session.getAttribute("shuru");
        
        if (select1 != null && select1.length() > 0) {
        	if(s1.equals("select by bookname"))
        	{
            
              
            	try {
					book1s =replyDAO.select(start, count,select1);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
   
              
           
          }
        	else if(s1.equals("select by author")){
        		 try {
                     
                 	book1s =replyDAO.select1(start, count,select1);
                 	
                   
                 } catch (Exception e) {
                   e.printStackTrace();
                 }	
        	
        	}
        	
        	else if(s1.equals("select by ISBN")){
       		 try {
                    
                	book1s =replyDAO.select2(start, count,select1);
                	
                  
                } catch (Exception e) {
                  e.printStackTrace();
                }	
       	
       	}
        	
        	else if(s1.equals("select by press")){
       		 try {
                    
                	book1s =replyDAO.select3(start, count,select1);
                	
                  
                } catch (Exception e) {
                  e.printStackTrace();
                }	
       	
       	}
        	
        }
        else book1s = replyDAO.list(start, count);
       
        
        request.setAttribute("books", book1s);
		request.getRequestDispatcher("index1.jsp").forward(request, response);
    }

}

