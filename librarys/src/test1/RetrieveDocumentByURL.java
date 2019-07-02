package test1;

import java.io.IOException;

import java.io.InputStream;
import java.util.StringTokenizer;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import entity.*;
import dao.BookDAO;
 
public class RetrieveDocumentByURL {
  
  public RetrieveDocumentByURL (String url,String ISBN,int number,String location,String category) throws ClientProtocolException, IOException{
	  System.out.println("aaaaaaabbbbbb"+url);
	  DefaultHttpClient client = new DefaultHttpClient();
    HttpGet get = new HttpGet(url);
    HttpResponse response = client.execute(get);
        HttpEntity entity = response.getEntity();
        InputStream is = entity.getContent();
      
        Book book = new BookXMLParser(is).getBook();
        System.out.println("bookname:->" + book.getBookname());
        System.out.println("Introduction:->"+ book.getIntroduction());
        System.out.println("price:-->" + book.getPrice());
        System.out.println("author:-->" + book.getAuthor());
        System.out.println("date:-->" + book.getPrintdate());
        System.out.println("Press:-->" + book.getPress());
        book.setLocation(location);
        book.setISBN(ISBN);
        book.setCategory(category);
        BookDAO.add(book,number);
     
  }
 
 
}