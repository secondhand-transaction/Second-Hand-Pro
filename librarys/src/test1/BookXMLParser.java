package test1;
import entity.Book;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
 
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
 
 
public class BookXMLParser extends DefaultHandler {
 
  private Book book = null;
 
  private final StringBuilder buff = new StringBuilder();
  private String attname = null;
  private final List<String> tags = new ArrayList<String>();
 
  /**
   * @return the book
   */
  public Book getBook() {
    return book;
  }
 
  public BookXMLParser(InputStream is) {
    try {
      SAXParserFactory spfactory = SAXParserFactory.newInstance();

      spfactory.setValidating(false);
      SAXParser saxParser = spfactory.newSAXParser();
      XMLReader xmlReader = saxParser.getXMLReader();
      xmlReader.setContentHandler(this);
      xmlReader.parse(new InputSource(is));
    } catch (Exception e) {
      System.err.println(e);
      System.exit(1);
    }
  }
 
  public void startElement(String uri, String localName, String name,
      Attributes atts) throws SAXException {
    if (name.equalsIgnoreCase("entry")) {
      book = new Book();
    } else if (name.equalsIgnoreCase("db:attribute")) {
      attname = atts.getValue("name");
    } else if (name.equalsIgnoreCase("db:tag")) {
      tags.add(atts.getValue("name"));
    } else if (name.equalsIgnoreCase("link")) {
     
    }
    buff.setLength(0);
  }
 
  public void endElement(String uri, String localName, String name)
      throws SAXException {
    if ("entry".equalsIgnoreCase(name)) {
      StringBuilder str = new StringBuilder();
      for (String t : tags) {
        str.append(t + "/");
      }
      book.setTags(str.toString());
    } else if (name.equalsIgnoreCase("db:attribute")) {
      String value = buff.toString().trim();
      if ("isbn13".equalsIgnoreCase(attname)) {
        book.setISBN(value);
      } else if ("title".equalsIgnoreCase(attname)) {
        book.setBookname(value);
      } else if ("author".equalsIgnoreCase(attname)) {
        book.setAuthor(value);
      } else if("price".equalsIgnoreCase(attname))
      {
    	  String result="0";
      	 StringTokenizer st=new StringTokenizer(value);
           while(st.hasMoreTokens()){
               
               boolean isDigit=true;
               char[] chs=st.nextToken().toCharArray();
               for(int i=0,len=chs.length;i<len-2;i++){   
                    result=result+chs[i];
                   }
               }
      	book.setPrice(Double.valueOf(result));
      }else if ("publisher".equalsIgnoreCase(attname)) {
        book.setPress(value);
      } 
      else if ("pubdate".equalsIgnoreCase(attname)) {
    	  StringTokenizer st=new StringTokenizer(value);
      	  StringBuilder sb = new StringBuilder();
            while(st.hasMoreTokens()){
                
              
                
                char[] chs=st.nextToken().toCharArray();
               
                
               
        		for(int i=0;i<chs.length;i++){
        			  if(chs.length<7&&i==5)
        			     {sb.append('0');sb.append(chs[5]);sb.append('-');sb.append('0');sb.append('1');break;}
        			  else if(chs.length<8&&i==6)
        			  {
        				  sb.append(chs[6]);sb.append('-');sb.append('0');sb.append('1');break;
        			  }
        			  else
        			  {
        				  sb.append(chs[i]);
        			  }
        		}
          
        }
            
          String result =sb.toString();
          book.setPrintdate(java.sql.Date.valueOf(result));
        
       
    }
      
    } else if ("summary".equalsIgnoreCase(name)) {
      book.setIntroduction(buff.toString());
    }
    buff.setLength(0);
  }
 
  public void characters(char ch[], int start, int length)
      throws SAXException {
    buff.append(ch, start, length);
  }
 
}

