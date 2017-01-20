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
	.star_rating {font-size:0; letter-spacing:-4px;}
	.star_rating a {
	    font-size:22px;
	    letter-spacing:0;
	    display:inline-block;
	    margin-left:5px;
	    color:#ccc;
	    text-decoration:none;
	}
	.star_rating a:first-child {margin-left:0;}
	.star_rating a.on {color:#777;}
</style>
</head>
<body>
	<div class="col-sm-12">
			<form role="form" class="form-horizontal" action="/project_final/review/update.do?revno=${review.revno}" 
				method="post" name="myform">
			<div class="form-group">
					<div class="form-group">
						<!-- 내용 -->
						<label class="control-label col-sm-4" for="orgtext">한 줄 평</label>
						<div class="col-sm-3">
						<input type="text" rows="1" cols="140" id="revcomment" name="revcomment" class="form-control">
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-2" for="orggrade">별 점</label>
							<p class="revgrade">
							    <a class="on" href="#">★</a>					
							    <a class="on" href="#">★</a>						
							    <a class="on" href="#">★</a>						
							    <a class="on" href="#">★</a>				
							    <a class="on" href="#">★</a>				
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
							<input type="radio"  name="goodbad" id="revgb" value="1"/>좋아요
							<input type="radio"  name="goodbad" id="revgb" value="2"/>싫어요
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-2" for="orgdate"></label>
						<div class="col-sm-3"> 
							<input type="text" id="orgdate" name="revdate"
								value="20160112" class="form-control" required>
						</div>
					</div>
					<div class="form-group">
						<!-- Button -->
						<div class="col-sm-3 col-sm-offset-2">
							<input type="button" value="목록" class="btn btn-success" onclick="location.href='Reviewlist.do'"/>
							<input type="submit" value="확인" class="btn btn-success" onclick="location.href='Reviewlist.do'"/>
						</div>
					</div>
			</form>
	</div>
</body>
</html>