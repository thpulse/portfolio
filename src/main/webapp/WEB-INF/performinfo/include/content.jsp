<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.net.URLEncoder"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
	})
</script>
</head>
<body>
<div class="container-fluid">

	<div class="w3-content w3-section col-sm-12" style="max-width:100%; margin:0px; padding:0px;">
		<img class="mySlides w3-animate-fading" src="/project_final/assets/img/bg/0.jpg" style="width:100%">
		<img class="mySlides w3-animate-fading" src="/project_final/assets/img/bg/1.jpg" style="width:100%">
		<img class="mySlides w3-animate-fading" src="/project_final/assets/img/bg/2.jpg" style="width:100%">
		<img class="mySlides w3-animate-fading" src="/project_final/assets/img/bg/3.jpg" style="width:100%">
		<img class="mySlides w3-animate-fading" src="/project_final/assets/img/bg/4.jpg" style="width:100%">
		<img class="mySlides w3-animate-fading" src="/project_final/assets/img/bg/5.jpg" style="width:100%">
		<img class="mySlides w3-animate-fading" src="/project_final/assets/img/bg/6.jpg" style="width:100%">
		<img class="mySlides w3-animate-fading" src="/project_final/assets/img/bg/7.jpg" style="width:100%">
		<img class="mySlides w3-animate-fading" src="/project_final/assets/img/bg/8.jpg" style="width:100%">
		<img class="mySlides w3-animate-fading" src="/project_final/assets/img/bg/9.jpg" style="width:100%">
	</div>
	<script>
	var myIndex = 0;
	carousel();
	
	function carousel() {
	    var i;
	    var x = document.getElementsByClassName("mySlides");
	    for (i = 0; i < x.length; i++) {
	       x[i].style.display = "none";  
	    }
	    myIndex++;
	    if (myIndex > x.length) {myIndex = 1}    
	    x[myIndex-1].style.display = "block";  
	    setTimeout(carousel, 6000);    
	}
	</script>
	
	<!-- �ڽ����ǽ� -->
	<div class="col-sm-12">
		<br/>
		<br/>
		<h1 style="text-align:right">[ �帣�� �ڽ����ǽ� ]</h1>
	</div>
	<br/>
	<div class="col-sm-6"></div>
   	<div class="col-sm-6 w3-container" style="text-align: center;">
   		<div style="padding:10px;text-align:right;" class="w3-panel w3-round-small w3-teal">
		<!-- �ڽ����ǽ� ��� -->
    	<h5><a style="color:black;" href="/project_final/index.do?genre=YK">����</a> |
    	<a style="color:black;" href="/project_final/index.do?genre=MU">������</a> |
    	<a style="color:black;" href="/project_final/index.do?genre=CCO">Ŭ����/�����</a> |
    	<a style="color:black;" href="/project_final/index.do?genre=MMB">����/�߷�</a> |
    	<a style="color:black;" href="/project_final/index.do?genre=KKB">����/����</a></h5>
    	</div>
    </div>
    <div class="col-sm-2"></div>
    <div class="col-sm-10">
       	<!-- �帣�� �ڽ����ǽ� -->
       	<div style="text-align:center;margin-top:60px">
		<c:forEach var="boxoffice" items="${boxlist}">
			<div class="col-sm-2" style="margin-bottom:20px;">
				<p style="text-align:left;">${boxoffice.rank}��</p>
				<a href="/project_final/perform/prfinfo/read.do?prfid=${boxoffice.prfid}">
					<img src="${boxoffice.poster}" style="height:200px;">
				</a>
			</div>
		</c:forEach>
		</div>
	</div><!-- #�ڽ����ǽ� -->

</div>
</body>

</html>