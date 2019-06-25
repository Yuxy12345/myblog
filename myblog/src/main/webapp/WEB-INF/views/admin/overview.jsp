<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>后台概览</title>
</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<%@include file="../frame/adminNav.jsp"%>
				<div class="row clearfix" style="margin: 70px">
					<h2>欢迎，${ sessionScope.user.userName }！</h2>
					<hr />
					<div class="col-md-6 column">
						<h2>最近文章</h2>
						<ul class="list-group">
							<c:forEach var="article" items="${ articles }">
								<a href="view-article/${ article.articleID }">
									<li class="list-group-item">
										<h2>${ article.title }</h2>
										<div class="row">
											<span class="col-md-6">时间： <fmt:formatDate
													value="${ article.updateTime }"
													pattern="yyyy-MM-dd hh:mm:ss" /></span> <span class="col-md-3">用户：${ article.user.userName }</span>
											<span class="col-md-3">类型：${ article.type.typeName }</span>
										</div>
										<p>${ article.content }</p>
									</li>
								</a>
							</c:forEach>
						</ul>
					</div>
					<div class="col-md-6 column">
						<h2>最近评论</h2>
						<ul class="list-group">
							<c:forEach var="comment" items="${ comments }">
								<li class="list-group-item">
									<h2>${ comment.article.title }</h2>
									<div class="row">
										<span class="col-md-6">时间： <fmt:formatDate
												value="${ comment.updateTime }"
												pattern="yyyy-MM-dd hh:mm:ss" /></span> <span class="col-md-3">用户：${ comment.user.userName }</span>
									</div>
									<p>${ comment.content }</p>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>