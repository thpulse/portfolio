<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/earlyaccess/hanna.css" />
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">
/* 	$(document).ready(function(){
		$("#selectform1").change(function() {
			$.ajax({
				url:"/project_final/perform/prfplc/select2.do/${currentIndex}",
				type:"get",
				data:{"sido_Val" : $("#selectform1 option:selected").val()},
				success:function(sidolist){
					alert(sidolist.length)
				}
			});
		});
	});
	function after_sido(txt) {
		var gungu_val = txt.gungu_json_list;	
		var plc_val = txt.gungu_plc_list;
		var plcId_val = txt.gungu_plcId_list;
		
		var gungu_length = gungu_val.length;	
		var plc_val_length = plc_val.length;	
		//select box 초기화
		$("#selectform2").find("option").remove();
		for(i = 0; i < gungu_length; i++){
			var gungu = gungu_val[i];
			$("#selectform2").append("<option value="+gungu+">"+ gungu +"</option>");
		}			
		$("#selectform3").find("option").remove();
		for(i = 0; i < plc_val_length; i++){
			var plc = plc_val[i];
			var plcId = plcId_val[i];
			$("#selectform3").append("<option value="+plcId+">"+ plc +"</option>");
		}
	} */
</script>
</head>
<body>
<div class="portfolio-container">
	<div class="container-fluid">
		<!-- 공연장소 검색 -->
		<div class="col-sm-12" style="text-align:right;">
				<h5>
					지역별 공연장 검색 : 
					<select class="w3-select" name="tel" id = "selectform1" size= "1">
						<option value="11">시/도 선택</option>
						<option value="11">서울</option>
						<option value="41">경기</option>
						<option value="26">부산</option>
						<option value="27">대구</option>
						<option value="28">인천</option>
						<option value="29">광주</option>
						<option value="30">대전</option>
						<option value="31">울산</option>
						<option value="36">세종시</option>
						<option value="42">강원도</option>
						<option value="43">충청북도</option>
						<option value="44">충청남도</option>
						<option value="45">전라북도</option>
						<option value="46">전라남도</option>
						<option value="47">경상북도</option>
						<option value="48">경상남도</option>
						<option value="50">제주특별자치도</option>
					</select>
					<select class="w3-select" name="tel2" id = "selectform2" size = "1">
						<option value="default">시/군/구 선택</option>
					</select>
				</h5>
   		</div>
   		<div class="col-sm-12" style="text-align:right;">
   			직접 검색 : <input type="text" style="height:28px;"> <input type="button" value="검색">
   		</div>
   		<br/>
   		<hr/>
   		<br/>
   		<br/>
		<!-- 리스트 테이블 -->
		<div class="col-sm-12">
			<table class="table table-hover">
				<!-- thead -->
				<thead>
					<tr>
					
						<td style="background-color: #aaaaaa; color:white;">공연시설(공연장)명</td>
						<td style="background-color: #aaaaaa; color:white;">공연장수</td>
						<td style="background-color: #aaaaaa; color:white;">객석수</td>
						<td style="background-color: #aaaaaa; color:white;">시설특성</td>
						<td style="background-color: #aaaaaa; color:white;">지역</td>
						<td style="background-color: #aaaaaa; color:white;">홈페이지</td>
					
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
	
	<!-- 페이징처리 -->
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
		
		
	</div><!-- #페이징 처리 -->
</div>
</body>
</html>