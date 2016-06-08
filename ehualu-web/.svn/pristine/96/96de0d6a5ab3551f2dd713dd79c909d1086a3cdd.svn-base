<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%-- <%String phone=(String)request.getSession().setAttribute("phone"); %>   --%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>用户中心-我的车辆</title>
<link href="<%=request.getContextPath()%>/resources/css/share_css.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.validate.js"></script>
</head>

<body>
<div class="top">
  <ul class="nav">
     <li class="sel"><a href="index.jsp">首页</a></li>
	    <li><a href="illegal_search.jsp">违法查询</a></li>
	    <li>
	    <a href="kindlyReminder.jsp" id="nologints" >在线缴款</a>
	    </li>
	    <li><a href="valueAddedService.jsp">增值服务</a></li>
	    <li><a href="dataService.jsp">数据服务</a></li>
	    <li class="help"><a href="help.jsp">帮助中心</a></li>
  </ul>
  <div class="loginfo loginfosel">
    <div class="login_pic"></div>
    <div class="user_name">用户登录</div>
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
          <input name="phone" type="text" id="phone" value="18101135740"></td>
        <td width="35%">&nbsp;</td>
      </tr>
      <tr>
        <td align="right">验证码&nbsp; </td>
        <td> <input name="textfield2" type="text" id="textfield2" value="请输入右侧的验证码" class="yanzhengma">
        <img src="codes.jsp" width="100" height="30" alt="获取验证码" class="get_yanzheng"> <a href="#"></a></td>
        <<!-- td><a href="codes.jsp">看不清？换一张</a></td> -->
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td><a href="#"id="next" class="reg_bt" onclick="next()">下一步</a></td>
        <!-- <td id="next" class="reg_bt"  >下一步</td> -->
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
function next(){
	var phone=document.getElementById("phone").value;
	$.ajax({
		url: "<%=request.getContextPath()%>/admin/findPassword",
		type: "POST",
		async : false,
		data: {usr:phone},
		dataType: "json",
		success: function(data){
			if(data.header.ztm=="106")
			 {
				 alert("用户名不存在");
			 }else{
				 window.location.href="RP_aqyz.jsp";
				 window.location='RP_aqyz.jsp?phone='+phone;
			 }
			
		}
    });
	
	
}
</script>