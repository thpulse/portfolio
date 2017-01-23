<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div class="portfolio-container">
	<div class="container-fluid">
		
		<!-- ������ top -->
		<div class="col-sm-12 portfolio-filters wow fadeInLeft" style="padding:0px;">
			<a href="/project_final/perform/prfplc/index.do">�����庸��</a> /
			<a>${plc.plcnm}</a>
		</div>
		
		<br/>
		<br/>
		
		<!-- ������ ���̺� -->
		<div class="col-sm-12">
			<table class="table">
				<tr>
					<td style="width:300px; color:white; background-color: #aaaaaa;">�����ü�(������)��</td>
					<td style="width:800px">${plc.plcnm}</td>
					<td style="width:300px; color:white; background-color: #aaaaaa;">�ü�Ư��</td>
					<td style="width:800px">${plc.plcchar}</td>
				</tr>
				<tr>
					<td style="width:300px; color:white; background-color: #aaaaaa;">�������</td>
					<td style="width:800px">${plc.plcnum}</td>
					<td style="width:300px; color:white; background-color: #aaaaaa;">������</td>
					<td style="width:800px">${plc.seatscale}</td>
				</tr>
				<tr>
					<td style="width:300px; color:white; background-color: #aaaaaa;">��ȭ��ȣ</td>
					<td style="width:800px">${plc.tel}</td>
					<td style="width:300px; color:white; background-color: #aaaaaa;">Ȩ������</td>
					<td style="width:800px"><a href="${plc.relateurl}">${plc.relateurl}</a></td>
				</tr>
				<tr>
					<td style="width:300px; color:white; background-color: #aaaaaa;">�ּ�</td>
					<td style="width:800px">${plc.address}</td>
				</tr>
			</table>		
		</div>
		
		<br/>
		<br/>
		
		<!-- ���� ������ ���� -->
		<div class="col-sm-12 portfolio-filters wow fadeInLeft" style="padding:0px;">
			<br/>
			<br/>
			������(����)�� ����
		</div>
		<div class="col-sm-12">
			<table class="table">
				<tr>
					<td style="color:white; background-color: #aaaaaa;">�帣</td>
					<td style="color:white; background-color: #aaaaaa;">������</td>
					<td style="color:white; background-color: #aaaaaa;">������</td>
					<td style="color:white; background-color: #aaaaaa;">�����Ⱓ</td>
				</tr>
				<c:choose>
					<c:when test="${fn:length(latestprflist) eq 0}">
						<tr>
							<td colspan="4">������(����)�� ������ �����ϴ�.</td>
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
		
		<!-- ������ġ -->
		<div class="col-sm-10 portfolio-filters wow fadeInLeft" style="padding:0px;">
			������ ��ġ����
			<br/>
			<br/>
			<div id="map" style="width:100%;height:400px;"></div>

			<script type="text/javascript" src="//apis.daum.net/maps/maps3.js?apikey=cb58abff2e050d2fdbe00c5302666966"></script>
			<script>
			var mapContainer = document.getElementById('map'), // ������ ǥ���� div 
			    mapOption = { 
			        center: new daum.maps.LatLng(${plc.la}, ${plc.lo}), // ������ �߽���ǥ
			         // draggable: false, // ������ �����Ҷ� ���� �̵� �� Ȯ��/��Ҹ� �������� draggable: false �ɼ��� �߰��ϼ���
			        level: 4 // ������ Ȯ�� ����
			    };
			
			var map = new daum.maps.Map(mapContainer, mapOption); // ������ �����մϴ�
			
			//��Ŀ�� ǥ�õ� ��ġ�Դϴ� 
			var markerPosition  = new daum.maps.LatLng(${plc.la}, ${plc.lo}); 
			
			// ��Ŀ�� �����մϴ�
			var marker = new daum.maps.Marker({
			    position: markerPosition
			});
			// ��Ŀ�� ���� ���� ǥ�õǵ��� �����մϴ�
			marker.setMap(map);
			
			var iwContent = '<div style="padding:5px; width:150px; text-align:center;">${plc.plcnm}</div>';
			iwPosition = new daum.maps.LatLng(${plc.la}, ${plc.lo}); //���������� ǥ�� ��ġ�Դϴ�
			
			//���������츦 �����մϴ�
			var infowindow = new daum.maps.InfoWindow({
			position : iwPosition, 
			content : iwContent 
			});
			
			//��Ŀ ���� ���������츦 ǥ���մϴ�. �ι�° �Ķ������ marker�� �־����� ������ ���� ���� ǥ�õ˴ϴ�
			infowindow.open(map, marker);
			
			</script>
		</div>
		<div class="col-sm-10" style="text-align: left;">�� ������ Ȯ��, ��Ұ� �����մϴ�</div>
		
	</div>
</div>

</body>
</html>