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
<title>易华路—我的车辆</title>
<link href="css/share_css.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>
</head>
<body onload="userVehicle();">
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
<li class="hover">我的车辆</li>
<li><a href="userDrivingLicense.jsp">我的驾证</a></li>
<li><a href="userindex.jsp">我的订单</a></li>
<li><a href="userindex.jsp">账户设置</a></li>
</ul>
</div>
<div class="grxx_right">
<h1>我的车辆</h1>
<div class="right_cla" id="bdclmx" >
  
</div>
<div class="right_cl" id="bdcltj1" >
	<ul>
		<li><a href="boundVehicle.jsp"><img src="images/bdcl.png"></a></li>
		<li>成功绑定车辆后，可获得车辆违法信息、车辆年审提醒、保险到期提醒等指示。</li>
	</ul>
</div>
<div class="right_cl"  id="bdcltj2" >
	<ul>
		<li><a href="boundVehicle.jsp"><img src="images/bdcl.png"></a></li>
		<li>成功绑定车辆后，可获得车辆违法信息、车辆年审提醒、保险到期提醒等指示。</li>
	</ul>
</div>
<div class="right_cl"  id="bdcltj3" >
	<ul>
		<li><a href="boundVehicle.jsp"><img src="images/bdcl.png"></a></li>
		<li>成功绑定车辆后，可获得车辆违法信息、车辆年审提醒、保险到期提醒等指示。</li>
	</ul>
</div>
<ul class="right_font">
<li class="bold">温馨提示</li>
<li>个人账户目前只能绑定三辆车。</li>
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
function userVehicle() {
	var path = "<%=request.getContextPath()%>/admin/queryBoundVehicleMore";
		$.post(path,{username:'<%=name%>'},function(data) {
			 var obj1 = eval(data);
			 if(obj1.body!=null && data.body.length!="0"){
				//用户绑定一辆车（隐藏1绑定车）
				if(data.body.length=="1"){
					
					$('#bdcltj1').hide();
				//用户绑定两辆车	（隐藏1,2绑定车）
				}else if(data.body.length=="2"){
					
					$('#bdcltj1').hide();
					$('#bdcltj2').hide();
					
				//用户绑定三辆车	（隐藏1,2,3绑定车）
				}else if(data.body.length=="3"){
					$('#bdcltj1').hide();
					$('#bdcltj2').hide();
					$('#bdcltj3').hide();
				}
				for(var i=0;i<data.body.length;i++){
					var hpzl=data.body[i].hpzl;
					var zt=data.body[i].zt;
					var hphm=data.body[i].hphm;
					if(hpzl==undefined){
						hpzl="小型汽车";
					}
					if(hpzl=="02"){
						hpzl="小型汽车";
					}
					if(hphm==undefined){
						hphm="";
					}else{
						hphm="辽"+data.body[i].hphm;
					}
					if(zt==undefined){
						zt="";
					}
					var unboundVehiclehp="";
					unboundVehiclehp='"'+data.body[i].hphm+'"';
					var div=$('#bdclmx');
					var arr = [];
					arr.push("<table width='100%' border='0'  cellpadding='0' cellspacing='0'>");
					arr.push("  <tr>");
					arr.push("    <td width='34%'  rowspan='2'> <div class='right_b'><a href='userVehiclelist.jsp'>"+hphm+"</a></div></td>");
					arr.push("    <td width='16%' >车辆识别码：</td>");
					arr.push("    <td width='23%'>"+data.body[i].clsbdh+"</td>");
					arr.push("    <td width='12%' >未处理：</td>");
					arr.push("    <td width='15%'><span>"+data.body[i].wclts+"</span>&nbsp;条</td>");
					arr.push("  </tr>");
					arr.push("  <tr>");
					arr.push("    <td >车辆类型：</td>");
					arr.push("    <td >"+hpzl+"</td>");
					arr.push("    <td >罚 &nbsp;款：</td>");
					arr.push("    <td > <span>"+data.body[i].fkje+"</span>&nbsp;元</td>");
					arr.push("  </tr>");
					arr.push("  <tr>");
					arr.push("    <td rowspan='2'><ul class='cp'><li><a style='cursor: pointer;' onClick='unboundUserVehicle("+unboundVehiclehp+");'>解除绑定</a></li></ul></td>");
					arr.push("    <td >车辆状态：</td>");
					arr.push("    <td >"+zt+"</td>");
					arr.push("    <td >扣 &nbsp;分：</td>");
					arr.push("    <td><span>"+data.body[i].kf+"</span>&nbsp;分</td>");
					arr.push("  </tr>");
					arr.push("  <tr>");
					arr.push("    <td > 保险到期：</td>");
					arr.push("    <td ><span>"+data.body[i].bxdqsj+"</span>&nbsp;天</td>");
					arr.push("    <td  >年检到期：</td>");
					arr.push("    <td ><span>"+data.body[i].njdqsj+"</span>&nbsp;天 </td>");
					arr.push("  </tr>"); 
					arr.push("</table>");  
					div.innerHTML = arr.join('\n');
					$("#bdclmx").append(div.innerHTML);
				}
			}else {
				//未绑定一辆车
				$('#bdclmx').hide();
				
			}
		},"json")
  	}
  	function unboundUserVehicle(hphm){
  		
  		var path = "<%=request.getContextPath()%>/admin/unboundUserVehicle";
		$.post(path,{username:'<%=name%>',hphm:hphm},function(data) {
			var obj1 = eval(data);
			var msg=obj1.header.ztm;
			if(msg=="000"){
				alert("机动车解绑成功");
				window.location.href="myVehicle.jsp";
				
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