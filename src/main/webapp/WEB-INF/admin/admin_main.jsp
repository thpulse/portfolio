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
	<h1>ADMIN ����������</h1>

	<div class="service wow fadeInUp">
		<!-- fa fa-eye" -->
		<div class="service-icon">
			<i class="fa fa-table"></i>
		</div>
		<h3>���� ������ ����</h3>
		<h3>( ���������� ���Ե� ��¥ : ${last.days } )</h3>
	<a href="/project_final/stat/insert.do">stat ������ ���� ����</a><br/>
	<a href="/project_final/stat/insert_complete.do">stat ���̺� ���� ���� ����</a>

	</div>
	<br/>

</body>
</html>