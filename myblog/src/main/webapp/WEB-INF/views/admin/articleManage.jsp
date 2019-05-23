<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>文章管理 - myblog后台</title>
</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<%@include file="../frame/adminNav.jsp"%>
				<div class="row clearfix" style="margin-top: 75px">
					<div class="column">
						<div class="row">
							<div class="col-md-4">
								<h3>文章管理</h3>
							</div>
							<div class="col-md-2 pull-right">
								<a class="btn btn-primary btn-blog-save form-control" style="margin-top:20px" href="${ ctx }/admin/articleEdit">新建文章</a>
							</div>
						</div>
						<table class="table table-striped table-hover">
							<thead>
								<tr>
									<th>文章ID</th>
									<th>标题</th>
									<th>类型</th>
									<th>作者</th>
									<th>修改时间</th>
									<th>状态</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:choose>
									<c:when test="${empty article}">
										<span>无文章</span>
									</c:when>
									<c:otherwise>
										<c:forEach var="a" items="${ article }">
											<tr>
												<td>${ a.articleID }</td>
												<td>${ a.title }</td>
												<td>${ a.type.typeName }</td>
												<td>${ a.user.userName }</td>
												<td>
													<!-- 时间日期格式 --> 
													<fmt:formatDate value="${ a.updateTime }"
														pattern="yyyy-MM-dd hh:mm:ss" />
												</td>
												<td>${ a.status }</td>
												<td><a href="${ ctx }/admin/articleModify/${ a.articleID }">修改</a> <a href="${ ctx }/admin/articleDelete/${ a.articleID }" class="deleteArticle" onclick="return confirmDelete();"
													>删除</a></td>
											</tr>
										</c:forEach>
									</c:otherwise>
								</c:choose>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>