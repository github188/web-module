<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="com.ehualu.rise.dto.*"%>  
<%
    UserDto  user = (UserDto)session.getValue("userinfo");
	String name="";
	if(user!=null){
		name=user.getUserName();
	}
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>易华路—违法处理业务/号牌选择</title>
<link href="css/share_css.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>
</head>
<body  onload="queryVehicleList();">
<div class="top">
  <ul class="nav">
    <li><a href="index.jsp">首页</a></li>
    <li><a href="illegal_search.jsp">违法查询</a></li>
    <li class="sel">  <a href=" myVehicle.jsp">在线缴款</a></li>
    <li><a href="valueAddedService.jsp">增值服务</a></li>
    <li><a href="dataService.jsp">数据服务</a></li>
    <li class="help"><a href="help.jsp">帮助中心</a></li>
  </ul>
  <div class="loginfo">
    <div class="login_pic"></div>
    <div class="user_name">已登录/<span style="cursor: pointer;" onclick="logOut();">退出 </span></div>
  </div>
</div>
<div id="change_banner_a">
  <div class="bigbanner_pic1_a"><img src="images/zxjf.png" width="1024" height="84"></div>
</div>
<div class="content_zxjk">
<h1>违法处理业务<span>/号牌选择</span></h1>
<h2>当前账户的机动车列表</h2>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="7%" class="title">&nbsp;</td>
    <td width="20%" class="title">号牌种类</td>
    <td width="17%" class="title">号牌号码</td>
    <td width="15%" class="title">发证机关</td>
    <td width="19%" class="title">所有人</td>
    <td width="22%" class="title">是否本人机动车</td>
  </tr>
  <tr>
	<tbody id="tbody">
	</tbody>
  </tr>
  <tr>
		<td colspan="6">&nbsp;</td>
  </tr>
 <tr>
		<td colspan="6">&nbsp;</td>
  </tr>
</table>
<div class="zxjk_font"><input name="trafficViol" id="trafficViol" type="checkbox" checked="true" value=""> 我已阅读<a   onClick="trafficViol();"  >《交通违法网上自助处理协议》</a>，并同意协议内容。</div>
<div class="btn_c"><a onClick="determine();" >确 定</a></div>
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
function queryVehicleList() {
	var path = "<%=request.getContextPath()%>/admin/queryBoundVehicleMore";
		$.post(path,{username:<%=name %>},function(data) {
			 var obj1 = eval(data);
			 if(obj1.body!=null && data.body.length!="0"){
				for(var i=0;i<data.body.length;i++){
					var hpzl=data.body[i].hpzl;
					var hphm=data.body[i].hphm;
					var fzjg=data.body[i].fzjg;
					var syr=data.body[i].syr;
					var sfbr=data.body[i].sfbr;
					var fdjh=data.body[i].fdjh;
					if(hpzl==undefined){
						hpzl="小型汽车";
					}if(hpzl=="02"){
						hpzl="小型汽车";
					}if(hphm==undefined){
						hphm="";
					}else{
						hphm="辽"+data.body[i].hphm;
					}
					if(fzjg==undefined){
						fzjg="";
					}if(syr==undefined){
						syr="";
					}if(sfbr==undefined){
						sfbr="";
					}if(fdjh==undefined){
						fdjh="";
					}if(fdjh!=undefined){
						fdjh = fdjh.substring(fdjh.length - 6);
					}
					var id=hphm+","+data.body[i].hpzl+","+fdjh;
					$("#tbody").append("<tr><td><input type='radio' name='radio' id='radio' value='" + id + "'></td><td>"+hpzl+"</td><td>"
							+hphm+"</td><td>"
							+fzjg+"</td><td>"
							+syr+"</td><td>"
							+sfbr+"</td></tr>"		
					);
				}
			}else {
				var message=data.header.ztm;
				 var sucess="";
				 if(message=="000"){
					 sucess="无相关符合条件数据";
				 }else if(message=="001"){
					  sucess=="系统异常";
				 }else {
					 sucess="无相关符合条件数据";
				 }
				 $("#tbody").append("<tr><td colspan='6' >"+sucess+"</td></tr>");
			}
		},"json")
  	}
function determine(){
	 var value="";
	 var radionum =  $("#radio");
	 for(var i=0;i<radionum.length;i++){
		 if(radionum[i].checked){
			 value = radionum[i].value
		 }
	} 
	if(value==""){
		alert("请选择一条数据!");
	}else{
		window.location.href="illegalDisposal.jsp";
		 window.location='illegalDisposal.jsp?value='+value;
	 }
}
function trafficViol(){
	 var value="";
	 var radionum =  $("#radio");
	 for(var i=0;i<radionum.length;i++){
		 if(radionum[i].checked){
			 value = radionum[i].value
		 }
	} 
	if(value==""){
		alert("请选择一条数据!");
	}else{
		window.location.href="trafficViolations.jsp";
		 window.location='trafficViolations.jsp?value='+value;
	 }
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