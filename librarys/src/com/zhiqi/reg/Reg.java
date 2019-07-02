package com.zhiqi.reg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiqi.mail.SendMail; 

public class Reg extends HttpServlet {
	private ServletConfig Servletconf; 
	
	private String email;
	private String msg;
	private String name;
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.Servletconf=config;
	}
   	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		 PrintWriter out = response.getWriter();
		email=request.getParameter("email");
		name=request.getParameter("name");
		System.out.println(email);
		System.out.println(Servletconf.getInitParameter("smtphost"));
		Sendtest mail = new Sendtest();
		
		mail.setSubject("BIBLIOSOFT");

		mail.setContent(" Hello ,"+name+ " <br />" +
    		"<br />" +
    		"You have books which has overdue ,please return it back </p>" );

		//收件人 可以发给其他邮箱(163等) 下同

		mail.setTo(new String[] {email});
		try {

			mail.sendMessage();

			out.println("<html>");
			out.println("<title>");
			out.println("Return");
			out.println("</title>");
			out.println("<h1> send email to you email succsessfully!please wait and check </h1></br>");
			out.println("<a href='login.jsp'>return to login</a><br>");
			out.println("<a href='Index1.jsp'>return to Index</a>");
			out.println("</body>");
			out.println("</html>");

		} catch (Exception e) {

			out.println("<html>");
			out.println("<title>");
			out.println("Return");
			out.println("</title>");
			out.println("<h1> send email to you email failed!</h1>");
			out.println("<a href='login.jsp'>return to login</a><br>");
			out.println("<a href='Index1.jsp'>return to Index</a>");
			out.println("</body>");
			out.println("</html>");

			e.printStackTrace();

		}

	}
	

}
