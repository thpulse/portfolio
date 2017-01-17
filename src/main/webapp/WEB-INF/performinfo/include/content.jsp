<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


    <body>
    	<!-- 슬라이드 상단 -->
    	<div>
    		<div>
    			<h4><a href="/project_final/index.do?genre=연극">연극</a></h4>
    			<h4><a href="/project_final/index.do?genre=뮤지컬">뮤지컬</a></h4>
    			<h4><a href="/project_final/index.do?genre=클래식&오페라">클래식/오페라</a></h4>
    			<h4><a href="/project_final/index.do?genre=무용&발레">무용/발레</a></h4>
    			<h4><a href="/project_final/index.do?genre=국악&복합">국악/복합</a></h4>
    		</div>
    	</div>
        <!-- Slider -->
        <div class="slider-container">
            <div class="container">
                <div class="row">
                    <div class="col-sm-10 col-sm-offset-1 slider">
                        <div class="flexslider">
                            <ul class="slides">
                            	<c:forEach var="boxoffice" items="${boxlist}" >
                                <li data-thumb="${boxoffice.poster}">
                                    <img src="${boxoffice.poster}">
                                </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        


    </body>

</html>