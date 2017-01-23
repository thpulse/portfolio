<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
			<a href="/project_final/perform/prfinfo/select.do">��������</a> /
			<a>${prf.prfnm}</a>
		</div>
		
		<br/>
		<br/>
		<br/>
		<!-- ������ ������ -->
		<div class="col-sm-5">
			<img style="height: 400px" src="${prf.poster}">
		</div>		
		<!-- ������ -->
		<div class="col-sm-5" style="background-color: #f4f4f4;">
			<ul class="list-group" style="background-color: #f4f4f4;">
				<li class="list-group-item" style="background-color: #f4f4f4;"><h4 style="padding:0px; margin:10px">${prf.prfnm}</h4></li>
				<li class="list-group-item" style="background-color: #f4f4f4;">�����Ⱓ: ${prf.prfpdfrom}~${prf.prfpdto}</li>
				<li class="list-group-item" style="background-color: #f4f4f4;">�����ð�: ${prf.prfdaytime}</li>
				<li class="list-group-item" style="background-color: #f4f4f4;">�������: ${prf.plcnm}<a href="/project_final/perform/prfplc/read.do?plcid=${prf.plcid}" style="color: #888888">[������]</a></li>
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