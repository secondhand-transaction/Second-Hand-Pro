<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8">
<title>pwd</title>

<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/style.css">
</head>
<body  style="background:#d0d0d0">
<div class="container">
<div class="form row">
<div class="form-horizontal col-md-offset-3" id="login_form">
<h1 class="form-title">Modify manager account password</h1>
<div class="col-md-9">
<form
	action="${pageContext.request.contextPath}/servlet/ManageServlet?op=systemManagerChangepwd" method="post">
	
<div class="form-group">
<i class="fa fa-lock fa-lg"><font size="5">old password</font></i><input class="form-control required" type="password" placeholder="Please input password" id="oldPassword" name="oldPassword" maxlength="8"/>
</div>

<div class="form-group">
<i class="fa fa-lock fa-lg"><font size="5">new password</font></i><input class="form-control required" type="password" placeholder="Please input password" id="newPassword" name="newPassword" maxlength="8"/>
</div>

<div class="form-group">
<i class="fa fa-lock fa-lg"><font size="5">confirm new password</font></i><input class="form-control required" type="password" placeholder="Please input password" id="cnewPassword" name="cnewPassword" maxlength="8"/>
</div>

<button type="submit" class="btn btn-lg btn-primary btn-block">modify</button>
</form>

<div class="form-group col-md-offset-8">


</div>
</div>
</div>
</div>
</div>
</body>
</html>