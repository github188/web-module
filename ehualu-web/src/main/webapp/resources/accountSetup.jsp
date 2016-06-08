<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="com.ehualu.rise.dto.*"%>  
<%
    UserDto  user = (UserDto)session.getValue("userinfo");
	String name="";
	String phone="";
	String email="";
	String nick="";
	String lastTime="";
	String password="";
	if(user!=null){
		name=user.getUserName();
		lastTime =user.getLastLoginDate();
		phone=user.getPhone();
		email=user.getEmail();
		password=user.getPassword();
		if(email!=null){
			
		}else{
			email="";
		}
		nick=user.getNick();
	}
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>易华路—账户设置</title>
<link href="css/share_css.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.validate.js"></script>

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
<li><%=lastTime%></li>
</ul>

<ul class="grxx_nav">
<li><a href="myVehicle.jsp">我的车辆</a></li>
<li><a href="userDrivingLicense.jsp">我的驾证</a></li>
<li><a href="userindex.jsp">我的订单</a></li>
<li class="hover">账户设置</li>
</ul>
</div>

<div class="grxx_right">
<h1>个人资料</h1>
<h2>亲爱的<span><%=name %></span>，填写真实的资料，有助于获得更好的服务体验哦。</h2>
<div class="right_table">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="11%" valign="top" class="td_r">当前头像</td>
    <td><img src="images/zcpeople.png" width="80" height="80"></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td class="td_r">手机号码</td>
    <td width="36%"><input name="phon"  id="phon" type="text" disabled  style="width:250px;" value="<%=phone%>" size="15"></td>
  <td width="14%"><div class="btn_ye"><a  onClick="changePassword();">修改密码</a></div></td>
  <td>&nbsp;</td>
    <td width="39%">&nbsp;</td>
  </tr>
  
</table>
</div>
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
function changePassword() {
	window.location.href="confirmAccount.jsp";
  	}
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