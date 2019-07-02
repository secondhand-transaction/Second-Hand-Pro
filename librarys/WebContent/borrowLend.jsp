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
	
	<link rel="stylesheet" type="text/css" href="css/homepage.css">
	<link rel="stylesheet" type="text/css" href="css/index.css">
<title>borrow and return book</title>
	<style type="text/css">
	
	    #ice1{
	        width:900px;
	        margin: auto;
	    }
		#ice2{
			width: 50px;
			height: 30px;
			background-color: #428bca;
			color:#fff;
			border-color: #357ebd;
			border-radius:10px;
			font-weight: 900;
			font-size: 70%;
			border:1px solid transparent;
		}
		
		#ice3{
			width: 900px;
			height: 600px;
			background: white;
			margin: auto;
		}
		#ice5{
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
		#ice6{
			width: 100px;
			height: 60px;
			background-color:aqua;
			color:#fff;
			border-color: #357ebd;
			border-radius:5px;
			font-weight: 900;
			font-size: 100%;
			border:1px solid transparent;
		}
		#ice8{
			width:720px;
			float: right;
		}
		#text1 { 
			border:2px solid #C3C; 
			height:30px;
			background:;
		}
		#text2 {
			border:2px solid #F60;
			width:210px;
			height:29px;
			font-size:14px; 
			line-height:1.6; 
			}

	</style>

	<script>
		//显示隐藏的div框
		function btn1(){
    document.getElementById('ice3').style.display='block'; 
}
		function btn2(){
    document.getElementById('ice7').style.display='block'; 
}
		//显示时间
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
                if(today.getDay()==1)   day   =   "Monday " 
                if(today.getDay()==2)   day   =   "Thusday " 
                if(today.getDay()==3)   day   =   "Wednesday " 
                if(today.getDay()==4)   day   =   "Thursday " 
                if(today.getDay()==5)   day   =   "Friday " 
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
		
            //显示提示信息
		
		   //当输入不为空时使按钮可用
           function checkA(obj) {
           var str = obj.value; 
           alert("Input success");
           if(str != null && str != "") {
           document.all.ice2.disabled = "";
           }
           else {
           document.all.ice2.disabled = "disabled";
           }
           }
            
            
           function del(){ 
         	   var msg = 'Borrowing books successfully!'+'\n'+'Do you want to continue?'; 
         	   if (confirm(msg)==true){ 
         	    return true; 
         	   }else{ 
         	    return false; 
         	   } 
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
    	out.print("<script type='text/javascript' charset='utf-8'> alert('This book has been borrowed!');</script>");
     }
    else if(lend==2){
    	out.print("<script type='text/javascript' charset='utf-8'> alert('This book has been ordered!');</script>");
     }
    else if(lend==3){
    	out.print("<script type='text/javascript' charset='utf-8'> alert('Fines are not paid.');</script>");
    }
    	else if (lend==4)
    	{
    		out.print("<script type='text/javascript' charset='utf-8'> alert('You can borrow three books at most.');</script>");
    	}
    	else if(lend==5)
    	{
    		out.print("<script type='text/javascript' charset='utf-8'> del();</script>");

    	}
    if(lend==6){
    	out.print("<script type='text/javascript' charset='utf-8'> alert('query was successful!');</script>");
     }
    else if(lend==7){
    	out.print("<script type='text/javascript' charset='utf-8'> alert('The phonenumber is incorrect. Please re enter the phonenumber!');</script>");
     }
     %>

</head>

<body  style="background:#3F506A" onLoad="startTime()">
	<!--导航栏-->

	<!--显示读者的信息-->
<div id="ice1">
		
		<br>
	    <form action="ReaderServlet1" method="post">
		<input type="text" id="text1" name="stunumber" onchange="checkA(this)" placeholder="Please input reader ID">

        <input id="ice2" type="submit" value="confirm" onclick="display()" disabled="disabled">
		</form>
	</div>
	<div id="ice3">
	<!--<div id="ice3" style="display:none">-->
	<img src="images/ggg.jpg" width="150" height="180">
		<div id="ice8">
	<div><span style="font-size: 18px"><b>Name：${name}</b></span></div><br>
	<div><span style="font-size: 18px"><b>School number：${stunumber}</b></span></div><br>
	<div><span style="font-size: 18px"><b>Email：${email}</b></span></div><br>
	<div><span style="font-size: 18px"><b>Fine：${fine}</b></span></div>
		</div>
		<div style="height: 50px"></div>
		<!--还书功能的实现-->
		
<table style="width: 600px;" class="table table-striped table-bordered table-hover
									table-condensed" border="1" cellspacing="0">
	<tr>
		<td>Title</td>
		<td>BookID</td>
		<td>ISBN</td>
		<td>Period of borrowing</td>
	</tr>
		
		<c:forEach items="${currentborrows}" var="currentborrow" varStatus="st">
	<tr>

		<td>${currentborrow.bookname}</td>
		<td>${currentborrow.ID}</td>
		<td>${currentborrow.ISBN}</td>
		<td>${currentborrow.borrowtime}</td>
		<td>
		<form action="ReaderServlet1?ISBN2=${currentborrow.ISBN}
	&borrowtime2=${currentborrow.borrowtime}&bookname2=${currentborrow.bookname}&stunumber=${stunumber}&ID2=${currentborrow.ID}" method="post">
		<!-- <input id="ice110" type="submit" value="return book"> -->
			</form>
		</td>

	</tr>
		</c:forEach>
			
</table>

		<br>
		<div style="width:400px;height:40px"></div>
		<span id="ice6">borrow book</span>
		<br><br>
		
		<!--借书功能的实现-->
	<!--<div id="ice7" style="display: none">  -->
     <div id="ice7">
			<form action="ReaderServlet1?stunumber=${stunumber}" method="post">
	            <input type="text" id="text2" name="userid1"  placeholder="Please input the ID of the book.">

		        <input id="ice5" type="submit" style="margin-left: 20px" onclick="display_alert()" value="confirm">
			</form>
		</div>
	</div>
</body>
</html>
	 <%@ include file="/hualuo.jsp"%>