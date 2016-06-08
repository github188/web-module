<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@page import="com.ehualu.rise.dto.*"%>  
<%
	String name="";
    UserDto  user = (UserDto)session.getValue("userinfo");
	if(user!=null){
		name=user.getUserName();
	}
	//String yzm = (String)session.getAttribute("checkCode");
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>易华路—违法查询</title>
<link href="css/share_css.css" rel="stylesheet" type="text/css">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.validate.js"></script>
<script type="text/javascript">
	var userName='<%=name %>';
	function checkcx() {
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
		 $('#count').text("0");
	}
</script>
</head>

<body onload="checkcx();">
<div class="top">
    <ul class="nav">
    <li class="sel"><a href="index.jsp">首页</a></li>
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
<div id="change_banner">
		<div class="bigbanner_pic1">
			<img
				src="<%=request.getContextPath()%>/resources/images/wfcximg.png"
				width="1024" height="232">
		</div>
	</div>
	<div class="search">
		<ul id="tab">
			<li class="fli">车辆违法查询</li>
			<li>驾照违法查询</li>
			<li>决定书查询</li>
		</ul>
		<div id="tab_con">
			<div class="fdiv">
				<table border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="45">车牌号</td>
						<td width="135">&nbsp;</td>
						<td width="135">识别码</td>
						<td width="85">查询省市</td>
						<td width="95">车辆类型</td>
						<td width="135">验证码</td>
						<td height="25">&nbsp;</td>
					</tr>
					<tr>
						<td><label for="select"></label> <select name="select"
							id="hplx">
						<option value="辽" >辽</option>
						<option value="京"selected="selected">京</option>
						</select></td>
						<!-- value="DR6368"-005754 -->
						<td><label for="textfield"></label> <input name="hphm"
							type="text" id="hphm" size="15" value=""></td>
						<td><input name="fdjh" type="text" id="fdjh" size="15"
							value=""></td>
						<td><select name="select2" id="select2" style="width:70px;">
								<option>全国</option>
						</select></td>
						<td><select name="hpzl" id="hpzl" style="width:80px;">
								<option value="02" selected="selected">小型车</option>
						</select></td>
						<td style="width:80px;">
							<img src="/ehualu-web/drawCheckCode" onclick="reCheckcode(this)" id="rand" />
						</td>
						
						    <td >
								<input name="checkcode" type="text" id="checkcode" size='10'></input>
							</td>
						 <td> </td>	
						<td>
							<a href="#" name="jzwf" onclick="check()"><img src="<%=request.getContextPath()%>/resources/images/cxbtn.png"width="50" height="28" alt="查询" /></a>
						</td>
							
							</tr>	
				</table>
			</div>
			<div>
				<table border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="135">驾驶证号</td>
						<td width="95">驾照归属地</td>
						<td width="135">验证码</td>
						<td height="25">&nbsp;</td>
					</tr>
					<tr>
						<td><input name="jszh" type="text" id="jszh" size="15"
							value=""></td>
						<td>
						<select name="select3" id="select3" style="width:80px;">
								<option>辽</option>
						</select>
						</td>
						<td><span style="cursor:pointer">
								<img src="/ehualu-web/drawCheckCode" onclick="reCheckcode(this)" />
							</span>
						</td>	
						<td>
							<input name="checkcodes" type="text" id="checkcodes" size='10'>
						</td>
						<td>
						    <a href="#" name="jzwf" onclick="check1()">
							<img src="<%=request.getContextPath()%>/resources/images/cxbtn.png" width="50" height="28" alt="查询" /></a>
						</td>
					</tr>
				</table>


			</div>
			<div>
				<table border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="300">决定书编号</td>
						<td height="25">&nbsp;</td>
					</tr>
					<tr>
						<td><input name="jdsbh" type="text" id="jdsbh"
							style="width:280px;" value="" ></td>
						<td><a href="#" name="jzwf" onclick="check2()"><img
								src="<%=request.getContextPath()%>/resources/images/cxbtn.png"
								width="70" height="30" alt="查询" /></a></td>
					</tr>
				</table>

			</div>
		</div>
	</div>
	<div class="searched content_zxjk">
		<h3 style=" margin-left:">
			违法记录共<span class="f1" id="count"  >*</span><span class="f1"></span>条
		</h3>
		<table border="0" cellspacing="0" cellpadding="0" width="100%">
			<tr>
				<td class="title">序号</td>
				<td class="title">违法时间</td>
				<td class="title">违法地址</td>
				<td class="title">违法省市</td>
				<td class="title">违法行为</td>
				<td class="title">记分值</td>
				<td class="title">罚款金额</td>
				<td class="title">查看详情</td>
			</tr>
			<tr>
			<tbody id="tbody">

			</tbody>
			</tr>
			<tr>
				<td colspan="8">&nbsp;</td>
			</tr>
			<tr>
				<td colspan="8">&nbsp;</td>
			</tr>
			<tr>
				<td colspan="8">&nbsp;</td>
			</tr>
			<tr>
				<td colspan="8">&nbsp;</td>
			</tr>
		</table>
		<p>
			<br>
		</p>
	</div>
	<div class="foot">
		<div class="textbox">
			易华录总部：北京市石景山区阜石路165号中国华录大厦<br> 客服电话：400-610-1996 （8610）52281111<br>
			传真：（8610）52281188 邮编：100043 网址：http://www.ehualu.com
			<div class="copyinfo">
				Copyright © 2013-2016 ehualu.com All rights reserved<br>
				京ICP备05016422 京公网安备1101070200132<br> 版权所有：北京易华录信息技术股份有限公司
			</div>
		</div>
	</div>


