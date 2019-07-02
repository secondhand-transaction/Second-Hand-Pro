<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	 <%@ include file="/huakai.jsp"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="css/bootstrap.min.css" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/homepage.css">

	<link rel="stylesheet" type="text/css" href="css/index.css">
	
<title>nav</title>
 <script language="javascript" type="text/javascript">
  
	   
    function rec()
           {
			   var BookName=document.getElementById("BookName").value;
			   var Press=document.getElementById("Press").value;
			   var Category=document.getElementById("Category").value;
			   var Author=document.getElementById("Author").value;
			   var Version=document.getElementById("Version").value;
			   var Location=document.getElementById("Location").value;
			   var Price=document.getElementById("Price").value;
			   var Number=document.getElementById("Number").value;
			   var Introduction=document.getElementById("Introduction").value;
			   if(BookName==null&&BookName=="")
				   alert("The BookName of the book is empty. Please enter BookName.");
			   else if(Press==null&&Press=="")
				   alert("The Press of the book is empty. Please enter Press.");
				   else if(Category==null&&Category=="")
					   alert("The Category of the book is empty. Please enter Category.");
					   else if(Author==null&&Author=="")
						   alert("The Author of the book is empty. Please enter Author.");
						   else if(Version==null&&Version=="")
							   alert("The Version of the book is empty. Please enter Version.");
							   else if(Location==null&&Location=="")
								   alert("The Location of the book is empty. Please enter Location.");
								   else if(Price==null&&Price=="")
									   alert("The Price of the book is empty. Please enter Price.");
									   else if(Number==null&&Number=="")
										   alert("The Number of the book is empty. Please enter Number.");
										   else if(Introduction==null&&Introduction=="")
											   alert("The Introduction of the book is empty. Please enter Introduction.");
			   else 
			   {
				   alert("add successfully!");
			   }
           }

	
        function response()
        {
        	alert("add successfully!");
        }
	</script>
	<script type="text/javascript" src="js/jquery2.1.4.min.js"></script>
<script type="text/javascript" src="js/JsBarcode.all.min.js"></script>
<script type="text/javascript">
   
    function barcodeGen(){
        var barvalue=$("#barcodeValue").val();
        if(barvalue==""){
            alert("请输入条形码字符串！！")
        }else{
            $("#bcode").JsBarcode(barvalue);
        }
    }
</script>

</head>

<body  style="background:#3F506A" onLoad="startTime()">

<div class="bodylibrary">
	<div class="allpage">
		<div class="headpage">
		<div class="booklibrarian">
			<img src="images/librarian.jpg" width="40%" height="80%" style="float:left;margin-top:10%">
			<p style="color:#736357;font-size:20px;margin-left:10% ;margin-top:10%;float:left">Nickname:</p>
			 <p style="color:#736357;font-size:20px;margin-left:10% ;margin-top:0%;float:left"><%
out.println(session.getAttribute("Librarianname"));
%>!</p>
<form action="login.jsp?" method="post">  	   
 <p><input type="submit"  value="logout" style="color:white;background-color:red;width:60px;height:30px;margin-left:10%;float:left;"><p>
	</form>													
		
		</div>
		<div class="picturepage">
			<img src="images/library.jpg" width="100%" height="100%">
		
		</div>
		<div class="sumpage">
		  
        

     <p class="part" style="color:#F00F13">Total number of library books:<strong style="color:#000000">${all}</strong>books</p>
	  <p class="part" style="color:#F00F13">Number of registered users in Libraries: <strong style="color:#000000">${allreader} </strong>users</p>

	  
      
  
	
		
	</div>
	</div>
	<br>
	
	<%
	String content =(String) request.getAttribute("content");
	%>
	<marquee class="zhifeiji" scrollamount=3 onmouseover=this.stop() onmouseout="this.start()"><img src="img/zhifeiji.gif" alt="baiyun" width="91" height="56" />Announcement:
	<%=content %></marquee>
	

