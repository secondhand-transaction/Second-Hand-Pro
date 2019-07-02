<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ include file="/huakai.jsp"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="css/bootstrap.min.css" crossorigin="anonymous">
	<!--下面三行为class="table table-striped table-bordered table-hover
					table-condensed"的CSS和JS-->
	<script src="js/jquery.min.js"></script>
    <link href="css/bootstrap.min1.css" rel="stylesheet">
    <script src="js/bootstrap.min.js"></script>
	

<title>return book</title>
	<style type="text/css">
	    #ice1{
	     width:900px;
	     height:500px;
	     background:white;
	     margin:auto;
	}

		#ice2{
			width: 60px;
			height: 30px;
			background-color: #428bca;
			color:#fff;
			border-color: #357ebd;
			border-radius:10px;
			font-weight: 900;
			font-size: 70%;
			border:1px solid transparent;
		}
		
		#text1 {
			border:2px solid #F60;
			width:210px;
			height:29px;
			font-size:14px; 
			line-height:1.6; 
			margin-left:250px;
			margin-top:30px;
			}
	</style>

	<script>

	function display_alert(){
	   alert("还书成功!");
	}
	</script>

	<%
int lend=0;
try{
	lend=Integer.parseInt(String.valueOf(request.getAttribute("lend") != null ? request.getAttribute("lend") : "0").trim());
}
catch(NumberFormatException e)
{	
}

    if(lend==1){
    	out.print("<script type='text/javascript' charset='utf-8'> alert('return book successfully!');</script>");
     }

    if(lend==2){
    	out.print("<script type='text/javascript' charset='utf-8'> alert('fail to return book!');</script>");
     }
     %>
</head>

<body  style="background:#3F506A" onLoad="startTime()">

<div id="ice1">

    <form action="ReturnBookServlet?tag=1" method="post">
	            <input type="text" id="text1" name="bookid"  placeholder="Please input the ID of the book.">

		        <input id="ice2" type="submit" style="margin-left: 20px"" value="return">
			</form>
</div>
</body>
</html>
	 <%@ include file="/hualuo.jsp"%>
	