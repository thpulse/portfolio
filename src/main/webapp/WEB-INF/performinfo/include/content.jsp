<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


    <body>
    	<!-- �����̵� ��� -->
    	<div>
    		<div>
    			<h4><a href="/project_final/index.do?genre=����">����</a></h4>
    			<h4><a href="/project_final/index.do?genre=������">������</a></h4>
    			<h4><a href="/project_final/index.do?genre=Ŭ����&�����">Ŭ����/�����</a></h4>
    			<h4><a href="/project_final/index.do?genre=����&�߷�">����/�߷�</a></h4>
    			<h4><a href="/project_final/index.do?genre=����&����">����/����</a></h4>
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