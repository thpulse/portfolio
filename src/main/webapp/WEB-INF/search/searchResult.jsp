<%@page import="twitter4j.Status"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style>
	/* 공연정보 css */
	table.type01 {
		
	    border-collapse: collapse;
	    line-height: 1.5;
	    margin : 20px 10px;
	}
	table.type01 th {
	    width: 150px;
	    padding: 10px;
	    font-weight: bold;
	    vertical-align: top;
	    border: 1px solid #ccc;
	}
	table.type01 td {
	    width: 350px;
	    padding: 10px;
	    vertical-align: top;
	    border: 1px solid #ccc;
	}
	table.type01 td.picsize {
	    width: auto; height: auto;
	    max-width: 100px;
	    max-height: 100px;
	}
	/* 공연정보 css */
	
	/* 검색어 css */
	#customers
	{
		font-family:"Trebuchet MS", Arial, Helvetica, sans-serif;
		width:200px;
		margin-left: 950px;
		border-collapse:collapse;
	}
	#customers td, #customers th 
	{
		font-size:1em;
		border:1px solid #99004c;
		padding:2px 2px 2px 2px;
	}
	#customers th 
	{
		font-size:1.1em;
		text-align:center;
		padding-top:5px;
		padding-bottom:4px;
		background-color:#99004c;
		color:#ffffff;
	}
	#customers tr.alt td 
	{
		color:#000000;
		background-color:#EAF2D3;
	}
	/* 검색어 css */
</style>
</head>
<body>

<table id="customers">
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
<!-- 검색어 view -->

<!-- 공연정보 view --> 	
<h4><i class="fa fa-angle-right"></i>검색결과</h4>
<table class="type01" style="margin-left: auto; margin-right: auto;">
    <thead>
        <tr>
			<th></th>
            <th>공연 정보</th>
        </tr>
    </thead>
    <tbody>
		<c:forEach var="prf2" items="${Plist}">
        <tr>
           <td class="picsize"><a href="/project_final/perform/prfinfo/read.do?prfid=${prf2.prfid}"><img src="${prf2.poster }"></a></td>
               <td>
                 	공연 이름 :<a href="/project_final/perform/prfinfo/read.do?prfid=${prf2.prfid}">${prf2.prfnm }</a><br/>
                                              공연 시작일: ${prf2.prfpdfrom }<br/>
                                              공연 종료일: ${prf2.prfpdto }<br/>
                                              출연진: ${prf2.prfcast }<br/>
                   	공연중: ${prf2.prfstats }
               </td>
			   </tr>
          </c:forEach>
                             
    </tbody>
</table>

 	<%  
 		if(request.getAttribute("twitterList") != null){
 			Status twi = (Status)request.getAttribute("twitterList");
 		
	%>
 <table id="customers">
	<tr>
	  <th>글쓴이</th>
	  <th>글목록</th>
	  <th>글쓴시간</th>
	</tr>
	<%-- <c:forEach var="twi" items="${twitter}"> --%>
	<tr>
		<td align="center">@<%=twi.getUser().getScreenName()%></td>
		<td align="center"><%=twi.getText() %></td>
		<td align="center"><%=twi.getCreatedAt() %></td>
	</tr>
	<%-- </c:forEach> --%>
</table>	 
	<% } %>
 
</body>
</html>