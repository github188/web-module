<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="com.ehualu.rise.dto.*"%>  
 <%String valuestr=(String)request.getParameter("value"); %> 
  <%
    UserDto  user = (UserDto)session.getValue("userinfo");
	String name="";
	String phone="";
	if(user!=null){
		name=user.getUserName();
		phone =user.getPhone();
	}
 %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>在线缴款-处罚决定书</title>
<link href="css/share_css.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>

</head>

<body onload="doQuery();">
<div class="content_zxjk">
  <h1>违法处理业务<span>/处罚决定书</span></h1>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td colspan="8" class="bold">交通违法驾驶人确认书</td>
    </tr>
  <tr>
    <td colspan="8">经与交通技术监控设备采集的违法信息进行核查对比，本人<br>
      （姓名：<%=name%>；联系电话：<%=phone%>）<br>
      承认驾驶车牌号为<span id="hpxx"></span>在以下时间、地点实施<span>1</span>起交通违法行为：</td>
  </tr>
  <tr>
    <td width="12%" class="title">处罚单位</td>
    <td width="18%" class="title">违法时间</td>
    <td width="21%" class="title">违法地点</td>
    <td width="15%" class="title">违法行为</td>
    <td width="9%" class="title">记分值</td>
    <td width="9%" class="title">罚款金额</td>
    <td width="7%" class="title">滞纳金</td>
    <td width="9%" class="title">违法照片</td>
  </tr>
  <tr>
	<tbody id="tbody">
	</tbody>
  </tr>
  
  
</table>
<div class="zxjk_fonta">
  <ul>
    <li>对处理以上交通行为，本人承诺所作的书面陈述、所提供的材料信息真实、有效，否则愿承担一切法律后果。</li>
    <li>如若选择“我不接受处罚”，请自行前往某某车管所申请行政复议。</li>
  </ul>
</div>
<div class="foot_btn">
<ul>
<li class="btn_r"><a  onClick="acceptPunishment();">我愿意接受处罚</a></li>
<li class="btn_b"><a href="userVehiclelist.jsp">我不接受处罚</a></li>
</ul>
</div>
</div>
</body>
</html>
<script type="text/javascript">
function doQuery(){
	var acceptPunistr="";
	var hpzlMS="";
	var valuestr="<%=valuestr%>";
	 if(valuestr!=undefined){
		var valuestring=valuestr.split(",");
		var hphm=valuestring[0];
		if(hphm== "undefined"){
			hphm="";
		}
		var hpzl=valuestring[1];
		if(hpzl== "undefined"){
			hpzl="";
		}if(hpzl=="小型汽车"){
			hpzl="02";
			hpzlMS="小型汽车";
		}
		var fdjhlw=valuestring[2];
		if(fdjhlw== "undefined"){
			fdjhlw="";
		}
		$('#hpxx').text(hphm+"的"+hpzlMS);
		var cfdw=valuestring[3];
		if(cfdw== "undefined"){
			cfdw="";
		}
		var wfsj=valuestring[4];
		if(wfsj== "undefined"){
			wfsj="";
		}
		var wfdd=valuestring[5];
		if(wfdd== "undefined"){
			wfdd="";
		}
		var wfxw=valuestring[6];
		if(wfxw== "undefined"){
			wfxw="";
		}
		var jfzStr=valuestring[7];
		if(jfzStr== "undefined" ){
			jfzStr="0";
		}
		var fkje=valuestring[8];
		if(fkje== "undefined"){
			fkje="0";
		}
		var znj=valuestring[9];
		if(znj== "undefined" ){
			znj="0";
		}
		var jdsbh=valuestring[10];
		if(jdsbh== "undefined" ){
			jdsbh="";
		}
		var clsj=valuestring[11];
		if(clsj== "undefined" ){
			clsj="";
		}
		acceptPunistr = hphm+","+hpzl+","+fdjhlw+","+jdsbh+","+cfdw+","+wfsj+","+jfzStr+","+fkje+","+clsj;
		var wfzp="";
		var div=$('#tbody');
		var arr = [];
		arr.push("  <tr>");
		arr.push("    <td >"+cfdw+"</td>");
		arr.push("    <td >"+wfsj+"</td>");
		arr.push("    <td >"+wfdd+"</td>");
		arr.push("    <td >"+wfxw+"</td>");
		arr.push("    <td >"+jfzStr+"</td>");
		arr.push("    <td >"+fkje+"</td>");
		arr.push("    <td >"+znj+"</td>");
		arr.push("    <td><div class='jkbtn'><a >查 看</a></div></td>");
		arr.push("  </tr>");
		 arr.push("  <tr>");
		arr.push("    <td height='153' class='g_f'>&nbsp;</td>");
		arr.push("    <td height='153' colspan='5' class='g_f c_f'>共<span>"+jfzStr+"</span>分 罚款<span>"+fkje+"</span>元 </td>");
		arr.push("   <td height='153' colspan='2' class='g_f'   name='acceptPuni' id='acceptPuni' value='" + acceptPunistr + "'>&nbsp;</td>");
		arr.push("  </tr>"); 
		div.innerHTML = arr.join('\n');
		$("#tbody").append(div.innerHTML);
	}else{
		$("#tbody").append("<tr><td colspan='8' >获取信息失败</td></tr>");
	}  
	}
	function acceptPunishment(){
		var value =  $("#acceptPuni").val();
		window.location.href="netPayment.jsp";
		window.location='netPayment.jsp?value='+value;
		
	}
</script>