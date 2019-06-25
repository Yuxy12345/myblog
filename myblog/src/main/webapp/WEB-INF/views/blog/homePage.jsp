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
					<h1>
						欢迎，
						<c:choose>
							<c:when test="${empty sessionScope.user}">
								朋友！
							</c:when>
							<c:otherwise>
								${ sessionScope.user.userName }！
							</c:otherwise>
						</c:choose>
					</h1>
					<p>${ sessionScope.welcomeWord }</p>
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