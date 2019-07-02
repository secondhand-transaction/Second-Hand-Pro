<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ include file="/huakai.jsp"%>
	<%@ page import="dao.DataDao"%>
	<%@ page import="domain.Setdata"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="css/bootstrap.min.css" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/homepage.css">



	<link rel="stylesheet" type="text/css" href="css/index.css">
	
<title>nav</title>
<style>


.pic1{top:0px;left:400px;-webkit-transform:rotate(-5deg);-moz-transform:rotate(-5deg);transform:rotate(-5deg);}
* {
    box-sizing: border-box;
}
.weizhi{
	position:relative;
	top:100px;
	left:20%;
	font-weight:900;
}
[class*="col-"] {
    float: left;    
    border:none;
	border-radius: 6px;
	margin-bottom:20px;
	
	
}
.col-1 {	
margin-left:100px;
width:140px;
height:100px;
padding:4px 0px;
text-align:right;}

.col-2{
width: 150px;
background:url("img/zhuce2.gif");
background-repeat:no-repeat;
background-position:left center;
background-size:70px 50px; 
height:100px;
}
.col-3 {width: 105px;
        height:40px;
		padding-top:8px;
		text-align:right;
		clear:left;
		margin-left:160px;
		
		}
.col-4 {width: 170px; 
        height:40px;
		padding:3px 0px;
		clear:right;
		}
.col-5 {width: 300px; 
        height:40px;
		padding:3px 50px;
		 margin-top:30px}
.col-6 {width: 300px; 
        height:40px;
		padding:3px 0px;}
.col-7 {width: 300px; 
        height:40px;
		padding:3px 0px;}
.col-8 {width: 200px; 
        height:40px;
		padding:10px;
	
		}


 input{
                border: 1px solid #ccc;
                padding: 7px 0px;
                border-radius: 3px;
                padding-left:5px;
                -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
                box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
                -webkit-transition: border-color ease-in-out .15s,-webkit-box-shadow                 ease-in-out .15s;
                -o-transition: border-color ease-in-out .15s,box-shadow ease-in-out                 .15s;
                transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s
}
 input:focus{
                    border-color: #000000;
                    outline: 0;
                    -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgba(102,175,233,.6);
                    box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgba(102,175,233,.6)
}

input[disabled="disabled"]
{
	background-color:#FFFFFF;
	
}
input[type="submit"]{
  font-size: 15px;
  color: #fff;
    outline: none;
  border: none;
  background: #000000;
  border-radius: 15px;
  padding:5px;
	-webkit-border-bottom-left-radius: 15px;
	-moz-border-bottom-left-radius: 15px;
	-o-border-bottom-left-radius: 15px;
	border-bottom-right-radius: 15px;
	-webkit-border-bottom-right-radius: 15px;
	-moz-border-bottom-right-radius: 15px;
	-o-border-bottom-right-radius: 15px;
	cursor: pointer;
}
input[type="submit"]:hover {
	background: #FFFFFF;
	color: #000000;
  border-radius: 15px;
	-webkit-border-bottom-left-radius: 15px;
	-moz-border-bottom-left-radius: 15px;
	-o-border-bottom-left-radius: 15px;
	border-bottom-right-radius: 15px;
	-webkit-border-bottom-right-radius: 15px;
	-moz-border-bottom-right-radius: 15px;
	-o-border-bottom-right-radius: 15px;
  	transition: 1s all;
	-webkit-transition: 1s all;
	-moz-transition: 1s all;
	-o-transition: 1s all;
}
.button{
  font-size: 15px;
  color: #fff;
  outline: none;
  border: none;
  background: #000000;
  padding: 5px;
  border-radius: 15px;
  text-decoration:none;
	-webkit-border-bottom-left-radius: 15px;
	-moz-border-bottom-left-radius: 15px;
	-o-border-bottom-left-radius: 15px;
	border-bottom-right-radius: 15px;
	-webkit-border-bottom-right-radius: 15px;
	-moz-border-bottom-right-radius: 15px;
	-o-border-bottom-right-radius: 15px;
	cursor: pointer;
}



.button:hover {
	background: #FFFFFF;
	color: #000000;
  border-bottom-left-radius: 15px;
	-webkit-border-bottom-left-radius: 15px;
	-moz-border-bottom-left-radius: 15px;
	-o-border-bottom-left-radius: 15px;
	border-bottom-right-radius: 15px;
	-webkit-border-bottom-right-radius: 15px;
	-moz-border-bottom-right-radius: 15px;
	-o-border-bottom-right-radius: 15px;
  	transition: 1s all;
	-webkit-transition: 1s all;
	-moz-transition: 1s all;
	-o-transition: 1s all;
}
</style>
 <script language="javascript" type="text/javascript">
 function checkPass(){
	 var pwd= null;  pwd=document.getElementById("p1").value;
	
	 if(pwd/1000000000<10){
	 	document.getElementById("pswd").innerHTML="Please enter 11-bit phone number!"; 	
	 }
	 else 
	 {
		 	document.getElementById("pswd").innerHTML=""; 	
		 }
 }
	   
   
	</script>
	<%int i=0;
try{
	i=Integer.parseInt(String.valueOf(request.getAttribute("i") != null ? request.getAttribute("i") : "0").trim());
}
catch(NumberFormatException e)
{	
}

    if(i==1){
    	out.print("<script type='text/javascript' charset='utf-8'> alert('Mobile phone number repeat');</script>");
     }
    else if(i==2)
    {
    	out.print("<script type='text/javascript' charset='utf-8'> alert('registration success');</script>");
    }
    %>
    <%
    int deposit=0;
    Setdata setdata= new DataDao().selectone();
    deposit=setdata.getDeposit();
	 request.setAttribute("deposit", deposit);
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
		  
        

    <!--   <p class="part" style="color:#F00F13">Total volume of library books: <strong style="color:#000000">${all}</strong>篇</p>
	  <p class="part" style="color:#F00F13">Number of registered users in Library: <strong style="color:#000000">${allreader} </strong>人</p> -->

	  
      
  
	
		
	</div>
	</div>
	


<div class="weizhi">
<form action="AddReaderServlet" method="post">
<div class="col-3">
Nickname：
</div>
<div class="col-4">
<input type="text" name="name"  placeholder="Enter your nickname here"  required autofocus />
</div>


<div class="col-3">
Telephone：
</div>
<div class="col-4">
<input type="text" name="stunumber"  id ="p1" maxlength="11" placeholder="Enter the phone here" onblur="checkPass()" required/>
</div>
<div class="col-10">
<span style="font-family:arial;color:red;" id="pswd" ></span>
</div>


<div class="col-3">
Mailbox：
</div>
<div class="col-4">
<input type="email" name="email"   placeholder="Enter the mailbox here"  required/>
</div>
<div class="col-3">
Deposit：
</div>
<div class="col-4">
<input type="text" name="deposit"   value=<%=deposit %>  required/>
</div>
<div class="col-3">
Address:
</div>
<div class="col-4">
<input type="text" name="address"   placeholder="Enter the address here"  required/>
</div>
<div class="col-5">
<input type="submit" value="Confirm add" >
</div>
</form>
</div>


       
</div>
</div>
	
								
</body>
</html>
 <%@ include file="/hualuo.jsp"%>