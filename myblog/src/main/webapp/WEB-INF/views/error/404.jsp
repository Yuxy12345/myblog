<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>页面未找到 - myblog</title>
</head>
<body>
	<div>
		<img src="${ ctx }/static/image/404.png" style="width: 100%" />
		<script type="text/javascript">
			$(function() {
				setInterval(ChangeTime, 2000);
			});

			function ChangeTime() {
				// var time;
				// time = $("#time").text();
				// time = parseInt(time);
				// time--;
				// if (time <= 0) {
				window.location.href = context + "home";
				// } else {
				// 	$("#time").text(time);
				// }
			}
		</script>
	</div>
</body>
</html>