</body>
</html>
<script type="text/javascript">
	var tabs=document.getElementById("tab").getElementsByTagName("li");
	var divs=document.getElementById("tab_con").getElementsByTagName("div");
	for(var i=0;i<tabs.length;i++){
		tabs[i].onclick=function(){
		change(this);
		}
	}
	function change(obj){
		for(var i=0;i<tabs.length;i++){
			if(tabs[i]==obj){
				tabs[i].className="fli";
				divs[i].className="fdiv";
				//$("#tbody").empty();
				//$("#count").empty();
			}else{
				tabs[i].className="";
				divs[i].className="";
			}
		}
	}
	/* function keyup(t) {  
	    var Error = "";  
	    var re = /^[\u4e00-\u9fa5a-z]+$/gi;  
	    if (!re.test(t)) {  
	    }  
	    alert("名称中含有特殊字符!"); 
	} */
	 function CheckStr(str){
		
		            var SpecialCharacters = "@/'\"#$%&^*";
		            var i =0;
		            for ( i = 0; i < SpecialCharacters.length - 1; i++)
		            {
		                if (str.IndexOf(SpecialCharacters.charIndex(i)) != -1)
		                {
		                    return true;
		                }
		            }
		            return false;
		        }
	function zt(sucess){
		 $("#tbody").append("<tr><td colspan='8' >"+sucess+"</td></tr>");
	}
	
	function check(){
		 
		//对车牌号进行判断
		$("#tbody").children().remove();  
		var hphm1 = document.getElementById("hphm").value;
		var hplx = document.getElementById("hplx").value;
		var hphm=hplx+hphm1;
		if(hphm1==""||/[@\/'\\"#$%&\^*]/.test(hphm1)){
			zt("请输入正确的车牌号！");
			return false;
		}
		//对识别码进行判断
		var hpzl = document.getElementById("hpzl").value;
	 	var fdjh = document.getElementById("fdjh").value;
		if(fdjh==""||fdjh.length!=6 ||/[@\/'\\"#$%&\^*]/.test(fdjh)){
			zt("请输入正确的识别码(发动机末六位)！");
			return false;
		}
		//对验证码进行判断
	 	var checkcode=document.getElementById("checkcode").value;
		if(checkcode==""){
			zt("请输入验证码！");
			return false;
		}
		$.ajax({
			url: "<%=request.getContextPath()%>/voilation/queryJDCVoilation",
			type: "POST",
			async : false,
			data: {
					hphm: hphm ,
				    hpzl: hpzl ,
				    fdjh: fdjh ,
				    checkcode:checkcode
				  },
			dataType: "json",
			success: function(data){
				 if(data.body!=undefined){
					 $('#count').text(data.body.length);
					for(var i=0;i<data.body.length;i++){
							$("#tbody").append("<tr><td>"+(i+1)+"</td><td>"+data.body[i].wfsj+"</td><td>"
									+data.body[i].wfdz+"</td><td>"
									+data.body[i].lxfs+"</td><td>"
									+data.body[i].wfxw+"</td><td>"
									+data.body[i].wfjfs+"</td><td>"
									+data.body[i].fkje+"</td><td>"
									+data.body[i].wfsj+"</td></tr>"		
												);
					}
				 	}else{
					 var message=data.header.ztm;
					 var sucess="";
					 if(message=="000"){
						 sucess="无相关符合条件数据";
					 }else if(message=="001"){
						  sucess=="系统异常";
					 }else if(message=="301"){
						 sucess="查询条件为空";
					 }else if(message=="302"){
						 sucess="号牌号码为空";
					 }else if(message=="303"){
						 sucess="号牌种类为空";
					 }else if(message=="304"){
						 sucess="发动机号为空";
					 }else if(message=="305"){
						 sucess="号牌种类不匹配";
					 }else if(message=="306"){
						 sucess="发动机号不匹配";
					 }else if(message=="307"){
						 sucess="结果集中发动机号为空";
					 }else if(message=="105"){
						 sucess="验证码校验失败";
					 }
					 $("#tbody").append("<tr><td colspan='8' >"+sucess+"</td></tr>");
				 					}
								}
	   			 });
 		
		}

	function check1(){
		$("#tbody").children().remove();  
		 var jszh = document.getElementById("jszh").value;
		 var checkcode = document.getElementById("checkcodes").value;
		 if(jszh=='') {
				zt("驾驶证号不能为空！");
				return false;
		 }
		 if (/[@\/'\\"#$%&\^*]/.test(jszh)){
			 zt("请输入正确的驾驶证号！");
		     return false;
		  }  
		 if(checkcode!=""){
			  $.ajax({
				url: "<%=request.getContextPath()%>/voilation/queryDriverLicenseVoilation",
				type: "POST",
				async : false,
				data: {jszh:jszh,checkcode:checkcode},
				dataType: "json",
				success: function(data){
					 if(data.body!=undefined){
					 $('#count').text(data.body.length);
					 for(var i=0;i<data.body.length;i++){
							$("#tbody").append("<tr><td>"+(i+1)+"</td><td>"+data.body[i].wfsj+"</td><td>"
									+data.body[i].wfdz+"</td><td>"
									+data.body[i].lxfs+"</td><td>"
									+data.body[i].wfxw+"</td><td>"
									+data.body[i].wfjfs+"</td><td>"
									+data.body[i].fkje+"</td><td>"
									+data.body[i].wfsj+"</td></tr>"		
							);
					}
					 }else{
						 var message=data.header.ztm;
						 var sucess="";
						 if(message=="000"){
							 sucess="无相关符合条件数据";
						 }else if(message=="401"){
							  sucess="驾驶证号为空";
						 }else if(message=="105"){
							  sucess="验证码校验失败";
						 }
						 $("#tbody").append("<tr><td colspan='8' >"+sucess+"</td></tr>");
					 }
				}
		    	});
		  }else{
			  zt("验证码不能为空!");
	       }
		 
		}
	
/* 	function keyup(t) {  
	    var Error = "";  
	    var re = /^[\u4e00-\u9fa5a-z]+$/gi;  
	    if (!re.test(t)) {  
	    }  
	    alert("名称中含有特殊字符!"); 
	} */
	//验证特殊字符
	function illegalChar(str)
	{
	    var pattern=/\D+/g;  
	    if(pattern.test(str)){  
	        return false;     
	    }     
	    return true;  
	}
 	function check2(){
 		$("#tbody").children().remove();  
		var jdsbh = document.getElementById("jdsbh").value;
		if(jdsbh=='') {
			 zt("决定书编号不能为空！");
			 return false;
		}
		if (/[@\/'\\"#$%&\^*]/.test(jdsbh)){
			 zt("请输入正确的决定书编号！");
		     return false;
		}  
		$.ajax({
			url: "<%=request.getContextPath()%>/voilation/queryJDSVoilation",
			type: "POST",
			async : false,
			data: {jdsbh:jdsbh},
			dataType: "json",
			success: function(data){
				 if(data.body!=undefined){
				$('#count').text(data.body.size);
				/* for(var i=0;i<=data.body.length;i++) */{
						$("#tbody").append("<tr><td>"+(i-2)+"</td><td>"+data.body.wfsj+"</td><td>"
								+data.body.wfdz+"</td><td>"
								+data.body.wfdz+"</td><td>"
								+data.body.lxfs+"</td><td>"
								+data.body.wfxw+"</td><td>"
								+data.body.jkfs+"</td><td>"
								+data.body.fkje+"</td></tr>"	
						);
				}
				 }else{
					 var message=data.header.ztm;
					 var sucess="";
					 if(message=="000"){
						 sucess="无相关符合条件数据！"
					 }else if(message=="501"){
						  sucess="决定书编号为空！";
					 }
					 $("#tbody").append("<tr><td colspan='8'>"+sucess+"</td></tr>");
				 }
			}
	    });
 	
	}
	
	function reCheckcode(img) {
		//这里的src应该对应着controller里的法法
		img.src = "/ehualu-web/drawCheckCode?" + Math.random();
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