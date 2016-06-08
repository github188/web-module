<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@page import="com.ehualu.rise.dto.*"%>  
<%
	String name="";
    UserDto  user = (UserDto)session.getValue("userinfo");
	if(user!=null){
		name=user.getUserName();
	}
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>易华路—帮助中心</title>
<link href="css/share_css.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	var userName='<%=name %>';
	function checkzt() {
		if(userName!=""){
			$('#nologin').css('display','none');
			$('#oklogin').css('display','block');
			
			$('#nologints').css('display','none');
			$('#oklogints').css('display','block');
		}else{
			$('#nologin').css('display','block');
			$('#oklogin').css('display','none');
			
			$('#nologints').css('display','block');
			$('#oklogints').css('display','none');
		}
	}
</script>
</head>

<body onload="checkzt();">
<div class="top">
  <ul class="nav">
    <li><a href="index.jsp">首页</a></li>
    <li><a href="illegal_search.jsp">违法查询</a></li>
    <li> 
   <a href="kindlyReminder.jsp" id="nologints" style="display: none;" >在线缴款</a>
    <a href="userindex.jsp" id="oklogints"  style="display: none;">在线缴款</a>
    </li>
    <li><a href="valueAddedService.jsp">增值服务</a></li>
    <li><a href="dataService.jsp">数据服务</a></li>
    <li class="help"><a href="help.jsp">帮助中心</a></li>
  </ul>
  <div class="loginfo">
    <div class="login_pic"></div>
    <div class="user_name">
    <a href="login.jsp" id="nologin" style="display: none;" >用户登录</a>
    <a id="oklogin" style="display: none;" >已登录/<span style="cursor: pointer;" onclick="logOut();">退出 </span></a>
    </div>
  </div>
</div>
<div id="change_banner_b">
  <div class="bigbanner_help">
    <div class="helptile"><strong>帮助中心</strong></div>
    <div class="tile"><strong>自助缴罚指南</strong></div>
  </div>
</div>
<div class="content_bzzx">
<div class="bzzx_left">
<ul class="grxx_nav">
      <li><a href="#">新手入门</a></li>
  </ul>
  <ul class="grxx_nav2">
      <li><a href="newMembers.jsp">新会员注册</a></li>
      <li><a href="help.jsp">用户登录</a></li>
      <li><a href="boundVehicleAndDriver.jsp">绑定车辆/驾证</a></li>
      <li><a href="bindingMicCha.jsp">绑定微信</a></li>
      <li><a href="retrievePassword.jsp">找回密码</a></li>
      <li><a href="illegalQuery.jsp">违法查询</a></li>
      <li><a href="businessInformation.jsp">自助服务业务须知</a></li>
      <li><a href="implementCode.jsp">辽宁实施规定</a></li>
  </ul>
  <ul class="grxx_nav">
      <li><a >自助缴罚指南</a></li>
      <li><a href="commonProblem.jsp">常见问题</a></li>
</ul>
</div>

<div class="grxx_right">
  <p><strong>1.自助缴罚</strong></p>
  <p>     进行自助缴罚需要您先登录易华路，并绑定车辆后才能正常进行缴罚，如您未绑定车辆，请先“绑定车辆”。 </p>
  <p><strong>  自助缴罚步骤如下：</strong><br>
    <img src="images/pic.png" width="616" height="269" alt="denglu"><br>
    (1)    点击网站导航栏“在线缴款”， 进入道理交通违法自助服务平台；<br>
    <img src="images/pic.png" width="616" height="269" alt="denglu"><br>
    (2)    同意《交通违法行为网上自助处理使用协议》，点击“同意并继续处理”； <br>
    (3)    系统将根据车牌号列出绑定车辆的违法记录以及状态、可进行的操作；<br>
    <img src="images/pic.png" width="616" height="269" alt="denglu"><br>
    (4)    选择要处理的记录，点击“确认”, 您可以看到记录的详细信息；<br>
    <img src="images/pic.png" width="616" height="269" alt="denglu"><br>
    (5)    切换到“违法处理业务”标签页，选中要缴款的记录（蓝色”缴款”按钮是可操作项、灰色”缴款”按钮是不可操作项、如果已经缴款则显示绿色个”已处理”按钮点击则转至”订单详细”页面），点击“缴款”弹出”处罚决定书”页面，在此页面可查看”违法照片”和选择”是否愿意接受处罚”；<br>
    <img src="images/pic.png" width="616" height="269" alt="denglu"><br>
    (6)    点击“我愿意接受处罚”，则转至”网银支付”页面，选择支付方式，系统生成订单，点击“去付款”进入相应的网银支付页面；（暂缺）<br>
    <img src="images/pic.png" width="616" height="269" alt="denglu"><br>
    (7)    按网银页面提示，完成付款操作，待交警系统完成解网处理即可。<br>
    <img src="images/pic.png" width="616" height="269" alt="denglu"><br>
    </p>
	<p><strong>  温馨提示：</strong><br>
	    (1)     自助缴罚暂时仅限200元以下（含200元）以下罚款； <br>
	    (2)     缴纳罚款前请先确认是否开通某网上银行，账户是否足够的金额；<br>
	    (3)     在线自助处罚结束后，交通处罚决定书将快递到当事人签收，请确保个人资料的邮寄地址正确，查看“个人资料”；（不确定）<br>
	  </p>
  <p><strong>2.根据处罚决定书缴款</strong><br>
     进行自助缴罚需要您先登录易华路，并绑定车辆后才能正常进行缴罚，如您未绑定车辆，请先“绑定车辆”。 <br></p>
  <p><strong>  操作步骤如下：</strong><br>
	    (1)     填写“决定书编号”，点击“查询”； <br>
	    (2)     系统将列出编号对应的违法信息，包括车牌号、违法行为、罚款金额等；<br>
	    (3)     确认违法信息无误，点击“立即缴款”，按网银支付流程完成付款即可，可详见自助缴罚流程。<br>
  </p>
  <p><strong>3.查看车辆违法照片</strong><br></p>
   <p>      易华路直连交警系统，可查看车辆的违法照片，您可以在”交通违法驾驶人确认书”页面，点击“查看”，系统将会从交警系统获取照片，因系统原因，照片显示时间略有延迟，请耐性等待。 </p>
   <p><img src="images/pic.png" width="616" height="269" alt="denglu"></p>
  
  <p><strong>4.异议处理</strong><br></p>
   <p>     当您对违法记录存有异议时，请在”交通违法驾驶人确认书”页面点击”我不接受处罚”，之后您可以到当地交管部门申请”行政复议”。 </p>
   <p><img src="images/pic.png" width="616" height="269" alt="denglu"></p>
   <p><strong>以下为交警系统允许异议处理的条件：</strong><br>
    (1)  确认违法图片有误，如车主、车牌、车颜色等有误； <br>
    (2)  对车辆违反交通违法条款存在疑义；<br>
    (3)  驾驶员信息有误； <br>
    (4)  机动车信息有误；<br>
    (5)  违法地点有误，如没有驾驶违法车辆到过违法地等；<br>
    (6)  对罚款金额、计分数存在疑义等；<br>
   </p>
</div>
  <div style="clear:both;"></div>

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