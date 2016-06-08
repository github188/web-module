<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@page import="com.ehualu.rise.dto.*"%>  
<%
	String name="";
    UserDto  user = (UserDto)session.getValue("userinfo");
	if(user!=null){
		name=user.getUserName();
	}
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>易华路—帮助中心</title>
<link href="css/share_css.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	var userName='<%=name %>';
	function checkzt() {
		if(userName!=""){
			$('#nologin').css('display','none');
			$('#oklogin').css('display','block');
			
			$('#nologints').css('display','none');
			$('#oklogints').css('display','block');
		}else{
			$('#nologin').css('display','block');
			$('#oklogin').css('display','none');
			
			$('#nologints').css('display','block');
			$('#oklogints').css('display','none');
		}
	}
</script>
</head>

<body onload="checkzt();">
<div class="top">
  <ul class="nav">
    <li><a href="index.jsp">首页</a></li>
    <li><a href="illegal_search.jsp">违法查询</a></li>
    <li> 
   <a href="kindlyReminder.jsp" id="nologints" style="display: none;" >在线缴款</a>
    <a href="userindex.jsp" id="oklogints"  style="display: none;">在线缴款</a>
    </li>
    <li><a href="valueAddedService.jsp">增值服务</a></li>
    <li><a href="dataService.jsp">数据服务</a></li>
    <li class="help"><a href="help.jsp">帮助中心</a></li>
  </ul>
  <div class="loginfo">
    <div class="login_pic"></div>
    <div class="user_name">
    <a href="login.jsp" id="nologin" style="display: none;" >用户登录</a>
    <a id="oklogin" style="display: none;" >已登录/<span style="cursor: pointer;" onclick="logOut();">退出 </span></a>
    </div>
  </div>
</div>
<div id="change_banner_b">
  <div class="bigbanner_help">
    <div class="helptile"><strong>帮助中心</strong></div>
    <div class="tile"><strong>绑定车辆/驾证</strong></div>
  </div>
</div>
<div class="content_bzzx">
<div class="bzzx_left">
<ul class="grxx_nav">
      <li><a href="#">新手入门</a></li>
  </ul>
  <ul class="grxx_nav2">
      <li><a href="newMembers.jsp">新会员注册</a></li>
      <li><a href="help.jsp">用户登录</a></li>
      <li><a >绑定车辆/驾证</a></li>
      <li><a href="bindingMicCha.jsp">绑定微信</a></li>
      <li><a href="retrievePassword.jsp">找回密码</a></li>
      <li><a href="illegalQuery.jsp">违法查询</a></li>
      <li><a href="businessInformation.jsp">自助服务业务须知</a></li>
      <li><a href="implementCode.jsp">辽宁实施规定</a></li>
  </ul>
  <ul class="grxx_nav">
      <li><a href="paymentPenaltyGuide.jsp">自助缴罚指南</a></li>
      <li><a href="commonProblem.jsp">常见问题</a></li>
</ul>
</div>

<div class="grxx_right">
  <p><br>
  &nbsp;&nbsp;  为方便您进行违法查询和自助缴款，注册成功后请先“绑定车辆”和“驾驶证”。
    绑定后，您可以直接在“我的易华路”查看到违法记录、扣分、罚款金额、车辆年检、保险日期等信息，而无须每次输入查
   询，更方便，更快捷。 </p>
  <p><strong>绑定车辆步骤如下：</strong></p>
  <p>1)   注册成功后，登录“我的易华路”， 进入“我的车辆”， 点击“+添加车辆”； </p>
  <p><img src="images/pic.png" width="616" height="269" alt="denglu"></p>
  <p>2)   在添加车辆页面， 按提示正确填写您车辆行驶证上的信息，点击“提交验证”完成添加车辆操作。 </p>
  <p><img src="images/pic.png" width="616" height="269" alt="denglu"></p>
  <p><strong>温馨提示：</strong><br>
    (1)   车辆信息将提交所在地的交警系统校验，通过后才能正常处理在线缴款； <br>
    (2)   每个注册用户只能绑定3辆机动车；  <br>
    (3)   识别代码：请按照车辆行驶证输入全部的车辆识别代码；  <br>
</p>
 <p><strong>绑定驾驶证步骤如下：</strong></p>
  <p>1)    注册成功后，登录“我的易华路”， 进入“驾驶证管理”， 点击“+绑定驾驶证”；  </p>
  <p><img src="images/pic.png" width="616" height="269" alt="denglu"></p>
  <p>2)   在绑定驾驶证页面， 按提示正确填写您驾驶证信息；  </p>
  <p><img src="images/pic.png" width="616" height="269" alt="denglu"></p>
  <p><strong>温馨提示：</strong><br>
    (1)   驾驶证信息将提交所在地的交警系统校验，通过后才能正常处理绑定；  <br>
    (2)   每个注册用户只能绑定1个驾驶证；  <br>
</p>
</div>

  <div style="clear:both;"></div>

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