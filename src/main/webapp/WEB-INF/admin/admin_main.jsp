<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>ADMIN ����������</h1>

	<div class="service wow fadeInUp">
		<!-- fa fa-eye" -->
		<div class="service-icon">
			<i class="fa fa-table"></i>
		</div>
		<h3>��¥����</h3>
		<h3>( ���������� ���Ե� ��¥ : 2017�� 01�� 07�� )</h3>
		<form role="form" action="/project_final/weather/insert.do" method="post" name="insert_form">
			<div class="form-group">
				<p>
					<!-- ���������� ���Ե� ������ ��¥ ���ýÿ� alert -->
					<select class="selectpicker" id="year" name="year" data-size="5">
						<option value="default">���� ����</option>
						<option value="2017">2017��</option>
						<option value="2016">2016��</option>
						<option value="2015">2015��</option>
						<option value="2014">2014��</option>
						<option value="2013">2013��</option>
						<option value="2012">2012��</option>
						<option value="2011">2011��</option>
						<option value="2010">2010��</option>
						<option value="2009">2009��</option>
						<option value="2008">2008��</option>
						<option value="2007">2007��</option>
						<option value="2006">2006��</option>
						<option value="2005">2005��</option>
						<option value="2004">2004��</option>
						<option value="2003">2003��</option>
						<option value="2002">2002��</option>
					</select> 
					<select class="selectpicker" id="month" name="month" data-size="5">
						<option value="default">�� ����</option>
						<option value="1">1��</option>
						<option value="2">2��</option>
						<option value="3">3��</option>
						<option value="4">4��</option>
						<option value="5">5��</option>
						<option value="6">6��</option>
						<option value="7">7��</option>
						<option value="8">8��</option>
						<option value="9">9��</option>
						<option value="10">10��</option>
						<option value="11">11��</option>
						<option value="12">12��</option>
					</select>
				</p>
			</div>
			<button type="submit" class="btn">���� ����</button>
	</div>
	<br/>



</body>
</html>