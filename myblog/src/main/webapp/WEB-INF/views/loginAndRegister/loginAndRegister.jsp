<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- 
<a class="btn big-register"
	data-toggle="modal" href="javascript:void(0)"
	onclick="openRegisterModal();">注册</a>
-->

<link href="${ ctx }/static/css/login-register.css" rel="stylesheet" />
<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
<script src="${ ctx }/static/js/login-register.js"
	type="text/javascript"></script>

<div class="modal fade login" id="loginModal">
	<div class="modal-dialog login animated">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title">登录</h4>
			</div>
			<div class="modal-body">
				<div class="box">
					<div class="content">
						<div class="error"></div>
						<div class="form loginBox">
							<form method="post" action="/login" accept-charset="UTF-8">
								<input id="userName" class="form-control" type="text"
									placeholder="用户名" name="userName"> 
								<input id="passWord"
									class="form-control" type="password" placeholder="密码"
									name="passWord"> 
								<input
									class="btn btn-default btn-login" type="button" value="登录"
									onclick="loginAjax()">
							</form>
						</div>
					</div>
				</div>
				<div class="box">
					<div class="content registerBox" style="display: none;">
						<div class="form">
							<form method="post"
								accept-charset="UTF-8">
								<input id="userName-reg" class="form-control" type="text"
									placeholder="用户名" name="userName-reg">
								<input id="email" class="form-control" type="text"
									placeholder="Email" name="email"> <input id="passWord-reg"
									class="form-control" type="password" placeholder="密码"
									name="passWord-reg"> <input id="passWord_confirmation"
									class="form-control" type="password"
									placeholder="重复密码" name="passWord_confirmation">
								<input class="btn btn-default btn-register" type="button"
									value="创建账户" name="commit" onclick="regist()">
							</form>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<div class="forgot login-footer">
					<span>没有账户？<a href="javascript: showRegisterForm();">创建一个</a> ！
					</span>
				</div>
				<div class="forgot register-footer" style="display: none">
					<span>已经拥有账户？</span> <a
						href="javascript: showLoginForm();">去登录</a>
				</div>
			</div>
		</div>
	</div>
</div>