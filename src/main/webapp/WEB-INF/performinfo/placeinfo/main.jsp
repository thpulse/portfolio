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
		
		<!-- ����Ʈ ���̺� -->
		<div class="col-sm-12">
			<table class="table table-hover">
				<!-- thead -->
				<thead>
					<tr>
					
						<td style="background-color: #aaaaaa; color:white;">�����ü�(������)��</td>
						<td style="background-color: #aaaaaa; color:white;">�������</td>
						<td style="background-color: #aaaaaa; color:white;">������</td>
						<td style="background-color: #aaaaaa; color:white;">�ü�Ư��</td>
						<td style="background-color: #aaaaaa; color:white;">����</td>
						<td style="background-color: #aaaaaa; color:white;">Ȩ������</td>
					
					</tr>
				</thead>
				<tbody>
				<c:forEach var="plc" items="${plclist}">
					<tr>
						<td>
							<a style="color:#888888" href="/project_final/perform/prfplc/read.do?plcid=${plc.plcid}">${plc.plcnm}</a>
						</td>
						<td>${plc.plcnum}</td>
						<td>${plc.seatscale}</td>
						<td>${plc.plcchar}</td>
						<td>${plc.sidonm}</td>
						<td><a href="${plc.relateurl}">LINK</a></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>		
		</div>
	</div>
	
	<!-- ����¡ó�� -->
	<c:url var="firstUrl" value="/perform/prfplc/select.do/0/${genre}"/>
	<c:url var="lastUrl" value="/perform/prfplc/select.do/${totalPages-1}/${genre}"/>
	<c:url var="prevUrl" value="/perform/prfplc/select.do/${currentIndex - 2}/${genre}"/>
	<c:url var="nextUrl" value="/perform/prfplc/select.do/${currentIndex}/${genre}"/>
	
	<div class="container-fluid">
		<ul class="pagination">
	        <c:choose>
	            <c:when test="${currentIndex == 1}">
	                <li class="disabled"><a href="#">&lt;&lt;</a></li>
	                <li class="disabled"><a href="#">&lt;</a></li>
	            </c:when>
	            <c:otherwise>
	                <li><a href="${firstUrl}">&lt;&lt;</a></li>
	                <li><a href="${prevUrl}">&lt;</a></li>
	            </c:otherwise>
	        </c:choose>
	        <c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
	            <c:url var="pageUrl" value="/perform/prfplc/select.do/${i-1}/${genre}" />
	            <c:choose>
	                <c:when test="${i == currentIndex}">
	                    <li class="active"><a href="${pageUrl}"><c:out value="${i}"/></a></li>
	                </c:when>
	                <c:otherwise>
		                    <li><a href="${pageUrl}"><c:out value="${i}" /></a></li>
	                </c:otherwise>
	            </c:choose>
	        </c:forEach>
	        <c:choose>
	            <c:when test="${currentIndex == totalPages}">
	                <li class="disabled"><a href="#">&gt;</a></li>
	                <li class="disabled"><a href="#">&gt;&gt;</a></li>
	            </c:when>
	            <c:otherwise>
	                <li><a href="${nextUrl}">&gt;</a></li>
	                <li><a href="${lastUrl}">&gt;&gt;</a></li>
	            </c:otherwise>
	        </c:choose>
	    </ul>
		
		
	</div><!-- #����¡ ó�� -->
</div>
</body>
</html>