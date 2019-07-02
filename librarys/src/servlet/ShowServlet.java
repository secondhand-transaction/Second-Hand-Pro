package servlet;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAO;
import entity.Book;
import entity.Book1;

/**
 * Servlet implementation class ShowServlet
 */
@WebServlet("/ShowServlet")
public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ISBN=null;
		PrintWriter out = response.getWriter();
	/*	ISBN=request.getParameter("ISBN");*/
		ISBN=(String) request.getAttribute("ISBN");
		System.out.println(ISBN);
		List<Book1> books ;
		books=BookDAO.list2(ISBN);
		int len=0,m=0;
		String str="0000";
		String[] number=new String[BookDAO.getTotal4(ISBN)];
		for(int i=0;i<BookDAO.getTotal4(ISBN);i++)
		{
		String numberImage =books.get(i).getID(); // 获取输入的数字
		len=numberImage.length();
		for(m=0;m<11-len;m++)
		{
		str+="0";
		}
		number[i]=str+numberImage;
		
		out.println("<iframe src='http://api.k780.com/?app=barcode.get&bc_text="+number[i]+"&appkey=10003&sign=b59bc3ef6191eb9f747dd4e83c99f2a4' height='100px' width='460px'></iframe></br>");
		
		}

		out.println(" <a href = 'BookListServlet'><button style='background-color:#2b7acd ;width: 76px;height: 36px;color: #FFFFFF;margin-left:220px'>Homepage </button></a>");
		
	}

	

}
