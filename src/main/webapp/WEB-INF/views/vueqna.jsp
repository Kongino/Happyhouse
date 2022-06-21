
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="icon" href="/favicon.ico">
<title>vue-board</title>
<script defer="defer" type="module" src="${root }/js/chunk-vendors.a1a86d4f.js"></script>
<script defer="defer" type="module" src="${root }/js/app.948093cc.js"></script>
<link href="${root }/css/chunk-vendors.0833f3cd.css" rel="stylesheet">
<link href="${root }/css/app.2c08013a.css" rel="stylesheet">
<script defer="defer" src="${root }/js/chunk-vendors-legacy.1e7d9d7b.js"
	nomodule></script>
<script defer="defer" src="${root }/js/app-legacy.747721c0.js" nomodule></script>
</head>
<body>
	<jsp:include page="./Header.jsp" />
	<noscript>
		<strong>We're sorry but vue-board doesn't work properly
			without JavaScript enabled. Please enable it to continue.</strong>
	</noscript>
	<div id="app"></div>
</body>
</html>