<div class="selectbook">
   <form class="form-inline col-md-5" style="width=30%;position:relative;left:35%; "action="BookListServlet?" method="post">
    <input class="form-control" type="search" placeholder="Please enter keywords" aria-label="Search" name="selectL">
    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
  </form>
  </form>
 
</div>
  

    <div class="div1">
<c:forEach items="${books}" var="book" varStatus="st">
   <div>
	<table  class="table1" cellpadding="0" cellspacing="0"  onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='white';">
	  <tr >
	    <td   class="td1"><b class="b1">Bookname:</b><a href="BookInformationServlet?ISBN_submit=${book.ISBN}"><span class="span1">${book.bookname}</span></a></td>
			<td  >Version：${book.version}</td>
   
	    </tr>
		<tr height="3px"></tr>
	   <tr>
	   	<td  class="td1">Author:${book.author}</td>
		   <td  class="td2">PrintDate:${book.printdate}</td>
	   </tr>
	   <tr height="5px"></tr>
	  <tr>
	  	<td class="td1" >Press:${book.press}</td>
	  	<td class="td2">Number of books:${book.number}</td>   
	  	<form method="POST" action="BookInformationServlet?ISBN_submit=${book.ISBN}">  
	  	<input type="submit"  value="View" style="color:white;background-color:#2B7ACD;width:60px;height:30px;
													 position:relative;left:75%;top:75px;">
													 </form>
	  	<tr height="5px"></tr>
	  </tr>
	  <td class="td1">Category:${book.category}</td>
	  <td class="td2">Number of borrowd books:<span class=span2>${book.borrownumber}</span></td>
	  </table>
	  </div>
	 </c:forEach>
	<nav>
	 <ul class="pager" style="background-color:RGB(237,248,224)">
	<li><a href="?start=0">FirstPage </a></li>
	<li><a href="?start=${pre}&selectL=${selectL}">PreviousPage</a></li>
	<li><a href="?start=${next}&selectL=${selectL}">NextPage</a></li>
	<li><a href="?start=${last}&selectL=${selectL}">LastPage</a></li>
	</ul>
	</nav>
	<br>
<div style="width=100%" > 
<form action="BookListServlet1?" method="POST" >
		<div style="width:100%;height:200px">
         <div style="float: left;padding-left: 10%">
          ISBN:<input type="text"  class="cardOuter" placeholder="Please input the ISBN of the book." id="ISBN1" name="ISBN1" style="color:#999999" onclick="if(value==defaultValue){value='';this.style.color='#000000'}"       onBlur="if(!value){value=defaultValue;this.style.color='#999'}" required/>
   		 </div>
         <div style="float: right;padding-right: 10%">
       Number:<input type="text"  class="cardOuter" placeholder="Please input the number of the book."  name="number1" id="number1" style="color:#999999" onclick="if(value==defaultValue){value='';this.style.color='#000000'}"       onBlur="if(!value){value=defaultValue;this.style.color='#999'}" required/>
         </div>
         <br>
         <br>
           <br>
          <div style="float: left;padding-left: 10%">
          Location:
           
          <select type="text"  class="cardOuter" id="floor" name="floor" style="color:black">
   		 <c:forEach var="floor" items="${floors}" varStatus="st">
   		 <option value="${floor}">${floor}</option>
   		 </c:forEach>
   		 </select>
   		  <select type="text"  class="cardOuter" id="area" name="area" style="color:black">
   		 <c:forEach var="area" items="${areas}" varStatus="st">
   		 <option value="${area}">${area}</option>
   		 </c:forEach>
   		 </select>
   		  <select type="text"  class="cardOuter" id="shelf" name="shelf" style="color:black">
   		 <c:forEach var="shelf" items="${shelfs}" varStatus="st">
   		 <option value="${shelf}">${shelf}</option>
   		 </c:forEach>
   		 </select>
   		 </div>
   		 <br>
   		  <br>
   		  <br>

   		 <div style="float: left;padding-left: 10%">
          Category:  
          <select type="text"  class="cardOuter" id="category" name="category" style="color:black">
   		 <c:forEach var="category" items="${categorys}" varStatus="st">
   		 <option value="${category}">${category}</option>
   		 </c:forEach>
   		 </select>
   		 </div>
   		 </div>
	    <div style="text-align: center">
	    <br>
		<input type="submit"  value="Scan" style="color:white;background-color:#2B7ACD;width:60px;height:30px" onClick="rec()"  >    
       </div>            
        </form>


