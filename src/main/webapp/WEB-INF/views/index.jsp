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




            <div class="row align-items-center">
            <div class="col-6">
            <img src="./img/banner.png" style="width:90%">
            </div>
            
                <div class="col-6">
                
                    <div class="banner_text">
                        <div class="banner_text_iner">
                            <h1 style="font-size:100px; color:black">Happy House</h1>
                            <p style="font-size:20px">원하는 지역의 주택 실거래가를 조회하세요</p>
                            <p style="font-size:20px">평소에 관심 있던 지역을 등록하시고</p>
                            <p style="font-size:20px">관심 지역의 환경 정보와 주변 상권 정보도 조회해 보세요</p>
                            <p></p>
                            <a href="${root }/search" class="btn btn-warning btn-lg">자세히 보기</a>
                            
                        </div>
                    </div>
                </div>

        </div>
<h3></h3>
</body>
</html>