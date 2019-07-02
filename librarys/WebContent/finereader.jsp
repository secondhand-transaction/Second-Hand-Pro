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
			font-size: 110%;
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
			top:0px;
		}

</style>
</head>

<body  style="background:#3F506A" onLoad="startTime()">

<div class="bodylibrary">
	<div class="allpage">
		<div class="headpage">
		<div class="booklibrarian">
			<img src="images/librarian.jpg" width="40%" height="80%" style="float:left;margin-top:10%">
			<p style="color:#736357;font-size:20px;margin-left:10% ;margin-top:20%;float:left">Nickname:</p>
			 <p style="color:#736357;font-size:20px;margin-left:10% ;margin-top:5%;float:left"><%
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
		  
        

   
	  <p class="part" style="color:#F00F13">Number of registered users in Library: <strong style="color:#000000">${total} </strong></p>
		
	</div>
	</div>
	<br>
	<div id="qq">
	<div id="qq1">
	        <br>
	        <form action="FineReaderServlet?" method="post">
		  <!-- <input type="text" id="qq2" name="select" placeholder="Please input " style="margin-left:400px"> -->  
		    
		    </form>
		      <form action="ListReaderServlet?fined=1" method="post">
		    <input id="qq4" type="submit" value="Reader List">
		    </form>
	</div>
    <table style="width: 600px; margin: 44px auto"
	class="table table-striped table-bordered table-hover  table-condensed"
	align='center' border='1' cellspacing='0'>
	<c:forEach items="${readers}" var="reader" varStatus="st">
		<tr>
			<td><div style="width:300px">Name：<span style="font-size:18px"><font color=blue><b>${reader.name}</b></font></span></div>
			<div>学号：<span style="font-size:18px"><font color=blue><b>${reader.stunumber}</b></font></span></div>
			<div>
			<span style="float:right"><a href="emailL?stunumber=${reader.stunumber}&email=${reader.email}&name=${reader.name}"><font color=red>email</font></a></span>
			<span style="float:right"><a href="PersonInformationServlet?ponumber=${reader.stunumber}">View</a></span>
			</div>
			</td>
		</tr>
	</c:forEach>

    </table>
   
	</div>
	
	
    </div>
</div>								
</body>
</html>
 <%@ include file="/hualuo.jsp"%>