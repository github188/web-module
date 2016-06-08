<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>易华路—找回密码</title>
<link href="<%=request.getContextPath()%>/resources/css/share_css.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>
</head>

<body onload="setTime()">
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
    <div class="user_name">
    <a href="login.jsp" id="nologin"  >用户登录</a>
  </div>
</div>
<div id="change_banner_a">
  <div class="bigbanner_pic1_a"><img src="<%=request.getContextPath()%>/resources/images/zxjf.png" width="1024" height="84"></div>
</div>
<div class="find_password">

  <div class="title">找回密码</div>
  <div class="buzou_area">
  <ul>
    <li class="tli">1.确认帐号</li>
    <li>2.安全验证</li>
    <li>3.重置密码</li>
    <li>4.完成</li>
  </ul>
  </div>
  <div class="getpassword_box_area">
    <br>
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="32%" align="right" >手机号&nbsp; </td>
        <td width="33%"><label for="textfield"></label>
          <input name="phone" type="text" id="phone" value=""></td>
        <td width="35%">&nbsp;</td>
      </tr>
      <tr>
        <td align="right">验证码&nbsp; </td>
        <td> <input name="textfield2" type="text" id="checkcode" value="请输入右侧验证码"onfocus="if(this.value == '请输入右侧验证码'){ this.value = '';}"  class="yanzhengma">
        <img src="/ehualu-web/drawCheckCode" width="100" height="30" alt="获取验证码" class="get_yanzheng"onclick="reCheckcode(this)" id="rand"name="checkcode" />
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td><a href="#"id="next" class="reg_bt" onclick="next()">下一步</a></td>
        <td>&nbsp;</td>
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
function setTime(){
	setInterval("setTime1()",10000);
}
function setTime1(){ 
	reCheckcode(document.getElementById('rand'));
}
function next(){
	var re=/^(13[0-9]{9})|(15[0-9]{9})|(17[0-9]{9})|(18[0-9]{9})$/; 
	
	var phone=document.getElementById("phone").value;
	var checkcode=document.getElementById("checkcode").value;
	if(phone==""||phone.length!=11 || !re.test(phone)){
		alert("请输入正确的手机号")
		
	}else{
	
	$.ajax({
		url: "<%=request.getContextPath()%>/admin/findPassword",
		type: "POST",
		async : false,
		data: {username:phone,checkcode:checkcode},
		dataType: "json",
		success: function(data){
			if(data.header.ztm=="001")
			{
				 window.location.href="securityVerification.jsp";
				 window.location='securityVerification.jsp?phone='+phone;
			 }else{
				if(data.header.ztm=="106")
					{
						alert("您输入的手机号不存在！");
					}else if(data.header.ztm=="105")
					 {
						 alert("验证码校验失败");
					 }
			 		}
								}
  		  });
	 }
	
					}
//reCheckcode(this)

/* function myrefresh() 
{ 
window.location.reload(); 
} 
setTimeout('myrefresh()',15000); */
//setTimeout('reCheckcode(this)',1000);
function reCheckcode(img) {	
	//alert(img);
	//这里的src应该对应着controller里的法法
	img.src = "/ehualu-web/drawCheckCode?" + Math.random();
}
</script>