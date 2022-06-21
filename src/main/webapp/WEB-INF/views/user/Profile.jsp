<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}"
	scope="session" />
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<title>Profile</title>
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet" />

<link href="${root}/css/sb-admin-2.min.css" rel="stylesheet" />
</head>
<body id="page-top">
	<jsp:include page="../Header.jsp"></jsp:include>
	<!-- Begin Page Content -->
	<div class="container-fluid">
		<div class="card mb-4">
			<div class="card-header">Profile</div>
			<div class="card-body">
				<form id="profileform" method="post" action="">
					<input type="hidden" type="text" value="${userInfo.password }"
						id="pw" name="pw"> <span class="text">이름</span> <input
						id="name" name="name" type="text"
						class="form-control bg-light border-0 small"
						value="${userInfo.name}" /> <span class="text">ID</span> <input
						id="id" name="id" type="text"
						class="form-control bg-light border-0 small"
						value="${userInfo.id}" readonly /> <span class="text">Email</span>
					<input id="email" name="email" type="text"
						class="form-control bg-light border-0 small"
						value="${userInfo.email}" /> <span class="text">Address</span> <input
						id="address" name="address" type="text"
						class="form-control bg-light border-0 small"
						value="${userInfo.address}" /> <span class="text">Phone
						Number</span> <input id="phone" name="phone" type="text"
						class="form-control bg-light border-0 small"
						value="${userInfo.phone}" /> <span class="text text-danger">Password</span>
					<input id="password" name="password" type="password"
						class="form-control bg-light border-0 small mb-3" />
					<c:if test="${! empty msg}">
						<div class="text-danger">${msg}</div>
					</c:if>
					<button id="edit-profile-btn" class="btn btn-primary">
						<span class="text">수정</span>
					</button>
					<button id="remove-profile-btn" class="btn btn-danger">
						<span class="text">탈퇴</span>
					</button>
				</form>
			</div>
		</div>
	</div>
	<!-- /.container-fluid -->
	<jsp:include page="../Footer.jsp"></jsp:include>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>
		$(document)
				.ready(
						function() {
							$("#edit-profile-btn")
									.click(
											function() {
												console.log("하하");
												if (!$("#name").val()) {
													alert("이름을 입력하세요.")
													return;
												} else if (!$("#id").val()) {
													alert("아이디를 입력하세요.");
													return;
												} else if (!$("#email").val()) {
													alert("이메일을 입력하세요.");
													return;
												} else if (!$("#address").val()) {
													alert("주소를 입력하세요.");
													return;
												} else if (!$("#phone").val()) {
													alert("전화번호를 입력하세요.");
													return;
												} else if (!$("#password")
														.val()) {
													alert("비밀번호를 입력하세요.");
													return;
												} else {
													if ($("#pw").val() == $(
															"#password").val()) {
														$("#type")
																.val(
																		"updateProfile");
														$("#profileform")
																.attr("action",
																		"${root}/member/update")
																.submit();
													} else {
														alert("비밀번호가 틀렸습니다.");
														return;
													}
												}
											});
							$("#remove-profile-btn")
									.click(
											function() {
												if (!$("#password").val()) {
													alert("비밀번호를 입력하세요.");
													return;
												} else {
													if ($("#pw").val() == $(
															"#password").val()) {

														$("#type")
																.val(
																		"removeProfile");
														$("#profileform")
																.attr("action",
																		"${root}/member/delete")
																.submit();
													} else {
														alert("비밀번호가 틀렸습니다.");
														return;
													}
												}
											});
						});
	</script>
</body>
</html>
