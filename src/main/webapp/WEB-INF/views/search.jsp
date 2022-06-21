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
	document.addEventListener('keydown', function(event) {
	    if (event.keyCode === 13) {
	        event.preventDefault();
	    }
	}, true);
	$(function () {
		$('#search').click(function () {
			pagelist(1);
			var frmi = document.getElementById('frm');
			var dn = $('#dongCode > option:selected').attr("value2");
			document.getElementById("dongName").value=dn;
			frmi.submit();
		})
		$('#search2').click(function () {
			pagelist(1);
			var frmi = document.getElementById('frm');
			var dn = $('#dongCode > option:selected').attr("value2");
			document.getElementById("dongName").value=dn;
			frmi.submit();
		})
		<c:if test="${!empty param.key}">
		  $('#key').val("${param.key}")
		</c:if>
		  
		$('#word').val("${param.word}")
		$('#pageNo').val("${param.pageNo}")
		
		$('#minprice').val("${param.minprice}")
		$('#maxprice').val("${param.maxprice}")
		$('#userid').val("${param.userid}")
		
		<c:if test="${!empty param.sido}">
		$('#sido').val("${param.sido}")
		</c:if>
		
		<c:if test="${!empty param.gugun}">
		$('#gugun').val("${param.gugun}")
		</c:if>
		
		<c:if test="${!empty param.dongCode}">
		$('#dongCode').val("${param.dongCode}")
		</c:if>
		
		$('#sido').change(function(){
			pagelist(1);
		})
		$('#gugun').change(function(){
			pagelist(1);
		})
		$('#dongCode').change(function(){
			pagelist(1);
			var frmi = document.getElementById('frm');
			var dn = $('#dongCode > option:selected').attr("value2");
			document.getElementById("dongName").value=dn;
			frmi.submit();
		})
		
		$('#regInterest').click(function () {
			var frmi = document.getElementById('frm');
			var dn = $('#dongCode > option:selected').attr("value2");
			console.log(dn);
			document.getElementById("dongName").value=dn;
			
			document.getElementById("insertOn").value = "on";
			
			alert("관심지역 등록")
		})
		
		$('#delInterest').click(function () {
			var frmi = document.getElementById('frm');
			var dn = $('#dongCode > option:selected').attr("value2");
			console.log(dn);
			document.getElementById("dongName").value=dn;
			
			document.getElementById("deleteOn").value = "on";

			alert("관심지역 해제")
		})
		
	})
	
	function pagelist(cpage){
		var frm = document.getElementById('frm');
		var pageNo = document.getElementById('pageNo');
		pageNo.value=cpage;
		frm.action="search"
		frm.submit();
	}
