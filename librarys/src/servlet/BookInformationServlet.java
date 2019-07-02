package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Date;
import java.util.List;

import dao.BookDAO;
import dao.DeleteBookDao;
import entity.Book;
import entity.Book1;;

/**
 * Servlet implementation class BookInformation
 */
public class BookInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDAO bookDAO = BookDAO.getInstance();
	private DeleteBookDao deletebookdao= DeleteBookDao.getInstance();
	private Book book = new Book();
       
    /**
     * @see HttpServlet#HttpServlet()榛樿鏋勯�犲嚱鏁�
     */
    public BookInformationServlet() {
        super();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html; charset=UTF-8");
			response.setHeader("content-type", "text/html;charset=UTF-8");
		    response.setCharacterEncoding("UTF-8");
		    request.setCharacterEncoding("UTF-8");
		    /*
		     * 杩欓噷瀹氫箟浜嗗洓涓彉閲�
		     * str鍜宻tring浣滀负涓粙鍙橀噺锛屼綔鐢ㄦ槸涓哄叾浠栧彉閲忎紶鍊�
		     * isUpdate鍜宨sDelete鏄痶ag锛岀敤鏉ュ垽鏂槸鍚︽洿鏂版垨鑰呭垹闄や功绫嶏紝褰搃sUpdate=1鏃讹紝鎵ц鏇存柊锛屽綋isDelete=1鏃讹紝鎵ц鍒犻櫎
		     */
			String str=null;
			String string=null;
			int isUpdate=0;
			int isDelete=0;
			int isLocationUpdate=0;
			int account=0;
			HttpSession session =request.getSession(true);
			account=(Integer)session.getAttribute("account");
			/*
			 * 
			 */
			int preNumber=0;
			int curNumber=0;
			preNumber=bookDAO.getTotal();
			/*
			 * 瀹氫箟book鐨勫睘鎬у彉閲�
			 */
			String ISBN="1231234123123";
			String author=null;
			String press=null;
			String category=null;
			String bookname=null;
			String version=null;
			String introduction=null;
			String location=null;
			Date printdate=null;
			double price=0;
			String reason = "";
			int delete_type = 0;
			int isborrow=1;
			int ID=0;
			int isorder=1;
			/*
			 * 鎺ユ敹BookInformation.jsp浼犳潵鐨勫彉閲�
			 */
			if(request.getParameter("ISBN_submit")!=null){
				ISBN=request.getParameter("ISBN_submit");
			}
			author=request.getParameter("author_submit");
			press=request.getParameter("press_submit");
			category=request.getParameter("category_submit");
			bookname=request.getParameter("bookname_submit");
			version=request.getParameter("version_submit");
			introduction=request.getParameter("introduction_submit");
			location=request.getParameter("location_submit");
			string=request.getParameter("printdate_submit");
			/*
			 * 鑾峰彇isUpdate鍜宨dDelete鏍囩鐨勫�硷紝浠嶣ookInformation.jsp浼犳潵
			 */
			if(request.getParameter("isUpdate")!=null){
				isUpdate=Integer.parseInt(request.getParameter("isUpdate"));
				ISBN=request.getParameter("ISBN_submit");
			}
			if(request.getParameter("isDelete")!=null){
				isDelete=Integer.parseInt(request.getParameter("isDelete"));
				ISBN=request.getParameter("ISBN");
				ID=Integer.parseInt(request.getParameter("ID"));
				bookname=request.getParameter("bookname");
				reason=request.getParameter("deleteReason");
				if(reason.equals("damage")){
					delete_type=1;
				}else{
					delete_type=2;
				}
			}
			if(request.getParameter("isLocationUpdate")!=null){
				isLocationUpdate=Integer.parseInt(request.getParameter("isLocationUpdate"));
				ISBN=request.getParameter("ISBN");
				ID=Integer.parseInt(request.getParameter("ID"));
				location=request.getParameter("location_submit");
			}
			if(request.getParameter("account")!=null){
				account=Integer.parseInt(request.getParameter("account"));
			}
			
			try {		
				if(request.getParameter("price_submit")!=null){
					price=Double.parseDouble(request.getParameter("price_submit"));
				}
				if(string!=null){
				printdate=java.sql.Date.valueOf(request.getParameter("printdate_submit"));
				}
			} catch (NumberFormatException e) {
				// 瑜版挻绁荤憴鍫濇珤濞屸剝婀佹导鐘插棘閺佺殜tart閺冿拷
			}
			/*
			 * 璁剧疆book鐨勫睘鎬�
			 */
			book.setISBN(ISBN);
			book.setID(ID);
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
			/*
			 * 鏇存柊涔︾睄淇℃伅
			 */
			if(isUpdate==1){
				bookDAO.update1(book);
			}
			/*
			 * 鍒犻櫎涔︾睄淇℃伅
			 */
			if(isDelete==1){
				deletebookdao.add(book,account,delete_type);
				bookDAO.delete(ISBN, ID);
				curNumber=bookDAO.getTotal();
				if(curNumber<preNumber){
					response.sendRedirect("BookListServlet");
				}
			}
			/*
			 * 淇敼鏌愪竴涓壒瀹欼D鐨刲ocation淇℃伅
			 */
			if(isLocationUpdate==1){
				bookDAO.update3(book);
			}
			List<Book1> books = bookDAO.list2(ISBN) ;
			request.setAttribute("books", books);
			if(isDelete==0||curNumber>=preNumber){
				request.getRequestDispatcher("BookInformation.jsp").forward(request, response);
			}
    }

}
