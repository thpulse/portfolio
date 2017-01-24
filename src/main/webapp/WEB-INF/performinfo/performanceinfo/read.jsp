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
		
		<!-- ������ top -->
		<div class="col-sm-12 portfolio-filters wow fadeInLeft" style="padding:0px;">
			<a href="/project_final/perform/prfinfo/select.do">��������</a> /
			<a>${prf.prfnm}</a>
		</div>
		
		<br/>
		<br/>
		<br/>
		<!-- ������ ������ -->
		<div class="col-sm-5">
			<img style="height: 370px" src="${prf.poster}">
		</div>		
		<!-- ������ -->
		<div class="col-sm-5">
			<ul class="list-group">
				<li class="list-group-item"><h4 style="padding:0px; margin:10px">${prf.prfnm}</h4></li>
				<li class="list-group-item">�����Ⱓ: ${prf.prfpdfrom}~${prf.prfpdto}</li>
				<li class="list-group-item">�����ð�: ${prf.prfdaytime}</li>
				<li class="list-group-item">�������: ${prf.plcnm}<a href="/project_final/perform/prfplc/read.do?plcid=${prf.plcid}" style="color: #888888">[������]</a></li>
				<li class="list-group-item">�⿬��: ${prf.prfcast}</li>
				<li class="list-group-item">������: ${prf.prfcrew}</li>
				<li class="list-group-item">�����ð�: ${prf.prfruntime}</li>
				<li class="list-group-item">��������: ${prf.prfage}</li>
				<li class="list-group-item">Ƽ�ϰ���: ${prf.tckprice}</li>
			</ul>
		</div>
		<!-- �Ұ��̹��� -->
		<div class="col-sm-10 well">
		������������
		</div>
		<div class="col-sm-10">
		${prf.story}
		</div>
		<div class="col-sm-10">
			<c:forEach var="sogaeimg" items="${sogaelist}">
				<img src="${sogaeimg.styurl}"/>
			</c:forEach>
		</div>
		
		<!-- ���� ���� -->
		<div class="col-sm-10">
	        <br/>
	        <br/>
	        <br/>
		</div>
			
		<!-- ��� -->
		<div class="col-sm-10">
		 <table class="table">
		                   <thead>                  
                              <tr>
                                 <th style="text-align: center;">��ȣ</th>
                                 <th style="text-align: center;">���̵�</th>
                                 <th style="text-align: center;">����</th>
                                 <th style="text-align: center;">����</th>
                                 <th style="text-align: center;">��õ</th>
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
                             		<td><a href="/project_final/review/delete.do?revno=${review.revno}">����</a></td>
                                 </tr>
                                 
                              </c:forEach>
                              
                           </tbody>
                            
                        </table>
                        
                        <ul class="nav navbar-center">
			 				<li style="text-align: center;"><a href="/project_final/review/write.do?prf_id=${prf.prfid}">�۾���</a></li>
						</ul>
			</div>
	</div>
</div>
</body>
</html>
