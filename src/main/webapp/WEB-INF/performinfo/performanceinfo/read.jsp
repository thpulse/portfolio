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
		
		<!-- ������ top -->
		<div class="row">
			<div class="col-sm-12 portfolio-filters wow fadeInLeft">
				<a href="/project_final/perform/prfinfo/select.do">��������</a> /
				<a>${prf.prfnm}</a>
			</div>
		</div>
		
		<br/>
		<br/>
		<br/>
		<!-- ������ ������ -->
		<div class="col-sm-6">
			<img style="height: 400px" src="${prf.poster}">
		</div>		
		<!-- ������ -->
		<div class="col-sm-4" style="background-color: #f4f4f4;">
			<ul class="list-group" style="background-color: #f4f4f4;">
				<li class="list-group-item" style="background-color: #f4f4f4;"><h4 style="padding:0px; margin:10px">${prf.prfnm}</h4></li>
				<li class="list-group-item" style="background-color: #f4f4f4;">�����Ⱓ: ${prf.prfpdfrom}~${prf.prfpdto}</li>
				<li class="list-group-item" style="background-color: #f4f4f4;">�����ð�: ${prf.prfdaytime}</li>
				<li class="list-group-item" style="background-color: #f4f4f4;">�������: <a href="/project_final/perform/prfplc/read.do?plcid=${prf.plcid}" style="color: #888888">${prf.plcnm}[������]</a></li>
				<li class="list-group-item" style="background-color: #f4f4f4;">�⿬��: ${prf.prfcast}</li>
				<li class="list-group-item" style="background-color: #f4f4f4;">������: ${prf.prfcrew}</li>
				<li class="list-group-item" style="background-color: #f4f4f4;">�����ð�: ${prf.prfruntime}</li>
				<li class="list-group-item" style="background-color: #f4f4f4;">��������: ${prf.prfage}</li>
				<li class="list-group-item" style="background-color: #f4f4f4;">Ƽ�ϰ���: ${prf.tckprice}</li>
			</ul>
		</div>
		<!-- �Ұ��̹��� -->
		<div class="col-sm-10 well">
		������������
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