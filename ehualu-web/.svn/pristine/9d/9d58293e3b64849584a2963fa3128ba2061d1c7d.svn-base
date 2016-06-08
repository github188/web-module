<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.ehualu.rise.dto.*"%>
<%
    UserDto  user = (UserDto)session.getValue("userinfo");
	String name="";
	String lastTime="";
	if(user!=null){
		name=user.getUserName();
		lastTime =user.getLastLoginDate();
	}
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>易华路—我的驾证</title>
<link href="css/share_css.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>

</head>

<body onload="userDrivingLicense();">
<div class="top">
  <ul class="nav">
    <li class="sel"><a href="index.jsp">首页</a></li>
    <li><a href="illegal_search.jsp">违法查询</a></li>
    <li class="sel">在线缴款</li>
    <li><a href="valueAddedService.jsp">增值服务</a></li>
    <li><a href="dataService.jsp">数据服务</a></li>
    <li class="help"><a href="help.jsp">帮助中心</a></li>
  </ul>
    <div class="loginfo">
    <div class="login_pic"></div>
    <div class="user_name"> 
    <a id="oklogin" >已登录/<span  style="cursor: pointer;" onclick="logOut();">退出 </span></a>
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
<li class="hover">我的驾证</li>
<li><a href="userindex.jsp">我的订单</a></li>
<li><a href="accountSetup.jsp">账户设置</a></li>
</ul>
</div>
<div class="grxx_right">
<h1>我的驾证</h1>
<div class="right_cla" style="width: 855px; " id="jzmx">
</div>
<div class="right_cl" id="wbdjz">
	<ul>
	<li><a href="drivingLicense.jsp"><img src="images/wdjz.png"></a></li>
	<li>成功绑定车辆后，可以在线缴款并实时查看车辆违法、年检、保险等信息啦。</li>
	</ul>
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
function userDrivingLicense() {
	var path = "<%=request.getContextPath()%>/admin/queryBoundDriverLicense";
		$.post(path,{username:<%=name%>},function(data) {
			 var obj1 = eval(data);
			 if(obj1.body!=null && data.body.length!="0"){
				var unbound="";
				unbound='"'+data.body.zjhm+'"';
				alert(data.body.xm);
				var div=$('#jzmx');
				var arr = [];
				arr.push("<table width='100%' border='0'  cellpadding='0' cellspacing='0'>");
				arr.push("  <tr>");
				arr.push("    <td width='34%' rowspan='2' >  <div class='right_b'><a onClick='unboundDrivingLicense("+unbound+");'>解除绑定</a></div></td>");
				arr.push("    <td width='19%'>真实姓名：</td>");
				arr.push("    <td width='22%'>"+data.body.xm+"</td>");
				arr.push("    <td width='19%'>证件号码：</td>");
				arr.push("    <td width='24%'>"+data.body.zjhm+"</td>");
				arr.push("  </tr>");
				arr.push("  <tr>");
				arr.push("    <td > 档案编号：</td>");
				arr.push("    <td >"+data.body.dabh+"</td>");
				arr.push("    <td >证芯编号：</td>");
				arr.push("    <td >"+data.body.zxbh+"</td>");
				arr.push("  </tr>"); 
				arr.push("</table>");   
				div.innerHTML = arr.join('\n');
				$("#jzmx").append(div.innerHTML);
				$('#wbdjz').hide();
			}else {
				//未绑定驾照
				$('#jzmx').hide();
			}
		},"json")
  	}
  	function unboundDrivingLicense(zjhm){
  		var path = "<%=request.getContextPath()%>/admin/unboundUserDriverLicense";
		$.post(path,{username:'<%=name%>',zjhm:zjhm},function(data) {
			var obj1 = eval(data);
			var msg=obj1.header.ztm;
			if(msg=="000"){
				alert("驾驶证解绑成功");
				window.location.href="userDrivingLicense.jsp";
			}else if(msg=="001"){
				alert("系统异常");
				return false;
			}
		},"json")
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