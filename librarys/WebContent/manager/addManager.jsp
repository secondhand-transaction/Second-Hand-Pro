<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>网上书城</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/./css/bootstrap.min.css">

<script src="${pageContext.request.contextPath}/./js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath }/./js/bootstrap.min.js"></script>
<script type="text/javascript">
	 function changeLanguage(){
	 	document.getElementById("p1").innerHTML="姓名：";
	 	document.getElementById("p2").innerHTML="密码：";
 		document.getElementById("p3").innerHTML="电话：";
		document.getElementById("p4").innerHTML="地址：";
		document.getElementById("p5").innerHTML="邮箱：";
		document.getElementById("p6").innerHTML="添加";
		document.getElementById("p7").innerHTML="添加管理员";	
		document.getElementById("p8").innerHTML="添加管理员";
		document.getElementById("p9").innerHTML="查询管理员";
		document.getElementById("p10").innerHTML="超期图书";
		document.getElementById("p11").innerHTML="读者管理";
		document.getElementById("p12").innerHTML="添加读者";
		document.getElementById("p13").innerHTML="查询读者";	
		document.getElementById("p14").innerHTML="管理员账号管理";
	 }
	</script>
	
	
       
</head>
<%@ include file="/manager/header.jsp"%>
<h3 id="p7">Add Librarian</h3>
<form
	action="${pageContext.request.contextPath}/servlet/ManageServlet?op=addManager"
	method="post">
	<table class="table table-striped" style="width: 50%;">
		<tr>
			<td id="p1">Account：</td>
			<td>
				 <input name="id"
				class="form-control" placeholder="Please input your account"
				aria-describedby="sizing-addon1">
			</td>
		</tr>
		<tr>
			<td id="p2">Name：</td>
			<td>
				<!-- <input name="username" id="name" /> --> <input name="username"
				class="form-control" placeholder="Please input your name"
				aria-describedby="sizing-addon1">
			</td>
		</tr>
		<tr>
			<td id="p3">Password：</td>
			<td>
				<!-- <input name="password" id="password" /> --> <input
				name="password" class="form-control"
				placeholder="Please input your password"
				aria-describedby="sizing-addon1">
			</td>
		</tr>
		<tr>
			<td id="p4">Telephone：</td>
			<td>
				<!-- <input name="phone" id="phone" /> --> <input name="phone"
				class="form-control" placeholder="Please input your telephone"
				aria-describedby="sizing-addon1">
			</td>
		</tr>
		<tr>
			<td id="p5">Address：</td>
			<td>
				<!-- 	<input name="address" /> --> <input name="address"
				class="form-control" placeholder="Please input your address"
				aria-describedby="sizing-addon1">
			</td>
		</tr>
		<tr>
			<td id="p6">Email：</td>
			<td>
				<!-- 			<input name="email"/> --> <input name="email"
				class="form-control" type="email" placeholder="Please input your email"
				aria-describedby="sizing-addon1">
			</td>
		</tr>
	</table>
	<!-- <input type="submit" value="add"/> -->
	<button type="submit" class="btn btn-info" id="p7">add</button>
</form>
</body>
</html>