<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style type="text/css">
	/* 검색어 css */
	#customers1
	{
		width:200px;
		border-collapse:collapse;
	}
	#customers1 td, #customers1 th 
	{
		border:1px solid #3498db;
		padding:2px 2px 2px 2px;
	}
	#customers1 th 
	{	
		font-size:1.1em;
		text-align:center;
		padding-top:5px;
		padding-bottom:4px;
		background-color:#3498db;
		color:#ffffff;
	}
	#customers1 td 
	{
		color:#000000;
		background-color:#dde1e2;
	}
	/* 검색어 css */
</style>
</head>
<body>
	<table id="customers1">
	<tr>
	  <th>순위</th>
	  <th>검색어</th>
	</tr>
	<c:forEach var="sea" items="${resultList}" begin="0" varStatus="status" end="8">
	<tr>
		<td align="center">${status.count}</td>
		<td align="center">${sea.search_word}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>