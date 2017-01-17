<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.net.URLEncoder"%>
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
				<div class="col-sm-10 portfolio-filters wow fadeInLeft">
					<a href="/project_final/perform/prfinfo/select.do">All</a> / 
					<a href='/project_final/perform/prfinfo/select.do?genre=<%=URLEncoder.encode("연극","euc-kr") %>'>연극</a> / 
					<a href='/project_final/perform/prfinfo/select.do?genre=<%=URLEncoder.encode("뮤지컬","euc-kr") %>'>뮤지컬</a> /
					<a href='/project_final/perform/prfinfo/select.do?genre=<%=URLEncoder.encode("클래식","euc-kr") %>'>클래식</a> /
					<a href='/project_final/perform/prfinfo/select.do?genre=<%=URLEncoder.encode("오페라","euc-kr") %>'>오페라</a> /
					<a href='/project_final/perform/prfinfo/select.do?genre=<%=URLEncoder.encode("무용","euc-kr") %>'>무용</a> /
					<a href='/project_final/perform/prfinfo/select.do?genre=<%=URLEncoder.encode("발레","euc-kr") %>'>발레</a> /
					<a href='/project_final/perform/prfinfo/select.do?genre=<%=URLEncoder.encode("국악","euc-kr") %>'>국악</a> /
					<a href='/project_final/perform/prfinfo/select.do?genre=<%=URLEncoder.encode("복합","euc-kr") %>'>복합</a>
				</div>
			</div><!-- #장르선택 -->
			
			<!-- 공연정보 -->
			<div class="row">
				<c:forEach var="prf" items="${prflist}">
				<div class="col-sm-3 portfolio-masonry" style="height: 400px;">
					<div class="portfolio-box web-design">
						<div class="portfolio-box-container">
							<a href="/project_final/perform/prfinfo/read.do?prfid=${prf.prfid}">
								<img src="${prf.poster}" alt="" data-at2x="${prf.poster}" style="max-height:200px">
							</a>
							<div class="portfolio-box-text">
								<h3><a href="/project_final/perform/prfinfo/read.do?prfid=${prf.prfid}">${prf.prfnm}</a></h3>
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