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
	
<script src="js/jquery.min.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/bootstrap.min.js"></script>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<title>readerlist</title>
<style type="text/css">
      		#qq3{
			width: 60px;
			height: 30px;
			background-color: #428bca;
			color:#fff;
			border-color: #357ebd;
			border-radius:10px;
			font-weight: 900;
			font-size: 80%;
			border:1px solid transparent;
		}
	#qq4{
			width: 160px;
			height: 30px;
			background-color: #428bca;
			color:#fff;
			border-color: #357ebd;
			border-radius:10px;
			font-weight: 900;
			font-size: 110%;
			border:1px solid transparent;
			position:relative;
			left:80%;
			top:-30px;
		}

</style>

	<%
int lend=0;
try{
	lend=Integer.parseInt(String.valueOf(request.getAttribute("lend") != null ? request.getAttribute("lend") : "0").trim());
}
catch(NumberFormatException e)
{	
}

    if(lend==1){
    	out.print("<script type='text/javascript' charset='utf-8'> alert('delete successfully!');</script>");
     }

    if(lend==2){
    	out.print("<script type='text/javascript' charset='utf-8'> alert('He has fine or has book is not return ,delete failed!');</script>");
     }
     %>
</head>

<body  style="background:#3F506A" onLoad="startTime()">

<div class="bodylibrary">
	<div class="allpage">
		<div class="headpage">
		<div class="booklibrarian">
			<img src="images/librarian.jpg" width="40%" height="80%" style="float:left;margin-top:10%">
			<p style="color:#736357;font-size:20px;margin-left:10% ;margin-top:20%;float:left">Nickname:</p>
			 <p style="color:#736357;font-size:20px;margin-left:10% ;margin-top:0%;float:left"><b><%
out.println(session.getAttribute("Librarianname"));
%>!</b></p>
		<form action="login.jsp?" method="post">  	   
 <p><input type="submit"  value="logout" style="color:white;background-color:red;width:60px;height:30px;margin-left:10%;float:left;"><p>
	</form>													
		
		</div>
		<div class="picturepage">
			<img src="images/library.jpg" width="100%" height="100%">
		
		</div>
		<div class="sumpage">
		  
        


	  <p class="part" style="color:#F00F13">Number of registered users in Library: <strong style="color:#000000">${total} </strong></p>
		
	</div>
	</div>
	<br>
	<div id="qq">
	<div id="qq1">
	        <br>
	        <form action="ListReaderServlet?" method="post">
		    <input name="select" type="text" SIZE="29" onmouseover="this.style.borderColor='black';this.style.backgroundColor='aqua'"
            style="width: 106; height: 21;margin-left:400px" placeholder="Please input phone number"
            onmouseout="this.style.borderColor='black';this.style.backgroundColor='#ffffff'" style="border-width:1px;border-color=black">
		    <input id="qq3" type="submit" value="serarch">
		    </form>
		     <form action="FineReaderServlet?" method="post">
		    <input id="qq4" type="submit" value="who owed book">
		    </form>
	</div>
    <table style="width: 600px; margin: 44px auto"
	class="table table-striped table-bordered table-hover  table-condensed"
	align='center' border='1' cellspacing='0'>
	<c:forEach items="${readers}" var="reader" varStatus="st">
		<tr>
			<td><div style="width:300px">Name：<span style="font-size:18px"><font color=blue><b>${reader.name}</b></font></span></div>
			<div>Phone Number：<span style="font-size:18px"><font color=blue><b>${reader.stunumber}</b></font></span>
			<span style="float:right"><a href="ListReaderServlet?stunumber=${reader.stunumber}&tag=yes"><font color=red>Delete</font></a></span>
			<span style="float:right">&nbsp&nbsp&nbsp</span>
			<span style="float:right"><a href="PersonInformationServlet?ponumber=${reader.stunumber}">Find</a></span>
			</div>
			</td>
		</tr>
	</c:forEach>

    </table>
    <nav>
	<ul class="pager">
		<li><a href="?start=0&select=${select}">home page</a></li>
		<li><a href="?start=${pre}&select=${select}">previous page</a></li>
		<li><a href="?start=${next}&select=${select}">next page</a></li>
		<li><a href="?start=${last}&select=${select}">last page</a></li>
	</ul>
    </nav>
	</div>
	
	
    </div>
</div>								
</body>
</html>
