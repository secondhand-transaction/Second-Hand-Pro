<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8">
<title>login</title>

 
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/style.css">
</head>
<body  style="background:#d0d0d0">
<div class="container">
<div class="form row">
<div class="form-horizontal col-md-offset-3" id="login_form">
<h1 class="form-title">Bibliosoft book management system</h1>
<div class="col-md-9">
<form
	action="${pageContext.request.contextPath}/servlet/ManageServlet?op=systemManagerLogin" method="post">
	
<div class="form-group">
<i class="fa fa-user fa-lg" ><font size="5">account</font></i><input class="form-control required" type="text" placeholder="Please input your account name" id="account" name="account" autofocus="autofocus" maxlength="20"/>
</div>

<div class="form-group">
<i class="fa fa-lock fa-lg"><font size="5">password</font></i><input class="form-control required" type="password" placeholder="Please input password" id="password" name="password" maxlength="8"/>
</div>

<div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"><font size="3">remember me</font></label>
        </div>
<div class="form-group col-md-offset-8">
<button type="submit" class="btn btn-lg btn-primary btn-block">log in</button>

</form>



</div>
</div>
</div>
</div>
</div>

<style type="text/css">    
     body{    
        background-image: url(images/bg.jpg);    
        background-size:cover;  
     }    
 </style> 
 
</body>
</html>