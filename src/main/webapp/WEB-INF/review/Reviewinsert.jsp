<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<title>review���</title>
</head>
<body>
	<div class="col-sm-10">
			<form role="form" class="form-horizontal" action="/project_final/review/write.do" method="post" name="myform">
				<fieldset>
					<div id="legend">
						<legend>�Ʒ� ����� �ۼ����ּ���.</legend>
					</div>
						<div class="form-group">
						<!-- ���̵� -->
						<label class="control-label col-sm-2" for="orgid">���̵�</label>
						<div class="col-sm-3">
							<input type="text" id="orgid" name="id"
								placeholder="���̵�" class="form-control"
								 required>
						</div>
					</div>
					
					<div class="form-group">
						<!-- ���� -->
						<label class="control-label col-sm-2" for="orgtext">����</label>
						<div class="col-sm-3">
						<textarea rows="1" cols="140" name="text" class="form-control"></textarea>
						</div>
					</div>
					
					<div class="form-group">
						<!-- Button -->
						<div class="col-sm-3 col-sm-offset-2">
							<input type="submit" value="����ϱ�" class="btn btn-success"/>
						</div>
					</div>
				</fieldset>
			</form>
	</div>
</body>
</html>