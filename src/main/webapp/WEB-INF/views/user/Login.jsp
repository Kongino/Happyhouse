<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!doctype html>
<html lang="">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="icon" href="/favicon.ico">
<title>test</title>
<script defer="defer" type="module" src="${root}/js/chunk-vendors.78d194e6.js"></script>
<script defer="defer" type="module" src="${root}/js/app.781f22d2.js"></script>
<link href="${root}/css/chunk-vendors.6516fab7.css" rel="stylesheet">
<link href="${root}/css/app.bd071c00.css" rel="stylesheet">
<script defer="defer" src="${root}/js/chunk-vendors-legacy.65003d49.js"
	nomodule></script>
<script defer="defer" src="${root}/js/app-legacy.fab13b78.js" nomodule></script>
</head>
<body>
	<jsp:include page="../Header.jsp"/>
	<noscript>
		<strong>We're sorry but test doesn't work properly without
			JavaScript enabled. Please enable it to continue.</strong>
	</noscript>
	<div id="app"></div>
</body>
</html>