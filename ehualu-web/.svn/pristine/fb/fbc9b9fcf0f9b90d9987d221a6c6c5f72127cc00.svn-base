<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.ehualu.rise.dto.*"%>  
<%String valuestr=(String)request.getParameter("value"); %> 

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>易华路—电子监控处理流水</title>
<link href="css/share_css.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>

</head>

<body>
<div class="content_zxjk">
<div class="wyzflc">网银支付流程</div>
  <div class="btn_b"><a  onClick="electronicMonit();">下一步</a></div>
</div>
</body>
</html>
<script type="text/javascript">
function electronicMonit(){
		var valuestr="<%=valuestr%>";
		window.location.href="electronicMonitoring.jsp";
		window.location='electronicMonitoring.jsp?value='+valuestr;
		
	}
</script>