<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    	 <%@ include file="/huakai.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>test</title>
<link rel="stylesheet" href="css/bootstrap.min.css" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/homepage.css">
	<link rel="stylesheet" type="text/css" href="css/index.css">
<title>nav</title>
</head>
<body style="background:#3F506A">

<div class="bodylibrary" >
	<div class="allpage">
		<div class="headpage">
		<div class="booklibrarian">
			<img src="images/librarian.jpg" width="40%" height="80%" style="float:left;margin-top:10%">
			<p style="color:#736357;font-size:20px;margin-left:10% ;margin-top:20%;float:left">Nickname:</p>
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
		  
        

      <p class="part" style="color:#F00F13">Total amount of feedback information: <strong style="color:#000000">${total}</strong>strip</p>
	 
	  	
	</div>
	</div>
    <div class="div1" >
    <div style="align-content: center" align="center"><span style="font-size: 30px"><b>Reader feedback information</b></span></div>
   <c:forEach items="${replys}" var="reply" varStatus="pt">
   <div>
	<table  class="table1" cellpadding="0" cellspacing="0"  onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='white';">
	   <tr >
	    <td class="td3" >The sender：<a href="###">${reply.name}</a></td>
			<td style="text-align: right"><span style="color: #807576;text-align: center">Application time：${reply.replytime}</span></td>
	    </tr>
		<tr height="5px"></tr>
     	<tr>
	   	<td align="center" colspan="2"><textarea style="border: none" cols="70px" rows="3px" >${reply.content}</textarea></td>
	   </tr>
	    <tr height="5px"></tr>
	   <a href="?ID=${reply.ID}&start=${start}"><input type="submit"  value="delete" style="color:white;background-color:#2B7ACD;width:60px;height:30px;
													 position:relative;left:82%;top:75px;"></table></a>
	  </table>
	  </div>
	 
		<br>
	</c:forEach>
	 

 <br>  
	<nav>
	<ul class="pager">

		<li><a href="?start=0&selectL=${selectL}">Home page</a></li>
		<li><a href="?start=${pre}&selectL=${selectL}">Previous page</a></li>
		<li><a href="?start=${next}&selectL=${selectL}">next page</a></li>
		<li><a href="?start=${last}&selectL=${selectL}">Last page</a></li>
		
	</ul>
</nav>
	<br>
<div style="width=100%" >
	
       
</div>
</div>

	</div>
</div>	

		
</body>
</html>
 <%@ include file="/hualuo.jsp"%>