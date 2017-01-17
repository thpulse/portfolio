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
		
		<p style="text-align:left">�� �˻� �Ǽ�: </p>
		<!-- ������ ���̺� -->
		<div class="col-sm-12">
			<table class="table">
				<!-- thead -->
				<tr>
					<td>�����ü�(������)��</td>
					<td>�������</td>
					<td>������</td>
					<td>�ü�Ư��</td>
					<td>����</td>
					<td>Ȩ������</td>
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