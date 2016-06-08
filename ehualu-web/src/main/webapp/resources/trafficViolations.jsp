<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="com.ehualu.rise.dto.*"%>  
  <%String value=(String)request.getParameter("value"); %> 
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
<title>电子监控处理流水</title>
<link href="css/share_css.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>

</head>

<body>
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
    <div class="user_name">用户登录</div>
  </div>
</div>
<div id="change_banner_a">
  <div class="bigbanner_pic1_a"><img src="images/zxjf.png" width="1024" height="84"></div>
</div>
<div class="content_zxjk">
<ul class="syxy">
<li><span><a href="#"><img src="images/close.png"></a></span><img src="images/icona.png"> 温馨提醒：您需要先开通网上银行业务并且已经绑定违法车辆，才能完成【违法自助处理】。</li>
</ul>
<h3>交通违法行为网上自助处理使用协议</h3>
<div class="text_xx">
<span>欢迎您使用全国道路交通违法自助服务平台办理交通违法行为网上自助处理业务，请认真阅读以下协议内容，按规范操作。</span><br>
1、必须成功注册为本系统用户后，才能使用本系统。用户注册成功后应当妥善保管帐号和登录口令，注册帐号仅限本人使用，不得向他人出售、<br>
转让、转借、出租。凡在本系统办理的所有业务，均视为帐号持有人本人真实意愿。<br>
2、本系统注册免费，用户在系统中进行的所有业务办理均不收取任何法定外手续费用。<br> 
3、用户在本网站注册时提供的个人资料，本网站不会以任何方式泄露给任何一方。<br> 
4、由于用户将个人密码告知他人或与他人共享注册账户，导致的个人资料泄露，本网站不负任何责任。<br> 
5、任何由于黑客攻击、计算机病毒侵入或发作、因政府管制而造成的暂时性关闭等影响网络正常处理交通违法或交款的不可抗力而造成的损失，<br>
本网站不承担责任。 <br>
6、本系统为“交通违法自助处理服务平台”，并无任何其它服务或代理机构。为确保用户合法权益，请不要委托他人或机构进行代办业务。<br> 
7、本系统服务范围： <br>
（1）籍机动车在全国范围内及全国机动车在范围内的电子监控交通违法信息查询；<br>
（2）公安机关交通管理部门作出的交通违法处罚决定，提供网上缴纳交通违法罚款服务；<br> 
（3）交通违法自助处理服务。处理范围： <br>
注册用户绑定并通过本系统合法性验证的非重点管理的机动车，在本系统中可查询到并可以适用简易程序处理的电子监控交通违法行为，可以使<br>
用本系统进行自助处理。 <br>
</div>
<div class="btn_b" style="width:130px;"><a onClick="agreedContinue('<%=value %>');" >同意并继续</a></div>
</div>
<div class="foot">
  <div class="textbox">易华录总部：北京市石景山区阜石路165号中国华录大厦<br>
    客服电话：400-610-1996 （8610）52281111<br>jiajia1
  传真：（8610）52281188　邮编：100043　网址：http://www.ehualu.com
  <div class="copyinfo">Copyright © 2013-2016 ehualu.com All rights reserved<br>

京ICP备05016422 京公网安备1101070200132<br>

版权所有：北京易华录信息技术股份有限公司</div>
  </div>
</div>
</body>
</html>
<script type="text/javascript">
function agreedContinue(value){
	window.location.href="illegalDisposal.jsp";
	window.location='illegalDisposal.jsp?value='+value;

}
</script>