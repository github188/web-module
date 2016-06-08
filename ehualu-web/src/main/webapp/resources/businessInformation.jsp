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
    <div class="tile"><strong>自助服务业务须知</strong></div>
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
      <li><a href="boundVehicleAndDriver.jsp">绑定车辆/驾证</a></li>
      <li><a href="bindingMicCha.jsp">绑定微信</a></li>
      <li><a href="retrievePassword.jsp">找回密码</a></li>
      <li><a href="illegalQuery.jsp">违法查询</a></li>
      <li><a >自助服务业务须知</a></li>
      <li><a href="implementCode.jsp">辽宁实施规定</a></li>
  </ul>
  <ul class="grxx_nav">
      <li><a href="paymentPenaltyGuide.jsp">自助缴罚指南</a></li>
      <li><a href="commonProblem.jsp">常见问题</a></li>
</ul>
</div>

<div class="grxx_right">
  <p><br>&nbsp;&nbsp; “道路交通违法自助服务平台”业务须知</p>
  &nbsp;&nbsp;  “ 交通违法自助服务平台”在互联网上实现了交通违法的自助处理，与传统的到交警部门接受交通违法处理模式具有同等的法律效力，属于行政处罚范畴，总队相关业务部门对自助处理的涉及内容，如业务流程、处罚主体部门、处罚对象、处理范围、经办人、法律救济、处理须知、告知内容、系统使用协议等进行了审定和明确，使得 “ 交通违法自助服务平台”提供的自助处理业务符合相关法律法规的规定和要求，最大限度避免出现法律争议和冲突。</p>
 <p><strong>（一） 自助处理可受理的交通违法范围 </strong></p>
   &nbsp; &nbsp; 1、 本省籍机动车在省内或省外的非现场交通违法、外省籍机动车在省内的交通违法； <br>
   &nbsp;&nbsp;2、 除重点管理的机动车之外的机动车非现场交通违法，即机动车使用性质为客运、货运、校车、剧毒化学品运输之外的机动车的非现场交通违法；  <br>
   &nbsp;&nbsp;3、 罚款金额低于200元（含）以下的适用简易程序处理的交通违法行为；  <br>
   &nbsp;&nbsp;4、 适用简易程序已作出罚款处罚决定而未缴纳罚款的交通违法。 <br>
  <p><strong>（二） 自助处理处罚对象的确定 </strong></p>
   &nbsp;&nbsp;自助处理的处理对象（当事人）默认为系统注册用户绑定的驾驶人。 <br>
  <p><strong>（三） 自助处理处罚机关的确定</strong></p>
   &nbsp;&nbsp;1、 本省籍或外省籍机动车在省内的机动车交通违法，自助处理时处罚机关为交通违法采集机关，如违法采集机关为中队，则处罚机关为所属上级大队部门；如违法采集机关为大队，则处罚机关与违法采集机关相同； <br>
   &nbsp;&nbsp;2、 本省籍机动车在省外的非现场交通违法，自助处理时处罚机关为车辆管理部门所属交警支队； <br>
  <p><strong>（四）自助处理案件经办人的确定</strong></p>
   &nbsp;&nbsp;自助处理无确定的案件经办人（经办民警），统一填写案件经办人为：网络交警。</p>
  <p><strong>（五）自助处理过程中告知内容的确定</strong></p>
   &nbsp; &nbsp; 自助处理过程，平台根据业务部门的要求提供准确的告知内容和告知事项，以符合法律法规要求，如下图所示： <br>
  <p><strong>（六）自助处理完成后处罚决定告知内容的确定</strong></p>
   &nbsp;&nbsp;平台根据业务部门的要求，提供处理完成后处罚决定的告知内容，以处罚决定电子凭据的方式显示（如下图所示），自助处理用户可自行打印，并作为到银行柜台缴款的处理缴款凭据。 <br>
  <p><strong>（七）自助处理简易处罚决定书的提供</strong></p>
   &nbsp;&nbsp;部分自助处理的当事人如要求提供正式的处罚决定书，当事人凭有效证件到处罚地交警部门通过“公安交通管理综合应用平台”的文书补打功能打印，由当事人自行联系处罚地交警部门索取。 <br>
  <p><strong>（八）自助处理的交通违法案件，处罚地交警部门存档</strong></p>
   &nbsp;&nbsp;自助处理的交通违法属于200元以下的罚款的简易程序处罚案件，交警部门以电子数据方式保存在“公安交通管理综合应用平台”。 <br>
  <p><strong>（九）与用户签订使用自助处理业务《使用协议》</strong></p>
   &nbsp;&nbsp;由于自助处理业务的特殊性，用户在“交通违法自助服务平台”注册使用自助处理业务前，必须在网站上同意《使用协议》后才允许自助处理交通违法，《使用协议》对双方的权利义务、法律责任、行为规范、安全保密责任、业务办理的相关规定和要求进行明确，以保障业务办理存在争议时，有效保护交警部门的权益。 <br>
  
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