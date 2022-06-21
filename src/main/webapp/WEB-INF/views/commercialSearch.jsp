<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<title>HappyHouse</title>
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet" />

<link href="css/sb-admin-2.min.css" rel="stylesheet" />
</head>
<body id="page-top">


	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script type="text/javascript">
	$(function () {
		
		<c:if test="${userInfo == null}">
		  alert("로그인 해주세요")
		  location.href="index"
		</c:if>
		$('#commercialSearch').click(function () {
			pagelist(1);
		})
		<c:if test="${!empty param.key}">
		  $('#key').val("${param.key}")
		</c:if>
		$('#word').val("${param.word}")
		$('#pageNo').val("${param.pageNo}")
		
		<c:if test="${!empty param.sido}">
		$('#sido').val("${param.sido}")
		</c:if>
		
		<c:if test="${!empty param.gugun}">
		$('#gugun').val("${param.gugun}")
		</c:if>
		
		<c:if test="${!empty param.dongName}">
		$('#dongName').val("${param.dongName}")
		</c:if>
		
		$('#sido').change(function(){
			var frmi = document.getElementById('frminter');
			frmi.action="interestcom"
			frmi.submit();
		})
		$('#gugun').change(function(){
			var frmi = document.getElementById('frminter');
			frmi.action="interestcom"
			frmi.submit();
		})
		$('#dongName').change(function(){
			var frmi = document.getElementById('frminter');
			frmi.action="interestcom"
			frmi.submit();
		})
		
		$('#interestSubmit').click(function () {
			var frmi = document.getElementById('frminter');
			frmi.action="interestcom/insert"
			frmi.submit();
		})
		
		$('#interestSearch').click(function () {
			var frmi = document.getElementById('frminter');
			frmi.action="interestcom/search"
			frmi.submit();
		})
	})
	
	function interSearch(sido, gugun, dong){
		var str = sido+" "+gugun+" "+dong
		
		 $('#key').val("Dongname")
	
		$('#word').val(str)
		
		pagelist(1);
	}
	
	function pagelist(cpage){
		var frm = document.getElementById('frm');
		var pageNo = document.getElementById('pageNo');
		pageNo.value=cpage;
		frm.action="commercialSearch"
		frm.submit();
	}
</script>

	<jsp:include page="./Header.jsp" />
	<!-- End of Topbar -->

	<!-- Begin Page Content -->




	<div class="container-fluid">


		<div class="row">

			<div class="col-12">
				<div class="card mb-4">
					<div class="card-header">관심지역</div>

					<div class="card-body">
						<form
							class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100"
							method='get' action='interest' id="frminter">

							<select id='sido' name='sido'
								class="form-control bg-light border-0 small">
								<option value='all'>--------시/도 선택--------</option>
								<c:if test="${!empty sidos}">
									<c:forEach var="sidov" items="${sidos}">
										<option>${sidov.getSidoName() }</option>

									</c:forEach>

								</c:if>

							</select> <select id='gugun' name='gugun'
								class="form-control bg-light border-0 small">
								<option value='all'>--------구/군 선택--------</option>
								<c:if test="${!empty guguns}">
									<c:forEach var="gugunv" items="${guguns}">
										<option>${gugunv.getGugunName() }</option>

									</c:forEach>

								</c:if>

							</select> <select id='dongName' name='dongName'
								class="form-control bg-light border-0 small">
								<option value='all'>--------동 선택--------</option>
								<c:if test="${!empty dongs}">
									<c:forEach var="dongv" items="${dongs}">
										<option>${dongv.getDongName() }</option>

									</c:forEach>

								</c:if>

							</select> <input type='hidden' name='userid' value="${userInfo.id }" />
							
															<c:if test="${interestExist != null}">
									<c:if test="${interestExist == false }">
							<button id="interestSubmit" class="btn btn-warning" type="submit">
								등록</button>
								</c:if>
								</c:if>



						</form>

