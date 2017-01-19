<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="kitri.user.vo.*" %>
    <%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
   <%@ taglib prefix="se" uri="http://www.springframework.org/security/tags"%>
<style>  
   * {box-sizing: border-box;}  
      body{margin: 0;}  
      div {padding: 15px 0}
      form {  
        position: relative;  
      }  
     
   .d1 input {  
        width: 33%;  
        height: 42px;  
        padding-left: 10px;  
        border: 2px solid #99004C;  
        border-radius: 5px;  
        outline: none;  
        background: #F9F0DA;  
        color: #9E9C9C;  
   }  
   
   .d1 button {  
        position: absolute;   
        top: 0;  
        right: 0px;  
        width: 42px;  
          height: 42px;  
        border: none;  
        background: #99004C;  
        border-radius: 0 5px 5px 0;  
        cursor: pointer;  
   }
   
   .d1 button:before {  
        content: "\f002";  
        font-family: FontAwesome;  
        font-size: 16px;  
          color: #F9F0DA;  
   }
</style>  
        
 	<%--  <%loginVO user = (loginVO) session.getAttribute("loginUser"); %> --%>
    <%-- <%UserVO user2 = (UserVO) session.getAttribute("loginUser"); %> --%>

<body>
   <!-- Top menu -->
   <nav class="navbar" role="navigation">
      <div class="container">
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="top-navbar-1">
               <ul class="nav navbar-nav navbar-right">

			   <se:authorize access="isAnonymous()">
               <li>
                  <a href="/project_final/index.do"><i class="fa fa-home"></i><br>Home</a>
               </li>
               </se:authorize>
              
               <se:authorize access="isAnonymous()">
               <li>
                   <a href="/project_final/perform/prfinfo/select.do"><i class="fa fa-camera"></i><br>Perform_Info</a>
                </li>
               </se:authorize>
               <li>
                   <a href="/project_final/reservation/main.do"><i class="fa fa-comments"></i><br>Reservation</a>
                </li>
               
               <se:authorize access="hasRole('ROLE_ADMIN')">
               <li class="dropdown active">
					<a href="/project_final/stat/weather_main.do" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="1000">
						<i class="fa fa-tasks"></i><br>Pro 2.0 <span class="caret"></span>
							</a>
					<ul class="dropdown-menu dropdown-menu-left" role="menu">
						<li class="active"><a href="/project_final/stat/weather_main.do">날씨별 통계</a></li>
						<li><a href="/project_final/stat/month_main.do">월별 통계</a></li>
					</ul>
				</li>
				</se:authorize>
				
				<se:authorize access="isAuthenticated()">
                <li>
                 <a href="/project_final/mypage/mypage.do"><i class="fa fa-user"></i><br>MyPage</a>
                </li>
                </se:authorize> 
                
                <li>
                <a href="/project_final/review/Reviewlist.do"><i class="fa fa-envelope"></i><br>Review</a>
                </li>
                
                <se:authorize access="hasRole('ROLE_ADMIN')">  
                <li>
				<a href="/project_final/admin/main.do"><i class="fa fa-user"></i><br>Admin</a>
				</li>
                </se:authorize>
                
                <se:authorize access="hasRole('ROLE_ADMIN')"> 
				<li>
				<a href="/project_final/list.do" onclick="list"><i class="fa fa-user"></i><br>회원관리</a>
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
                  
                  
                  <!-- Modal -->
                 
                  <form role="form" action="/project_final/j_spring_security_check" method="POST">
   
                  <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                       <div class="modal-dialog modal-lg" role="document">
                      <div class="modal-content">
                        <div class="modal-header">
                       <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>

                        Id : <input type="text" name="user_id" class="form__input" placeholder="Username" required><br><br>
                         Password : <input type="password" name="user_pass" class="form__input" placeholder="Password" required>
                        </div>

                          <div class="form__field">
                               <p><input type="submit"  class="btn btn-info" value="Log-In">
                                 <input type="submit" onclick="location.href='/project_final/insert.do'" class="btn btn-info" value="Sign-up"></p>
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
                     <div class="d1">
                          <form method='POST' action="/project_final/search/searchResult.do">
                        <select name="tag">
                           <option value="prfnm">Perform</option>
                           <option value="plcnm">ConcertHall</option>
                        </select>
                             <input type="text" name="Sword" placeholder="fill it">
                                <button type="submit"></button>
                          </form>
                     </div>
                  </li>
                  <!-- ingyu search end 170117-->
			</ul>
		</div>
      </nav>
</body>
</html>
