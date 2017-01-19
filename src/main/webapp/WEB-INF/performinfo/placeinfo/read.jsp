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
		
		<!-- 상세정보 top -->
		<div class="col-sm-12 portfolio-filters wow fadeInLeft" style="padding:0px;">
			<a href="/project_final/perform/prfplc/index.do">공연장보기</a> /
			<a>${plc.plcnm}</a>
		</div>
		
		<br/>
		<br/>
		<br/>
		
		<!-- 상세정보 테이블 -->
		<div class="col-sm-12">
			<table class="table">
				<!-- thead -->
				<tr>
					<td style="width:300px; color:white; background-color: #aaaaaa;">공연시설(공연장)명</td>
					<td style="width:700px">${plc.plcnm}</td>
					<td style="width:300px; color:white; background-color: #aaaaaa;">시설특성</td>
					<td style="width:700px">${plc.plcchar}</td>
				</tr>
				<tr>
					<td style="width:300px; color:white; background-color: #aaaaaa;">공연장수</td>
					<td style="width:700px">${plc.plcnum}</td>
					<td style="width:300px; color:white; background-color: #aaaaaa;">객석수</td>
					<td style="width:700px">${plc.seatscale}</td>
				</tr>
				<tr>
					<td style="width:300px; color:white; background-color: #aaaaaa;">전화번호</td>
					<td style="width:700px">${plc.tel}</td>
					<td style="width:300px; color:white; background-color: #aaaaaa;">홈페이지</td>
					<td style="width:700px">${plc.relateurl}</td>
				</tr>
				<tr>
					<td style="width:300px; color:white; background-color: #aaaaaa;">주소</td>
					<td style="width:700px">${plc.address}</td>
				</tr>
			</table>		
		</div>
	</div>
</div>

</body>
</html>