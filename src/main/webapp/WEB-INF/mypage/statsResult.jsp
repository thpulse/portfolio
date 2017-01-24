<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<!-- ��� CSS -->
    <link href="/project_final/assets/css2/style.css" rel="stylesheet">
    <script src="/project_final/assets/js/chart-master/Chart.js"></script>
<!-- ��� CSS -->    
</head>
<body>
<!-- ��� View -->
<!-- ���� ��� View -->
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