<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	    day31_Val = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31];
		day30_Val = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,30];
		day28_Val = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28];
		day29_Val = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29];
		
		$("#month_select").change(function(){
			var month_Val = $("#month_select option:selected").val();
			$("#day_select").html("");
			if(month_Val % 2 == 1 || month_Val == 8){
				for(i = 0; i < day31_Val.length; i++){
					$("#day_select").append("<option value=" + day31_Val[i] + ">" + day31_Val[i] +"일</option>");	
				}
			}else if(month_Val % 2 == 0){
				for(i = 0; i < day30_Val.length; i++){
					$("#day_select").append("<option value=" + day30_Val[i] + ">" + day30_Val[i] +"일</option>");	
				}		  					
			}else if(month_Val/4 && month_Val%4 !=0 ){
				//윤년체크
				for(i = 0; i < day29_Val.length; i++){
					$("#day_select").append("<option value=" + day29_Val[i] + ">" + day29_Val[i] +"일</option>");	
				}		  				
			}else if(month_Val==2) {
				for(i = 0; i < day28_Val.length; i++){
					$("#day_select").append("<option value=" + day28_Val[i] + ">" + day28_Val[i] +"일</option>");	
				}u		  				
			}
		})
		
		
	}
	
})

</script>
<body>
	 <!-- Services -->
        <div class="services-container">
	        <div class="container">
	        	<div class="row">
	        		<div class="col-sm-6">
	        			<div class = "row">
	        				<div class="service wow fadeInUp">
			                <!-- fa fa-eye" -->
			                    <div class="service-icon"><i class="fa fa-table"></i></div>
			                    <h3>날짜선택</h3>
				                 <p>   
				                 	<select class="selectpicker" id="month_select" data-size="5" >
					                    <option value="default">월 선택</option>
										<option value="1">1월</option>
										<option value="2">2월</option>
										<option value="3">3월</option>
										<option value="4">4월</option>
										<option value="5">5월</option>
										<option value="6">6월</option>
										<option value="7">7월</option>
										<option value="8">8월</option>
										<option value="9">9월</option>
										<option value="10">10월</option>
										<option value="11">11월</option>
										<option value="12">12월</option>	
									</select>	
				                    <select class="selectpicker" id="day_select" data-size="5">
				                   		<option value="default">일 선택</option>		                    
				                    </select>
				                 </p>
		               		 </div>
	        			</div>
	        			<div class = "row">
		        			<div class="service wow fadeInDown">
			                    <div class="service-icon"><i class="fa fa-magic"></i></div>
			                    <h3>영화관선택</h3>
				                    <select class="w3-select" name="tel" id ="selectform1" size= "1">
										<option value="11">시/도 선택</option>
										<option value="11">서울특별시</option>
										<option value="26">부산광역시</option>
										<option value="27">대구광역시</option>
										<option value="28">인천광역시</option>
										<option value="29">광주광역시</option>
										<option value="30">대전광역시</option>
										<option value="31">울산광역시</option>
										<option value="36">세종특별자치시</option>
										<option value="42">강원도</option>
										<option value="43">충청북도</option>
										<option value="44">충청남도</option>
										<option value="45">전라북도</option>
										<option value="46">전라남도</option>
										<option value="47">경상북도</option>
										<option value="48">경상남도</option>
										<option value="50">제주특별자치도</option>
									</select>
			                    <p>영화관이 여기에뿌려지도록 한다. / 극장 나열</p>
			                </div>
	        			
	        			</div>
	        			<div class = "row">
	        				<div class="service wow fadeInUp">
			                    <div class="service-icon"><i class="fa fa-magic"></i></div>
			                    <h3>공연선택</h3>
			                    <p>포스터 + 공연제목</p>
			                </div>
	        			</div>
	        		</div>
	        		<div class="col-sm-6">
	        			 <div class="service wow fadeInDown">
			                    <div class="service-icon"><i class="fa fa-print"></i></div>
			                    <table class="table">
			                    	<thead>
			                    		<tr>
			                    			<th>상영시간</th>
			                    			<th>공연명</th>
			                    			<th>관/남은좌석</th>			                    		
			                    		</tr>			                    		
			                    	</thead>
			                    	<tbody>
			                    		<tr>
			                    			<td>19:00~21:00</td>
			                    			<td>놀부띠</td>
			                    			<td>30/100</td>			                    			
			                    		</tr>
			                    	</tbody>		                    
			                    </table>
			             </div>	        		
	        		</div>
	        		<div class="col-sm-6">
						  <a href = "/project_final/reservation/seat.do">
						  	<button type="button" class="btn btn-link" onclick="location.href='/project_final/reservation/seat.do' ">예매버튼 / 아이디/공연날짜, 시간/공연명 물고넘어감</button>
						  </a>     
	        		</div>
	        	</div>
	            
	            
	            <!-- <div class="row">
	            	<div class="col-sm-6">
		                
					</div>
					<div class="col-sm-12">
		                <div class="service wow fadeInDown">
		                    <div class="service-icon"><i class="fa fa-magic"></i></div>
		                    <h3>영화관선택</h3>
		                    <p>영화관이 여기에뿌려지도록 한다. / 극장 나열</p>
		                </div>
	                </div>	 
	                <div class="row">               
		                <div class="col-sm-6">
			                <div class="service wow fadeInUp">
			                    <div class="service-icon"><i class="fa fa-magic"></i></div>
			                    <h3>공연선택</h3>
			                    <p>포스터 + 공연제목</p>
			                </div>
		                </div>
		                <div class="col-sm-6">
			                <div class="service wow fadeInDown">
			                    <div class="service-icon"><i class="fa fa-print"></i></div>
			                    <h3>공연시간선택</h3>
			                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et...</p>
			                </div>
		                </div>
		            </div>
		              
	            </div> -->
	           
	        </div>
        </div>

</body>
</html>