<hr>
						<div class="order_details_iner"
							style="width: 100%; height: 550px; overflow: auto">
							<table class="table table-active text-left">
								<thead>
									<tr>
										<td>주소</td>
										<td></td>

									</tr>

								</thead>

								<tbody>
									<c:if test="${!empty interests}">
										<c:forEach var="interest" items="${interests}">
										<c:if test = "${interest.getUserid() == userInfo.id }">
											<tr>
												<td><a href = "javascript:;"><p onclick='interSearch("${interest.getSido() }", "${interest.getGugun() }", "${interest.getDongname() }")'>
												${interest.getSido() } ${interest.getGugun() } ${interest.getDongname() }</p></a></td>
												
												<td><a href = "interestcom/delete?no=${interest.getNo() }">삭제</a></td>
															
											</tr>
										</c:if>
										</c:forEach>

									</c:if>

								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>



			<div class="col-6">
				<div class="card mb-4">
					<div class="card-header">관심지역 업종정보 조회</div>
					<div class="card-body">
						<form
							class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100"
							method='get' action='commercialSearch' id="frm">
							
									<div class="input-group">
									<input type='hidden' name='key' id='key' />
								<input type='hidden' name='action' value='list' /> <input type='text' id='word' name='word'
									class="form-control bg-light border-0 small" /> <input
									type="hidden" id="pageNo" name="pageNo" value='1' />
								<div class="input-group-append">

								</div>
							</div>

						</form>
						<hr>
						<div class="order_details_iner"
							style="width: 100%; height: 550px; overflow: auto">
							
							<input
									type="hidden" id="pageNo" name="pageNo" value='1' />
							<table class="table table-active text-left">
								<thead>
									<tr>
										<td>이름</td>
										<td>업종분류</td>
										<td>주소</td>

									</tr>

								</thead>

								<tbody>
									<c:if test="${!empty commercials}">
										<c:forEach var="commercial" items="${commercials}">
											<tr>
												<td><a href="javascript:;"><p
															onclick='Print("${commercial}", "${commercial.getLat() }", "${commercial.getLng() }", "${commercial.getShopname()}", "${commercial.getLocalname()}")'>${commercial.getShopname()}
															${commercial.getLocalname() }</p></a></td>
												<td>${commercial.getCodename3() }</td>
												<td>${commercial.getAddress()}</td>

											</tr>
										</c:forEach>

									</c:if>

								</tbody>
							</table>
						</div>



						<div id="pagination-container">${pageBean.pageLink}</div>


					</div>
				</div>
			</div>
			<!-- asdafasdasd -->
			<div class="col-6">
				<div id="map" style="width: 100%; height: 770px;"></div>
			</div>
			<script type="text/javascript"
				src="//dapi.kakao.com/v2/maps/sdk.js?appkey=066af963f56b72087d9971b98c3e0690&libraries=services"></script>
			<script type="text/javascript">
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

// 지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 


// 주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();

// 주소로 좌표를 검색합니다
geocoder.addressSearch('', function(result, status) {

    // 정상적으로 검색이 완료됐으면 
     if (status === kakao.maps.services.Status.OK) {

        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new kakao.maps.Marker({
            map: map,
            position: coords
        });

        // 인포윈도우로 장소에 대한 설명을 표시합니다
        var infowindow = new kakao.maps.InfoWindow({
            content: '<div style="width:150px;text-align:center;padding:6px 0;">우리회사</div>'
        });
        infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    } 
});    
</script>

		</div>

	</div>
	</div>
	<div class="col-6">
		<div class="card mb-4">
			<div class="card-header">통계</div>
			<div id="detailInfo" class="card-body">
				<p style="font-size: 15px">소매 : ${statistics.getD()}</p>
				<p style="font-size: 15px">음식 : ${statistics.getQ()}</p>
				<p style="font-size: 15px">학문/교육 : ${statistics.getR()}</p>
				<p style="font-size: 15px">생활서비스 : ${statistics.getF()}</p>
				<p style="font-size: 15px">의료 : ${statistics.getS()}</p>
				<p style="font-size: 15px">관광/여가/오락 : ${statistics.getN()}</p>
				<p style="font-size: 15px">부동산 : ${statistics.getL()}</p>
				<p style="font-size: 15px">숙박 : ${statistics.getO()}</p>
				<p style="font-size: 15px">스포츠 : ${statistics.getP()}</p>
			</div>
		</div>
	</div>
	</div>
	</div>



	<script type="text/javascript">
	function Print(name, lat, lng, Aname, Bname){
		
		var pr = `<p style="font-size : 15px">`+name+`</p>` 
		

		        var coords = new kakao.maps.LatLng(lat, lng);

		        // 결과값으로 받은 위치를 마커로 표시합니다
		        var marker = new kakao.maps.Marker({
		            map: map,
		            position: coords
		        });

		        // 인포윈도우로 장소에 대한 설명을 표시합니다
		        var infowindow = new kakao.maps.InfoWindow({
		            content: '<div style="width:150px;text-align:center;padding:6px 0;">'+Aname+Bname+'</div>'
		        });
		        infowindow.open(map, marker);

		        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
		        map.setCenter(coords);

		
	}


</script>




	<!-- /.container-fluid -->
	</div>
	<!-- End of Main Content -->


	<!-- Footer -->
	<footer class="sticky-footer bg-white">
		<div class="container my-auto">
			<div class="copyright text-center my-auto">
				<span>Copyright &copy; SSAFY 16</span>
			</div>
		</div>
	</footer>
	<!-- End of Footer -->
	</div>
	<!-- End of Content Wrapper -->
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</body>
</html>
