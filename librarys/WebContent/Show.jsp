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
<script type="text/javascript" src="js/jquery2.1.4.min.js"></script>
<script type="text/javascript" src="js/JsBarcode.all.min.js"></script>
<script type="text/javascript">
<%
out.println("<iframe src='http://api.k780.com/?app=barcode.get&bc_text=12345678&appkey=10003&sign=b59bc3ef6191eb9f747dd4e83c99f2a4' height='100px' width='460px'></iframe></br>");
%>

</script>

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

	
        
	</script>
</head>

<body  style="background:#3F506A" onLoad="startTime()">

<div class="bodylibrary">
	
    <a href="#" onClick="myprint();" ><span> 打  印</span></a><br>
    <c:forEach items="${books}" var="book" varStatus="st">
						<tr align="center">
			<div>			    
	<hr>
    <input type="text"  id="barcodeValue" value="${book.ID}"> &nbsp;<a href="#" onClick="barcodeGen()" ><span> 生成条形码</span></a><br>
    <!--startprint-->
    <img id="bcode"/>
    <!--endprint-->
    <hr>
									
			
						</tr>
						</div>
					</c:forEach>

</div>									
</body>
</html>
