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
import entity.Book;

public class BookListServlet extends HttpServlet{
private BookDAO bookDAO = BookDAO.getInstance();
private AnnouncementDAO announcementDAO=AnnouncementDAO.getInstance();
private Book book = new Book();
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setHeader("content-type", "text/html;charset=UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    request.setCharacterEncoding("UTF-8");
		int start = 0;
		int count = 5;
		String selectL = null;

		
		String string=null;
		String num1=null;
		String price1=null;
		String ISBN=null;
		int ID=0;
		String author=null;
		String press=null;
		String category=null;
		String bookname=null;
		String version=null;
		String introduction=null;
		int isborrow=1;
		Date printdate=null;
		int isorder=1;
		String location=null;
		double price=0;
		int number=0;
		String floor=null;
		String area=null;
		String shelf=null;
		String floor1=null;
		String area1=null;
		String shelf1=null;
		String category1=null;
		ISBN=request.getParameter("ISBN");
		author=request.getParameter("author");
		press=request.getParameter("press");
		floor=request.getParameter("floor");
		area=request.getParameter("area");
		shelf=request.getParameter("shelf");
	
		category=request.getParameter("category");
		bookname=request.getParameter("bookname");
		version=request.getParameter("version");
		introduction=request.getParameter("introduction");
		//str=request.getParameter("ID");
		location=floor+area+shelf;
	//	if(str!=null)
		//ID=Integer.parseInt(str);
		string=request.getParameter("printdate");
		if(string!=null)
		printdate=java.sql.Date.valueOf(request.getParameter("printdate"));
		num1=request.getParameter("number");
		if(num1!=null)
			number=Integer.parseInt(num1);
		price1=request.getParameter("price");
		if(price1!=null)
			price=Integer.parseInt(price1);
		String delete=null;
		delete=request.getParameter("delete");
		
		floor1=request.getParameter("floor1");
		area1=request.getParameter("area1");
		shelf1=request.getParameter("shelf1");
		category1=request.getParameter("category1");
		if(floor1!=null&&floor1!="") bookDAO.addFloor(floor1);
		if(area1!=null&&area1!="") bookDAO.addArea(area1);
		if(shelf1!=null&&shelf1!="") bookDAO.addShelf(shelf1);
		if(category1!=null&&category1!="") bookDAO.addCategory(category1);
		String[] floors=BookDAO.floor();
		String[] areas=BookDAO.area();
		String[] shelfs=BookDAO.shelf();
		String[] categorys=BookDAO.category();
		if(delete!=null)
			bookDAO.delete1(delete);
		try {
			selectL= request.getParameter("selectL");
			start = Integer.parseInt(request.getParameter("start"));
			
			
		
		} catch (NumberFormatException e) {
			// 当浏览器没有传参数start时
		}
	
		   book.setISBN(ISBN);
		   // book.setID(ID);
		    book.setAuthor(author);
		    book.setPress(press);
		    book.setCategory(category);
		    book.setBookname(bookname);
		    book.setVersion(version);
		    book.setIntroduction(introduction);
		    book.setIsborrow(isborrow);
		   book.setPrintdate(printdate);
		    book.setIsorder(isorder);
		    book.setLocation(location);
		    book.setPrice(price);
		  //  System.out.println("dddd"+ISBN);
			//System.out.println("dddd"+author)
		    int index=0;
		    if(bookname!=null)
		        {ISBN=bookDAO.add(book,number);
		        
		        System.out.println("aaaaaaaaaaaaaaaaaaaaa");
		        System.out.println(index);
		        index=1;
		        }
		    
		  //  System.out.println(selectL);
		int next = start + count;
		int pre = start - count;

		int total = 0;
		if(selectL==null)
		   {total =BookDAO.getTotal();
			}
	        else 
	        {
	        total = BookDAO.getTotal1(selectL);
	        }
		int all = BookDAO.getTotal2();
        int allreader = BookDAO.getTotal3();
		int last =0;
		if(total!=0){
		if (0 == total % count)
			last = total - count;
		else
			last = total - total % count;
		}
		pre = pre < 0 ? 0 : pre;
		next = next > last ? last : next;
        System.out.println("aaaa"+total);
        
		request.setAttribute("next", next);
		request.setAttribute("pre", pre);
		request.setAttribute("last", last);

		List<Book> books ;
		 if(selectL==null)
	        {books = BookDAO.list(start, count);
			}
	        else 
	        {
	        books = BookDAO.list1(start, count, selectL);
	    	
	        }
		 String content=announcementDAO.getContent();
			request.setAttribute("content", content);
		request.setAttribute("books", books);
		request.setAttribute("ISBN",ISBN);
		request.setAttribute("start", start); 
		request.setAttribute("selectL", selectL); 
		request.setAttribute("all", all);
		request.setAttribute("allreader", allreader); 
		request.setAttribute("floors",floors);
		request.setAttribute("areas",areas);
		request.setAttribute("shelfs",shelfs);
		request.setAttribute("categorys",categorys);
		System.out.println(next);
		if(index==1)
		{
			request.getRequestDispatcher("ShowServlet").forward(request, response);
		}
		else{
		request.getRequestDispatcher("Library.jsp").forward(request, response);
		}
	}
}
