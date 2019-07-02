<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Library Login</title>
<style>
body {
    background-image:url('img/denglu2.gif');
	background-repeat:no-repeat; 
    background-position:-200px 0px; 
}
.huochai
{   
    position:relative;
	top:300px;
	left:-80px;
}
.lanqiu
{   
    position:relative;
	top:290px;
	left:400px;
}
.zhanghu
{   
    position:relative;
	top:-400px;
	left:730px;
}
.mima
{   
    position:relative;
	top:-324px;
	left:700px;
}
.container{
     width:1100px;
     height:550px;
     margin:60px auto;
     position:relative;
	 top:-130px;
	 left:0px;
 }
 .container img{
     position:absolute;
    padding:10px 10px 15px;
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

input[type="text"] {
	  width: 300px;
	  padding: 1em 3em 0em 3em;
	  color: #000000;
	  font-size: 18px;
	  outline: none;
	  background: url(../images/adm.png) no-repeat 10px 15px;
	  border: none;
	  font-weight: 100;
	  border-bottom: 1px solid#484856;
	  margin-top: 2em;
	  position:relative;
	  top:-476px;
	  left:710px;
}
 input[type="password"]{
	  width: 290px;
	  padding: 1em 2em 0em 3em;
	  color: #dd3e3e;
	  font-size: 18px;
	  outline: none;
	  background: url(../images/key.png) no-repeat 10px 23px;
	  border: none;
	  font-weight: 100;
	  border-bottom: 1px solid#484856;
	  margin-bottom: 3em;
	  position:relative;
	  top:-400px;
	  left:300px;
 }
 
input[type="submit"]{
  font-size: 20px;
  color: #fff;
  outline: none;
  border: none;
  background: #000000;
  width: 111px;
  height:40px;
  padding: 8px 0;
  border-bottom-left-radius: 15px;
   position:relative;
   top:-330px;

   left:-30px;
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

.button{
  font-size: 15px;
  color: #fff;
  outline: none;
  border: none;
  background: #000000;
  padding: 10px 5px;
  border-bottom-left-radius: 15px;
   position:relative;
   top:-406px;

   left:900px;
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
.huanying
{
	position:absolute;
	top:100px;
	left:620px;
	font-size:30px;
}
.tishi
{
	position:absolute;
	top:170px;
	left:950px;
	
}	

a{

		text-decoration:none;

}
</style>
</head>

<body>

<img class="lanqiu" src="img/login2.gif" alt="login2" width="127" height="59"/> 
<img class="huochai" src="img/login4.gif" alt="login4" width="125" height="90" />

<div class="container">
  <img class="pic1" src="img/login6.png" alt="login6"  width="300" height="90" />
</div>
<img class="zhanghu" src="img/login8.png" alt="login4" width="30" height="30" />
<img class="mima" src="img/login9.png" alt="login4" width="30" height="30" />

<form action="LoginServlet" method="post">
   
  <input  type="text" name="user"  placeholder="Please enter your login account" onfocus="this.placeholder= '';" onblur="if (this.placeholder == '') {this.placeholder = 'Please enter your login account';}" required autofocus/>
   
  <input type="password" name="pwd"  placeholder="Please enter your login password" onfocus="this.placeholder = '';" onblur="if (this.placeholder == '') {this.placeholder = 'Please enter your login password';}" required />
  
  <input type="submit" value="login" />
  
</form>
 </br> </br>
 </br> </br>
 <a href="register.jsp" class="button">Forgot password？</a>

 <a href="SeServlet" class="button">Visitors entrance</a>

<div class="huanying">
     <h1>welcome！</h1>
</div>

</body>
</html>
