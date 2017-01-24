<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.net.URLEncoder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/earlyaccess/hanna.css" />
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<!-- Portfolio -->
	<div class="portfolio-container">
		<div class="container-fluid">
			
			<!-- 장르선택 -->
			<div class="col-sm-10 portfolio-filters wow fadeInLeft" style="padding:0px;">
				<a href="/project_final/perform/prfinfo/select2.do/0/all">All</a> / 
				<a href='/project_final/perform/prfinfo/select2.do/0/<%=URLEncoder.encode("연극","euc-kr") %>'>연극</a> / 
				<a href='/project_final/perform/prfinfo/select2.do/0/<%=URLEncoder.encode("뮤지컬","euc-kr") %>'>뮤지컬</a> /
				<a href='/project_final/perform/prfinfo/select2.do/0/<%=URLEncoder.encode("클래식","euc-kr") %>'>클래식</a> /
				<a href='/project_final/perform/prfinfo/select2.do/0/<%=URLEncoder.encode("오페라","euc-kr") %>'>오페라</a> /
				<a href='/project_final/perform/prfinfo/select2.do/0/<%=URLEncoder.encode("무용","euc-kr") %>'>무용</a> /
				<a href='/project_final/perform/prfinfo/select2.do/0/<%=URLEncoder.encode("발레","euc-kr") %>'>발레</a> /
				<a href='/project_final/perform/prfinfo/select2.do/0/<%=URLEncoder.encode("국악","euc-kr") %>'>국악</a> /
				<a href='/project_final/perform/prfinfo/select2.do/0/<%=URLEncoder.encode("복합","euc-kr") %>'>복합</a>
			</div><!-- #장르선택 -->
			
			<!-- 공연정보 -->
			<div class="row">
				<c:forEach var="prf" items="${prflist}">
				<div class="col-sm-3 portfolio-masonry" style="height: 400px;">
					<div class="portfolio-box web-design">
						<div>
							<a href="/project_final/perform/prfinfo/read.do?prfid=${prf.prfid}">
								<img src="${prf.poster}" alt="" data-at2x="${prf.poster}" style="max-height:200px">
							</a>
							<div class="portfolio-box-text">
								<h3><a href="/project_final/perform/prfinfo/read.do?prfid=${prf.prfid}">${prf.prfnm}</a></h3>
								<p>장르:${prf.genre}</p>
								<p>공연기간:${prf.prfpdfrom}~${prf.prfpdto}</p>
							</div>
						</div>
					</div>
				</div>
				</c:forEach>
			</div><!-- #공연정보 -->
		</div><!-- #container -->
		
		
		
		<!-- 페이징처리 -->
		<c:url var="firstUrl" value="/perform/prfinfo/select2.do/0/${genre}"/>
		<c:url var="lastUrl" value="/perform/prfinfo/select2.do/${totalPages-1}/${genre}"/>
		<c:url var="prevUrl" value="/perform/prfinfo/select2.do/${currentIndex - 2}/${genre}"/>
		<c:url var="nextUrl" value="/perform/prfinfo/select2.do/${currentIndex}/${genre}"/>
		
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
		            <c:url var="pageUrl" value="/perform/prfinfo/select2.do/${i-1}/${genre}" />
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
			
			
		</div>
		
	</div><!-- #portfolio-container -->
	
</body>
</html>