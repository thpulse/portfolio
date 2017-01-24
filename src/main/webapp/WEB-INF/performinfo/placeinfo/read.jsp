<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/earlyaccess/hanna.css" />
</head>
<body>
<div class="portfolio-container">
	<div class="container-fluid">
		
		<!-- 상세정보 top -->
		<div class="col-sm-12 portfolio-filters wow fadeInLeft" style="padding:0px;">
			<a href="/project_final/perform/prfplc/index.do">공연장보기</a> /
			<a>${plc.plcnm}</a>
		</div>
		
		<br/>
		<br/>
		
		<!-- 상세정보 테이블 -->
		<div class="col-sm-12">
			<table class="table">
				<tr>
					<td style="width:300px; color:white; background-color: #aaaaaa;">공연시설(공연장)명</td>
					<td style="width:800px">${plc.plcnm}</td>
					<td style="width:300px; color:white; background-color: #aaaaaa;">시설특성</td>
					<td style="width:800px">${plc.plcchar}</td>
				</tr>
				<tr>
					<td style="width:300px; color:white; background-color: #aaaaaa;">공연장수</td>
					<td style="width:800px">${plc.plcnum}</td>
					<td style="width:300px; color:white; background-color: #aaaaaa;">객석수</td>
					<td style="width:800px">${plc.seatscale}</td>
				</tr>
				<tr>
					<td style="width:300px; color:white; background-color: #aaaaaa;">전화번호</td>
					<td style="width:800px">${plc.tel}</td>
					<td style="width:300px; color:white; background-color: #aaaaaa;">홈페이지</td>
					<td style="width:800px"><a href="${plc.relateurl}">${plc.relateurl}</a></td>
				</tr>
				<tr>
					<td style="width:300px; color:white; background-color: #aaaaaa;">주소</td>
					<td style="width:800px">${plc.address}</td>
				</tr>
			</table>		
		</div>
		
		<br/>
		<br/>
		
		<!-- 현재 상영중인 공연 -->
		<div class="col-sm-12 portfolio-filters wow fadeInLeft" style="padding:0px;">
			<br/>
			<br/>
			공연중(예정)인 공연
		</div>
		<div class="col-sm-12">
			<table class="table">
				<tr>
					<td style="color:white; background-color: #aaaaaa;">장르</td>
					<td style="color:white; background-color: #aaaaaa;">포스터</td>
					<td style="color:white; background-color: #aaaaaa;">공연명</td>
					<td style="color:white; background-color: #aaaaaa;">공연기간</td>
				</tr>
				<c:choose>
					<c:when test="${fn:length(latestprflist) eq 0}">
						<tr>
							<td colspan="4">공연중(예정)인 공연이 없습니다.</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="prf" items="${latestprflist}" varStatus="status">
							<tr>
								<td>${prf.genre}</td>
								<td><a href="/project_final/perform/prfinfo/read.do?prfid=${prf.prfid}" style="color: #888888 !important">
									<img src="${prf.poster}" alt="" data-at2x="${prf.poster}" style="max-height:100px">
								</a></td>
								<td><a href="/project_final/perform/prfinfo/read.do?prfid=${prf.prfid}">${prf.prfnm}</a></td>
								<td>${prf.prfpdfrom}~${prf.prfpdto}</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</table>
		</div>
		
		<br/>
		<br/>
		
		<!-- 지도위치 -->
		<div class="col-sm-10 portfolio-filters wow fadeInLeft" style="padding:0px;">
			공연장 위치보기
			<br/>
			<br/>
			<div id="map" style="width:100%;height:400px;"></div>

			<script type="text/javascript" src="//apis.daum.net/maps/maps3.js?apikey=cb58abff2e050d2fdbe00c5302666966"></script>
			<script>
			var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
			    mapOption = { 
			        center: new daum.maps.LatLng(${plc.la}, ${plc.lo}), // 지도의 중심좌표
			         // draggable: false, // 지도를 생성할때 지도 이동 및 확대/축소를 막으려면 draggable: false 옵션을 추가하세요
			        level: 4 // 지도의 확대 레벨
			    };
			
			var map = new daum.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
			
			//마커가 표시될 위치입니다 
			var markerPosition  = new daum.maps.LatLng(${plc.la}, ${plc.lo}); 
			
			// 마커를 생성합니다
			var marker = new daum.maps.Marker({
			    position: markerPosition
			});
			// 마커가 지도 위에 표시되도록 설정합니다
			marker.setMap(map);
			
			var iwContent = '<div style="padding:5px; width:150px; text-align:center;">${plc.plcnm}</div>';
			iwPosition = new daum.maps.LatLng(${plc.la}, ${plc.lo}); //인포윈도우 표시 위치입니다
			
			//인포윈도우를 생성합니다
			var infowindow = new daum.maps.InfoWindow({
			position : iwPosition, 
			content : iwContent 
			});
			
			//마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
			infowindow.open(map, marker);
			
			</script>
		</div>
		<div class="col-sm-10" style="text-align: left;">※ 지도는 확대, 축소가 가능합니다</div>
		
	</div>
</div>

</body>
</html>