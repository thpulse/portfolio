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
		    day31_Val = [01,02,03,04,05,06,07,08,09,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31];
			day30_Val = [01,02,03,04,05,06,07,08,09,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,30];
			day28_Val = [01,02,03,04,05,06,07,08,09,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28];
			day29_Val = [01,02,03,04,05,06,07,08,09,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29];
		
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
				}		  				
			}
		})
		//시,도를 보낸다.
		$("#selectform1").change(function() {
			$.get("/project_final/reservation/find_hall_sido.do", {
				"sido_Val" : $("#selectform1 option:selected").val()},after_sido, "json");
		});
		$("#selectform2").change(function() {
			var gungu_Val2=$("#selectform2 option:selected").val();
			$.get("/project_final/reservation/find_hall_gungu.do", {
				"gungu_Val" : encodeURI(gungu_Val2)},after_gungu, "json");
		});
		$("#selectform3").change(function() {
			var plcId=$("#selectform3 option:selected").val();
			$.get("/project_final/reservation/find_prf.do", {
				"plcId_Val" : $("#selectform3 option:selected").val()},after_prf, "json");
		});
	})		
		function after_sido(txt) {
			var gungu_val = txt.gungu_json_list;	
			var plc_val = txt.gungu_plc_list;
			var plcId_val = txt.gungu_plcId_list;
			
			var gungu_length = gungu_val.length;	
			var plc_val_length = plc_val.length;	
			//select box 초기화
			$("#selectform2").find("option").remove();
			for(i = 0; i < gungu_length; i++){
				var gungu = gungu_val[i];
				$("#selectform2").append("<option value="+gungu+">"+ gungu +"</option>");
			}			
			$("#selectform3").find("option").remove();
			for(i = 0; i < plc_val_length; i++){
				var plc = plc_val[i];
				var plcId = plcId_val[i];
				$("#selectform3").append("<option value="+plcId+">"+ plc +"</option>");
			}
		}
		function after_gungu(txt) {
			var plc_val = txt.plc_list;	
			var plcId_val = txt.plcId_list;	
			
			var plc_val_length = plc_val.length;
			var plcId_val_length = plcId_val.length;	
			//select box 초기화
			$("#selectform3").find("option").remove();
			for(i = 0; i < plc_val_length; i++){
				var plc = plc_val[i];
				var plcId= plcId_val[i];
				$("#selectform3").append("<option value="+plcId+">"+ plc +"</option>");
			}			
		}
		function after_prf(txt) {				
			$("#prf_detail_show").html("");
			var plc_obj_arr = txt.plc_list;	
			var plc_obj_length = plc_obj_arr.length;	
			if(plc_obj_length ==0){
				$("#prf_detail_show").append("<h2>현재 상영중인 공연이 없습니다.</h2>");
			}
			//select box 초기화

			for(i = 0; i < plc_obj_length; i++){
				var obj = plc_obj_arr[i];
				var plcPoster = obj.poster;
				var plcId= obj.plcid;
				var plcName=obj.prfnm;
				$("#prf_detail_show").append(
											"<div class = 'wrapper'>" +
											"<table class= 'table'>"+
											"<tr id='"+plcId+"' onclick=prf_detail('"+plcId+"')>"+
											"<td>"+
												"<img src='"+plcPoster+"'/>"+
												"<h3>"+plcName+"</h3>" +
											"</td>"+
											"</tr>" +
											"</table>"+
											"</div>"				
				)
				
			}
		}
		var prf_id_point;//공연아이디 클릭하는 순간 저장
		//공연상세정보(시간표 뿌리기)
		function prf_detail(id){
			$.get("/project_final/reservation/find_prf_detail.do", {
				"prf_id" : id}, prf_detail_after, "json");
			prf_id_point = id;
		}
		function prf_detail_after(prf){			
			$("#prf_timetable").html("");
			var year_val = $("#year_select").val();
			var month_val = $("#month_select").val();
			var day_val = $("#day_select").val();
			alert(year_val + month_val + day_val);
			var timeTable_json = prf.timeTable.timeTable_arr;
			var timeTable_length =timeTable_json.length;
			$("#prf_timetable").append(
										"<table class= 'table'>"+
										"<thead>"+
										"<tr>"+
										"<th>"+"공연명"+"</th>"+
										"<th>"+"시작일"+"</th>"+
										"<th>"+"종료일"+"</th>"+
										"<th>"+"가격"+"</th>"+	
										"</tr>"+
										"</thead>"+
										"<tbody>"+
										"<tr>"+
										"<td>"+ prf.prfnm+"</td>"+
										"<td>"+ prf.prfpdfrom+"</td>"+
										"<td>"+ prf.prfpdto+"</td>"+
										"<td>"+ prf.tckprice+"</td>"+										
										"</tr>"+
										"</tbody>"+										
										"</table>"
										);
			var table_Parts="";
			for(i=0; i < timeTable_length; i++){	
				table_Parts = table_Parts+"<tr>";
				for(j=0;j<timeTable_length;j++){
					var val = timeTable_json[j][i];
					if(val==null){
						table_Parts = table_Parts + "<td>-</td>";
					}else{
						onmouse = "onmouseover=location.href='/project_final/reservation/pre_chk.do?time=("+val+")&day="+j+"&id="+prf_id_point+"&year="+year_val+"&month="+month_val+"&day2="+day_val;
						table_Parts = table_Parts+"<td "+onmouse+"onclick=location.href='/project_final/reservation/seat.do?time=("+val+")&day="+j+"&id="+prf_id_point+"&year="+year_val+"&month="+month_val+"&day2="+day_val+"'>"+val+"</td>";
						
					}					
				}
				table_Parts = table_Parts+"</tr>";
			}
			$("#prf_timetable_detail").html("");
			$("#prf_timetable_detail").append(
												"<table class= 'table'>"+
												"<thead>"+
												"<tr>"+
													"<th>"+"일"+"</th>"+
													"<th>"+"월"+"</th>"+
													"<th>"+"화"+"</th>"+
													"<th>"+"수"+"</th>"+
													"<th>"+"목"+"</th>"+
													"<th>"+"금"+"</th>"+
													"<th>"+"토"+"</th>"+
												"</tr>"+
												"</thead>"+
												"<tbody>"+
												table_Parts+
												"</tbody>"+										
												"</table>"													
												);										
		}
		function reserv_do(val){
		}
		

