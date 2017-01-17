<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="java.util.*,spring.data.mongodb.taehyung_test.*"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="/project_final/score/search">
		<h1>검색하기</h1>
		검색할 필드선택: <select name="field">
			<option value="name,is">성명</option>
			<option value="id,is">아이디</option>
			<option value="addr,is">주소</option>
			<option value="dept,is">부서</option>
			<option value="java,gt">java</option>
			<option value="spring,gt">spring</option>
			<option value="servlet,gt">servlet</option>
			<option value="bonus,gt">bonus</option>
		</select>
		<h3>검색값:</h3>
		<input type="text" name="value" />
		<input type="submit" value="검색"/>
	</form>
</body>
</html>










