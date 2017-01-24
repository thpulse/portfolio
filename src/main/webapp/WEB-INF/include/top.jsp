<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="kitri.user.vo.*" %>
    <%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
   <%@ taglib prefix="se" uri="http://www.springframework.org/security/tags"%>
   <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/earlyaccess/hanna.css" />
<style type="text/css">
/* search */
input[.tb1] {
    border: 3px solid #761A1A;
    border-radius: 8px;
    width: 80px;
    height: 30px;
}
 
</style>
<body>
   <!-- Top menu -->
   <nav class="navbar" role="navigation">
      <div class="container">
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="top-navbar-1">
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
               
               <se:authorize access="hasRole('ROLE_ADMIN')">
               <li class="dropdown active">
					<a href="/project_final/stat/weather_main.do" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="1000">
						<i class="fa fa-tasks"></i><br>Pro 2.0 <span class="caret"></span>
							</a>
					<ul class="dropdown-menu dropdown-menu-left" role="menu">
						<li class="active"><a href="/project_final/stat/weather_main.do">Weather</a></li>
						<li><a href="/project_final/stat/month_main.do">Month</a></li>
					</ul>
				</li>
				</se:authorize>
				
				<se:authorize access="isAuthenticated()">
                <li>
                 <a href="/project_final/mypage/mypage.do"><i class="fa fa-user"></i><br>MyPage</a>
                </li>
                </se:authorize>
                
               <se:authorize access="hasRole('ROLE_ADMIN')">  
               	<li class="dropdown active">
					<a href="/project_final/admin/main.do" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="1000">
						<i class="fa fa-tasks"></i><br>Admin <span class="caret"></span>
							</a>
					<ul class="dropdown-menu dropdown-menu-left" role="menu">
						<li class="active"><a href="/project_final/list.do">Member</a></li>
						
					</ul>
				</li>
                </se:authorize>
          
				<li>
				<se:authorize access="isAnonymous()">	
				<a href="#" onclick="login" data-toggle="modal" data-target="#myModal"><i class="fa fa-unlock"></i><br>Log-in</a>
				</se:authorize>  
				
				<se:authorize access="isAuthenticated()"> 
				<a href="/project_final/logout.do" onclick="logout"><i class="fa fa-lock"></i><br>LogOut</a>
				</se:authorize>  
				
				<se:authorize access="isAuthenticated()">
				 <li><a href="#"><i class="glyphicon glyphicon-user"></i><br><se:authentication property="principal.user_name"/></a>
                 </li>
				</se:authorize>
				
				<se:authorize access="isAnonymous()">  
               	<li class="dropdown active">
					<a href="/project_final/insert.do" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="1000">
						<i class="fa fa-tasks"></i><br>USER <span class="caret"></span>
							</a>
					<ul class="dropdown-menu dropdown-menu-left" role="menu">
						<li class="active"><a href="/project_final/insert.do">Sign-UP</a></li>
						<li class="active"><a href="/project_final/idsearch.do">ID/PW Ã£±â</a></li>
					</ul>
				</li>
                </se:authorize>
                  
                  
                  <!-- Modal -->
                 
                  <form role="form" action="/project_final/j_spring_security_check" method="POST">
   
                  <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                       <div class="modal-dialog modal-lg" role="document">
                      <div class="modal-content">
                        <div class="modal-header">
                       <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>

                        Id : <input type="text" name="user_id" placeholder="Username" required><br><br>
                        Password : <input type="password" name="user_pass" placeholder="Password" required>
                        </div>

                          <div class="form__field">
							<p><input type="submit"  class="btn btn-info" value="Log-In"></p>
                          </div>
                     </div>
                    </div>
                    
                    </div>
                    </form>
                    
            </li>
            </ul>
         </div>
         </div>
      </nav>
      <nav class="navbar" role="navigation">
      	<div class="container">
	      	<ul class="nav navbar-nav navbar-right">
      			<!-- ingyu search start 170117 -->
                  <li>
                     <div>
                          <form method='POST' action="/project_final/search/searchResult.do">
                        <select name="tag">
                           <option value="prfnm">Perform</option>
                           <option value="prfcast">cast</option>
                        </select>
                             <input type="text" class="tb1" name="Sword" placeholder="fill it">
                                <button type="submit" class="btn btn-link">Search</button>
                          </form>
                     </div>
                  </li>
                  <!-- ingyu search end 170117-->
			</ul>
		</div>
      </nav>
</body>
</html>
