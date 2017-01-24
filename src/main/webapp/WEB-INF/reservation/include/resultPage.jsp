<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <%@ taglib prefix="se" uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script type="text/javascript">
	

</script>
</head>
<body>	
		<div class="container-fluid">
			  <div class="row">	
			  		<div class="col-sm-2" style="background-color:yellow;"><p>여백</p></div>
				    	<div class="col-sm-8" style="background-color:lavender;">
				    	<h1>예약이 완료되었습니다.</h1>
				    	<p><img src="${poster}"/></p>
				    	
				    		
						 					
				    	<button type="button" class="btn btn-success" onclick="location.href='/project_final/index.do'">메인화면</button>					    		
				    	</div>
				    	 	    	
			    	<div class="col-sm-2" style="background-color:yellow;"><p>여백</p></div>
			  </div>
		</div>
</body>
</html>