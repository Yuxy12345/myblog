<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页 - myblog</title>
</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<!-- 加入导航条 -->
				<%@include file="../frame/navBar.jsp" %>
				
				<div class="jumbotron" style="margin-top: 80px">
					<h1>欢迎，朋友！</h1>
					<p>This is a template for a simple marketing or informational
						website. It includes a large callout called the hero unit and
						three supporting pieces of content. Use it as a starting point to
						create something more unique.</p>
					<p>
						<a class="btn btn-primary btn-large" href="#">Learn more</a>
					</p>
				</div>
			</div>
		</div>
		<div class="row clearfix">
			<h2>推荐文章</h2>
			<c:forEach var="article" items="${Article}">
				<div class="col-md-4 column">
					<h2>${ article.title }</h2>
					<p>${ article.content }</p>
					<p>
						<a class="btn" href="view-article/${ article.articleID }">查看全文 »</a>
					</p>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>