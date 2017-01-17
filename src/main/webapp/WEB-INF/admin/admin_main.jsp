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
	<h1>ADMIN 메인페이지</h1>

	<div class="service wow fadeInUp">
		<!-- fa fa-eye" -->
		<div class="service-icon">
			<i class="fa fa-table"></i>
		</div>
		<h3>날짜선택</h3>
		<h3>( 마지막으로 삽입된 날짜 : 2017년 01월 07일 )</h3>
		<form role="form" action="/project_final/weather/insert.do" method="post" name="insert_form">
			<div class="form-group">
				<p>
					<!-- 마지막으로 삽입된 이전의 날짜 선택시에 alert -->
					<select class="selectpicker" id="year" name="year" data-size="5">
						<option value="default">연도 선택</option>
						<option value="2017">2017년</option>
						<option value="2016">2016년</option>
						<option value="2015">2015년</option>
						<option value="2014">2014년</option>
						<option value="2013">2013년</option>
						<option value="2012">2012년</option>
						<option value="2011">2011년</option>
						<option value="2010">2010년</option>
						<option value="2009">2009년</option>
						<option value="2008">2008년</option>
						<option value="2007">2007년</option>
						<option value="2006">2006년</option>
						<option value="2005">2005년</option>
						<option value="2004">2004년</option>
						<option value="2003">2003년</option>
						<option value="2002">2002년</option>
					</select> 
					<select class="selectpicker" id="month" name="month" data-size="5">
						<option value="default">월 선택</option>
						<option value="1">1월</option>
						<option value="2">2월</option>
						<option value="3">3월</option>
						<option value="4">4월</option>
						<option value="5">5월</option>
						<option value="6">6월</option>
						<option value="7">7월</option>
						<option value="8">8월</option>
						<option value="9">9월</option>
						<option value="10">10월</option>
						<option value="11">11월</option>
						<option value="12">12월</option>
					</select>
				</p>
			</div>
			<button type="submit" class="btn">날씨 삽입</button>
	</div>
	<br/>



</body>
</html>