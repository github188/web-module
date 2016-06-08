
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String phone=request.getParameter("phone");  %> 
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>易华路—找回密码</title>
<link href="<%=request.getContextPath() %>/resources/css/share_css.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath() %>/resources/css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>
</head>

<body>
<div class="top">
  <ul class="nav">
     <li class="sel"><a href="index.jsp">首页</a></li>
     <li><a href="illegal_search.jsp">违法查询</a></li>
     <li>
      <a href="kindlyReminder.jsp" id="nologints"  >在线缴款</a>
     </li>
     <li><a href="valueAddedService.jsp">增值服务</a></li>
     <li><a href="dataService.jsp">数据服务</a></li>
     <li class="help"><a href="help.jsp">帮助中心</a></li>
  </ul>
  <div class="loginfo loginfosel">
    <div class="login_pic"></div>
    <div class="user_name" ><a href="login.jsp" id="nologin"  >用户登录</a></div>
  </div>
</div>
<div id="change_banner_a">
  <div class="bigbanner_pic1_a"><img src="images/zxjf.png" width="1024" height="84"></div>
</div>
<div class="find_password">

  <div class="title">找回密码</div>
  <div class="buzou_area">
  <ul>
    <li class="wancheng">1.确认帐号</li>
    <li class="tli">2.安全验证</li>
    <li>3.重置密码</li>
    <li>4.完成</li>
  </ul>
  </div>
  <div class="getpassword_box_area">
    <br>
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="32%" align="right">您输入的手机号是&nbsp; </td>
        <td> <input name="textfield2" type="text" id="textfield2" value="请输入右侧的验证码" onfocus="if(this.value == '请输入右侧的验证码'){ this.value = '';}" class="yanzhengma">
        <img src="images/hqyanzhengma.png" width="98" height="30" alt="获取验证码" class="get_yanzheng"> <a href="#"></a></td>
        <td width="35%">&nbsp;</td>
      </tr>
      <tr>
        <td align="right">验证码&nbsp; </td>
        <td> <input name="textfield2" type="text" id="authenCode" value="请输入接收到的验证码" onfocus="if(this.value == '请输入接收到的验证码'){ this.value = '';}"  ></td>
        <td>&nbsp;</td>
      </tr>
      <tr>
       <td id="phone" style="visibility:hidden" value="<%=phone%>"></td>
        <!-- <td>&nbsp;</td> -->
        <td><a href="#"id="next" class="reg_bt" onclick="next()">下一步</a></td>
         <td id="phone" value="<%=phone%>"></td>
      </tr>
    </table>
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
/* var tabs=document.getElementById("taa").getElementsByTagName("li");
var divs=document.getElementById("taa_con").getElementsByTagName("li");
for(var i=0;i<tabs.length;i++){
	tabs[i].onclick=function(){change(this);}
	}
function change(obj){
	for(var i=0;i<tabs.length;i++)
	{
		if(tabs[i]==obj){
		tabs[i].className="tli";
		divs[i].className="tdiv";
	}
	else{
	tabs[i].className="";
	divs[i].className="";
		}
	}
} */
function next(){
	var authenCode=document.getElementById("authenCode").value;
	//var phone=<%=phone%>;
	var re=/^(13[0-9]{9})|(15[0-9]{9})|(17[0-9]{9})|(18[0-9]{9})$/; 
	var phone=document.getElementById("textfield2").value;
	if(phone==""||phone.length!=11 || !re.test(phone)){
		alert("请输入正确的手机号")
		 return false;
	}
	$.ajax({
		url: "<%=request.getContextPath()%>/admin/findPassword",
		type: "POST",
		async : false,
		data: {authenCode:authenCode},
		dataType: "json",
		success: function(data){
			if(data.header.ztm=="105")
			 {
				 alert("校验失败");
			 }else{
				 window.location.href="resetPassword.jsp";
				 window.location='resetPassword.jsp?phone='+phone;
			 }
		}
    });
	
	
}
</script>