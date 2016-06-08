
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>易华路—用户登录</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.cookie.js"></script>
</head>
<body >
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
    <div class="loginfo">
    <div class="login_pic"></div>
    <div class="user_name">
    <a href="login.jsp" id="nologin"  >用户登录</a>
    
    </div>
  </div>
</div>
<div id="change_banner">
  <div class="bigbanner_pic1"><img src="images/login_pic.png" width="1024" height="363"></div>
</div>
<div class="login_area">
  <div class="login_box_area">
    <div class="login_box"><strong>用户登录</strong> <span class="auto_login"><input name="" type="checkbox" id="rmbUser"  value="">自动登录</span>
       <div class="user_area">
         <label for="textfield"></label>
        <!--  18101135740 -->
         <input type="text" name="username" id="username" value="">
       </div>
      <div class="password_area">
         <label for="textfield"></label>
         <input type="password" name="password" id="password"  value="">
       </div>
       <div class="reg_forget"><a href="zhuce.jsp" class="new_register">注册新用户</a> <a href="confirmAccount.jsp" class="forget">忘记登录密码？</a></div>
    <a  class="login_bt"  onClick="doLogin();">登 录 </a></div>
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
function doLogin(){
	doLogin1()	
	doLogin2()
}



function checkMath(inputValue) {
	if (inputValue.replace(/[\d+]/ig, "").length > 0) {
		return false;
	}
	return true;
}

/*登录验证函数*/
function doLogin2() {
    var username = $("#username").val();
    var password = $("#password").val();
	if( "" == username ){
		alert("请输入用户名！");
		return false;
    }
	 if (/[@\/'\\"#$%&\^*]/.test(username)){
		 alert("请输入正确的用户名！");
	     return false;
	  }
	 
	 var re=/^(13[0-9]{9})|(15[0-9]{9})|(17[0-9]{9})|(18[0-9]{9})$/;  
	 if(username.length!=11  || !checkMath(username)||!re.test(username)){
		 alert("请输入正确的用户名！");
	        return false;
	    }
	if( "" == password ){
   		alert("请输入密码！");
   		return false;
	}
	
	var path = "<%=request.getContextPath()%>/admin/login";
		$.post(path,{username:username,password:password,cc:""},function(data) {
			 var obj1 = eval(data);
			if(obj1.body!=null){
				window.location.href="userindex.jsp";
			   return true;
			}else {
				var msg=obj1.header.ztm;
				if(msg=="001"){
					alert("系统异常");
				}else if(msg=="101"){
					alert("用户名或密码不正确");
				}else if(msg=="102"){
					alert("验证码不正确");
				}
				return false;
			}
		},"json")
  	}
  	
$(document).ready(function () {
    if ($.cookie("rmbUser") == "true") {
    $("#rmbUser").attr("checked", true);
    $("#username").val($.cookie("username"));
    $("#password").val($.cookie("password"));
    }
});

//记住用户名密码
function doLogin1() {
    if ($("#rmbUser").attr("checked")) {
        var username = $("#username").val();
        var password = $("#password").val();
        $.cookie("rmbUser", "true", { expires: 7 }); //存储一个带7天期限的cookie
        $.cookie("username", username, { expires: 7 });
        $.cookie("password", password, { expires: 7 });
    }
    else {
        $.cookie("rmbUser", "false", { expire: -1 });
        $.cookie("username", "", { expires: -1 });
        $.cookie("password", "", { expires: -1 });
    }
}; 

</script>