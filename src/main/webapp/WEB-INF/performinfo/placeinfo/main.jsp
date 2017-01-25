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
		//select box �ʱ�ȭ
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
		<!-- ������� �˻� -->
		<div class="col-sm-12" style="text-align:right;">
				<h5>
					������ ������ �˻� : 
					<select class="w3-select" name="tel" id = "selectform1" size= "1">
						<option value="11">��/�� ����</option>
						<option value="11">����</option>
						<option value="41">���</option>
						<option value="26">�λ�</option>
						<option value="27">�뱸</option>
						<option value="28">��õ</option>
						<option value="29">����</option>
						<option value="30">����</option>
						<option value="31">���</option>
						<option value="36">������</option>
						<option value="42">������</option>
						<option value="43">��û�ϵ�</option>
						<option value="44">��û����</option>
						<option value="45">����ϵ�</option>
						<option value="46">���󳲵�</option>
						<option value="47">���ϵ�</option>
						<option value="48">��󳲵�</option>
						<option value="50">����Ư����ġ��</option>
					</select>
					<select class="w3-select" name="tel2" id = "selectform2" size = "1">
						<option value="default">��/��/�� ����</option>
					</select>
				</h5>
   		</div>
   		<div class="col-sm-12" style="text-align:right;">
   			���� �˻� : <input type="text" style="height:28px;"> <input type="button" value="�˻�">
   		</div>
   		<br/>
   		<hr/>
   		<br/>
   		<br/>
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