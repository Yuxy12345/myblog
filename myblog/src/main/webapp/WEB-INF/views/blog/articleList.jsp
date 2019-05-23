<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>所有文章 - myblog</title>
</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<%@include file="../frame/navBar.jsp"%>
			</div>
		</div>
		<div class="row clearfix" style="margin-top: 80px">
			<h1>所有文章</h1>
			<ul class="list-group">
				<c:forEach var="article" items="${ Article }">
				<a href="view-article/${ article.articleID }">
					<li class="list-group-item">
						<h2>${ article.title }</h2>
						<div class="row">
							<span class="col-md-3">时间：
								<fmt:formatDate value="${ article.updateTime }"
									pattern="yyyy-MM-dd hh:mm:ss" /></span> 
							<span class="col-md-3">用户：${ article.user.userName }</span> 
							<span class="col-md-3">类型：${ article.type.typeName }</span>
						</div>
						<p>${ article.content }</p>
					</li>
				</a>
				</c:forEach>
			</ul>
		</div>
	</div>
</body>
</html>