<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>易华路—注册用户</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>

</head>

<body >
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
<div class="register_area">
  <div class="register_box_area">
    <div class="register_box">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr >
          <td width="10%" align="right"><span class="f1">*</span>手机号&nbsp; </td>
          <td width="29%"><label for="textfield"></label>
          <input type="text" name="phone" id=phone ></td>
          <td width="21%"> 
              <img src="images/error.png" width="14" height="14" alt="错误提示" id="phoneerrimg" style="display: none;" > 
           	  <span class="f1" id="phonemsg1" style="display: none">手机号不能为空</span> 
              <span class="f1" id="phonemsg2" style="display: none">请输入有效的手机号码！</span> 
               <span class="f1" id="phonemsg3" style="display: none">手机号已注册！</span> 
          </td>
          <td width="40%" rowspan="5" valign="top"><label for="textarea"></label>
          <textarea name="textarea" rows="15" id="textarea">尊敬的客户，欢迎您注册成为本网站用户。
在注册前请您仔细阅读如下服务条款：
    本服务协议双方为本网站与本网站客户，本服务协议具有合同效力。您确认本服务协议后，本服务协议即在您和本网站之间产生法律效力。请您务必在注册之前认真阅读全部服务协议内容，如有任何疑问，可向本网站咨询。无论您事实上是否在注册之前认真阅读了本服务协议，只要您点击协议正本左下方的"立即注册"按钮并按照本网站
注册程序成功注册为用户，您的行为仍然表示您同意并签署了本服务协议。
协议细则：
          </textarea></td>
        </tr>
       
        <tr>
          <td align="right"><span class="f1">*</span>验证码&nbsp;</td>
          <td valign="middle" >
          <input type="text" name="cccode" id="cccode" class="yanzhengma" >
          <img src="images/hqyanzhengma.png" width="98" height="30" alt="获取验证码" class="get_yanzheng"></td>
          </td>
          <td > 
           <img src="images/error.png" width="14" height="14" alt="错误提示" id="ccerrimg" style="display: none;" > 
           <span class="f1" id="ccmsg1" style="display: none">验证码不正确</span> 
           <span class="f1" id="ccmsg2" style="display: none">验证码不能为空</span> 
          </td>
        </tr><tr><td>&nbsp;</td>
        <td nowrap width="6" style=" color:#f60; font-size:12px" > 请查收手机短信，并填写手机短信中的验证码</td>
         <td>&nbsp;</td>
        </tr>
        <tr>
          <td align="right"><span class="f1">*</span>密码&nbsp;</td>
          <td><input type="password" name="password" id="password"></td> 
          <td><img src="images/error.png" width="14" height="14" alt="错误提示" id="passwordoneerrimg" style="display: none;">
             <span class="f1" id="passwordonemsg1" style="display: none">密码不能为空</span></td>
        </tr>
        
        
        <tr>
          <td align="right"><span class="f1">*</span>确认密码&nbsp;</td>
          <td><input type="password" name="passwordtoo" id="passwordtoo" ></td>
          <td>
            <img src="images/error.png" width="14" height="14" alt="错误提示" id="passworderrimg" style="display: none;">
             <span class="f1" id="passwordmsg1" style="display: none">两次密码不一致</span>
              <span class="f1" id="passwordmsg2" style="display: none">确认密码不能为空</span>
          </td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td><a class="reg_bt" onClick="dosumit();">立即注册</a></td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
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


 function checkMath(inputValue) {
	if (inputValue.replace(/[\d+]/ig, "").length > 0) {
		return false;
	}
	return true;
}
 function Trim () { 
	    var m = this.match(/^0?(13[0-9]|15[012356789]|18[0236789]|14[57])[0-9]{8}$/);
	    return m ? true : false; 
	 }
function dosumit(){
	var phone = $("#phone").val();
	var cccode=$("#cccode").val();
	var password = $("#password").val();
	var passwordtoo = $("#passwordtoo").val();
	 var re=/^(13[0-9]{9})|(15[0-9]{9})|(17[0-9]{9})|(18[0-9]{9})$/;  
	
    if(phone.length==""){
    	$('#phoneerrimg').css('display','block');
		$('#phonemsg1').css('display','block');
		$('#phonemsg2').css('display','none');
       return false;
    } else if(phone.length!=11  || !checkMath(phone)||!re.test(phone)){
    	$('#phoneerrimg').css('display','block');
    	$('#phonemsg1').css('display','none');
		$('#phonemsg2').css('display','block');
        return false;
    }else{
		$('#phoneerrimg').css('display','none');
		$('#phonemsg1').css('display','none');
		$('#phonemsg2').css('display','none');
	}
	
	if(cccode==""){
		$('#ccerrimg').css('display','block');
		$('#ccmsg2').css('display','block');
		$('#ccmsg1').css('display','none');
		return false;
	}else{
		$('#ccerrimg').css('display','none');
		$('#ccmsg1').css('display','none');
		$('#ccmsg2').css('display','none');
	}
	
	
	if(password==""){
		$('#passwordoneerrimg').css('display','block');
		$('#passwordonemsg1').css('display','block');
		return false;
	}else{
		$('#passwordoneerrimg').css('display','none');
		$('#passwordonemsg1').css('display','none');
	}
	
	if(passwordtoo==""){
		$('#passworderrimg').css('display','block');
		$('#passwordmsg2').css('display','block');
		$('#passwordmsg1').css('display','none');
		return false;
	}
	if(password!=passwordtoo){   
		$('#passworderrimg').css('display','block');
		$('#passwordmsg1').css('display','block');
		$('#passwordmsg2').css('display','none');
	    return false;
	 }else{
		$('#passworderrimg').css('display','none');
		$('#passwordmsg1').css('display','none');
		$('#passwordmsg2').css('display','none');
	 }
	var path = "<%=request.getContextPath()%>/admin/registerUser";
	$.post(path,{username:phone,phone:phone,password:password,cc:cccode},function(data) {
		 var obj1 = eval(data);
		 var msg=obj1.header.ztm;
			if(msg=="000"){
				alert("注册成功");
				window.location.href="login.jsp" ;
			   return true;
			}else {
				if(msg=="001"){
					alert("系统异常");
				}else if(msg=="104"){
					$('#phoneerrimg').css('display','block');
					$('#phonemsg3').css('display','block');
				}else if(msg=="105"){
					$('#ccerrimg').css('display','block');
					$('#ccmsg1').css('display','block');
				}else if(msg=="002"){
					alert("有参数为空,请查看!");
				}
				return false;
			}
	},"json")
 }

</script>