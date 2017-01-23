<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<title>review����</title>
</head>
<body>
	<div class="col-sm-12">
			<form role="form" class="form-horizontal" action="/project_final/review/read.do?revno=${review.revno}&action=UPDATE" 
				method="post" name="myform">
					
					<div class="form-group">
						<label class="control-label col-sm-2" for="orgprf">��������</label>
						<div class="col-sm-3">
							${review.prf_id}
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-2" for="orgno">��Ϲ�ȣ</label>
						<div class="col-sm-3">
							${review.revno}
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-2" for="orgid">���̵�</label>
						<div class="col-sm-3">
							${review.mem_id}
						</div>
					</div>	
				
					<div class="form-group">
						<!-- ���� -->
						<label class="control-label col-sm-4" for="orgtext">�� �� ��</label>
						<div class="col-sm-3">
							${review.revcomment}
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-2" for="orggrade">�� ��</label>
						<div class="col-sm-3"> 
							${review.revgrade}
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-2" for="orggb"></label>
						<div class="col-sm-3"> 
							${review.revgb}
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-2" for="orgdate"></label>
						<div class="col-sm-3"> 
							${review.revdate}
						</div>
					</div>
					<div class="form-group">
						<!-- Button -->
						<div class="col-sm-3 col-sm-offset-2">
							<input type="button" value="���" class="btn btn-success" onclick="location.href='Reviewlist.do'"/>
							<input type="submit" value="����" class="btn btn-success" onclick="location.href='Reviewlist.do'"/>
						</div>
					</div>
			</form>
	</div>
</body>
</html>