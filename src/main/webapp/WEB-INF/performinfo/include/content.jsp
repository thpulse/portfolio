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
<link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/earlyaccess/hanna.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">

</script>
</head>
<body>
<div class="container-fluid">

   <div class="w3-content w3-section col-sm-12" style="max-width:100%; margin:0px; margin-top:20px; padding:0px;">
      <a href="/project_final/index.do">
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
         <img class="mySlides w3-animate-fading" src="/project_final/assets/img/bg/10.jpg" style="width:100%">
         <img class="mySlides w3-animate-fading" src="/project_final/assets/img/bg/11.jpg" style="width:100%">
      </a>
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
       setTimeout(carousel, 2000);    
   }
   </script>
   
   <!-- 박스오피스 -->
   <div class="col-sm-6 w3-container" style="text-align: center;">
      <br/>
      <br/>
      <h1 style="text-align:left">[ 장르별 박스오피스 ]</h1>
      <br/>
   
         <div style="padding:10px;text-align:left;" class="w3-panel w3-round-small w3-teal">
         <!-- 박스오피스 상단 -->
          <h5>
             <a style="color:black;" href="/project_final/index.do?genre=YK">연극</a> |
             <a style="color:black;" href="/project_final/index.do?genre=MU">뮤지컬</a> |
             <a style="color:black;" href="/project_final/index.do?genre=CCO">클래식/오페라</a> |
             <a style="color:black;" href="/project_final/index.do?genre=MMB">무용/발레</a> |
             <a style="color:black;" href="/project_final/index.do?genre=KKB">국악/복합</a>
          </h5>
       </div>
    
       <!-- 장르별 박스오피스 -->
      <table class="table">
           <tr>
              <td style="color:white; background-color: #aaaaaa">순위</td>
               <td style="color:white; background-color: #aaaaaa">포스터</td>
               <td style="color:white; background-color: #aaaaaa">공연명</td>
               <td style="color:white; background-color: #aaaaaa">관객수</td>
           </tr>
            <c:forEach var="boxoffice" items="${boxlist}">
            <tr>
               <td>${boxoffice.rank}</td>
              <td>
                  <a href="/project_final/perform/prfinfo/read.do?prfid=${boxoffice.prfid}">
                  <img src="${boxoffice.poster}" style="height:100px;">
               </a>
            </td>
               <td>
                  (${boxoffice.area})
                  <a href="/project_final/perform/prfinfo/read.do?prfid=${boxoffice.prfid}">${boxoffice.prfnm}</a>
               </td>
               <td>${boxoffice.nmrs}명</td>
            </tr>
            </c:forEach>
      </table>
   </div>
	   <!-- 이건 내꺼고 -->
	   <c:set var="name" value="${id_val}" />
		<c:choose>
		    <c:when test="${name eq 'anonymousUser'}">		       
		    </c:when>		   
		    <c:otherwise>
		    	
		        <div class="col-sm-6 w3-container" style="text-align: center;">
		        <br/>
		         <br/>
		        <h1 style="text-align:left">${id_val} 회원님게 추천하는 공연!</h1>
		        	<table class="table">
		        		<tr>
			               <td style="color:white; background-color: #aaaaaa">포스터</td>
			               <td style="color:white; background-color: #aaaaaa">공연명</td>
			          	 </tr>
				   		<c:forEach var="poster" items="${posterlist}">
				            <tr>               
				               <td>
				               		<a href="/project_final/perform/prfinfo/read.do?prfid=${poster.prfid}"><img src="${poster.poster}" style="height:100px;"></a>
				               	</td>  
				               <td>${poster.prfnm}</td>           
				            </tr>
				        </c:forEach>   
			        </table>
			 	 </div>
		    </c:otherwise>		
		</c:choose>	   
   </div>   

</body>
</html>