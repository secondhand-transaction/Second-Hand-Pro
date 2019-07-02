<%@ page language="java" contentType="texhtml; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="css/Untitled-1.css" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Current Borrow</title>
<script type="text/javascript">
	window.onload = function() {
		var arr = document.getElementsByTagName('a');
		for (var i = 0; i < arr.length; i++) {
			arr[i].onclick = function() {
				if (this.id == '1') {
					document.getElementById("box1").style.display = 'block';
					document.getElementById("box2").style.display = 'none';
				} else {
					document.getElementById("box1").style.display = 'none';
					document.getElementById("box2").style.display = 'block';
				}
				//this是当前激活的按钮，在这里可以写对应的操作
				if (this.className == 'btn1') {
					this.className = 'btn2';
					var name = this.id;
					var btn = document.getElementsByClassName('btn2');
					for (var j = 0; j < btn.length; j++) {
						if (btn[j].id != name) {
							btn[j].className = 'btn1';
						}
					}
				}
			}
		}
	}
</script>
<link rel="stylesheet" href="css/csss.css" type="text/css"></link> 

<style>

.suoyin {
	width: 1300px;
	height: 500px;
	position: absolute;
	top: 170px;
	left: 80px;
}

table {
	width: 100%;
	font-size: .938em;
	border-collapse: collapse; /*边框会合并为一个单一的边框*/
}

th {
	text-align: center;
	font-weight: bold;
	color: #fff;
	background: #66677c;
	color: #fff;
}

td {
	padding: .5em .5em;
	border-bottom: solid 1px #ccc;
	background-color: white;
}

table, table tr th, table tr td {
	border: 1px solid black;
} /*设置边框的*/

.weizhi{
position:absolute;
  top:150px;
}
</style>
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
	<div class="suoyin">
		<div>
			<ul class="ui">
				<li class="li"><a href="ahistoryServelt" data-hover="History">History</a></li>
				<li class="li"><a href="acurrentServelt" data-hover="History">Current</a>
				<li>
			</ul><br>
			<div class="boxx" id="box1">
				<table width="100%" border="0" align="center" cellpadding="5"
					cellspacing="0" id="item">
					<th>ISBN</th>
					<th>BookID</th>
					<th>BorrowTime</th>
					<th>BookName</th>
					<th>ReturnDeadline</th>

					</tr>
					<c:forEach items="${currents}" var="c" varStatus="st">
						<tr align="center">
							<td width="20%">${c.ISBN}</td>
							<td width="20%">${c.ID}</td>
							<td width="20%">${c.borrowtime}</td>
							<td width="20%">${c.bookname}</td>
							<td width="20%">${c.returntime}</td>
						</tr>
					</c:forEach>

				</table>
				<nav>
				<ul class="pager">

					<li><a href="?start=0" class="href">start</a></li>
					<li><a href="?start=${pre}" class="href">pre</a></li>
					<li><a href="?start=${next}" class="href">next</a></li>
					<li><a href="?start=${last}" class="href">last</a></li>
				</ul>
				</nav>
			</div>
		</div>
	</div>
 </div>











</div>
</body>
</html>
