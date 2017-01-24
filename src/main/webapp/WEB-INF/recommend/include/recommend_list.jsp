<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*, kitri.user.vo.*" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="euc-kr">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<%-- <% UserVO result = (UserVO) request.getAttribute("result");	%>
	<% UserVO loginUser = (UserVO) session.getAttribute("loginUser"); %> --%>
<div class="container">
  <h2>������_ȸ����õ���� ����</h2>
<%--    <%if(loginUser!=null){ %>
		<small><%=loginUser.getUser_name() %>(<%=loginUser.getUser_id() %>)�� �����ڸ���Դϴ�.</small>
		<%} %> --%>
	<input type="button" value="SQL��λ���" onclick="location.href='/project_final/recommend/delete.do'">
	<input type="button" value="SQL ���� �� �����" onclick="location.href='/project_final/recommend/update.do'">
	<input type="button" value="������� SQL MongoDB����" onclick="location.href='/project_final/recommend/mongoInsert.do'">	
	<input type="button" value="���Ͽ� ����" onclick="location.href='/project_final/recommend/reload.do'">
	<!-- <input type="button" value="���Ͽ�����" onclick="location.href='/project_final/recommend/recommend.do'"> -->
	
	<table class="table">
    <thead>
      <tr>
        <th>���̵�</th>
        <th>����ID</th>
        <th>Ƚ��</th>
      </tr>
    </thead>
    		<tbody>
    		<c:forEach var="item" items="${list}">
	     	<tr>
			       	<td>${item.user_id}</td>
					<td>${item.prf_id}</td>
					<td>${item.count}</td>
					<%-- <td><a href="/project_final/delete.do?id=${item.user_id }">ȸ������</a> --%>
			 </tr>
	      	 </c:forEach>
	      
    </tbody>
  </table>
</div>

</body>
</html>