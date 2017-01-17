<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
  <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- CSS -->
        
        
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,400">
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Droid+Sans">
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Lobster">
        <link rel="stylesheet" href="/project_final/assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="/project_final/assets/font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="/project_final/assets/css/animate.css">
        <link rel="stylesheet" href="/project_final/assets/css/magnific-popup.css">
        <link rel="stylesheet" href="/project_final/assets/flexslider/flexslider.css">
        <link rel="stylesheet" href="/project_final/assets/css/form-elements.css">
        <link rel="stylesheet" href="/project_final/assets/css/style.css">
        <link rel="stylesheet" href="/project_final/assets/css/media-queries.css">
		
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- Favicon and touch icons -->
        <link rel="shortcut icon" href="/project_final/assets/ico/favicon.ico">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="/project_final/assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="/project_final/assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="/project_final/assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="/project_final/assets/ico/apple-touch-icon-57-precomposed.png">

<style type="text/css">
ul.vert-one{
	margin:0;padding:0;list-style-type:none;display:block;
	font:bold 12px tahoma, sans-serif;line-height:165%;
	width:200px;
}

ul.vert-one li{
	margin:0;padding:0;border-top:1px solid #4D0000;
	border-bottom:1px solid #761A1A;
}

ul.vert-one li a{
	display:block;text-decoration:none;color:#fff;
	background:#600;padding:5px 0 5px 20px;width:200px;
}

ul.vert-one li a:hover{
	background:#900 url("http://www.blueb.co.kr/data/201010/IJ12872476173279/vert-one_arrow.gif") no-repeat 0 9px;
}

ul.vert-one li a.current,ul.vert-one li a.current:hover{
background:#933 url("http://www.blueb.co.kr/data/201010/IJ12872476173279/vert-one_arrow.gif") no-repeat 0 9px;}
</style>
</head>
<body>
	    <!-- Top menu -->
		
			<tiles:insertAttribute name="top"/>		
		<div class="col-sm-2 sidenav">
			<!-- JeonInGyu 170110 update Start -->
			<tiles:insertAttribute name="mypage_menu"/>
			<!-- JeonInGyu 170110 update End -->
		</div>
        <!-- Slider -->
  		<div class="col-sm-10"> 
  			
            <tiles:insertAttribute name="content"/>
            
 		</div>
        <!-- Footer -->

            <tiles:insertAttribute name="footer"/>
</body>
<!-- Javascript -->
        <script src="/project_final/assets/js/jquery-1.11.1.min.js"></script>
        <script src="/project_final/assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="/project_final/assets/js/bootstrap-hover-dropdown.min.js"></script>
        <script src="/project_final/assets/js/jquery.backstretch.min.js"></script>
        <script src="/project_final/assets/js/wow.min.js"></script>
        <script src="/project_final/assets/js/retina-1.1.0.min.js"></script>
        <script src="/project_final/assets/js/jquery.magnific-popup.min.js"></script>
        <script src="/project_final/assets/flexslider/jquery.flexslider-min.js"></script>
        <script src="/project_final/assets/js/jflickrfeed.min.js"></script>
        <script src="/project_final/assets/js/masonry.pkgd.min.js"></script>
        <script src="/project_final/assets/js/jquery.ui.map.min.js"></script>
        <script src="/project_final/assets/js/scripts.js"></script>
    

</html>