</div>
	<br>
<div style="width=100%" >
	
	<form action="BookListServlet?" method="POST" >
		<div style="width:100%;height:200px">
         <div style="float: left;padding-left: 10%">
          ISBN:<input type="text"  class="cardOuter" placeholder="Please input the ISBN of the book." id="ISBN" name="ISBN" style="color:#999999" onclick="if(value==defaultValue){value='';this.style.color='#000000'}"       onBlur="if(!value){value=defaultValue;this.style.color='#999'}" />
   		 </div>
         <div style="float: right;padding-right: 10%">
       BookName:<input type="text"  class="cardOuter" placeholder="Please input the title of the book."  name="bookname" style="color:#999999" onclick="if(value==defaultValue){value='';this.style.color='#000000'}"       onBlur="if(!value){value=defaultValue;this.style.color='#999'}" required/>
         </div><br><br>
		<div style="float: left;padding-left: 10%">
		  Press:<input type="text"  class="cardOuter" placeholder="Please input book press." name="press"  style="color:#999999" onclick="if(value==defaultValue){value='';this.style.color='#000000'}"       onBlur="if(!value){value=defaultValue;this.style.color='#999'}" />
			</div>
	  
	    <div style="float: right;padding-right: 10%">
		  Author:<input type="text"  class="cardOuter" placeholder="Please input the author of the book." name="author"  style="color:#999999" onclick="if(value==defaultValue){value='';this.style.color='#000000'}"       onBlur="if(!value){value=defaultValue;this.style.color='#999'}" />
		</div><br><br>
	    <div style="float: left;padding-left: 10%">
		   Version:<input type="text"  class="cardOuter" placeholder="Please input version of book" name="version"  style="color:#999999" onclick="if(value==defaultValue){value='';this.style.color='#000000'}"       onBlur="if(!value){value=defaultValue;this.style.color='#999'}" />
		</div>
		<div style="float: right;padding-right: 10%">
		    PrintDate:<input type="text"  class="cardOuter" placeholder="Please enter the version of the book to enter the publication date, like yyyy-mm-dd"  name="printdate" style="color:#999999" onclick="if(value==defaultValue){value='';this.style.color='#000000'}"       onBlur="if(!value){value=defaultValue;this.style.color='#999'}" required/>
		</div>
		<br><br>
		  <div style="float: left;padding-left: 10%">
          Location:
           
          <select type="text"  class="cardOuter" id="floor" name="floor" style="color:black">
   		 <c:forEach var="floor" items="${floors}" varStatus="st">
   		 <option value="${floor}">${floor}</option>
   		 </c:forEach>
   		 </select>
   		  <select type="text"  class="cardOuter" id="area" name="area" style="color:black">
   		 <c:forEach var="area" items="${areas}" varStatus="st">
   		 <option value="${area}">${area}</option>
   		 </c:forEach>
   		 </select>
   		  <select type="text"  class="cardOuter" id="shelf" name="shelf" style="color:black">
   		 <c:forEach var="shelf" items="${shelfs}" varStatus="st">
   		 <option value="${shelf}">${shelf}</option>
   		 </c:forEach>
   		 </select>
   		 </div>
   		 <br>
   		  <br>

   		 <div style="float: left;padding-left: 10%">
          Category:  
          <select type="text"  class="cardOuter" id="category" name="category" style="color:black">
   		 <c:forEach var="category" items="${categorys}" varStatus="st">
   		 <option value="${category}">${category}</option>
   		 </c:forEach>
   		 </select>
   		 </div><br><br>
		  <div style="float: left;padding-left: 10%">
		Price:<input type="text"  class="cardOuter" placeholder="Please enter the price of the book." name="price"  style="color:#999999" onclick="if(value==defaultValue){value='';this.style.color='#000000'}"       onBlur="if(!value){value=defaultValue;this.style.color='#999'}" required/>
		</div>
	    <div style="float: right;padding-right: 10%">
		   Number:<input type="text"  class="cardOuter" placeholder="Please input the number of books." name="number"  style="color:#999999" onclick="if(value==defaultValue){value='';this.style.color='#000000'}"       onBlur="if(!value){value=defaultValue;this.style.color='#999'}" required/>
		</div><br><br>
		</div>
		<br>
		<br>
		<br>
   		<div style="width:80%;height:155px;margin: auto;align-content:center">
		
    	<span style="text-align:center">Introdution:</span>
		<div class="cardtext2">
          <textarea  style="color:#999999" class="cardtext" name="introduction" onclick="if(value==defaultValue){value='';this.style.color='#000000'}"       onBlur="if(!value){value=defaultValue;this.style.color='#999'}"></textarea>
		</div>
		 
    	</div>
	    <div style="text-align: center">
	    <br>
		<input type="submit"  value="Add" style="color:white;background-color:#2B7ACD;width:60px;height:30px" onClick="rec()"  >    
       </div>            
        </form>
       
