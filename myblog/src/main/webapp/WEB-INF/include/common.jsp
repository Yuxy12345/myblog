<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!-- 定义ctx -->
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
	var context = "${ctx}/";
</script>

<!DOCTYPE html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="apple-mobile-web-app-capable" content="yes" />

<!-- 引用bootstrap -->
<link rel="stylesheet" href="${ ctx }/static/css/bootstrap.min.css" />
<script src="${ ctx }/static/js/jquery.min.js"></script>
<script src="${ ctx }/static/js/bootstrap.min.js"></script>

