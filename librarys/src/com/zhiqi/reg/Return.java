package com.zhiqi.reg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Return extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String email;
	private String password;

   	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    PrintWriter out = response.getWriter();
		    HttpSession session1 =request.getSession(true);
			username=(String) session1.getAttribute("name1");
			email=(String) session1.getAttribute("email1");
			password=(String) session1.getAttribute("password1");
			Sendtest mail = new Sendtest();

			mail.setSubject("BIBLIOSOFT");

			mail.setContent(" Hello "+username+",<br />" +
	    		"<br />" +
	    		"The password you forgot is ： </p>" + password);

			//收件人 可以发给其他邮箱(163等) 下同

			mail.setTo(new String[] {email});
	/*
			//抄送

			mail.setCc(new String[] {"xxx@qq.com","xxx@qq.com"});

			//密送

			mail.setBcc(new String[] {"xxx@qq.com","xxx@qq.com"});

			//发送附件列表 可以写绝对路径 也可以写相对路径(起点是项目根目录)

			mail.setFileList(new String[] {"file\\附件1.txt","file\\附件2.txt"});*/

			//发送邮件

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


