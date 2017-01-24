<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>목록</title>
</head>
<body>
 <form role="form" class="form-horizontal" action="/project_final/review/search2.do" method="post" name="myform">
	<select name="tag">
		<option value="mem_id">아이디</option>
	</select> <input type="text" name="search"/><input type="submit" value="검색">
</form>   
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
        	<c:forEach var="review" items="${readadmin}">
        		<tr>
        			<td>${review.prf_id}</td>
                    <td>${review.revno}</a></td>
                    <td>${review.mem_id}</td>
                    <td>${review.revcomment}</td>                                
                    <c:choose>
                    	<c:when test="${review.revgrade=='1'}">
                    		<td>★</td>
                        </c:when>
                        <c:when test="${review.revgrade=='2'}">
                            <td>★★</td>
                        </c:when>
                        <c:when test="${review.revgrade=='3'}">
                            <td>★★★</td>
                        </c:when>
                        <c:when test="${review.revgrade=='4'}">
                           	<td>★★★★</td>
                        </c:when>
                        <c:otherwise>
                            <td>★★★★★</td>
                        </c:otherwise>				
                     </c:choose>
                             		
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
                        

</div>   
	</body>
</html>