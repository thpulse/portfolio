<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">
var aaa = function(revno) {
 	var String1 = $('#write_id').val();
 	var String2 = $('#login_id').val();
	var String3 = "racer";
	var prfid = $('#prfid').val();
		if (String1 == String2 && String2 == String3) {
		location.href="/project_final/review/delete.do?revno="+revno+"&prfid="+prfid
	} else {
		alert("�۾��̰� �ƴմϴ�.")
	} 
}
	</script>
	<div class="portfolio-container">
		<div class="container-fluid">

			<!-- ������ top -->
			<div class="col-sm-12 portfolio-filters wow fadeInLeft"
				style="padding: 0px;">
				<a href="/project_final/perform/prfinfo/select.do">��������</a> <a>${prf.prfnm}</a>
			</div>

			<br /> <br /> <br />
			<!-- ������ ������ -->
			<div class="col-sm-5">
				<img style="height: 400px" src="${prf.poster}">
			</div>
			<!-- ������ -->
			<div class="col-sm-5" style="background-color: #f4f4f4;">
				<ul class="list-group" style="background-color: #f4f4f4;">
					<li class="list-group-item" style="background-color: #f4f4f4;"><h4
							style="padding: 0px; margin: 10px">${prf.prfnm}</h4></li>
					<li class="list-group-item" style="background-color: #f4f4f4;">�����Ⱓ:
						${prf.prfpdfrom}~${prf.prfpdto}</li>
					<li class="list-group-item" style="background-color: #f4f4f4;">�����ð�:
						${prf.prfdaytime}</li>
					<li class="list-group-item" style="background-color: #f4f4f4;">�������:
						${prf.plcnm}<a
						href="/project_final/perform/prfplc/read.do?plcid=${prf.plcid}"
						style="color: #888888">[������]</a>
					</li>
					<li class="list-group-item" style="background-color: #f4f4f4;">�⿬��:
						${prf.prfcast}</li>
					<li class="list-group-item" style="background-color: #f4f4f4;">������:
						${prf.prfcrew}</li>
					<li class="list-group-item" style="background-color: #f4f4f4;">�����ð�:
						${prf.prfruntime}</li>
					<li class="list-group-item" style="background-color: #f4f4f4;">��������:
						${prf.prfage}</li>
					<li class="list-group-item" style="background-color: #f4f4f4;">Ƽ�ϰ���:
						${prf.tckprice}</li>
				</ul>
			</div>
			<!-- �Ұ��̹��� -->
			<div class="col-sm-10 well">������������</div>
			<div class="col-sm-10">${prf.story}</div>
			<div class="col-sm-10">
				<c:forEach var="sogaeimg" items="${sogaelist}">
					<img src="${sogaeimg.styurl}" />
				</c:forEach>
			</div>

			<!-- ��� -->
			<table class="table">
				<thead>
					<td>���ƿ�:${count1 } �Ⱦ��:${count2 }</td>
					<tr>
						<th>����</th>
						<th>��ȣ</th>
						<th>���̵�</th>
						<th>����</th>
						<th>����</th>
						<th>��õ</th>
					</tr>
				</thead>
				<tbody>

	<c:forEach var="review" items="${reviewlist}">				
						<tr>
							<td>${review.prf_id}</td>
							<td>${review.revno}</td>
							<td>${review.mem_id}</td>
							<td>${review.revcomment}</td>
							<c:choose>
								<c:when test="${review.revgrade=='1'}">
									<td>��</td>
								</c:when>
								<c:when test="${review.revgrade=='2'}">
									<td>�ڡ�</td>
								</c:when>
								<c:when test="${review.revgrade=='3'}">
									<td>�ڡڡ�</td>
								</c:when>
								<c:when test="${review.revgrade=='4'}">
									<td>�ڡڡڡ�</td>
								</c:when>
								<c:otherwise>
									<td>�ڡڡڡڡ�</td>
								</c:otherwise>
							</c:choose>

							<c:choose>
								<c:when test="${review.revgb==0}">
									<td>�Ⱦ��</td>
								</c:when>
								<c:otherwise>
									<td>���ƿ�</td>
								</c:otherwise>
							</c:choose>
							<td><a href="javascript:aaa('${review.revno }')" >����</a></td>
							<td><input type="hidden" value="<sec:authentication property="principal.username"/>" id="login_id" /></td>
							<td><input type="hidden" value="${review.mem_id}" id="write_id" /></td>
							<td><input type="hidden" value="${review.prf_id}" id="prfid" /></td>
						</tr>
						</c:forEach>
				</tbody>
			</table>
			<ul class="nav navbar-nav navbar-center">
				<li><a
					href="/project_final/review/write.do?prf_id=${prf.prfid}"
					style="text-align: center;">�۾���</a></li>
			</ul>

		</div>
	</div>
</body>
</html>
