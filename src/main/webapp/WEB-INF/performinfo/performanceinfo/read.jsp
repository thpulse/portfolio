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
		alert("글쓴이가 아닙니다.")
	} 
}
	</script>
	<div class="portfolio-container">
		<div class="container-fluid">

			<!-- 상세정보 top -->
			<div class="col-sm-12 portfolio-filters wow fadeInLeft"
				style="padding: 0px;">
				<a href="/project_final/perform/prfinfo/select.do">공연보기</a> <a>${prf.prfnm}</a>
			</div>

			<br /> <br /> <br />
			<!-- 상세정보 포스터 -->
			<div class="col-sm-5">
				<img style="height: 400px" src="${prf.poster}">
			</div>
			<!-- 상세정보 -->
			<div class="col-sm-5" style="background-color: #f4f4f4;">
				<ul class="list-group" style="background-color: #f4f4f4;">
					<li class="list-group-item" style="background-color: #f4f4f4;"><h4
							style="padding: 0px; margin: 10px">${prf.prfnm}</h4></li>
					<li class="list-group-item" style="background-color: #f4f4f4;">공연기간:
						${prf.prfpdfrom}~${prf.prfpdto}</li>
					<li class="list-group-item" style="background-color: #f4f4f4;">공연시간:
						${prf.prfdaytime}</li>
					<li class="list-group-item" style="background-color: #f4f4f4;">공연장소:
						${prf.plcnm}<a
						href="/project_final/perform/prfplc/read.do?plcid=${prf.plcid}"
						style="color: #888888">[더보기]</a>
					</li>
					<li class="list-group-item" style="background-color: #f4f4f4;">출연진:
						${prf.prfcast}</li>
					<li class="list-group-item" style="background-color: #f4f4f4;">제작진:
						${prf.prfcrew}</li>
					<li class="list-group-item" style="background-color: #f4f4f4;">관람시간:
						${prf.prfruntime}</li>
					<li class="list-group-item" style="background-color: #f4f4f4;">관람연령:
						${prf.prfage}</li>
					<li class="list-group-item" style="background-color: #f4f4f4;">티켓가격:
						${prf.tckprice}</li>
				</ul>
			</div>
			<!-- 소개이미지 -->
			<div class="col-sm-10 well">공연상세정보▼</div>
			<div class="col-sm-10">${prf.story}</div>
			<div class="col-sm-10">
				<c:forEach var="sogaeimg" items="${sogaelist}">
					<img src="${sogaeimg.styurl}" />
				</c:forEach>
			</div>

			<!-- 댓글 -->
			<table class="table">
				<thead>
					<td>좋아요:${count1 } 싫어요:${count2 }</td>
					<tr>
						<th>제목</th>
						<th>번호</th>
						<th>아이디</th>
						<th>내용</th>
						<th>별점</th>
						<th>추천</th>
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
							<td><a href="javascript:aaa('${review.revno }')" >삭제</a></td>
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
					style="text-align: center;">글쓰기</a></li>
			</ul>

		</div>
	</div>
</body>
</html>
