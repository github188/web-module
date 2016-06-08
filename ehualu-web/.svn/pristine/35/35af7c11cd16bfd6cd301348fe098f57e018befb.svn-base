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
    <div class="tile"><strong>常见问题</strong></div>
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
      <li><a href="paymentPenaltyGuide.jsp">自助缴罚指南</a></li>
      <li><a >常见问题</a></li>
</ul>
</div>

<div class="grxx_right">
  <p><strong>1.辽宁省处罚/缴款政策（暂缺）</strong><br>
  </p>
 <p><strong>2.平台使用问题</strong><br>
    1、    为什么在使用自助处理平台前，要签订使用自助处理业务《使用协定》？<br>
       &nbsp;&nbsp;&nbsp;&nbsp;答：由于自助处理业务的特殊性，用户在“交通违法自助服务平台”注册使用自助处理业务前，必须在网站上同意《使用协议》后才允许自助处理交通违法，《使用协议》对双方的权利义务、法律责任、行为规范、安全保密责任、业务办理的相关规定和要求进行明确，以保障业务办理存在争议时，有效保护交警部门的权益。 <br>
    2、    如何注册用户？ <br>
       &nbsp;&nbsp;&nbsp;&nbsp;答：浏览器打开易华路自助平台后，点击用户登陆下方的新用户注册按钮，进入新用户注册页面，填写完毕用户信息，为避免后续使用存在障碍，请将信息尽量填写完整，最后点击确认即可。<br>
    3、    如何绑定车辆？为什么会显示验证失败？ <br>
       &nbsp;&nbsp;&nbsp;&nbsp;答：进入到车辆绑定页面，选择车辆所属省份、车辆类型、号牌号码、车辆识别代号，点击确认即可，如果显示验证失败，说明输入内容有误，大部分为车辆识别代号输入有误，请核对后重新输入。<br>
    4、   如何绑定驾驶证？为什么会显示验证失败？ <br>
       &nbsp;&nbsp;&nbsp;&nbsp;答：进入到驾驶证绑定页面，输入真实姓名、证件号码、档案编号以及证芯编号，点击确认即可，如果显示验证失败，说明输入内容有误，请核对后重新输入。 <br>
    5、  为什么登录时候提示我“用户已登录，是否关闭上次登录”？ <br>
       &nbsp;&nbsp;&nbsp;&nbsp;答：出现此提示是因为上一次的用户登陆没有正确退出系统所致，在每次使用完毕后，点击退出登陆按钮可避免之。<br>
    6、  如何查看违法照片？为什么我的违法记录照片看不到？ <br>
       &nbsp;&nbsp;&nbsp;&nbsp;答：在违法记录列表页，点击查看图片即可查看此条记录的违法图片，如果看不到照片，可能犹如原因： <br>
       &nbsp;&nbsp;&nbsp;&nbsp;1)   此违法记录交警系统没有或不提供图片查看；<br>
       &nbsp;&nbsp;&nbsp;&nbsp;2)   交警和平台网络之间的数据传输出现故障；<br>
       &nbsp;&nbsp;&nbsp;&nbsp;3)   有些省份的数据传输没有通过网络连接，需要定时导出，故有数据延迟的原因导致图片看不到。<br>
    7、  我确认违法后，为什么一直显示确认中？ <br>
       &nbsp;&nbsp;&nbsp;&nbsp;答： 1）网络问题导致数据文件未生成； <br>
       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2）海南、青海、重庆暂为定时导入导出数据文件，数据未导入造成页面一直显示确认中；<br>
       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3）其他原因，如交警系统故障等。<br>
    8、  通过易华路平台网络缴款，支持哪些银行？ <br>
       &nbsp;&nbsp;&nbsp;&nbsp;答：（暂缺）<br>
    9、   通过易华路平台自助处理，会扣分吗？需要手续费吗？ <br>
       &nbsp;&nbsp;&nbsp;&nbsp;答：不会扣分，不需要手续费。<br>
    10、易华路平台和交管的数据更新周期是多久？ <br>
       &nbsp;&nbsp;&nbsp;&nbsp;答：（暂缺） <br>
    11、一条违法信息从发生到可以从平台上查询到，一般需要多久？ <br>
       &nbsp;&nbsp;&nbsp;&nbsp;答：（暂缺） <br>
    12、成功缴款后多久可以解网消除？ <br>
       &nbsp;&nbsp;&nbsp;&nbsp;答：（暂缺） <br>
    13、为什么我注册绑定后，车辆违法记录的【确认】是灰色的，无法点击？ <br>
       &nbsp;&nbsp;&nbsp;&nbsp;答：这是因为此条违法不符合平台处理的违法范围，或是车辆不符合平台处理范围。<br>
    14、罚款200元以上的罚款，可以通过易华路确认和缴纳吗？ <br>
       &nbsp;&nbsp;&nbsp;&nbsp;答： 暂不可以。 <br>
    15、我的车是外省的，但是我在辽宁有一个现场开单的处罚决定书，可以通过易华路缴款吗？ <br>
       &nbsp;&nbsp;&nbsp;&nbsp;答：（暂缺） <br>
    16、网上自助确认生成的处罚决定书编号少一位，无法通过手机银行缴款，怎么办？ <br>
       &nbsp;&nbsp;&nbsp;&nbsp;答：请打印电子违法决定书，打印件会提供16位决定书编号。 <br>
    17、前一次缴款后没消除，我又重新缴款了，重复缴款的话，怎么进行退款啊？ <br>
       &nbsp;&nbsp;&nbsp;&nbsp;答：首先保证是在平台产生的重复缴款，然后请及时联系客服，提供号牌号码、订单号、决定书编号、联系电话、银行帐号等信息方便客服核对信息无误后，协调各省财政处理。注意;由于道路交通违法罚款是直接接入各省财政专户，财政无法提供罚款退款处理，缴款中如有问题立即停止，并致电平台服务热线请求帮助。 <br>
    18、易华路官网的客服在线时间是几点到几点？ <br>
       &nbsp;&nbsp;&nbsp;&nbsp;答：每天的9:00～17:30 <br>
    19、我在易华路官网上确认后一直提示确认中，那我能再去交管处理点去缴款吗？ <br>
       &nbsp;&nbsp;&nbsp;&nbsp;答：不能，在确定产生决定书编号以后方可缴款。 <br>
    20、我没有网银，可以打印出来去银行缴款吗？ <br>
       &nbsp;&nbsp;&nbsp;&nbsp;答：可以。 <br>
    21、多长时间不缴款会产生滞纳金？ <br>
       &nbsp;&nbsp;&nbsp;&nbsp;答：自处罚决定书产生之日起，15天之内不会产生滞纳金，超过15天后，每天按照3%收取滞纳金，最高不超过本金。 <br>
    22、我要下载APP，输入什么关键字？ <br>
       &nbsp;&nbsp;&nbsp;&nbsp;答：驾驶员或车主朋友可以通过APPStore、应用宝、 百度助手、91手机助手、豌豆夹等应用市场搜索“易华路”下载安装。 <br>
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