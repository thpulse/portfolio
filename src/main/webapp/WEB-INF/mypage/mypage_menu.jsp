<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>
<div class="well" style="margin-top: 30px; background-color: white;">
	<br/>
	<h3>�� �� �� ��</h3>
	<hr/>
	<br/>
	<ul class="list-group">
		<sec:authorize access="isAuthenticated()">
		<li class="list-group-item">
			<a href="/project_final/mypageRcheck/list.do?userid=<sec:authentication property="principal.username"/>">���� ���� Ȯ��</a>
		</li>
		</sec:authorize>	
	</ul>
</div>
</body>
</html>