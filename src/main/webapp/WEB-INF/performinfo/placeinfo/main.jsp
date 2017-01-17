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
	<div class="container">
		<br/>
		<br/>
		<br/>
		
		<p style="text-align:left">총 검색 건수: </p>
		<!-- 상세정보 테이블 -->
		<div class="col-sm-12">
			<table class="table">
				<!-- thead -->
				<tr>
					<td>공연시설(공연장)명</td>
					<td>공연장수</td>
					<td>객석수</td>
					<td>시설특성</td>
					<td>지역</td>
					<td>홈페이지</td>
				</tr>
				<c:forEach var="plc" items="${plclist}">
					<tr>
						<td><a style="color:#888888" href="/project_final/perform/prfplc/read.do?plcid=${plc.plcid}">${plc.plcnm}</a></td>
						<td>${plc.plcnum}</td>
						<td>${plc.seatscale}</td>
						<td>${plc.plcchar}</td>
						<td>${plc.sidonm}</td>
						<td><a href="${plc.relateurl}">LINK</a></td>
					</tr>
				</c:forEach>
			</table>		
		</div>
	</div>
</div>
</body>
</html>