</script>
<body>
	 <!-- Services -->
        
	        <div class="container">
	        	
	        		<div class="col-sm-6">
	        			<div class = "row">
	        				<div class="service wow fadeInUp">
			                <!-- fa fa-eye" -->
			                    <div class="service-icon"><i class="fa fa-table"></i></div>
			                    <h3>날짜선택</h3>
				                 <p>   
				                 	<select class="selectpicker" id="year_select" data-size="5">
				                   		<option value="00">년 선택</option>
				                   		<option value="2017">2017년</option>	
				                   		<option value="2018">2018년</option>			                    
				                    </select>
				                 	<select class="selectpicker" id="month_select" data-size="5" >
					                    <option value="00">월 선택</option>
										<option value="01">1월</option>
										<option value="02">2월</option>
										<option value="03">3월</option>
										<option value="04">4월</option>
										<option value="05">5월</option>
										<option value="06">6월</option>
										<option value="07">7월</option>
										<option value="08">8월</option>
										<option value="09">9월</option>
										<option value="10">10월</option>
										<option value="11">11월</option>
										<option value="12">12월</option>	
									</select>	
				                    <select class="selectpicker" id="day_select" data-size="5">
				                   		<option value="00">일 선택</option>		                    
				                    </select>
				                 </p>
		               		 </div>
	        			</div>
	        			<div class = "row">
		        			<div class="service wow fadeInDown">
			                    <div class="service-icon"><i class="fa fa-magic"></i></div>
			                    <h3>영화관선택</h3>
			                    <select class="w3-select" name="tel" id = "selectform1" size= "1">
									<option value="11">시/도 선택</option>
									<option value="11">서울</option>
									<option value="41">경기</option>
									<option value="26">부산</option>
									<option value="27">대구</option>
									<option value="28">인천</option>
									<option value="29">광주</option>
									<option value="30">대전</option>
									<option value="31">울산</option>
									<option value="36">세종시</option>
									<option value="42">강원도</option>
									<option value="43">충청북도</option>
									<option value="44">충청남도</option>
									<option value="45">전라북도</option>
									<option value="46">전라남도</option>
									<option value="47">경상북도</option>
									<option value="48">경상남도</option>
									<option value="50">제주특별자치도</option>
								</select>
								<select class="w3-select" name="tel2" id = "selectform2" size = "1">
									<option value="default">시/군/구 선택</option>
								</select>
								<select class="w3-select" name="tel3" id = "selectform3" size = "1">
									<option value="default">영화관 선택</option>
								</select>	
			                    <button type="button" class="btn btn-link" onclick="location.href='/project_final/reservation/find_hall_sido.do'">공연장출력</button>
			                </div>	        			
	        			</div>
	        			<div class = "row">
	        				<div class="service wow fadeInUp">
			                    <div class="service-icon"><i class="fa fa-magic"></i></div>
			                    <h3>공연선택</h3>
			                    <div id = "prf_detail_show">
			               		</div>        			
	        				</div>
	        			</div>
	        		</div>
	        			
	        			
	        		<div class="col-sm-6">
	        			 <div class="service wow fadeInDown">
			                    <div class="service-icon"><i class="fa fa-print"></i></div>
			                    <div id ="prf_timetable">
			                     </div>
			                     <div id ="prf_timetable_detail">
			                     </div>
			             </div>	        		
	        		</div>
	        		<div class="col-sm-6">
						  <a href = "/project_final/reservation/seat.do">
						  	<button type="button" class="btn btn-link" onclick="location.href='/project_final/reservation/seat.do' ">예매버튼 / 아이디/공연날짜, 시간/공연명 물고넘어감</button>
						  </a>     
	        		</div>
	    	</div>

</body>
</html>