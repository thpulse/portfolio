<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript" 
	src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.1.1.min.js"></script>
<style type="text/css">
	.revgrade {font-size:0; letter-spacing:-4px;}
	.revgrade a {
	    font-size:22px;
	    letter-spacing:0;
	    display:inline-block;
	    margin-left:5px;
	    color:#ccc;
	    text-decoration:none;
	}
	.revgrade a:first-child {margin-left:0;}
	.revgrade a.on {color:#777;}
</style>

</head>
<body>
	<div class="col-sm-12">
			<form role="form" class="form-horizontal" action="/project_final/review/write.do" 
				method="post" name="myform">

					<div class="form-group">
						<label class="control-label col-sm-2" for="orgid">��������</label>
						<div class="col-sm-3">
							<input type="text" id="prf_id" name="prf_id"
								value="������" class="form-control" required>
						</div>
					</div>
					
					<!-- <div class="form-group">
						<label class="control-label col-sm-2" for="orgno">��Ϲ�ȣ</label>
						<div class="col-sm-3">
							<input type="number" id="orgno" name="revno" class="form-control" value="1">
						</div>
					</div> -->
					
					<div class="form-group">
						<label class="control-label col-sm-2" for="orgid">���̵�</label>
						<div class="col-sm-3">
							<input type="text" id="mem_id" name="mem_id"
								value="����������" class="form-control" required>
						</div>
					</div>
					
					<div class="form-group">
						<!-- ���� -->
						<label class="control-label col-sm-4" for="orgtext">����</label>
						<div class="col-sm-3">
						<input type="text" rows="1" cols="140" id="revcomment" name="revcomment" 
							value="���������� ������źζ� �����缼��" class="form-control">
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-2" for="orggrade">�� ��</label>
							<p class="revgrade">
							    <a class="on" href="#">��</a>					
							    <a class="on" href="#">��</a>						
							    <a class="on" href="#">��</a>						
							    <a class="on" href="#">��</a>				 
							    <a class="on" href="#">��</a>				
							</p>
							<script type="text/javascript">
								$(document).ready(function(){
									$(".revgrade a").on("click",function() {
										$(this).parent().children("a").removeClass("on");
									    $(this).addClass("on").prevAll("a").addClass("on");
									    return false;
									})
								});
							</script>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-2" for="orggb"></label>
						<div class="col-sm-3"> 
							<input type="radio"  name="revgb" id="revgb" value="1"/>���ƿ�
							<input type="radio"  name="revgb" id="revgb" value="0"/>�Ⱦ��
						</div>
					</div>
					
					<!-- <div class="form-group">
						<label class="control-label col-sm-2" for="orgdate"></label>
						<div class="col-sm-3"> 
							<input type="text" id="orgdate" name="revdate"
								value="" class="form-control" required>
						</div>
					</div> -->
					
					<div class="form-group">
						<!-- Button -->
						<div class="col-sm-3 col-sm-offset-2">
							<input type="submit" value="����ϱ�" class="btn btn-success"/>
						</div>
					</div>
			</form>
	</div>
</body>
</html>