<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="css/1.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Persoal Imformation</title>
<style>  
.weizhi{
	position:absolute;
	top:350px;
	left:100px;
	font-weight:900;
}
[class*="col-"] {
	box-sizing: border-box;
    float: left;    
    border:none; 
	border-radius: 6px;
	margin-bottom:20px;
	
}
.col-1 {	
margin-left:100px;
width:300px;
height:100px;
padding:4px 0px;}

.col-2{
width: 150px;
background:url("img/i1.gif");
background-repeat:no-repeat;
background-position:left center;
background-size:100px 50px; 
height:100px;
}
.col-3 {width: 120px;
        height:40px;
		padding-top:8px;
		text-align:right;
		clear:left;
		margin-left:200px;
		
		}
.col-4 {width: 180px; 
        height:40px;
		padding:3px 0px;
		}
.col-5 {width: 120px; 
        height:40px;
		padding:3px 10px;
		 margin-top:30px}
.col-6 {width: 300px; 
        height:40px;
		padding:3px 0px;}
.col-7 {width: 300px; 
        height:40px;
		padding:3px 0px;}
.col-8 {width: 120px;
        height:40px;
		padding-top:8px;
		text-align:right;
		margin-left:50px;
		
		}
.col-9 {width: 180px; 
        height:40px;
		padding:3px 0px;
		clear:right;
		}
.col-10 {width: 180px; 
        height:40px;
		padding:10px;
	    clear:right;
	   
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
input[type="button"]{
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
input[type="button"]:hover {
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


</style>
<link rel="stylesheet" href="css/csss.css" type="text/css"></link> 


</head>

<body>
<div class="top">
<img class="tubiao" src="img/log.gif"  />
<marquee class="baiyun1"  scrollamount=2 onmouseover=this.stop() onmouseout=this.start()><img src="img/baiyun1.gif" alt="baiyun" /></marquee>
<marquee class="baiyun2" scrollamount=4 onmouseover=this.stop() onmouseout=this.start()><img src="img/baiyun2.gif" alt="baiyun" /></marquee>
<h2 class="hello" style="font-family:STHupo">...Hello,<%
out.println(session.getAttribute("name"));
%>!</h2>

<div class="bottom">
<nav class="in">
    <ul>
        <li><a href="#">ABOUT US</a></li>
        <li><a href="#">CALL US</a></li>
        <li><a href="#">OUR TEAM</a></li>
        <li><a href="#">NOTHING</a></li>
        <li><a href="#">NOTHING</a></li>
    </ul>
</nav>
</div>
<img class="fengzheng" src="img/fengzheng.gif " width="1264" height="740"/>
<marquee class="zhifeiji" scrollamount=3 onmouseover=this.stop() onmouseout="this.start()"><img src="img/zhifeiji.gif" alt="baiyun" width="91" height="56" />Announcement:<%
out.println(session.getAttribute("an")); %></marquee>
<nav class="menu">
    <ul>
        <li><a href="login.jsp">Logout</a></li>
        <li><a href="IndexServlet">Book</a></li>
        <li><a href="acurrentServelt">Borrow</a></li>
        <li><a href="ImformationServlet">Personal</a></li>
        <li><a href="#"></a></li>
    </ul>
<br />
<p style="font-size:15px">MENU</p>
</nav>

<div class="weizhi">
<form action="ImformationNewServlet" method="post" >



<div class="col-1">
<h1>IMFORMATION</h1>
</div>
<div class="col-2">
</div>
<div class="col-5">
<input type="button" id="1" value="ChangeIMF" onclick="showin()" />
</div>
<div class="col-5">
<input type="button" id="2" value="ChangePWD" onclick="showpa()" />
</div>
<div class="col-5">
<input type="submit" id="3" value="Confirm" style="display:none" disabled="disabled"/>
</div>
<div class="col-5">
<input type="button" id="4" value="Cancel" style="display:none" onclick="disshow()" />
</div>
<div class="col-3">
name：
</div>
<div class="col-4">
<input type="text" name="name" id="5" value="${reader.name}"  disabled="disabled"/>
</div>
<div style="display:none" id="a">
<div class="col-8">
old-pwd：
</div>
<div class="col-9">
<input type="password" id="p" name="password" onblur="checkPass();" />
</div>
<div class="col-10">
<span style="font-family:arial;color:red;" id="pswd" ></span>
</div>
</div>

<div class="col-3">
email：
</div>
<div class="col-4">
<input type="text" name="email" id="7"  value="${reader.email}" disabled="disabled"/>
</div>

<div style="display:none" id="b">
<div class="col-8">
new-pwd：
</div>
<div class="col-9">
<input type="text" name="newpassword"  id="p1" onblur="checkPass();"  />
</div>
</div>
</form>
<div class="col-3">
fine：
</div>
<div class="col-4">
<input type="text" name="fine"  disabled="disabled" value="${reader.fine}￥" />
</div>


<div style="display:none" id="c">
<div class="col-8">
pwd-again：
</div>
<div class="col-9">
<input type="text" name="repassword"  id="p2"  onblur="checkPass();" />
</div>

<div class="col-10">
<span style="font-family:arial;color:red;" id="errorpwd" ></span>
</div>
</div>
</form>













</div>
</body>
<script type="text/javascript">


function checkPass(){
var pwd1=document.getElementById("p1").value;
var pwd2=document.getElementById("p2").value;
if(pwd1==pwd2||pwd1==null||pwd2==null){
document.getElementById("errorpwd").innerHTML="";
}
else{
document.getElementById("errorpwd").innerHTML="different new-pwd！";
}
var pwd=document.getElementById("p").value;
var psd="${reader.password}";
if(psd==pwd){
	document.getElementById("pswd").innerHTML="";
	
}
else{
	document.getElementById("pswd").innerHTML="pwd wrong！";
}
var pswd=document.getElementById("pswd").innerHTML;
var errorpwd=document.getElementById("errorpwd").innerHTML;
if(pswd==""&&errorpwd=="") 
	{
	document.getElementById("3").disabled=false;
	}
}

function showin(){
	var r =document.getElementById("1");
	var q =document.getElementById("2");
	var w =document.getElementById("3");
	var e =document.getElementById("4");
	document.getElementById("3").disabled=false;
	document.getElementById("5").disabled=false;

	document.getElementById("7").disabled=false;
	q.style.display="none";
	r.style.display="none";
	w.style.display="block";
	e.style.display="block";
}
function showpa(){
	var r =document.getElementById("1");
	var q =document.getElementById("2");
	var w =document.getElementById("3");
	var e =document.getElementById("4");
	var t =document.getElementById("a"); 
	var y =document.getElementById("b");
	var u =document.getElementById("c");
	document.getElementById("3").disabled=true;
	t.style.display="block";
	y.style.display="block";
	u.style.display="block";
	r.style.display="none";
	q.style.display="none";
	w.style.display="block";
	e.style.display="block";
}
function disshow(){
	var r =document.getElementById("1");
	var q =document.getElementById("2");
	var w =document.getElementById("3");
	var e =document.getElementById("4");
	var t =document.getElementById("a"); 
	var y =document.getElementById("b");
	var u =document.getElementById("c");
	document.getElementById("5").disabled=true;

	document.getElementById("7").disabled=true;
	t.style.display="none";
	y.style.display="none";
	u.style.display="none";
	r.style.display="block";
	q.style.display="block";
	w.style.display="none";
	e.style.display="none";
	document.getElementById("5").value="${reader.name}";

	document.getElementById("7").value="${reader.email}";
	document.getElementById("p").value="";
	document.getElementById("p1").value="";
	document.getElementById("p2").value="";
}

</script>

</html>
