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

	<!-- Portfolio -->
	<div class="portfolio-container">
		<div class="container">
			
			<!-- 장르선택 -->
			<div class="row">
				<div class="col-sm-12 portfolio-filters wow fadeInLeft">
					<a href="/project_final/perform/prfinfo/select.do">All</a> / 
					<a href="/project_final/perform/prfinfo/select.do?genre=YK">연극</a> / 
					<a href="/project_final/perform/prfinfo/select.do?genre=MU">뮤지컬</a> / 
					<a href="/project_final/perform/prfinfo/select.do?genre=CCO">클래식,오페라</a>
					<a href="/project_final/perform/prfinfo/select.do?genre=MMB">무용,발레</a> /
					<a href="/project_final/perform/prfinfo/select.do?genre=KKB">국악,복합</a>
				</div><!-- #장르선택 -->
			</div>
			
			<!-- 공연정보 -->
			<div class="row">
				<c:forEach var="prf" items="#{prflist}">
				<div class="col-sm-3 portfolio-masonry">
					<div class="portfolio-box web-design">
						<div class="portfolio-box-container">
							<img src="${prf.poster}" alt="" data-at2x="${prf.poster}" style="max-height:200px">
							<div class="portfolio-box-text">
								<h3>${prf.prfnm}</h3>
								<p>장르:${prf.genre}</p>
								<p>공연기간:${prf.prfpdfrom}~${prf.prfpdto}</p>
								<p></p>
							</div>
						</div>
					</div>
				</div>
				</c:forEach>
			</div><!-- #공연정보 -->
			
		</div><!-- #container -->
	</div><!-- #portfolio-container -->
	
</body>
</html>