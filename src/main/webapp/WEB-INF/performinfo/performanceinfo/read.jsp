<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/earlyaccess/hanna.css" />
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<!-- 통계 CSS -->
    <link href="/project_final/assets/css2/style.css" rel="stylesheet">
    <script src="/project_final/assets/js/chart-master/Chart.js"></script>
<!-- 통계 CSS -->  
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
		                   	<td>
		                   	좋아요:${count1 } 싫어요:${count2 }
		                   	</td>                  
                              <tr>
                                 <th style="text-align: center;">내용</th>
                                 <th style="text-align: center;">작성자</th>
                                 <th style="text-align: center;">별점</th>
                                 <th style="text-align: center;">추천</th>
							 </tr>
                           </thead>
                           <tbody>
                          
                              <c:forEach var="review" items="${reviewlist}">
                                 <tr>
                                    <td>${review.revcomment}</td>
                                    <td>${review.mem_id}</td>                                
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

<div class="col-md-4 col-sm-4 mb">
	<div class="white-panel pn donut-chart">
		<div class="white-header">
			<h5>성별</h5>
       	</div>
		<div class="row">
			<span class="label label-primary">남자</span>
			<span class="label label-danger">여자</span>
			<canvas id="serverstatus01" height="120" width="120"></canvas>
	    </div>
		<script>
			var doughnutData = [
				{
					value: parseInt("${male}"),
					color:"#428bca"
				},
				{
					value : parseInt("${female}"),
					color : "#d9534f"
				}
			];
		var myDoughnut = new Chart(document.getElementById("serverstatus01").getContext("2d")).Doughnut(doughnutData);
		</script>
	</div>
</div>
<!-- 성별 통계 View -->

<!-- 나이 통계 View -->
<div class="col-md-4 col-sm-4 mb">
	<div class="white-panel pn donut-chart">
		<div class="white-header">
			<h5>나이</h5>
		</div>
		<div class="row">
			<span class="badge bg-success">10</span>
			<span class="badge bg-info">20</span>
			<span class="badge bg-inverse">30</span>
			<span class="badge bg-warning">40</span>  				
      		<canvas id="serverstatus02" height="120" width="120"></canvas>
      	</div>
	</div>
</div>
	<script>
 		var doughnutData2 = [
			{
				value :parseInt("${teens}"),
				color :"#a9d86e"
			},
			{
				value :parseInt("${twenty}"),
				color :"#41cac0"
			},
			{
				value :parseInt("${thirty}"),
				color :"#2a3542"
			},					
			{
				value :parseInt("${forty}"),
				color :"#fcb322"
			}
			];
		var myDoughnut2 = new Chart(document.getElementById("serverstatus02").getContext("2d")).Doughnut(doughnutData2);
	</script>



<!-- 통계 CSS -->
<script src="/project_final/assets/js/sparkline-chart.js"></script>    
<!-- 통계 CSS -->
</body>
</html>
