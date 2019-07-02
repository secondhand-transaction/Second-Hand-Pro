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
<script src="js/jquery.min.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/bootstrap.min.js"></script>
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

	
        
	</script>
	<script type="text/javascript" src="js/jquery2.1.4.min.js"></script>
<script type="text/javascript" src="js/JsBarcode.all.min.js"></script>
<script type="text/javascript">
   
    function barcodeGen(){
        var barvalue=$("#barcodeValue").val();
        if(barvalue==""){
            alert("Please enter a barcode string！！")
        }else{
            $("#bcode").JsBarcode(barvalue);
        }
    }
    function btn1(){
		document.getElementById('DepositeList').style.display='none';
		document.getElementById('FineList').style.display='block'; 
		document.getElementById('CB').style.backgroundColor="#98bf21";
		document.getElementById('HB').style.backgroundColor="aliceblue";
	}
    
	function btn2(){
		document.getElementById('FineList').style.display='none'; 
		document.getElementById('DepositeList').style.display='block'; 
		document.getElementById('HB').style.backgroundColor="#98bf21";
		document.getElementById('CB').style.backgroundColor="aliceblue";
	}
</script>
<%
int select=0;
try{
	select=Integer.parseInt(String.valueOf(request.getAttribute("select") != null ? request.getAttribute("lend") : "0").trim());
}
catch(NumberFormatException e)
{	
}
    if(select==1)
    	%>
    	<script>
    	document.getElementById('DepositeList').style.display='none';
		document.getElementById('FineList').style.display='block'; 
		document.getElementById('CB').style.backgroundColor="#98bf21";
		document.getElementById('HB').style.backgroundColor="aliceblue";
		</script>
   <%
     %>
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
		  
        

     <p class="part" style="color:#F00F13">Library total income this year is :<strong style="color:#000000">${year}</strong> yuan</p>
	  <p class="part" style="color:#F00F13">Library total income this month is : <strong style="color:#000000">${month} </strong> yuan</p>
	   <p class="part" style="color:#F00F13">Library total income this day is : <strong style="color:#000000">${day} </strong> yuan</p>	
	</div>
	</div>
	
<br>
<br>
<br>
<br>
<div class="row">
<div class="col-md-10 col-md-offset-1">
<br>

		<div style="height:50px">
			<ul>
  				<input id="CB" type="submit" value="FineList" onclick="btn1()" style="height: 100%;border: none;background-color: #98bf21;height: 100%;padding-top: 6px;padding-bottom: 6px;font-size: 20px">
  				<input id="HB" type="submit" value="DepositeList" onclick="btn2()" style="height: 100%;border: none;background-color: aliceblue;height: 100%;padding-top: 6px;padding-bottom: 6px;font-size: 20px">
			</ul>
	  </div>
<div id="FineList" style="height: 90%;width: 100%;background-color: aliceblue;display: block">
<table class="table table-hover"
	
	align='center' border='1' cellspacing='0'>
			<tr>
				 <td>phonenumber</td>
				 <td>time</td>
				 <td>money</td>
			</tr>

		<c:forEach items="${incomes1}" var="income1" varStatus="st">
			<tr>
				<td>${income1.stunumber}</td>
				<td>${income1.time}</td>
				<td>${income1.money}</td>
			</tr>
		</c:forEach>
		</table>
		
	
	<nav>
	<ul class="pager">

		<li><a href="?start1=0&select=1">First page</a></li>
		<li><a href="?start1=${pre1}&select=1">Previous Page</a></li>
		<li><a href="?start1=${next1}&select=1">Next Page</a></li>
		<li><a href="?start1=${last1}&select=1">Last Page</a></li>
		
	</ul>
</nav>
</div>
	
<div id="DepositeList" style="height: 90%;width: 100%;background-color: aliceblue;display: none">
<table class="table table-hover"
	
	align='center' border='1' cellspacing='0'>
			<tr>
				 <td>phonenumber</td>
				 <td>time</td>

				 <td>money</td>
			</tr>

		<c:forEach items="${incomes2}" var="income2" varStatus="st">
			<tr>
				<td>${income2.stunumber}</td>
				<td>${income2.time}</td>
				<td>${income2.money}</td>
			</tr>
		</c:forEach>
		</table>
		
	
	<nav>
	<ul class="pager">

		<li><a href="?start2=0">First page</a></li>
		<li><a href="?start2=${pre2}">Previous Page</a></li>
		<li><a href="?start2=${next2}">Next Page</a></li>
		<li><a href="?start2=${last2}">Last Page</a></li>
		
	</ul>
</nav>
</div>
	
	</div>
	  </div>
     </div>
    </div>
							
</body>
</html>
 <%@ include file="/hualuo.jsp"%>