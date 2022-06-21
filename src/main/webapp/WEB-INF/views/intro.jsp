<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HappyHouse</title>
</head>
<body>

	<jsp:include page="Header.jsp"/>

<h3>&nbsp; 주택 실거래가 정보 제공</h3>

	<div class="container-fluid">
		<div class="card mb-4">
			<div class="card-header">사이트맵</div>
			<div class="card-body">
			
				<a href="${root }/index">메인화면</a> <hr>
				<a href="${root }/search">주택 실거래가조회</a> <hr>
				<a href="${root }/commercialSearch">관심지역 업종조회</a> <hr>
				<a href="${root }/pollution">관심지역 환경정보조회</a> <hr>
				<a href="${root}/board/list">회원정보 조회</a> <hr>
				<a href="${root}/board/list">비밀번호 찾기</a> <hr>
				<a href="${root}/board/list">회원가입</a> <hr>
			
			</div>
		</div>
	</div>
</body>
</html>