</div>
</div>
<br>
<br>
<br>
<br>
<div style="width:270px;
    height:150px;
    margin:0 auto;">
    <hr>
  
   Please enter the lost book ID：
      <br>
      <br>
   <input type="text"  id="barcodeValue" style="text-align:center"> &nbsp;<a href="#" onClick="barcodeGen();" >
     <br>
      <br>
   <span> Generat ebarcode</span></a><br>

    <!--startprint-->
    <img id="bcode"/>
    <!--endprint-->
    <hr>
    
    </div>
    <form action="BookListServlet?" method="POST" >
		<div style="width:100%;height:200px">
         <div >
          Floor:<input type="text"  class="cardOuter"  id="floor1" name="floor1" style="color:#999999" onclick="if(value==defaultValue){value='';this.style.color='#000000'}"       onBlur="if(!value){value=defaultValue;this.style.color='#999'}" required/>
   		  <input type="submit"  value="Add" style="color:white;background-color:#2B7ACD;width:60px;height:30px;position:relative;letf:40px;" onClick="response()"  >
   		 </div>
   		
 </form>
 <br>
 <form action="BookListServlet?" method="POST" >
         <div >
         Area:<input type="text"  class="cardOuter"  name="area1" id="area1" style="color:#999999" onclick="if(value==defaultValue){value='';this.style.color='#000000'}"       onBlur="if(!value){value=defaultValue;this.style.color='#999'}" required/>
          <input type="submit"  value="Add" style="color:white;background-color:#2B7ACD;width:60px;height:30px;position:relative;letf:40px;" onClick="response()" >
         </div>
         
         </form>
         <br>
         <form action="BookListServlet?" method="POST" >
         <div >
         Shelf:<input type="text"  class="cardOuter"  name="shelf1" id="shelf1" style="color:#999999" onclick="if(value==defaultValue){value='';this.style.color='#000000'}"       onBlur="if(!value){value=defaultValue;this.style.color='#999'}" required/>
     <input type="submit"  value="Add" style="color:white;background-color:#2B7ACD;width:60px;height:30px;position:relative;letf:40px;" onClick="response()"  >
         </div>
            
         </form>
          <br>
         <form action="BookListServlet?" method="POST" >
         <div>
         Category:<input type="text"  class="cardOuter"  name="category1" id="category1" style="color:#999999" onclick="if(value==defaultValue){value='';this.style.color='#000000'}"       onBlur="if(!value){value=defaultValue;this.style.color='#999'}" required/>
          <input type="submit"  value="Add" style="color:white;background-color:#2B7ACD;width:60px;height:30px;position:relative;letf:40px;" onClick="response()"  >
         </div>
            		
         </form>
         <br>
         <br>
	</div>
</div>									
</body>
</html>
 <%@ include file="/hualuo.jsp"%>
