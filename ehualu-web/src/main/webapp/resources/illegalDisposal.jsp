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
<title>在线缴款-确认车辆信息</title>
<link href="css/share_css.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>

</head>

<body onload="querydata();">
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
    <div class="user_name">已登录/<span style="cursor: pointer;" onclick="logOut();">退出 </span></div>
  </div>
</div>
<div id="change_banner_a">
  <div class="bigbanner_pic1_a"><img src="images/zxjf.png" width="1024" height="84"></div>
</div>
<div class="content_zxjk">
<h1>违法处理业务<span>/确认车辆信息</span></h1>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td class="td">号牌号码</td>
    <td class="td_a b_r"  id="hphm"></td>
    <td class="td">车辆状态</td>
    <td class="td_a">您还有<span id="wclts"></span>条未处理违法行为</td>
  </tr>
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td colspan="8" class="blue_f">选择监控记录</td>
    </tr>
  <tr>
    <td colspan="8" class="f_f">系统提示：<img src="images/lsfk.png"> 可以在网上处理。<img src="images/hsfk.png"> 需要去窗口处理。</td>
    </tr>
  <tr>
    <td colspan="8" class="g_f">违法处理地市：<a href="#">全部</a> <a href="#">辽宁</a></td>
    </tr>
  <tr>
    <td width="6%" class="title">序号</td>
    <td width="14%" class="title">时间</td>
    <td width="20%" class="title">违法地点</td>
    <td width="15%" class="title">违法行为</td>
    <td width="11%" class="title">记分值</td>
    <td width="10%" class="title">罚款金额</td>
    <td width="12%" class="title">查看详细</td>
    <td width="12%" class="title">操作</td>
  </tr>
  <tr>
	<tbody id="tbody">
	</tbody>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td height="153" class="g_f">&nbsp;</td>
    <td height="153" class="g_f">&nbsp;</td>
    <td height="153" colspan="4" class="g_f c_f">共<span id="count"></span>条数据</td>
    <td height="153" colspan="2" class="g_f">
	    <ul class="fy">
		  <li>首页</li>
		  <li>上一页</li>
		  <li>下一页</li>
		  <li>尾页</li>
		</ul>
	 </td>
   </tr>
</table>
<div class="btn_b"><a href="userVehiclelist.jsp">上一步</a></div>

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
function querydata(){
	var valuestr="";
	var valuestr='<%=value %>';
	var valuestring=valuestr.split(",");
	var hphmstr=valuestring[0];
	var hpzlstr=valuestring[1];
	var fdjhlw=valuestring[2];
	var checkcode="";
	var hpzl="";
	if(hpzlstr==02){
		hpzl="小型汽车";
	}

	$('#hphm').text(hphmstr);
	$("#tbody").empty();
	var wclzs="0";
	$.ajax({
		url: "<%=request.getContextPath()%>/voilation/queryJDCVoilation",
		type: "POST",
		async : false,
		data: {
				hphm: hphmstr ,
			    hpzl: hpzlstr ,
			    fdjh: fdjhlw ,
			    checkcode:checkcode
			  },
		dataType: "json",
			success: function(data){
				 if(data.body!=undefined){
					 
					 $('#count').text(data.body.length);
					for(var i=0;i<data.body.length;i++){
						var arr = [];
						arr.push("  <tr>");
						arr.push("    <td>"+(i+1)+"</td>");
						arr.push("    <td>"+data.body[i].wfsj+"</td>");
						arr.push("    <td>"+data.body[i].wfdz+"</td>");
						arr.push("    <td>"+data.body[i].wfxw+"</td>");
						arr.push("    <td>"+data.body[i].wfjfs+"</td>");
						arr.push("    <td>"+data.body[i].fkje+"</td>");
						arr.push("    <td ><a onClick='viewDetails();'>查看</a></td>");
						valuestr="";
						valuestr='"'+hphmstr+","+hpzl+","+fdjhlw+","+data.body[i].xzqh+","
							+data.body[i].wfsj+","+data.body[i].wfdz+","
							+data.body[i].wfxw+","+data.body[i].jfz+","+data.body[i].fkje+","
							+data.body[i].znj+","+data.body[i].jdsbh+","+data.body[i].clsj+'"';
						if(data.body[i].clbj==0){
							wclzs=(+Number(wclzs)+1).toString();
							  //未处理（罚金>200）
							  if(0<data.body[i].fkje<=200){
								  arr.push("    <td  ><div class='jkbtn'><a  onClick='penaltyDecision("+valuestr+");'>缴 款</a></div></td>");
							  }else{
								  arr.push("     <td><div class='jfbtn'><a href='#'>缴 款</a></div></td>  ");
							  }
						  } else{
							  //已处理
							  arr.push("      <td class='r_f'><a href='userindex.jsp'>已处理</a></td>");
						  } 
						arr.push("  </tr>"); 
						var div=$('#tbody');
						div.innerHTML = arr.join('\n');
						$("#tbody").append(div.innerHTML); 
					}
				 }else{
					 var message=data.header.ztm;
					 var sucess="";
					 if(message=="000"){
						 sucess="无相关符合条件数据";
					 }else if(message=="001"){
						  sucess=="系统异常";
					 }else if(message=="305"){
						 sucess="号牌种类不匹配";
					 }else if(message=="306"){
						 sucess="发动机号不匹配";
					 }
					 $('#count').text(0);
					 $("#tbody").append("<tr><td colspan='8' >"+sucess+"</td></tr>");
				 }
			}
	    }); 
	 $('#wclts').text(wclzs);
	}
	
function viewDetails(){
	
}
function penaltyDecision(value){
	window.location.href="penaltyDecision.jsp";
	window.location='penaltyDecision.jsp?value='+value;
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