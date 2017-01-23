<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>목록</title>
</head>
<body>
<div class="row">   
   <div class="col-sm-3" style="background-color:yellow;"><p>여백</p></div>
      <div class="col-sm-6" style="background-color:lavender;">
         <form role="form" class="form-horizontal" action="/project_final/review/Reviewlist.do" method="post" name="myform">
            
               <table class="table">
                           <thead>
                              <tr>
                                 <th>제목</th>
                                 <th>번호</th>
                                 <th>아이디</th>
                                 <th>내용</th>
                                 <th>별점</th>
                                 <th>추천</th>                            
                              </tr>
                           </thead>
                           <tbody>
                              <c:forEach var="review" items="${reviewlist}">
                                 <tr>
                                    <td>${review.prf_id}</td>
                                    <td><a href="/project_final/review/read.do?revno=${review.revno}&action=READ">${review.revno}</a></td>
                                    <td>${review.mem_id}</td>
                                    <td>${review.revcomment}</td>                                 
                             		<c:forEach var="reviewlist" items="${revgrade}" begin="1" varStatus="status" end="5">
                             				<td>${review.revgrade}</td>
                             		</c:forEach>
                             		<c:choose>
                             			<c:when test="${review.revgb==0}">
                             				<td>싫어요</td>
                             			</c:when>
                                    	<c:otherwise>
                                    		<td>좋아요</td> 
                                    	</c:otherwise>  
                             		</c:choose>
                             		                                
                                    <td><a href="/project_final/review/delete.do?revno=${review.revno}">삭제</a></td>
                                 </tr>
                              </c:forEach>
                           </tbody>
                        </table>
                        <ul class="nav navbar-nav navbar-right">
                           <li><a href="/project_final/review/write.do"
                              style="text-align: right;">글쓰기</a></li>
                        </ul>
                  </form>   
      </div>   
      <div class="col-sm-3" style="background-color:yellow;"><p>여백</p></div>
</div>
</body>
</html>