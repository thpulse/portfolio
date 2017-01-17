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
		
		<!-- 상세정보 top -->
		<div class="row">
			<div class="col-sm-12 portfolio-filters wow fadeInLeft">
				<a href="/project_final/perform/prfinfo/select.do">공연보기</a> /
				<a>${prf.prfnm}</a>
			</div>
		</div>
		
		<br/>
		<br/>
		<br/>
		<!-- 상세정보 포스터 -->
		<div class="col-sm-6">
			<img style="height: 400px" src="${prf.poster}">
		</div>		
		<!-- 상세정보 -->
		<div class="col-sm-4" style="background-color: #f4f4f4;">
			<ul class="list-group" style="background-color: #f4f4f4;">
				<li class="list-group-item" style="background-color: #f4f4f4;"><h4 style="padding:0px; margin:10px">${prf.prfnm}</h4></li>
				<li class="list-group-item" style="background-color: #f4f4f4;">공연기간: ${prf.prfpdfrom}~${prf.prfpdto}</li>
				<li class="list-group-item" style="background-color: #f4f4f4;">공연시간: ${prf.prfdaytime}</li>
				<li class="list-group-item" style="background-color: #f4f4f4;">공연장소: <a href="/project_final/perform/prfplc/read.do?plcid=${prf.plcid}" style="color: #888888">${prf.plcnm}[더보기]</a></li>
				<li class="list-group-item" style="background-color: #f4f4f4;">출연진: ${prf.prfcast}</li>
				<li class="list-group-item" style="background-color: #f4f4f4;">제작진: ${prf.prfcrew}</li>
				<li class="list-group-item" style="background-color: #f4f4f4;">관람시간: ${prf.prfruntime}</li>
				<li class="list-group-item" style="background-color: #f4f4f4;">관람연령: ${prf.prfage}</li>
				<li class="list-group-item" style="background-color: #f4f4f4;">티켓가격: ${prf.tckprice}</li>
			</ul>
		</div>
		<!-- 소개이미지 -->
		<div class="col-sm-10 well">
		공연상세정보▼
		</div>
		<div class="col-sm-10">
		${prf.story}
		</div>
		<div class="col-sm-10">
			<c:forEach var="sogaeimg" items="${sogaelist}">
				<img src="${sogaeimg.styurl}"/>
			</c:forEach>
		</div>
		
	</div>
</div>
</body>
</html>