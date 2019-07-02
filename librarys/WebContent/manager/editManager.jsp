<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="business.BusinessImpl"%>
<%@page import="business.Business"%>
<%@page import="domain.Manager"%>
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Bibiosoft</title>
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
		document.getElementById("p6").innerHTML="修改";
		document.getElementById("p7").innerHTML="修改管理员信息";
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
<%
    	Business b = new BusinessImpl();
    	int managerId = Integer.valueOf(request.getParameter("managerId"));
    	Manager manager = b.findManagerById(managerId);
    %>
<%@ include file="/manager/header.jsp"%>
<h3 id="p7">Edit Librarian</h3>
<form
	action="${pageContext.request.contextPath}/servlet/ManageServlet?op=editManager&managerId=<%=manager.getId() %>"
	method="post">
	<table class="table table-striped" style="width: 50%;">
		<tr>
			<td id="p1">Name：</td>
			<td><input name="username" id="name" class="form-control"
				value="<%=manager.getUsername() %>" /></td>
		</tr>
		<tr>
			<td id="p2">Password：</td>
			<td><input name="password" id="password" class="form-control"
				value="<%=manager.getPassword()%>" /></td>
		</tr>
		<tr>
			<td id="p3">Telephone：</td>
			<td><input name="phone" id="phone" class="form-control"
				value="<%= manager.getPhone()%>" /></td>
		</tr>
		<tr>
			<td id="p4">Address：</td>
			<td><input name="address" class="form-control"
				value="<%=manager.getAddress()%>" /></td>
		</tr>
		<tr>
			<td id="p5">Email：</td>
			<td><input name="email" class="form-control"
				value="<%=manager.getEmail()%>" /></td>
		</tr>

	</table>
	<!-- <input type="submit" value="Save"/> -->
	<button type="submit" class="btn btn-info" id="p6">Edit</button>
</form>
</body>
</html>
