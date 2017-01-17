<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<title>review등록</title>
</head>
<body>
	<div class="col-sm-10">
			<form role="form" class="form-horizontal" action="/project_final/review/write.do" method="post" name="myform">
				<fieldset>
					<div id="legend">
						<legend>아래 양식을 작성해주세요.</legend>
					</div>
						<div class="form-group">
						<!-- 아이디 -->
						<label class="control-label col-sm-2" for="orgid">아이디</label>
						<div class="col-sm-3">
							<input type="text" id="orgid" name="id"
								placeholder="아이디" class="form-control"
								 required>
						</div>
					</div>
					
					<div class="form-group">
						<!-- 내용 -->
						<label class="control-label col-sm-2" for="orgtext">내용</label>
						<div class="col-sm-3">
						<textarea rows="1" cols="140" name="text" class="form-control"></textarea>
						</div>
					</div>
					
					<div class="form-group">
						<!-- Button -->
						<div class="col-sm-3 col-sm-offset-2">
							<input type="submit" value="등록하기" class="btn btn-success"/>
						</div>
					</div>
				</fieldset>
			</form>
	</div>
</body>
</html>