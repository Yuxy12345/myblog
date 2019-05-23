<%@page import="org.springframework.web.context.request.SessionScope"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myblog - 后台管理</title>
</head>
<body>
	<nav class="navbar navbar-default navbar-inverse navbar-fixed-top"
		role="navigation">
		<div class="navbar-header" style="margin-left: 20px">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span
					class="icon-bar"></span><span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${ ctx }/admin">myblog后台管理</a>
		</div>

		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active"><a href="${ ctx }/admin">概要</a></li>
				<li><a href="${ ctx }/admin/article">文章管理</a></li>
				<li><a href="${ ctx }/admin/type">类型管理</a>
				<li><a href="${ ctx }/admin/comment">评论管理</a>
				<li><a href="${ ctx }/admin/user">用户管理</a>
				<li><a href="${ ctx }/admin/settings">设置</a>
			</ul>
			
			<%@include file="../loginAndRegister/loginAndRegister.jsp" %>
			<ul class="nav navbar-nav pull-right" style="margin-right: 20px"> 
				<c:choose>
					<c:when test="${empty sessionScope.user}">
						<li>
							<a href="#" data-toggle="modal" href="javascript:void(0)" onclick="openLoginModal();">登录</a>
						</li> 
						<script type="text/javascript">
							alert("您的登录信息失效，请重新登录！");
							showLoginForm();
						</script>
					</c:when>
					<c:otherwise>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">${sessionScope.user.userName }<strong
								class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li><a href="${ ctx }/home">返回前台</a></li>
								<li class="divider"></li>
								<li><a id="logout" href="javascript:void(0)"
									onclick="logoutAjax()">退出登录</a></li>
							</ul>
						</li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</nav>
</body>
</html>