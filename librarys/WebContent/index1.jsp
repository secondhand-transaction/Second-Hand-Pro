<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/csss.css" type="text/css"></link> 
<title>无标题文档</title>
<style>


div.img
  {
  margin:3px;
  border:none;
  height:240px;
  width:180px;
  float:left;
  text-align:center;
  background-color:#FFFFFF;
  }
div.img img
  {
  display:inline;
  margin:4px;
  border:none;
  }
div.img a:hover img
  {
  border:1px solid #333333;
}
.pager {
    position:absolute;
    
	top: 1000px;
	left:900px;
	padding-left: 0;
	margin: 20px 0;
	text-align: center;
	list-style: none
}

.pager li {
	display: inline;
}

.pager li>a, .pager li>span {
	display: inline-block;
	padding: 5px 14px;
	
	background-color: grey;
	border: 1px solid #ddd;
	border-radius: 15px
}

.pager li>a:focus, .pager li>a:hover {
	text-decoration: none;
	background-color: #eee
}

.pager .next>a, .pager .next>span {
	float: right
}

.pager .previous>a, .pager .previous>span {
	float: left
}

.pager .disabled>a, .pager .disabled>a:focus, .pager .disabled>a:hover,
	.pager .disabled>span {
	color: #777;
	cursor: not-allowed;
	background-color: #fff
}

.href {
	text-decoration: none;
	color: black;
}
.fengzheng1{
    width:100%;
    height:200px;
    
	position:absolute;
	left:0px;
	top:300px;
	margin-left:0px;
	
}
.bottom1{
	position:absolute;
	top:1280px;
	width:100%;
	height:200px;
	background-image:url(img/green.png);
	background-repeat:no-repeat;
	background-size:100% 200px;
	
	
}

div.location{
border:none;
width:600px;
height:500px;
position:absolute;
top:460px;
left:800px;

}
.chaxun{
position:absolute;
top:440px;
left:225px;
}
.fenlei{
position:absolute;
top:500px;
left:250px;
}
input[type="submit"]{
  font-size: 15px;
  color: #fff;
    outline: none;
  border: none;
  background: gray;
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
	background: black;
	color: white;
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
</head>

<body>
<div class="top">
<img class="tubiao" src="img/log.gif"  />
<marquee class="baiyun1"  scrollamount=2 onmouseover=this.stop() onmouseout=this.start()><img src="img/baiyun1.gif" alt="baiyun" /></marquee>
<marquee class="baiyun2" scrollamount=4 onmouseover=this.stop() onmouseout=this.start()><img src="img/baiyun2.gif" alt="baiyun" /></marquee>
<h2 class="hello" style="font-family:STHupo">...Hello,visitor!</h2>

<div class="bottom1">
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
<div class="fengzheng1">
<img  src="img/book.gif " width="1600" height="1000"/>
</div>
<marquee class="zhifeiji" scrollamount=3 onmouseover=this.stop() onmouseout=this.start()><img src="img/zhifeiji.gif" alt="baiyun" width="91" height="56" />Announcement:<%
out.println(session.getAttribute("an")); %></marquee>
<nav class="menu">
    <ul>
        <li><a href="login.jsp">Login</a></li>
        <li><a href="IndexServlet1">Book</a></li>
        <li><a href="#"></a></li>
        <li><a href="#"></a></li>
        <li><a href="#"></a></li>
    </ul>
<br />
<p style="font-size:15px">MENU</p>
</nav>





<div class="location">


 <c:forEach items="${books}" var="book" varStatus="bk">
		

<div class="img">
  <a  href="abookmassageServelt1?ISBN=${book.ISBN}" onclick="chuanzhi">
  <img src="img/tjkd.jpg" alt="tjkd" width="160" height="160">
  </a>
  <div class="desc">ISBN:${book.ISBN}<br/> Bookname：${book.bookname}<br/>Author:${book.author}</div>
</div>

</c:forEach> 

</div>

<div class="pager">
<nav>
	<ul>

		<li><a href="?start=0">start</a></li>
		<li><a href="?start=${pre}">pre</a></li>
		<li><a href="?start=${next}">next</a></li>
		<li><a href="?start=${last}">last</a></li>
	</ul>
</nav>
</div>




<div class="chaxun">
<form action="SelectServlet1" accept-charset="UTF-8" onsubmit="document.charset='UTF-8';" method="post" >
<select id="s" name="s">
<option value="select by bookname">select by bookname</option>
<option value="select by author">select by author</option>
<option value="select by ISBN">select by ISBN</option>
<option value="select by press">select by press</option>
</select>

<input type="text" name="input">
<input type="submit">
</form>
</div>


<div class="fenlei">


<form action="SelectServlet2" accept-charset="UTF-8" onsubmit="document.charset='UTF-8';" method="post" >
<p><input type="submit" value="all" name="f" id="f"/>.....................................................</p><br/><br/>
<p><input type="submit" value="math" name="f" id="f"/>.................................................</p><br/><br/>
<p><input type="submit" value="literature" name="f" id="f"/>...........................................</p><br/><br/>
<p><input type="submit" value="history" name="f" id="f"/>..............................................</p><br/><br/>

</form>

</div>





</div>
</body>
</html>
