<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${ article.title } - myblog</title>
</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<%@include file="../frame/navBar.jsp"%>
			</div>
		</div>
		<div class="row clearfix" style="margin-top: 80px">
			<h2>${ article.title }</h2>
			<div class="row">
				<span class="col-md-3">时间： <fmt:formatDate
						value="${ article.updateTime }" pattern="yyyy-MM-dd hh:mm:ss" /></span>
				<span class="col-md-3">作者：${ article.user.userName }</span> <span
					class="col-md-3">类型：${ article.type.typeName }</span>
			</div>
			<div class="panel-body">
				<!-- 用于显示md编辑器的md格式 -->
				<div id="doc-content">
					<textarea style="display: none;">${article.content}</textarea>
				</div>
			</div>
		</div>
		<div class="row clearfix">
			<h3>评论</h3>
			<form method="post">
				<textarea id="content" rows="4" cols="30"></textarea>
				<input id="articleID" type="hidden" value="${ article.articleID }"/>
				<button class="btn btn-success" onclick="submitCommentAjax();">提交评论</button>
			</form>
			<c:choose>
				<c:when test="${empty comment}">
					<span>还没有评论呢，快来抢沙发！</span>
				</c:when>
				<c:otherwise>
					<c:forEach var="c" items="${ comment }">
						<div class="row">
							<div>
								<h4 style="display: inline-block;">${ c.user.userName }</h4>
								<span style="margin-left: 20px"><fmt:formatDate
									value="${ c.updateTime }" pattern="yyyy-MM-dd hh:mm:ss" /></span>
							</div>
							<span id="content">${ c.content }</span>
						</div>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	<c:import url="/WEB-INF/include/viewArticleDep.jsp"></c:import>
</body>
</html>