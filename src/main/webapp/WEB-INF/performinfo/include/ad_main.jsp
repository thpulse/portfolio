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
	<h1>ADMIN 메인페이지</h1>
	<h5>
		<a href="/project_final/perform/boxweekly/insert.do?genre=YK">박스오피스(연극-YK) Insert</a><br/>
		<a href="/project_final/perform/boxweekly/insert.do?genre=MU">박스오피스(뮤지컬-MU) Insert</a><br/>
		<a href="/project_final/perform/boxweekly/insert.do?genre=CCO">박스오피스(클래식/오페라 - CCO) Insert</a><br/>
		<a href="/project_final/perform/boxweekly/insert.do?genre=MMB">박스오피스(무용/발레 - MMB) Insert</a><br/>
		<a href="/project_final/perform/boxweekly/insert.do?genre=KKB">박스오피스(국악/복합 - KKB) Insert</a><br/>
	</h5>
	<!-- performance info db입력 -->
	<h3>공연정보 INSERT</h3>
	<h5>
		<a href="/project_final/perform/prfinfo/insert.do">공연 정보 모두 Insert</a>
	</h5>
	<!-- performance place info db입력 -->
	<h3>공연장 INSERT</h3>
	<h5>
		<a href="/project_final/perform/prfplc/insert.do">공연장 모두 Insert</a>
	</h5>
</body>
</html>