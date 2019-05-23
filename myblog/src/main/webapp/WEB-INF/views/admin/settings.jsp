<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>设置 - myblog后台</title>
</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<%@include file="../frame/adminNav.jsp"%>
				<div class="tabbable" id="tabs-549813" style="margin-top: 75px">
				<ul class="nav nav-tabs">
					<li class="active">
						 <a href="#panel-480803" data-toggle="tab">个人设置</a>
					</li>
					<li>
						 <a href="#panel-917406" data-toggle="tab">站点设置</a>
					</li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane active" id="panel-480803">
						<h2>个人设置</h2>
						<form action="${ ctx }/admin/changeUserProfile" role="form">
							<div class="form-group">
					 			<label for="email1">修改电子邮箱</label>
					 			<input type="email" class="form-control" id="email" />
							</div>
							<button type="submit" class="btn btn-default">修改</button>
							<hr />
							<div class="form-group">
					 			<label for="email1">密码</label><br />
								<button id="changePassWord" class="btn btn-default">修改</button>
							</div>
						</form>
					</div>
					<div class="tab-pane" id="panel-917406">
						<form action="changeSiteSettings" role="form">
							<div class="form-group">
					 			<label for="email1">站点名称</label>
					 			<input type="text" class="form-control" id="welcomeWord" />
							</div>
							<div class="form-group">
					 			<label for="email1">欢迎文字</label>
					 			<input type="text" class="form-control" id="welcomeWord" />
							</div>
							<button type="submit" class="btn btn-default">修改</button>
						</form>
					</div>
				</div>
			</div>
			</div>
		</div>
	</div>	
</body>
</html>