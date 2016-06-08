<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.ehualu.rise.dto.*"%>
<%
    UserDto  user = (UserDto)session.getValue("userinfo");
	String name="";
	String lastTime="";
	String bdcxx="";
	if(user!=null){
		name=user.getUserName();
		lastTime =user.getLastLoginDate();
	}
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>易华路—绑定驾驶证</title>
<link href="css/share_css.css" rel="stylesheet" type="text/css">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>

</head>

<body style="background:url(images/bg.png) center top no-repeat;">
<div class=" markbg"></div>
<div class="box mydiv">
<div class="bdcl">
  <h1><span><a href="#"  onclick="closewindow();"><img src="images/close.png"></a></span>绑定驾驶证</h1>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="14%" class="font"><span>*</span> 真实姓名</td>
    <td width="43%"><input name="xm" type="text" id="xm" value="林"onfocus="if(this.value == '请输入真实姓名'){ this.value = '';}" size="15" style="width:296px;"></td>
    <td width="43%" rowspan="7"><img src="images/bdjsz.png" width="320" height="195"></td>
  </tr>
  <tr>
    <td colspan="2" style="height:5px;"></td>
    </tr>
  <tr>
    <td class="font"><span>* </span>驾驶证号</td>
    <td><input name="sfzmhm" type="text" id="sfzmhm" value="350221197911155519"onfocus="if(this.value == '请输入驾驶证号'){ this.value = '';}" size="15" style="width:296px;"></td>
    </tr>
  <tr>
    <td colspan="2" style="height:5px;"></td>
    </tr>
  <tr>
    <td class="font"><span>* </span>档案编号</td>
    <td><input name="dabh" type="text" id="dabh" value="350200323935"onfocus="if(this.value == '请输入档案编号'){ this.value = '';}" size="15" style="width:296px;"></td>
    </tr>
  <tr>
    <td class="font"><span>*</span> 证芯编号</td>
    <td><input name="zxbh" type="text" id="zxbh" value="350200323935" onfocus="if(this.value == '请输入证芯编号'){ this.value = '';}"size="15" style="width:296px;"></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td><div class="btn_gr"><a onClick="savadrivinglis()" >提交验证</a></div></td>
    </tr>
</table>
<div class="line"></div>
<ul class="right_font">
<li class="bold"><span>*</span>注意事项提示：</li>
<li>1、系统默认您绑定的驾驶证为违法处理人，云南省除外；</li>
<li>2、一个账号只能绑定一个驾驶证，用户成功绑定驾驶证后不可取消绑定；</li>
<li>3、驾驶证信息将由交警系统核验，请务必填写真实信息；</li>
</ul>

</div>
</div>
</body>
</html>
<script type="text/javascript">
function savadrivinglis(){
    var xm = $("#xm").val();
    var sfzmhm = $("#sfzmhm").val();
    var dabh = $("#dabh").val();
    var zxbh = $("#zxbh").val();
    
	if( "" == xm ||"请输入真实姓名"== xm){
	alert("请输入真实姓名！");
	return false;
    }
	if( "" == sfzmhm ||"请输入驾驶证号"== sfzmhm ){
   		alert("请输入证件号码！");
   		return false;
	}if( "" == dabh || "请输入档案编号" == dabh){
   		alert("请输入档案编号！");
   		return false;
	}if( "" == zxbh || "请输入证芯编号" ==zxbh){
   		alert("请输入证芯编号！");
   		return false;
	}
	var path = "<%=request.getContextPath()%>/admin/boundUserDriverLicense";
	$.post(path,{username:<%=name%>,xm:xm,zjhm:sfzmhm,dabh:dabh,zxbh:zxbh},function(data) {
		var obj1 = eval(data);
		var msg=obj1.header.ztm;
		if(msg=="000"){
			alert("绑定成功");
			window.location.href="userDrivingLicense.jsp";
			return true;
		}else if(msg=="001"){
			alert("系统异常");
			return false;
		}/* else if(msg=="217"){
			alert("驾驶证已被绑定,");
			return false;
		}else if(msg=="213"){
			alert("姓名不匹配");
			return false;
		}else if(msg=="214"){
			alert("档案编号不匹配 ");
			return false;
		}else if(msg=="215"){
			alert("证芯编号不匹配 ");
			return false;
		}else if(msg=="216"){
			alert("驾驶证不存在");
			return false;
		}else{
			alert(msg);
			return false;
		} */
	},"json")
  	}
function closewindow(){
	window.location.href="userDrivingLicense.jsp";
		
	}
</script>