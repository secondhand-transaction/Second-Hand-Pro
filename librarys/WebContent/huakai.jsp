<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/homepage.css">

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!-- bootstrap v3.3.6 css -->
<script type="text/javascript"
	src="js/vendor/jquery-1.12.0.min.js"></script>
<link rel="stylesheet"
	href="css/bootstrap.min.css">
<link rel="stylesheet"
	href="css/bootstrap-theme.min.css">
<!-- bootstrap js -->
<script src="js/bootstrap.min.js"></script>

	<link rel="stylesheet" type="text/css" href="css/index.css">
	
<title>nav</title>
 <script language="javascript" type="text/javascript">
  
	   
  
	  function startTime()   
            {   
                var today=new Date();
                var yyyy = today.getFullYear();  
                var MM = today.getMonth()+1;   
                var dd = today.getDate();   
                var hh=today.getHours();
                var mm=today.getMinutes();
                var ss=today.getSeconds(); 
                MM=checkTime(MM);
                dd=checkTime(dd);
                mm=checkTime(mm);   
                ss=checkTime(ss);    
                var day; 
                if(today.getDay()==0)   day   =   "Sunday " 
                if(today.getDay()==1)   day   =   "Monday" 
                if(today.getDay()==2)   day   =   "Tuesday" 
                if(today.getDay()==3)   day   =   "Wednesday " 
                if(today.getDay()==4)   day   =   "ThurSsday " 
                if(today.getDay()==5)   day   =   "Friday" 
                if(today.getDay()==6)   day   =   "Saturday " 
                document.getElementById('nowDateTimeSpan').innerHTML=yyyy+"-"+MM +"-"+ dd +" " + hh+":"+mm+":"+ss+"   " + day;   
                setTimeout('startTime()',1000);
            }   
	    
            function checkTime(i)   
            {   
                if (i<10){
                    i="0" + i;
                }   
                  return i;
            }  
	</script>
</head>

<body  style="background:#3F506A" onLoad="startTime()">
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <button class="navbar-toggle" data-toggle="collapse" data-target="#one">
                
                <span class="icon-bar"/>
                <span class="icon-bar"/>
                <span class="icon-bar"/>
            </button>
            <img src="images/logo.png" style="width:150px;height:50px;float: left" />
            <a href="#" class="navbar-brand" disabled> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Library management system </a>
            <li style="padding-top: 15px;padding-left:690px">Current time：<span id="nowDateTimeSpan"></span></li>
        </div>
        <div class="collapse navbar-collapse" id="one">
            <ul class="nav navbar-nav">
             
                <li> <a href="BookListServlet?"> Homepage </a> </li>
                 <li> <a href="AnnouncementListServlet?"> Announcement </a> </li>
                <li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false" >Borrow an Return books<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a
							href="borrowLend.jsp" >Borrow book</a></li>
						<li><a
							href="ReturnBookServlet" >Return book</a></li>
					</ul></li>
                <li> <a href="replyServlet?"> Reader feedback</a> </li>
                <li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false" >Reader list <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a
							href="addreader.jsp" >Add reader</a></li>
						<li><a
							href="ListReaderServlet" >List reader</a></li>
					</ul></li>
                <li> <a href="DeleteBookServlet?"> Book record deleted</a> </li>
                <li> <a href="IncomeRecordServlet"> Income record</a> </li>
             
	
            </ul>
        </div>   
    </div>
</nav>
</body>
</html>