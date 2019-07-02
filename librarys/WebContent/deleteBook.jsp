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

</style>

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
		  
  
	  <p class="part" style="color:#F00F13">Number of delete book: <strong style="color:#000000">${total} </strong></p>
		
	</div>
	</div>
	<br>
	<div id="qq">
	<div id="qq1">
	        <br>

	</div>
	<br>
	<br>
 <table class="table table-hover"
	
	align='center' border='1' cellspacing='0'>
	<tr>
	        <td>ISBN</td>
	        <td>ID</td>
	        <td>bookname</td>
	        <td>account</td>
	        <td>type</td>
	</tr>
	<c:forEach items="${deletebooks}" var="deletebook" varStatus="st">
		<tr>
			<td>${deletebook.ISBN }</td>
			<td>${deletebook.ID }</td>
			<td>${deletebook.bookname }</td>
			<td>${deletebook.account }</td>
			<td>
			<c:if test="${deletebook.type == 1 }">loss</c:if>
			<c:if test="${deletebook.type == 2 }">detroy</c:if>
			</td>
		</tr>
	</c:forEach>

    </table>
    <nav>
	<ul class="pager">
		<li><a href="?start=0">home page</a></li>
		<li><a href="?start=${pre}">previous page</a></li>
		<li><a href="?start=${next}">next page</a></li>
		<li><a href="?start=${last}">last page</a></li>
	</ul>
    </nav>
	</div>
	
	
    </div>
</div>								
</body>
</html>
 <%@ include file="/hualuo.jsp"%>