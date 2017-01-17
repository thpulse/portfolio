<%@page import="spring.data.mongodb.taehyung_test.ScoreDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
	<%ScoreDTO dto = (ScoreDTO)request.getAttribute("document"); %>
	<div class="container-fluid">
		<form role="form" class="form-horizontal"
			action="/project_final/score/insert" method="POST">
			<fieldset>
				<div id="legend">
					<legend>�Ʒ� ����� �ۼ����ּ���.</legend>
				</div>
				<div class="form-group">
					<!-- �μ��ڵ� -->
					<label class="control-label col-sm-2" for="orgcode">���̵�</label>
					<%= dto.getId() %>
				</div>
				<div class="form-group">
					<!-- �μ���-->
					<label class="control-label col-sm-2" for="orgname">����</label>
					<%= dto.getName() %>
				</div>
				<div class="form-group">
					<!-- �μ���ġ-->
					<label class="control-label col-sm-2" for="orgloc">�μ���</label>
					<%= dto.getDept() %>
				</div>
				<div class="form-group">
					<!-- ��ȭ��ȣ-->
					<label class="control-label col-sm-2" for="orgtel">�ּ�</label>
					<%= dto.getAddr() %>
				</div>
				<div class="form-group">
					<!-- �μ��ڵ� -->
					<label class="control-label col-sm-2" for="orgcode">�ڹ�����</label>
					<%= dto.getJava() %>
				</div>



				<div class="form-group">
					<!-- �μ���-->
					<label class="control-label col-sm-2" for="orgname">����</label>
					<%= dto.getServlet() %>
				</div>







				<div class="form-group">
					<!-- �μ���ġ-->
					<label class="control-label col-sm-2" for="orgloc">spring</label>
					<%= dto.getSpring() %>
				</div>
				<div class="form-group">
					<!-- ��ȭ��ȣ-->
					<label class="control-label col-sm-2" for="orgtel">���ʽ�</label>
					<%= dto.getBonus() %>
				</div>

				<div class="form-group">
					<!-- Button -->
					<div class="col-sm-3 col-sm-offset-2">
						<input type="button"  
		onclick="location.href='/project_final/score/detail?key=id&value=<%=dto.getId()%>&action=update'"
						value="�����ϱ�" 					class="btn btn-success" />

					</div>
				</div>
			</fieldset>
		</form>
	</div>
</body>
</html>