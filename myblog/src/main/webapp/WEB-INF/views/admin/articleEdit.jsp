<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新建文章 - myblog后台</title>
<link rel="stylesheet"
	href="${ ctx }/static/editor.md-master/css/editormd.min.css">
<script type="text/javascript"
	src="${ ctx }/static/editor.md-master/editormd.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<%@include file="../frame/adminNav.jsp" %>
			<h1 style="margin-top: 75px">新建文章</h1>
			<!-- 构造form表单，以便提交数据-->
			<form id="formBlog" method="post">
				<input id="blog_title" name="title" value="" style="display: none;"></input>
				<textarea id="blog_md" name="md" style="display: none;"></textarea>
			</form>
			<div class="row">
				<div class="panel panel-primary">
					<div class="page-header">
						<div class="panel-heading">
							<div class="row">
								<div class="col-md-6 col-md-offset-1 col-sm-3">
									<input type="text" class="form-control" id="art-head"
										name="art-head" placeholder="输入标题">
								</div>
								<div class="col-md-2">
                                <select id="typeSelect" name="typeList" class="form-control">
                                	<c:forEach var="type" items="${typeList}">
                                		<option value="${ type.typeID }" <c:if test="${typeSelect.typeID==type.typeID}"><c:out value="selected"/></c:if>>
                                		${type.typeName}
                                	</c:forEach>
                                </select>
                            </div>
								<div class="col-md-1 col-sm-1">
									<button class="btn btn-primary btn-blog-save form-control">保存</button>
								</div>
								<div class="col-md-1 col-sm-1">
									<button class="btn btn-success btn-blog-publish">提交内容</button>
								</div>
							</div>
						</div>
					</div>
					<div class="panel-body">
						<div class="row">
							<!-- md文件编辑器编辑区域 后续js中会使用到 -->
							<div id="blog_mdedit"></div>
						</div>
					</div>
				</div>
			</div>
			<script type="text/javascript" src="${ ctx }/static/js/articleEdit.js">
			</script>
		</div>
	</div>
</body>
</html>