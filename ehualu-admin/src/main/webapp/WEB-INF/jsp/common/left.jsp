<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- #section:basics/sidebar -->
			<div id="sidebar" class="sidebar responsive">
				<ul class="nav nav-list">
					<!--<li class="active">
						<a href="#">
							<i class="menu-icon fa fa-desktop"></i>
							<span class="menu-text"> 查看首页 </span>
						</a>

						<b class="arrow"></b>
					</li>
					
					<li class="">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa glyphicon-user fa-eye"></i>
							<span class="menu-text">
								站内搜索
							</span>

							<b class="arrow fa fa-angle-down"></b>
						</a>

						<b class="arrow"></b>

						<ul class="submenu">
							<li class="">
								<a href="/fileIndex" target="mainFrame">
									<i class="menu-icon fa fa-caret-right"></i>
										索引初始化
									<b class="arrow fa fa-angle-down"></b>
								</a>
							</li>

							<li class="">
								<a href="/" target="mainFrame">
									<i class="menu-icon fa fa-caret-right"></i>
									去搜索
								</a>
								<b class="arrow"></b>
							</li>

						</ul>
					</li>  -->
					<c:if test="${isAdmin }">
					<li class="">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa glyphicon-user fa-users"></i>
							<span class="menu-text">
								用户管理
							</span>

							<b class="arrow fa fa-angle-down"></b>
						</a>

						<b class="arrow"></b>

						<ul class="submenu">
							<li class="">
								<a href="<%=request.getContextPath() %>/admin/user/users" target="mainFrame">
									<i class="menu-icon fa fa-caret-right"></i>
										用户信息管理
									<b class="arrow fa fa-angle-down"></b>
								</a>
							</li>

							<li class="">
								<a href="<%=request.getContextPath() %>/admin/group/groups" target="mainFrame">
									<i class="menu-icon fa fa-caret-right"></i>
									用户组管理
								</a>
								<b class="arrow"></b>
							</li>

							<li class="">
								<a href="<%=request.getContextPath() %>/admin/role/roles" target="mainFrame">
									<i class="menu-icon fa fa-caret-right"></i>
									用户角色管理
								</a>
								<b class="arrow"></b>
							</li>
						</ul>
					</li>
					</c:if>
					
					<c:if test="${isAdmin }">
					<li class="">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-pencil-square-o"></i>
							<span class="menu-text"> 信息发布管理 </span>

							<b class="arrow fa fa-angle-down"></b>
						</a>

						<b class="arrow"></b>

						<ul class="submenu">
							<li class="">
								<a href="<%=request.getContextPath() %>/admin/channel/channels" target="mainFrame">
									<i class="menu-icon fa fa-caret-right"></i>
									栏目管理
								</a>

								<b class="arrow"></b>
							</li>

							<li class="">
								<a href="<%=request.getContextPath() %>/admin/topic/audits" target="mainFrame">
									<i class="menu-icon fa fa-caret-right"></i>
									文章管理
								</a>

								<b class="arrow"></b>
							</li>
						</ul>
					</li>
					</c:if>
					
					<!--<c:if test="${isAdmin }">
					<li class="">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-cogs"></i>
							<span class="menu-text">系统设置 </span>

							<b class="arrow fa fa-angle-down"></b>
						</a>

						<b class="arrow"></b>

						<ul class="submenu">
							<li class="">
								<a href="/admin/dictionary/dictionarys/0" target="mainFrame">
									<i class="menu-icon fa fa-caret-right"></i>
									数据字典
								</a>

								<b class="arrow"></b>
							</li>
							
							<li class="">
								<a href="/admin/dept/depts/0" target="mainFrame">
									<i class="menu-icon fa fa-caret-right"></i>
									部门管理
								</a>

								<b class="arrow"></b>
							</li>
							
							<li class="">
								<a href="/admin/line/map" target="mainFrame">
									<i class="menu-icon fa fa-caret-right"></i>
									路线管理
								</a>

								<b class="arrow"></b>
							</li>
							
							<li class="">
								<a href="/druid" target="mainFrame">
									<i class="menu-icon fa fa-caret-right"></i>
									Druid Monitor(监听)
								</a>

								<b class="arrow"></b>
							</li>

							<li class="">
								<a href="/admin/system/baseinfo" target="mainFrame">
									<i class="menu-icon fa fa-caret-right"></i>
									网站信息管理
								</a>

								<b class="arrow"></b>
							</li>
						</ul>
					</li>
					</c:if>

					<li class="">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa glyphicon-user fa-book"></i>
							<span class="menu-text">
								日志管理
							</span>

							<b class="arrow fa fa-angle-down"></b>
						</a>

						<b class="arrow"></b>

						<ul class="submenu">
							<li class="">
								<a href="/admin/log/system/list" target="mainFrame">
									<i class="menu-icon fa fa-caret-right"></i>
										系统日志
									<b class="arrow fa fa-angle-down"></b>
								</a>
							</li>
						</ul>
					</li>-->
					<li class="">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa glyphicon-user fa-book"></i>
							<span class="menu-text">
								日志管理
							</span>

							<b class="arrow fa fa-angle-down"></b>
						</a>
						<b class="arrow"></b>
						<ul class="submenu">
							<li class="">
								<a href="<%=request.getContextPath() %>/admin/sms/smsRecords" target="mainFrame">
									<i class="menu-icon fa fa-caret-right"></i>
										短信发送日志
									<b class="arrow fa fa-angle-down"></b>
								</a>
							</li>
						</ul>
					</li>
					<li class="">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa glyphicon-user fa-bell"></i>
							<span class="menu-text">
								定时调度平台
							</span>

							<b class="arrow fa fa-angle-down"></b>
						</a>

						<b class="arrow"></b>

						<ul class="submenu">
							<li class="">
								<a href="<%=request.getContextPath() %>/admin/job/jobs" target="mainFrame">
									<i class="menu-icon fa fa-caret-right"></i>
										任务管理
									<b class="arrow fa fa-angle-down"></b>
								</a>
							</li>
						</ul>
					</li>
					
					<!--<li class="">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa glyphicon-user fa-leaf "></i>
							<span class="menu-text">
								ACE UI实例
							</span>

							<b class="arrow fa fa-angle-down"></b>
						</a>

						<b class="arrow"></b>

						<ul class="submenu">
							<li class="">
								<a href="#" class="dropdown-toggle">
									<i class="menu-icon fa fa-caret-right"></i>
										进入UI界面
									<b class="arrow fa fa-angle-down"></b>
								</a>
							</li>
						</ul>
					</li>-->
				</ul><!-- /.nav-list -->

				<!-- #section:basics/sidebar.layout.minimize -->
				<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
					<i class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
				</div>

				<!-- /section:basics/sidebar.layout.minimize -->
				<script type="text/javascript">
					try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
				</script>
			</div>