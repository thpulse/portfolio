<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="kitri.user.vo.*" %>
    <%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
   <%@ taglib prefix="se" uri="http://www.springframework.org/security/tags"%>
   <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/earlyaccess/hanna.css" />
<body>

	<nav class="navbar" role="navigation" style="background-color: #f4f4f4; padding-top:10px; margin-bottom:5px;">
		<div class="container-fluid">
			<!-- ingyu search start 170117 -->
			<div class="col-sm-12">
				<div class="col-sm-3" style="text-align:left;">
					<!-- user inform. -->
					<se:authorize access="isAuthenticated()">
						<h5><i class="glyphicon glyphicon-user"></i> "<se:authentication property="principal.user_name"/>"님 환영합니다.</h5>
					</se:authorize>
					<se:authorize access="isAnonymous()">
						<h5><i class="glyphicon glyphicon-user"></i> 사용자 정보가 없습니다.</h5>
					</se:authorize>
				</div>
				<div class="col-sm-9" style="text-align:right;">
					<!-- search -->
					<form method='POST' action="/project_final/search/searchResult.do">
						<select name="tag" style="height:25px;">
							<option value="prfnm">performance</option>
							<option value="prfcast">cast</option>
						</select>
						<input type="text" class="tb1" style="width:200px; height:30px; background-color: white" name="Sword">
						<button type="submit" class="btn btn-link" style="height:30px;">Search</button>
					</form>
				</div>
			</div>
			<!-- ingyu search end 170117-->
		</div>
	</nav>


	<!-- Top menu -->
	<nav class="navbar" role="navigation">
      <div class="container-fluid">
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="top-navbar-1">
			
			<!-- menu -->
			<ul class="nav navbar-nav navbar-right">

				<li>
					<a href="/project_final/index.do"><i class="fa fa-home"></i><br>Home</a>
				</li>

				<li>
					<a href="/project_final/perform/prfinfo/select2.do/0/all"><i class="fa fa-camera"></i><br>Perform_Info</a>
				</li>
                
				<li>
					<a href="/project_final/reservation/main.do"><i class="fa fa-comments"></i><br>Reservation</a>
				</li>
                
                <!-- user -->
				<li>
					<se:authorize access="isAnonymous()">	
					<a href="#" onclick="login" data-toggle="modal" data-target="#myModal"><i class="fa fa-unlock"></i><br>Log-in</a>
					</se:authorize>  
					
					<se:authorize access="isAuthenticated()"> 
					<a href="/project_final/logout.do" onclick="logout"><i class="fa fa-lock"></i><br>LogOut</a>
					</se:authorize>  
					
					<se:authorize access="isAnonymous()">  
	               	<li class="dropdown active">
						<a href="/project_final/insert.do" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="1000">
							<i class="fa fa-tasks"></i><br>USER <span class="caret"></span>
								</a>
						<ul class="dropdown-menu dropdown-menu-left" role="menu">
							<li class="active"><a href="/project_final/insert.do">Sign-UP</a></li>
							<li class="active"><a href="/project_final/idsearch.do">ID/PW 찾기</a></li>
						</ul>
					</li>
	                </se:authorize>
                  
                  
					<!-- Modal -->
	                 
					<form role="form" action="/project_final/j_spring_security_check" method="POST">
						
						<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
							<div class="modal-dialog modal-lg" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal" aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										Id : <input type="text" name="user_id" placeholder="Username" required><br><br>
										Password : <input type="password" name="user_pass" placeholder="Password" required>
									</div>
									<div class="form__field">
										<br/>
										<p><input type="submit"  class="btn btn-info" value="Log-In"></p>
									</div>
								</div>
							</div>
						</div>
					</form>
            </li><!-- #user -->
            
            <!-- mypage -->
            <se:authorize access="isAuthenticated()">
			<li>
				<a href="/project_final/mypage/mypage.do"><i class="fa fa-user"></i><br>MyPage</a>
			</li>
			</se:authorize>  
 			
 			<!-- pro 2.0 -->
			<se:authorize access="hasRole('SPECIAL_USER')">
               <li class="dropdown active">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="1000">
						<i class="fa fa-tasks"></i><br>Pro 2.0 <span class="caret"></span>
					</a>
					<ul class="dropdown-menu dropdown-menu-left" role="menu">
						<li class="active"><a href="/project_final/stat/weather_main.do">Weather</a></li>
						<li><a href="/project_final/stat/month_main.do">Month</a></li>
					</ul>
				</li>
			</se:authorize>
			
            <!-- admin -->
            <se:authorize access="hasRole('ROLE_ADMIN')">  
				<li class="dropdown active">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="1000">
						<i class="fa fa-tasks"></i><br>Admin<span class="caret"></span>
					</a>
					<ul class="dropdown-menu dropdown-menu-left" role="menu">
						<li><a href="/project_final/admin/main.do">Pro</a></li>
						<li><a href="/project_final/review/adminlist.do">review</a></li>
						<li><a href="/project_final/list.do">Member</a></li>              
						<li><a href="/project_final/recommend/main.do">RecommendService</a></li> 
					</ul>
				</li>
 			</se:authorize>
 			
            </ul><!-- #menu -->
         </div>
         </div>
      </nav>
      
</body>
</html>