</script>

	<jsp:include page="./Header.jsp" />
	<!-- End of Topbar -->

	<!-- Begin Page Content -->




	<div class="container-fluid">


		<div class="row">
			<div class="col-6">
				<div class="card mb-4">
					<div class="card-header">실거래가 조회</div>
					<div class="card-body">
						<form
							class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100"
							method='get' action='search' id="frm">

							<select id='sido' name='sido'
								class="form-control bg-light border-0 small">
								<option value='all'>------시/도 선택------</option>
								<c:if test="${!empty sidos}">
									<c:forEach var="sidov" items="${sidos}">
										<option>${sidov.getSidoName() }</option>

									</c:forEach>

								</c:if>

							</select> <select id='gugun' name='gugun'
								class="form-control bg-light border-0 small">
								<option value='all'>------구/군 선택------</option>
								<c:if test="${!empty guguns}">
									<c:forEach var="gugunv" items="${guguns}">
										<option>${gugunv.getGugunName() }</option>

									</c:forEach>

								</c:if>

							</select> <select id='dongCode' name='dongCode'
								class="form-control bg-light border-0 small">
								<option value='all'>------동 선택------</option>
								<c:if test="${!empty dongs}">
									<c:forEach var="dongv" items="${dongs}">
										<option value="${dongv.getDongCode() }"
											value2="${dongv.getDongName() }">${dongv.getDongName() }</option>

									</c:forEach>

								</c:if>

							</select>
							<c:if test="${userInfo != null}">
								<input type='hidden' name='userid' value="${userInfo.id }" />
								<input type='hidden' name='dongName' id='dongName' />
								<c:if test="${interestExist != null}">
									<c:if test="${interestExist == false }">
										<input type='hidden' name='insertOn' id='insertOn' value ="off"/>
										<button id="regInterest" class="btn btn-warning" type="submit">
											관심지역 등록</button>
									</c:if>

									<c:if test="${interestExist == true }">
										<input type='hidden' name='deleteOn' id='deleteOn' value ="off"/>
										<button id="delInterest" class="btn btn-warning" type="submit">
											관심지역 해제</button>
									</c:if>

								</c:if>
							</c:if>

							<hr>
							<div class="input-group">
								<input type='hidden' name='action' value='list' /> <select
									id='key' name='key'
									class="form-control bg-light border-0 small">
									<option value='all'>----선택하세요----</option>
									<option value='Aptname'>아파트이름</option>
								</select>
								<h>&nbsp&nbsp&nbsp&nbsp&nbsp</h>

								<input type='text' id='word' name='word'
									class="form-control bg-light border-0 small" /> <input
									type="hidden" id="pageNo" name="pageNo" value='1' />
								<div class="input-group-append">
									<button id="search" class="btn btn-warning" type="submit">
										<img src="./img/search.svg" alt="" width="20px" height="20px" />
									</button>
								</div>
							</div>
							<hr>
							<div class='input-group'>
								<p class="form-control border-0 small">거래 금액</p>
								<input type='text' id='minprice' name='minprice'
									class='form-control bg-light border-0 small' />
								<p class="form-control border-0 small" style="font-size: 12px;">만
									원 이상</p>
								<input type='text' id='maxprice' name='maxprice'
									class='form-control bg-light border-0 small' />
								<p class="form-control border-0 small" style="font-size: 12px;">만
									원 이하</p>
								<div class="input-group-append">
									<button id="search2" class="btn btn-warning" type="submit">
										<img src="./img/search.svg" alt="" width="20px" height="20px" />
									</button>
								</div>
							</div>
						</form>
						<hr>




						<div class="order_details_iner"
							style="width: 100%; height: 550px; overflow: auto">
							<table class="table table-active text-left">
								<thead>
									<tr>
										<td>아파트이름</td>
										<td>거래금액</td>
										<td>거래일</td>
										<td>주소</td>

									</tr>

								</thead>

								<tbody>
									<c:if test="${!empty apts}">
										<c:forEach var="apt" items="${apts}">
											<tr>
												<td><a href="javascript:;"><p
															onclick="Print(`${apt}`, `${apt.getLat() }`, `${apt.getLng() }`, `${apt.getAptName() }`)">${apt.getAptName() }</p></a></td>
												<td>${apt.getDealAmount() }</td>
												<td>${apt.getDealYear() }.${apt.getDealMonth() }.${apt.getDealDay() }</td>
												<td>${apt.getRoadName() }</td>

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
				<div id="map" style="width: 100%; height: 850px;"></div>
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
			<div class="card-header">상세 정보</div>
			<div id="detailInfo" class="card-body"></div>
		</div>
	</div>
	</div>
	</div>


	<script type="text/javascript">
	function Print(name, lat, lng, Aname){
		
		var pr = `<p style="font-size : 15px">`+name+`</p>` 
		

		        var coords = new kakao.maps.LatLng(lat, lng);

		        // 결과값으로 받은 위치를 마커로 표시합니다
		        var marker = new kakao.maps.Marker({
		            map: map,
		            position: coords
		        });

		        // 인포윈도우로 장소에 대한 설명을 표시합니다
		        var infowindow = new kakao.maps.InfoWindow({
		            content: '<div style="width:150px;text-align:center;padding:6px 0;">'+Aname+'</div>'
		        });
		        infowindow.open(map, marker);

		        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
		        map.setCenter(coords);

		
		$('#detailInfo').empty().append(pr);
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
