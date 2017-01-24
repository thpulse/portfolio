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
<!-- ��� CSS -->
    <link href="/project_final/assets/css2/style.css" rel="stylesheet">
    <script src="/project_final/assets/js/chart-master/Chart.js"></script>
<!-- ��� CSS -->  
</head>
<body>
<div class="portfolio-container">
	<div class="container-fluid">
		
		<!-- ������ top -->
		<div class="col-sm-12 portfolio-filters wow fadeInLeft" style="padding:0px;">
			<a href="/project_final/perform/prfinfo/select.do">��������</a>
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
		                   	<td>
		                   	���ƿ�:${count1 } �Ⱦ��:${count2 }
		                   	</td>                  
                              <tr>
                                 <th style="text-align: center;">����</th>
                                 <th style="text-align: center;">�ۼ���</th>
                                 <th style="text-align: center;">����</th>
                                 <th style="text-align: center;">��õ</th>
							 </tr>
                           </thead>
                           <tbody>
                          
                              <c:forEach var="review" items="${reviewlist}">
                                 <tr>
                                    <td>${review.revcomment}</td>
                                    <td>${review.mem_id}</td>                                
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

<div class="col-md-4 col-sm-4 mb">
	<div class="white-panel pn donut-chart">
		<div class="white-header">
			<h5>����</h5>
       	</div>
		<div class="row">
			<span class="label label-primary">����</span>
			<span class="label label-danger">����</span>
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
<!-- ���� ��� View -->

<!-- ���� ��� View -->
<div class="col-md-4 col-sm-4 mb">
	<div class="white-panel pn donut-chart">
		<div class="white-header">
			<h5>����</h5>
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



<!-- ��� CSS -->
<script src="/project_final/assets/js/sparkline-chart.js"></script>    
<!-- ��� CSS -->
</body>
</html>
