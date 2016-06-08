<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../common/common_css.jsp"%>
</head>
<body class="no-skin">
	<div class="main-content-inner">
		<!-- #section:basics/content.breadcrumbs -->
		<div class="breadcrumbs" id="breadcrumbs">
			<ul class="breadcrumb">
				<li>
					<i class="ace-icon fa fa-home home-icon"></i>
					<a href="#">短信发送日志</a>
				</li>
				<li class="active">短信发送日志</li>
			</ul><!-- /.breadcrumb -->			
		</div>
		
		<div class="page-content">
			<%@ include file="../common/setting.jsp"%>
			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<div class="row">
						<div class="col-xs-12">
							<table id="sample-table-1" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th>序号</th>
										<th>用户手机</th>
										<th>发送内容</th>
										<th>返回结果</th>
										<th>时间</th>
										<th>标示</th>
									</tr>
								</thead>

								<tbody>
								<c:if test="${datas.total eq 0}">
									<tr align="center"><td colspan="10"><font color="red">没有找到相关记录</font></td></tr>
								</c:if>
								<c:forEach items="${datas.datas }" var="smsrecord">
									<tr>
										<td>
											${smsrecord.id}
										</td>
										<td>${smsrecord.phone}</td>
										<td>${smsrecord.content}</td>
										<td>${smsrecord.returnvalue}</td>
										<td>${smsrecord.time}</td>
										<td>${smsrecord.flag}</td>
									</tr>
								</c:forEach>
								</tbody>
							</table>
							<div class="page-header position-relative">
								<table style="width: 100%;">
									<tbody>
										<tr>
											<td style="vertical-align: top;">
												<c:if test="${datas.total > 0}">
													<jsp:include page="/jsp/pager.jsp">
														<jsp:param value="${datas.total }" name="totalRecord"/>
														<jsp:param value="smsRecords" name="url"/>
													</jsp:include>
												</c:if>
											</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div><!-- /.span -->
					</div><!-- /.row -->
				</div><!-- /.col -->
			</div><!-- /.row -->
		</div>
	</div>
<%@ include file="../common/common_js.jsp"%>

<script src="<%=request.getContextPath() %>/resources/ace/assets/js/jquery.dataTables.js"></script>
<script src="<%=request.getContextPath() %>/resources/ace/assets/js/jquery.dataTables.bootstrap.js"></script>

</body>
</html>