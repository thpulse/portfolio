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
		
		<!-- ������ top -->
		<div class="col-sm-12 portfolio-filters wow fadeInLeft" style="padding:0px;">
			<a href="/project_final/perform/prfplc/index.do">�����庸��</a> /
			<a>${plc.plcnm}</a>
		</div>
		
		<br/>
		<br/>
		<br/>
		
		<!-- ������ ���̺� -->
		<div class="col-sm-12">
			<table class="table">
				<!-- thead -->
				<tr>
					<td style="width:300px; color:white; background-color: #aaaaaa;">�����ü�(������)��</td>
					<td style="width:700px">${plc.plcnm}</td>
					<td style="width:300px; color:white; background-color: #aaaaaa;">�ü�Ư��</td>
					<td style="width:700px">${plc.plcchar}</td>
				</tr>
				<tr>
					<td style="width:300px; color:white; background-color: #aaaaaa;">�������</td>
					<td style="width:700px">${plc.plcnum}</td>
					<td style="width:300px; color:white; background-color: #aaaaaa;">������</td>
					<td style="width:700px">${plc.seatscale}</td>
				</tr>
				<tr>
					<td style="width:300px; color:white; background-color: #aaaaaa;">��ȭ��ȣ</td>
					<td style="width:700px">${plc.tel}</td>
					<td style="width:300px; color:white; background-color: #aaaaaa;">Ȩ������</td>
					<td style="width:700px">${plc.relateurl}</td>
				</tr>
				<tr>
					<td style="width:300px; color:white; background-color: #aaaaaa;">�ּ�</td>
					<td style="width:700px">${plc.address}</td>
				</tr>
			</table>		
		</div>
	</div>
</div>

</body>
</html>