<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>ADMIN 메인페이지</h1>

	<div class="service wow fadeInUp">
		<!-- fa fa-eye" -->
		<div class="service-icon">
			<i class="fa fa-table"></i>
		</div>
		<h3>날씨 데이터 삽입</h3>
		<h3>( 마지막으로 삽입된 날짜 : ${last.days } )</h3>
	<a href="/project_final/stat/insert.do">stat 관객수 정보 삽입</a><br/>
	<a href="/project_final/stat/insert_complete.do">stat 테이블 최종 정보 삽입</a>

	</div>
	<br/>

</body>
</html>