<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户管理 - myblog后台</title>
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
								<h3>用户管理</h3>
							</div>
							<div class="col-md-2 pull-right">
								<a class="btn btn-primary btn-blog-save form-control" style="margin-top:20px" href="${ ctx }/admin/intoAddUser">添加用户</a>
							</div>
						</div>
						<table class="table table-striped table-hover">
							<thead>
								<tr>
									<th>用户ID</th>
									<th>用户名</th>
									<th>邮箱</th>
									<th>用户类型</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:choose>
									<c:when test="${empty user}">
										<span>无用户</span>
									</c:when>
									<c:otherwise>
										<c:forEach var="u" items="${ user }">
											<tr>
												<td>${ u.userID }</td>
												<td>${ u.userName }</td>
												<td>${ u.email }</td>
												<td>${ u.userType }</td>
												<td><a href="${ ctx }/admin/articleDelete/${ a.articleID }" class="deleteArticle" onclick="return confirmDelete();"
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