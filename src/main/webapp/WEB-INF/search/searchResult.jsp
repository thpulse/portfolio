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
	/* �������� css */
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
	/* �������� css */
	
	/* �˻��� css */
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
	/* �˻��� css */
</style>
</head>
<body>

<table id="customers">
	<tr>
	  <th>����</th>
	  <th>�˻���</th>
	</tr>
	<c:forEach var="sea" items="${resultList}" begin="0" varStatus="status" end="8">
	<tr>
		<td align="center">${status.count}</td>
		<td align="center">${sea.search_word}</td>
	</tr>
	</c:forEach>
</table>
<!-- �˻��� view -->

<!-- �������� view --> 	
<h4><i class="fa fa-angle-right"></i>�˻����</h4>
<table class="type01" style="margin-left: auto; margin-right: auto;">
    <thead>
        <tr>
			<th></th>
            <th>���� ����</th>
        </tr>
    </thead>
    <tbody>
		<c:forEach var="prf2" items="${Plist}">
        <tr>
           <td class="picsize"><a href="/project_final/perform/prfinfo/read.do?prfid=${prf2.prfid}"><img src="${prf2.poster }"></a></td>
               <td>
                 	���� �̸� :<a href="/project_final/perform/prfinfo/read.do?prfid=${prf2.prfid}">${prf2.prfnm }</a><br/>
                                              ���� ������: ${prf2.prfpdfrom }<br/>
                                              ���� ������: ${prf2.prfpdto }<br/>
                                              �⿬��: ${prf2.prfcast }<br/>
                   	������: ${prf2.prfstats }
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
	  <th>�۾���</th>
	  <th>�۸��</th>
	  <th>�۾��ð�</th>
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