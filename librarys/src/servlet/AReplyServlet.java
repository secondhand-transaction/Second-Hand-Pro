package servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AReplyDAO;

import entity.Reply;




public class AReplyServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private AReplyDAO replyDAO = AReplyDAO.getInstance();
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");  
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader( " content-type", "text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
        
		HttpSession session =request.getSession(true);
        String content=request.getParameter("content");
        
        String name=(String) session.getAttribute("name");
        long stunumber=(long) session.getAttribute("stunumber");
        

        Timestamp replytime=new Timestamp(System.currentTimeMillis());


        Reply reply=new Reply();
        reply.setContent(content);
        reply.setName(name);
        reply.setStunumber(stunumber);
        reply.setReplytime(replytime);
        reply.setID(1);
        
        replyDAO.add(reply);
        

        response.sendRedirect("IndexServlet");
        System.out.println("huakaiai");
    }




	
}
