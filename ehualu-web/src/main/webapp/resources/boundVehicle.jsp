<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.ehualu.rise.dto.*"%>
<%
    UserDto  user = (UserDto)session.getValue("userinfo");
	String userName="";
	if(user!=null){
		userName=user.getUserName();
	}
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>绑定车辆</title>
<link href="css/share_css.css" rel="stylesheet" type="text/css">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>

</head>

<body style="background:url(images/bg.png) center top no-repeat;">
<div class=" markbg"></div>
<div class="box mydiv">
<div class="bdcl">
  <h1><span><a href="#" onclick="closewindow();"><img src="images/close.png" ></a></span>绑定车辆</h1>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="14%" class="font"><span>* </span>车辆类型</td>
    <td width="43%"><select name="hpzl" id="hpzl" style="width:300px;">
      <option value="02">小型汽车</option>
    </select></td>
    <td width="43%" rowspan="6"><img src="images/jsz.png" width="305" height="195"></td>
  </tr>
  <tr>
    <td colspan="2" style="height:5px;"></td>
    </tr>
  <tr>
    <td class="font"><span>*</span> 车牌号码</td>
    <td>
	    <select name="hplx" id="hplx" >
	      <option value="辽">辽</option>
	    </select>
	    <input name="hphm" type="text" id="hphm"  value="请输入车牌号码" onfocus="if(this.value == '请输入车牌号码'){ this.value = '';}"size="15" style="width:250px;">
	</td>
    </tr>
  <tr>
    <td colspan="2" style="height:5px;"></td>
    </tr>
  <tr>
    <td class="font"><span>*</span> 发动机号</td>
    <td><input name="clsbm" type="text" id="clsbm" value="请输入车辆发动机号后六位" onfocus="if(this.value == '请输入车辆发动机号后六位'){ this.value = '';}"size="15" style="width:296px;"></td>
    </tr>
  <tr>
    <td>&nbsp;</td>
    <td><div class="btn_gr"><a  onClick="dosumit()">提交验证</a></div></td>
    </tr>
</table>
<div class="line"></div>
<ul class="right_font">
<li class="bold"><span>*</span>注意事项提示：</li>
<li>1、您需要绑定车辆后才能继续自助处理缴款，每个账号可绑定3辆机动车；</li>
<li>2、车辆信息将由交警系统核验，请务必填写真实信息。</li>
</ul>

</div>
</div>
</body>
</html>
<script type="text/javascript">
function dosumit(){
    var hpzl = $("#hpzl").find("option:selected").val();
    var hplx = $("#hplx").find("option:selected").val();
    var hphmdm = $("#hphm").val();
    var fdjh = $("#clsbm").val();
	if( "" == hpzl ){
	alert("请输入车辆类型！");
	return false;
    }
	if( "" == hplx ){
   		alert("请输入车牌号码！");
   		return false;
	}if( "" == hphmdm || "请输入车牌号码" == hphmdm){
   		alert("请输入车牌号码！");
   		return false;
	}if( "" == fdjh || "请输入车辆发动机号后六位" ==fdjh){
   		alert("请输入发动机号后六位！");
   		return false;
	}
	
	var hphm=hplx+hphmdm;//hphm=DR6368&hpzl=02&fdjh=005754
	var path = "<%=request.getContextPath()%>/admin/boundUserVehicle";
		$.post(path,{username:<%=userName%>,hphm:hphmdm,hpzl:hpzl,fdjh:fdjh},function(data) {
			var obj1 = eval(data);
			var msg=obj1.header.ztm;
			if(msg=="000"){
				alert("绑定成功");
				window.location.href="myVehicle.jsp";
				return true;
			}else if(msg=="001"){
				alert("系统异常");
				return false;
			}else if(msg=="201"){
				alert("条件为空");
				return false;
			}else if(msg=="202"){
				alert("车牌号码为空");
				return false;
			} else if(msg=="203"){
				alert("车辆类型为空");
				return false;
			} else if(msg=="204"){
				alert("发动机号为空");
				return false;
			} else if(msg=="205"){
				alert("车辆类型不匹配");
				return false;
			} else if(msg=="206"){
				alert("发动机号后六位不匹配");
				return false;
			}else if(msg=="210"){
				alert("车牌号码不存在");
				return false;
			}else if(msg=="211"){
				alert("用户名为空");
				return false;
			}else if(msg=="208"){
				alert("重复绑定机动车，请查阅");
				return false;
			}

		},"json")
  	}
  		function closewindow(){
  		window.location.href="myVehicle.jsp";
  		
  	}
</script>