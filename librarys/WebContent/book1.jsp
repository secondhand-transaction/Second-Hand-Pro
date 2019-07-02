<%@ page language="java" contentType="texhtml; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/csss.css" type="text/css"></link> 
<title>无标题文档</title>
<script type="text/javascript">

        window.onload = function(){
            var arr = document.getElementsByTagName('a');
            for(var i = 0;i<arr.length;i++){
                arr[i].onclick = function(){
                    if (this.id == '1' )
                    {
                        document.getElementById("box1").style.display = 'block' ;
                        document.getElementById("box2").style.display = 'none' ;
                    }
                    else{
                        document.getElementById("box1").style.display = 'none' ;
                        document.getElementById("box2").style.display = 'block' ;
                    }
                    //this是当前激活的按钮，在这里可以写对应的操作
                    if(this.className == 'btn1'){
                        this.className = 'btn2';
                        var name = this.id;
                        var btn = document.getElementsByClassName('btn2');
                        for(var j=0;j<btn.length;j++){
                            if(btn[j].id!=name){
                                btn[j].className = 'btn1';
                            }
                        }
                    }
                }
            }
        }
    </script>
<script type="text/javascript">
//多行注释
 /* 我是多行注释！
  我需要隐藏，
  否则会报错哦！*/

//在页面中显示文字

//页面中弹出提示框
function myFunction(){
    alert('order successfully!')
    }
    

//单行注释
   //我是单行注释，我也要隐藏起来！

</script>
<link rel="stylesheet" type="text/css" href="css/Untitled-1.css"  />
<style>
.weizhi{
position:absolute;
  top:200px;
}



.bottom1{
	position:absolute;
	top:1200px;
	width:100%;
	height:200px;
	background-image:url(img/green.png);
	background-repeat:no-repeat;
	background-size:100% 200px;
	
	
}
</style>


</head>

<body>
<div class="top">
<img class="tubiao" src="img/log.gif"  />
<marquee class="baiyun1"  scrollamount=2 onmouseover=this.stop() onmouseout=this.start()><img src="img/baiyun1.gif" alt="baiyun" /></marquee>
<marquee class="baiyun2" scrollamount=4 onmouseover=this.stop() onmouseout=this.start()><img src="img/baiyun2.gif" alt="baiyun" /></marquee>
<h2 class="hello" style="font-family:STHupo">...Hello,visitor</h2>

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
<img class="fengzheng" src="img/fengzheng.gif " width="1264" height="740"/>
<marquee class="zhifeiji" scrollamount=3 onmouseover="this.stop()" onmouseout="this.start()" ><img src="img/zhifeiji.gif" alt="baiyun" width="91" height="56" />Announcement:<%
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


<div class="weizhi">
<div class='daxiao'>
	<img class='img' src="img/timg.jpg" />
  <table class="table">   <tr>
  <c:forEach items="${abooks}" var="abook" varStatus="st" begin="0" end= "0">
    <th align="left">Bookname：</th>
    <td>${abook.bookname}</td>
  </tr>
  <tr>
    <th align="left">Author：</th>
    <td>${abook.author}</td>
  </tr>
  <tr>
  	<th align="left">Press：</th>
	<td>${abook.press}</td>
  <tr>
    <th align="left">Quantity：</th>
    <td>${total}</td>
  </tr>
  <tr>
    <th align="left">Price：</th>
    <td>￥${abook.price}</td>
  </tr>
   <tr>
    <th>Can I borrow it：</th>
    <td><c:if test="${yes eq 'yes' }">yes</c:if><c:if test="${yes eq 'no' }">no</c:if></td></c:forEach>
  </tr>
  </table>

<b class="p">Brief Introduction：</b>
<div class="bo"> <c:forEach items="${abooks}" var="abook" varStatus="st" begin="0" end= "0">
	<p class="ziti">${abook.introduction}</p></div>  </c:forEach>
</div>
<div class="suoyixinxi">
<div>
        <ul class="ui">
            <li><a id="1" class="btn2">Information</a></li>
            <li><a id="2" class="btn1">To order</a><li>
        </ul>
        <div class="box" id="box1"><table width="100%" border="0" align="center" cellpadding="5" cellspacing="0" id="item">
					  					          					          <tr align="center" class="biaotou">
					            <td >BookID</td>
					            <td >Pringdate</td>
					            <td >Location</td>
					            <td >Status</td>
																
					         </tr><c:forEach items="${abooks}" var="abook" varStatus="st">
					          					          <tr align="center">
					            <td  width="10%" >${abook.ID}</td>
					            <td  width="15%" >${abook.printdate}</td>
					            <td  width="25%"">${abook.location}</td>
					            <td  width="20%" >new</td></tr>
					          					          					  </c:forEach>    </table></div>
        <div class="box" id="box2"><table width="100%" border="0" align="center" cellpadding="5" cellspacing="0" id="item">
					  					          					          <tr align="center" class="biaotou">
					            <td >BookID</td>
					            <td >Order status</td>
					            <td >order</td>
																
					         </tr><c:forEach items="${abooks}" var="abook" varStatus="st" >
					          					          <tr align="center">
					            <td  width="10%" >${abook.ID} </td>
					           <td  width="15%" ><c:if test="${abook.borrow eq 'no'||abook.isorder eq 'no' }">no</c:if><c:if test="${abook.borrow eq 'yes'&&abook.isorder eq 'yes' }">yes</c:if></td>
					            <td  width="20%" ></td>
															          </tr>
					          				  
					          					          					       </c:forEach> </table></div>
</div>

</div>








</div>
</body>
</html>
