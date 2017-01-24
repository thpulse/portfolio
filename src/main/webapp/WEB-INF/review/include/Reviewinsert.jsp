
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript" 
	src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.1.1.min.js"></script>
<style type="text/css">
	.revgrade {font-size:0; letter-spacing:-4px; }
	.revgrade a {
	    font-size:22px;
	    letter-spacing:0px;
	    display:inline-block;
	    margin-left:0px;
	    color:#ccc;
	    text-decoration:none;
	    text-align:left;	
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
						<label class="control-label col-sm-2" for="orgid">공연제목</label>
						<div class="col-sm-3">
							<input type="hidden" id="prf_id" name="prf_id"
								value="${prf_id}" class="form-control" required>
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-2" for="orgid">아이디</label>
						<div class="col-sm-2">
							<input type="text" id="mem_id" name="mem_id"
								value="<sec:authentication property="principal.username"/>" class="form-control" required>
						</div>
					</div>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
					
					<div class="form-group">						
						<label class="control-label col-sm-2" for="orgtext">한줄평</label>
						<div class="col-sm-4">
						<input type="text" rows="1" cols="140" id="revcomment" name="revcomment" 
							value="" class="form-control">
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-2" for="orggrade">별 점</label>	
							<input type="hidden" id ="revgrade" name ="revgrade" value="5"/>	
								<p class="revgrade col-sm-2">
								    <a class="on" href="#" name="1" value="1">★</a>					
								    <a class="on" href="#" name="2" value="2">★</a>						
								    <a class="on" href="#" name="3" value="3">★</a>						
								    <a class="on" href="#" name="4" value="4">★</a>				 
								    <a class="on" href="#" name="5" value="5">★</a>				
								</p>
								<script type="text/javascript">
									$(document).ready(function(){
										$(".revgrade a").on("click",function(){
											var a = $(this).attr("name");
											$("#revgrade").val(a);
											$(this).parent().children("a").removeClass("on");											
										    $(this).addClass("on").prevAll("a").addClass("on");
										    return false;
										})
									});
								</script>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-2" for="orggb"></label>
						<div class="col-sm-2"> 
							<input type="radio"  name="revgb" id="revgb" value="1"/>좋아요
							<input type="radio"  name="revgb" id="revgb" value="0"/>싫어요
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-sm-2 col-sm-offset-2">
							<input type="submit" value="등록하기" class="btn btn-success"/>
						</div>
					</div>
			</form>
	</div>
</body>
</html>