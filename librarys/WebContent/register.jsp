<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Register</title>
<style>
body {
	
	background-repeat:no-repeat;	
	}
.container{
 width:auto;
     height:auto;
     position:relative;

	 left:25%
	 
 }
 .container img{
     position:absolute;

     background:#fff;
     border:none;
     -webkit-transition:1s ;
     -moz-transition:1s ;
     transition:1s ;
     z-index:1;
 }
 .container img:hover{
     -webkit-transform:rotate(0deg);
     -moz-transform:rotate(0deg);
     transform:rotate(0deg);
     -webkit-transform:scale(1.1);
     -moz-transform:scale(1.1);
     transform:scale(1.1);
     -webkit-box-shadow:5px 5px 5px #ddd;
     -moz-box-shadow:5px 5px 5px #ddd;
     box-shadow:5px 5px 5px #ddd;
     z-index:2;
     cursor:pointer;
 }a
.pic1{top:0px;left:400px;-webkit-transform:rotate(-5deg);-moz-transform:rotate(-5deg);transform:rotate(-5deg);}
* {
    box-sizing: border-box;
}
.weizhi{
	position:relative;
	top:200px;
	left:25%;
	font-weight:900;
}
[class*="col-"] {
    float: left;    
    border:none;
	border-radius: 6px;
	margin-bottom:20px;
	
	
}
.col-1 {	
margin-left:160px;
width:300px;
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
.col-3 {width: 120px;
        height:40px;
		padding-top:8px;
		text-align:right;
		clear:left;
		margin-left:160px;
		
		}
.col-4 {width: 180px; 
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
.col-8 {width: 300px; 
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
</head>

<body>
<div class="container">
  <img class="pic1" src="img/login6.png" alt="login6"  width="600" height="180" />
</div>

<div class="weizhi">
<form action="SendEmail。do" method="post">
<div class="col-1">
<h1>Retrieve password</h1>
</div>
<div class="col-2">
</div>
<div class = "col-3">
account：
</div>
<div class="col-4">
<input type="text" name="account"   placeholder="account for login" oninput = "value=value.replace(/[^\d]/g,'')" required/>
</div>

<div class="col-3">
email：
</div>
<div class="col-4">
<input type="email" name="email"   placeholder="your emali"  required/>
</div>
<div class="col-3">
<input type="submit" value="send email" >
</div>
<div class="col-5">
<a href="login.jsp" class="button">return</a>
</div>
</form>
</div>
</body>

<script type="text/javascript">




</script>
</html>
