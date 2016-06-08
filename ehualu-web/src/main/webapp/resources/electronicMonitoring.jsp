<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%String valuestr=(String)request.getParameter("value");
 %> 
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>电子监控处理流水</title>
<link href="css/share_css.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>

</head>

<body onload="doload();">
<div class="content_zxjk">
  <h1>电子监控处理流水</h1>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="12%" class="title">决定书编号</td>
    <td width="18%" class="title">处罚单位</td>
    <td width="21%" class="title">违法时间</td>
    <td width="15%" class="title">记分值</td>
    <td width="9%" class="title">罚款金额</td>
  </tr>
 <tr>
	<tbody id="tbody">
	</tbody>
  </tr>
  </table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td colspan="2" class="blue_f">当前流程进度</td>
    </tr>
  <tr>
    <td colspan="2"><img src="images/jd.png" width="573" height="80"></td>
    </tr>
  <tr>
    <td width="29%" class="c_f g_back">处理时间</td>
    <td width="71%" class="c_f g_back">处理信息</td>
  </tr>
  <tr>
    <td ><span id="clsj"></span></td>
    <td>缴款成功</td>
  </tr>
</table>
<div class="btn_b" style="width:130px;"><a  onClick="closeillegalwin();" >关闭当前窗口</a></div>
</div>
</body>
</html>
<script type="text/javascript">

function doload(){
	var valuestr="<%=valuestr%>";
	if(valuestr!=undefined){}
	var valuestring=valuestr.split(",");
	var jdsbh=valuestring[3];
	if(jdsbh== "undefined"){
		jdsbh="";
	}
	var cfdw=valuestring[4];
	if(cfdw== "undefined"){
		cfdw="";
	}
	var wfsj=valuestring[5];
	if(wfsj== "undefined"){
		wfsj="";
	}
	var jfz=valuestring[6];
	if(jfz== "undefined"){
		jfz="0";
	}
	var fkje=valuestring[7];
	if(fkje== "undefined"){
		fkje="0";
	}
	var clsj=valuestring[8];
	if(clsj== "undefined" ){
		clsj="";
	}
	$("#tbody").append("<tr><td>"+jdsbh+"</td><td>"
			+cfdw+"</td><td>"
			+wfsj+"</td><td>"
			+jfz+"</td><td>"
			+fkje+"</td></tr>"		
	);
   $('#clsj').text(clsj); 
}
function closeillegalwin(){
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
		}
		var fdjhlw=valuestring[2];
		if(fdjhlw== "undefined"){
			fdjhlw="";
		}
	 }
	var valuestring=hphm+","+hpzl+","+fdjhlw;
	window.location.href="illegalDisposal.jsp";
	window.location='illegalDisposal.jsp?value='+valuestring;
		
	}
</script>