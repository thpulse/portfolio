<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*,spring.data.mongodb.taehyung_test.*"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<% List<ScoreDTO> mongolist  =
			(List<ScoreDTO>)request.getAttribute("mongolist"); 
	   int size = mongolist.size();	%>
	<h1>Score(Mongo)</h1>
	
	<hr/>
	<table align="center" border="1" width="600">
		<tr bgcolor="skyblue">
			<th>���̵�</th><th>���ʽ�</th><th>����</th>
			<th>�ּ�</th><th>�μ���ȣ</th>
			<th>����</th>
		</tr>
		<%for(int i = 0;i<size;i++){
			ScoreDTO user = mongolist.get(i);%>
			<tr>
				<td><a
 href="/project_final/score/detail?key=id&value=<%=user.getId()%>&action=read"><%= user.getId() %></a></td>
				<td><%= user.getBonus()%></td>
				<td><%= user.getName() %></td>
				<td><%= user.getAddr() %></td>
				<td><%= user.getDept()%></td>
				<td>
		<a href="mybatisDel.do?id=<%=user.getId() %>">����</a></td>
			</tr>
			
		<%} %>
		<tr>
			<td colspan="6">
				<a href = "/project_final/score/list?pageNo=0">1</a>
				<a href = "/project_final/score/list?pageNo=1">2</a>
				<a href = "/project_final/score/list?pageNo=2">3</a>
				<a href = "/project_final/score/list?pageNo=3">4</a>
				<a href = "/project_final/score/list?pageNo=4">5</a>
				<a href = "/project_final/score/list?pageNo=5">6</a>				
			</td>
		</tr>	
	</table>
	
</body>
</html>










