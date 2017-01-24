<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>
<ul class="vert-one">
	  <sec:authorize access="isAuthenticated()">
	  <li><a href="/project_final/mypageRcheck/list.do?userid=<sec:authentication property="principal.username"/>" title="CSS Menus">예약 내역 확인</a></li>
	  </sec:authorize>
	  <li><a href="/project_final/stats/statsResult.do" title="CSS Menus">통계 test</a></li>
	  <li><a href="/project_final/twitter/test.do" title="CSS Menus">트위터 test</a></li>
</ul>
</body>
</html>