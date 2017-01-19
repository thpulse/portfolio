<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div class="portfolio-container">
	<div class="container-fluid">
		
		<p style="text-align:left">총 검색 건수: </p>
		<!-- 상세정보 테이블 -->
		<div class="col-sm-12">
			<table class="table table-hover">
				<!-- thead -->
				<thead>
					<tr>
					
						<td><h4 style="margin:0px">공연시설(공연장)명</h4></td>
						<td><h4 style="margin:0px">공연장수</h4></td>
						<td><h4 style="margin:0px">객석수</h4></td>
						<td><h4 style="margin:0px">시설특성</h4></td>
						<td><h4 style="margin:0px">지역</h4></td>
						<td><h4 style="margin:0px">홈페이지</h4></td>
					
					</tr>
				</thead>
				<tbody>
				<c:forEach var="plc" items="${plclist}">
					<tr>
						<td>
							<a style="color:#888888" href="/project_final/perform/prfplc/read.do?plcid=${plc.plcid}">${plc.plcnm}</a>
						</td>
						<td>${plc.plcnum}</td>
						<td>${plc.seatscale}</td>
						<td>${plc.plcchar}</td>
						<td>${plc.sidonm}</td>
						<td><a href="${plc.relateurl}">LINK</a></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>		
		</div>
	</div>
</div>
</body>
</html>