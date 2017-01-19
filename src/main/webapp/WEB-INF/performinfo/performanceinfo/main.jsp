<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.net.URLEncoder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<!-- Portfolio -->
	<div class="portfolio-container">
		<div class="container-fluid">
			
			<!-- �帣���� -->
			<div class="col-sm-10 portfolio-filters wow fadeInLeft" style="padding:0px;">
				<a href="/project_final/perform/prfinfo/select.do">All</a> / 
				<a href='/project_final/perform/prfinfo/select.do?genre=<%=URLEncoder.encode("����","euc-kr") %>'>����</a> / 
				<a href='/project_final/perform/prfinfo/select.do?genre=<%=URLEncoder.encode("������","euc-kr") %>'>������</a> /
				<a href='/project_final/perform/prfinfo/select.do?genre=<%=URLEncoder.encode("Ŭ����","euc-kr") %>'>Ŭ����</a> /
				<a href='/project_final/perform/prfinfo/select.do?genre=<%=URLEncoder.encode("�����","euc-kr") %>'>�����</a> /
				<a href='/project_final/perform/prfinfo/select.do?genre=<%=URLEncoder.encode("����","euc-kr") %>'>����</a> /
				<a href='/project_final/perform/prfinfo/select.do?genre=<%=URLEncoder.encode("�߷�","euc-kr") %>'>�߷�</a> /
				<a href='/project_final/perform/prfinfo/select.do?genre=<%=URLEncoder.encode("����","euc-kr") %>'>����</a> /
				<a href='/project_final/perform/prfinfo/select.do?genre=<%=URLEncoder.encode("����","euc-kr") %>'>����</a>
			</div><!-- #�帣���� -->
			
			<!-- �������� -->
			<div class="row">
				<c:forEach var="prf" items="${prflist}">
				<div class="col-sm-3 portfolio-masonry" style="height: 400px;">
					<div class="portfolio-box web-design">
						<div class="portfolio-box-container">
							<a href="/project_final/perform/prfinfo/read.do?prfid=${prf.prfid}">
								<img src="${prf.poster}" alt="" data-at2x="${prf.poster}" style="max-height:200px">
							</a>
							<div class="portfolio-box-text">
								<h3><a href="/project_final/perform/prfinfo/read.do?prfid=${prf.prfid}">${prf.prfnm}</a></h3>
								<p>�帣:${prf.genre}</p>
								<p>�����Ⱓ:${prf.prfpdfrom}~${prf.prfpdto}</p>
								<p></p>
							</div>
						</div>
					</div>
				</div>
				</c:forEach>
			</div><!-- #�������� -->
			
		</div><!-- #container -->
	</div><!-- #portfolio-container -->
	
</body>
</html>