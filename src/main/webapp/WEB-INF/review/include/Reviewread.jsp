<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<title>review수정</title>
</head>
<body>
	<div class="col-sm-12">
			<form role="form" class="form-horizontal" action="/project_final/review/read.do?revno=${review.revno}&action=UPDATE" 
				method="post" name="myform">
					
					<div class="form-group">
						<label class="control-label col-sm-2" for="orgprf">공연제목</label>
						<div class="col-sm-3">
							${review.prf_id}
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-2" for="orgno">등록번호</label>
						<div class="col-sm-3">
							${review.revno}
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-2" for="orgid">아이디</label>
						<div class="col-sm-3">
							${review.mem_id}
							<input type="hidden" value="${review.prf_id}" id="prfid" name="prfid"/>
						</div>
					</div>	
				
					<div class="form-group">
						<!-- 내용 -->
						<label class="control-label col-sm-4" for="orgtext">한 줄 평</label>
						<div class="col-sm-3">
							${review.revcomment}
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-2" for="orggrade">별 점</label>
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
							<input type="button" value="목록" class="btn btn-success" onclick="location.href='/project_final/perform/prfinfo/read.do?prfid='+document.getElementById('prfid').value;"/>
							<input type="submit" value="수정" class="btn btn-success" />
						</div>
					</div>
			</form>
	</div>
</body>
</html>