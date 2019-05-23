<%@page import="org.springframework.web.context.request.SessionScope"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>导航栏</title>
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
			<a class="navbar-brand" href="${ ctx }/home">myblog</a>
		</div>

		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active"><a href="${ ctx }/home">主页</a></li>
				<li><a href="${ ctx }/all_articles">所有文章</a></li>
			</ul>

			<ul class="nav navbar-nav navbar-right" style="margin-right: 20px">
				<li>
					<form class="navbar-form" action="${ ctx }/search" method="get" style="margin-right: 20px" role="search">
						<div class="form-group">
							<input id="searchWord" name="searchWord" type="text" class="form-control" placeholder="输入要搜索的文章" />
						</div>
						<button type="submit" class="btn btn-default">搜索</button>
					</form>
				</li>
				<c:choose>
					<c:when test="${empty sessionScope.user}">
						<li><a data-toggle="modal" href="javascript:void(0)"
							onclick="openLoginModal();">登录</a></li>
					</c:when>
					<c:otherwise>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">${sessionScope.user.userName }<strong
								class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li><a href="${ ctx }/admin">进入后台</a></li>
								<li class="divider"></li>
								<li><a id="logout" href="javascript:void(0)"
									onclick="logoutAjax()">退出登录</a></li>
							</ul></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</nav>
	<%@include file="../loginAndRegister/loginAndRegister.jsp"%>
</body>
</html>