<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.ehualu.rise.dto.*"%>
<%
    UserDto  user = (UserDto)session.getValue("userinfo");
	String name="";
	String lastTime="";
	String bdcxx="";
	if(user!=null){
		name=user.getUserName();
		lastTime =user.getLastLoginDate();
	}
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>易华路—在线缴款</title>
<link href="css/share_css.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>
</head>
<body >
<div class="top">
  <ul class="nav">
    <li><a href="index.jsp">首页</a></li>
    <li><a href="illegal_search.jsp">违法查询</a></li>
     <li class="sel">在线缴款</li>
    <li><a href="valueAddedService.jsp">增值服务</a></li>
    <li><a href="dataService.jsp">数据服务</a></li>
    <li class="help"><a href="help.jsp">帮助中心</a></li>
  </ul>
  <div class="loginfo">
    <div class="login_pic"></div>
    <div class="user_name">
    <a id="oklogin" >已登录/<span style="cursor: pointer;" onclick="logOut();">退出 </span></a>
    </div>
  </div>
</div>
<div id="change_banner_a">
  <div class="bigbanner_pic1_a"><img src="images/zxjf.png" width="1024" height="84"></div>
</div>
<div class="content_yhzx">
<div class="yhzx_left">
<p><img src="images/grtx.png"></p>
<ul class="grxx">
<li>你好，<span><%=name%></span></li>
<li><a href="#">已绑定手机</a>  |  <a href="#">绑定微信</a></li>
<li>上次登录时间</li>
<li><span><%=lastTime%></span></li>
</ul>

<ul class="grxx_nav">
<li><a href="myVehicle.jsp" >我的车辆</a></li>
<li><a href="userDrivingLicense.jsp">我的驾证</a></li>
<li><a href="userindex.jsp">我的订单</a></li>
<li><a href="accountSetup.jsp">账户设置</a></li>
</ul>
</div>

<div class="grxx_right">
<dl class="right_xx">
<dt><img src="images/icon2.png"></dt>
<dd>最快、最便捷的在线缴罚款</dd>
<dd>交警系统直连，快速、准确反馈违法记录，缴款完成实时解网，让您的缴款就是快。</dd>
</dl>
<ol class="right_ewm">
<dl>
<dt><img src="images/android.png"></dt>
<dd><a href="#"><img src="images/axz.png"></a></dd>
</dl>
<dl>
<dt><img src="images/iphone.png"></dt>
<dd><a href="#"><img src="images/ixz.png"></a></dd>
</dl>
</ol>
<ul class="right_font">
<li class="bold">·车辆违法照片实时查</li>
<li>&nbsp;&nbsp;&nbsp;让您看到车辆违法的实地照片，帮助您全面的掌握您车辆的违法信息。</li>
<li class="bold">·更全面的驾照、车辆辅助信息</li>
<li>&nbsp;&nbsp;&nbsp;轻松绑定驾照、车辆，违法信息一目了然，还能及时了解驾照扣分情况，车辆保险、年检日期、车辆状态等信息。</li>
<li>&nbsp;&nbsp;&nbsp;不知道怎样操作，可进入<a href="#">帮助中心</a>查看教程。</li>
</ul>
</div>
</div>
<div class="foot">
  <div class="textbox">易华录总部：北京市石景山区阜石路165号中国华录大厦<br>
    客服电话：400-610-1996 （8610）52281111<br>
  传真：（8610）52281188　邮编：100043　网址：http://www.ehualu.com
  <div class="copyinfo">Copyright © 2013-2016 ehualu.com All rights reserved<br>

京ICP备05016422 京公网安备1101070200132<br>

版权所有：北京易华录信息技术股份有限公司</div>
  </div>
</div>
</body>
</html>
<script type="text/javascript">
function logOut(){
		 var path = "<%=request.getContextPath()%>/admin/logOut";
		 $.post(path,{username:'<%=name%>'},function(data) {
			var obj1 = eval(data);
			var msg=obj1.header.ztm;
			if(msg=="000"){
				alert("成功退出");
				window.location.href="index.jsp";
			}else if(msg=="001"){
				alert("系统异常");
				return false;
			}
				
		},"json")
	}
	
</script>