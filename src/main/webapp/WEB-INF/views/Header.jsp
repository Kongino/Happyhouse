<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}"
	scope="session" />
<!DOCTYPE html>
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
	<div id="wrapper">
		<ul
			class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
			id="accordionSidebar">
			<a
				class="sidebar-brand d-flex align-items-center justify-content-center"
				href="${root }/index">
				<div class="sidebar-brand-icon">
					<img src="${root}/img/Home_Icon.svg" alt="logo" width="50px"
						height="50px" />
				</div>
				<div class="sidebar-brand-text mx-3">HappyHouse</div>
			</a>

			<!-- Divider -->
			<hr class="sidebar-divider" />

			<!-- Heading -->
			<div class="sidebar-heading">Menu</div>
			
			<!-- Nav Item - Utilities Collapse Menu -->
			<li class="nav-item"><a class="nav-link collapsed"
				href="${root }/intro"> <img class="mr-3"
					src="${root}/img/interest.svg" alt="" width="15px" height="15px" />
					<span>사이트 소개</span>
			</a></li>

			<!-- Nav Item - Pages Collapse Menu -->
			<li class="nav-item"><a class="nav-link collapsed"
				href="${root }/search"> <img class="mr-3"
					src="${root}/img/notice.svg" alt="" width="15px" height="15px" />
					<span>실거래가조회</span>
			</a></li>

			<!-- Nav Item - Utilities Collapse Menu -->
			<li class="nav-item"><a class="nav-link collapsed"
				href="${root }/commercialSearch"> <img class="mr-3"
					src="${root}/img/interest.svg" alt="" width="15px" height="15px" />
					<span>관심 지역 업종정보</span>
			</a></li>
			<li class="nav-item"><a class="nav-link collapsed"
				href="${root }/pollution"> <img class="mr-3"
					src="${root}/img/interest.svg" alt="" width="15px" height="15px" />
					<span>관심 지역 환경정보</span>
			</a></li>
			
			
			</a></li>
			<li class="nav-item"><a class="nav-link collapsed"
				href="${root}/board/list"> <img class="mr-3"
					src="${root}/img/interest.svg" alt="" width="15px" height="15px" />
					<span>공지 사항</span>
			</a></li>
			
			
		</ul>
		<div id="content-wrapper" class="d-flex flex-column">
			<!-- Main Content -->
			<div id="content">
				<!-- Topbar -->
				<nav
					class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
					<!-- Sidebar Toggle (Topbar) -->
					<button id="sidebarToggleTop"
						class="btn btn-link d-md-none rounded-circle mr-3">
						<i class="fa fa-bars"></i>
					</button>

					<!-- Topbar Navbar -->
					<ul class="navbar-nav ml-auto">
						<!-- Nav Item - User Information -->
						<li class="nav-item dropdown no-arrow"><a
							class="nav-link dropdown-toggle" href="#" id="userDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="true"> <c:choose>
									<c:when test="${userInfo != null}">
										<span id="user-name"
											class="mr-2 d-none d-lg-inline text-gray-600 small">
											${userInfo.name} </span>
									</c:when>
									<c:otherwise>
										<span id="user-name"
											class="mr-2 d-none d-lg-inline text-gray-600 small">
											Guest </span>
									</c:otherwise>
								</c:choose> <img class="img-profile rounded-circle"
								src="${root}/img/undraw_profile.svg" />
						</a> <!-- Dropdown - User Information --> <c:choose>
								<c:when test="${userInfo != null}">
									<div
										class="user-menu dropdown-menu dropdown-menu-right shadow animated--grow-in"
										aria-labelledby="userDropdown">
										<a class="dropdown-item" href="${root}/board/list">
											Profile/Logout </a>
											<!--  
										<div class="dropdown-divider"></div>
										<a class="dropdown-item" href="${root}/member/logout">
											Logout </a>
											-->
									</div>
								</c:when>
								<c:otherwise>
									<div
										class="user-menu dropdown-menu dropdown-menu-right shadow animated--grow-in"
										aria-labelledby="userDropdown">
										<a class="dropdown-item" href="${root}/board/list">
											Login </a>
									</div>
								</c:otherwise>
							</c:choose></li>
					</ul>
				</nav>
				<!-- End of Topbar -->



				<script
					src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
				<script src="${root}/js/index.js"></script>