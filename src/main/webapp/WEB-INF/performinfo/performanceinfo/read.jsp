<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/earlyaccess/hanna.css" />
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div class="portfolio-container">
	<div class="container-fluid">
		
		<!-- 상세정보 top -->
		<div class="col-sm-12 portfolio-filters wow fadeInLeft" style="padding:0px;">
			<a href="/project_final/perform/prfinfo/select.do">공연보기</a> /
			<a>${prf.prfnm}</a>
		</div>
		
		<br/>
		<br/>
		<br/>
		<!-- 상세정보 포스터 -->
		<div class="col-sm-5">
			<img style="height: 370px" src="${prf.poster}">
		</div>		
		<!-- 상세정보 -->
		<div class="col-sm-5">
			<ul class="list-group">
				<li class="list-group-item"><h4 style="padding:0px; margin:10px">${prf.prfnm}</h4></li>
				<li class="list-group-item">공연기간: ${prf.prfpdfrom}~${prf.prfpdto}</li>
				<li class="list-group-item">공연시간: ${prf.prfdaytime}</li>
				<li class="list-group-item">공연장소: ${prf.plcnm}<a href="/project_final/perform/prfplc/read.do?plcid=${prf.plcid}" style="color: #888888">[더보기]</a></li>
				<li class="list-group-item">출연진: ${prf.prfcast}</li>
				<li class="list-group-item">제작진: ${prf.prfcrew}</li>
				<li class="list-group-item">관람시간: ${prf.prfruntime}</li>
				<li class="list-group-item">관람연령: ${prf.prfage}</li>
				<li class="list-group-item">티켓가격: ${prf.tckprice}</li>
			</ul>
		</div>
		<!-- 소개이미지 -->
		<div class="col-sm-10 well">
		공연상세정보▼
		</div>
		<div class="col-sm-10">
		${prf.story}
		</div>
		<div class="col-sm-10">
			<c:forEach var="sogaeimg" items="${sogaelist}">
				<img src="${sogaeimg.styurl}"/>
			</c:forEach>
		</div>
		
		<!-- 띄어쓰기 공간 -->
		<div class="col-sm-10">
	        <br/>
	        <br/>
	        <br/>
		</div>
			
		<!-- 댓글 -->
		<div class="col-sm-10">
		 <table class="table">
		                   <thead>                  
                              <tr>
                                 <th style="text-align: center;">번호</th>
                                 <th style="text-align: center;">아이디</th>
                                 <th style="text-align: center;">내용</th>
                                 <th style="text-align: center;">별점</th>
                                 <th style="text-align: center;">추천</th>
							 </tr>
                           </thead>
                           <tbody>
                          
                              <c:forEach var="review" items="${reviewlist}">
                                 <tr>
                                    <td><a href="/project_final/review/read.do?revno=${review.revno}&action=READ">${review.revno}</a></td>
                                    <td>${review.mem_id}</td>
                                    <td>${review.revcomment}</td>                                
                             		<c:choose>
                             			<c:when test="${review.revgrade=='1'}">
                             				<td>★</td>
                             			</c:when>
                             			<c:when test="${review.revgrade=='2'}">
                             				<td>★★</td>
                             			</c:when>
                             			<c:when test="${review.revgrade=='3'}">
                             				<td>★★★</td>
                             			</c:when>
                             			<c:when test="${review.revgrade=='4'}">
                             				<td>★★★★</td>
                             			</c:when>
                             			<c:otherwise>
                             				<td>★★★★★</td>
                             			</c:otherwise>				
                             		</c:choose>
                             		
                             		<c:choose>
                             			<c:when test="${review.revgb==0}">
                             				<td>싫어요</td>
                             			</c:when>
                             			<c:otherwise>
                             				<td>좋아요</td>
                             			</c:otherwise>	
                             		</c:choose>
                             		<td><a href="/project_final/review/delete.do?revno=${review.revno}">삭제</a></td>
                                 </tr>
                                 
                              </c:forEach>
                              
                           </tbody>
                            
                        </table>
                        
                        <ul class="nav navbar-center">
			 				<li style="text-align: center;"><a href="/project_final/review/write.do?prf_id=${prf.prfid}">글쓰기</a></li>
						</ul>
			</div>
	</div>
</div>
</body>
</html>
