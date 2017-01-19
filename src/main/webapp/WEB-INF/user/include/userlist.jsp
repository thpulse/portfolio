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
  <h2>회원목록조회</h2>
<%--    <%if(loginUser!=null){ %>
		<small><%=loginUser.getUser_name() %>(<%=loginUser.getUser_id() %>)님 관리자모드입니다.</small>
		<%} %> --%>

	<table class="table">
    <thead>
      <tr>
        <th>아이디</th>
        <th>이름</th>
        <th>이메일</th>
        <th>성별</th>
        <th>전화번호</th>
        <th>선호장르</th>
        <th>회원삭제</th>
        <th>권한</th>
      </tr>
    </thead>
    		<tbody>
    		<c:forEach var="item" items="${userlist}">
	     	<tr>
			       	<td>${item.user_id }</td>
					<td>${item.user_name }</td>
					<td>${item.user_email }</td>
					<td>${item.user_gender }</td>
					<td>${item.user_tel }</td>
					<td>${item.user_gerne }</td>
					<td><a href="/project_final/delete.do?id=${item.user_id }">회원삭제</a>
			       	<td></td>
			 		</tr>
	      			 </c:forEach>
	      
    </tbody>
  </table>
</div>

</body>
</html>