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
					$("#day_select").append("<option value=" + day31_Val[i] + ">" + day31_Val[i] +"��</option>");	
				}
			}else if(month_Val % 2 == 0){
				for(i = 0; i < day30_Val.length; i++){
					$("#day_select").append("<option value=" + day30_Val[i] + ">" + day30_Val[i] +"��</option>");	
				}		  					
			}else if(month_Val/4 && month_Val%4 !=0 ){
				//����üũ
				for(i = 0; i < day29_Val.length; i++){
					$("#day_select").append("<option value=" + day29_Val[i] + ">" + day29_Val[i] +"��</option>");	
				}		  				
			}else if(month_Val==2) {
				for(i = 0; i < day28_Val.length; i++){
					$("#day_select").append("<option value=" + day28_Val[i] + ">" + day28_Val[i] +"��</option>");	
				}		  				
			}
		})
		//��,���� ������.
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
			//select box �ʱ�ȭ
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
			//select box �ʱ�ȭ
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
				$("#prf_detail_show").append("<h2>���� ������ ������ �����ϴ�.</h2>");
			}
			//select box �ʱ�ȭ

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
		//����������(�ð�ǥ �Ѹ���)
		function prf_detail(id){
			$.get("/project_final/reservation/find_prf_detail.do", {
				"prf_id" : id},prf_detail_after, "json");
		}
		function prf_detail_after(prf){			
			$("#prf_timetable").html("");
			$("#prf_timetable").append(
										"<table class= 'table'>"+
										"<thead>"+
										"<tr>"+
										"<th>"+"������"+"</th>"+
										"<th>"+"������"+"</th>"+
										"<th>"+"������"+"</th>"+
										"<th>"+"����"+"</th>"+
										"<th>"+"��������"+"</th>"+
										"</thead>"+
										"<tbody>"+
										"<tr>"+
										"<td>"+ prf.prfnm+"</td>"+
										"<td>"+ prf.prfpdfrom+"</td>"+
										"<td>"+ prf.prfpdto+"</td>"+
										"<td>"+ prf.tckprice+"</td>"+
										"<td>"+ prf.prfdaytime+"</td>"+
										"<tr>"+
										"</tbody>"+										
										"</table>"
										);
										
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
			                    <h3>��¥����</h3>
				                 <p>   
				                 	<select class="selectpicker" id="month_select" data-size="5" >
					                    <option value="default">�� ����</option>
										<option value="1">1��</option>
										<option value="2">2��</option>
										<option value="3">3��</option>
										<option value="4">4��</option>
										<option value="5">5��</option>
										<option value="6">6��</option>
										<option value="7">7��</option>
										<option value="8">8��</option>
										<option value="9">9��</option>
										<option value="10">10��</option>
										<option value="11">11��</option>
										<option value="12">12��</option>	
									</select>	
				                    <select class="selectpicker" id="day_select" data-size="5">
				                   		<option value="default">�� ����</option>		                    
				                    </select>
				                 </p>
		               		 </div>
	        			</div>
	        			<div class = "row">
		        			<div class="service wow fadeInDown">
			                    <div class="service-icon"><i class="fa fa-magic"></i></div>
			                    <h3>��ȭ������</h3>
			                    <select class="w3-select" name="tel" id = "selectform1" size= "1">
									<option value="11">��/�� ����</option>
									<option value="11">����</option>
									<option value="41">���</option>
									<option value="26">�λ�</option>
									<option value="27">�뱸</option>
									<option value="28">��õ</option>
									<option value="29">����</option>
									<option value="30">����</option>
									<option value="31">���</option>
									<option value="36">������</option>
									<option value="42">������</option>
									<option value="43">��û�ϵ�</option>
									<option value="44">��û����</option>
									<option value="45">����ϵ�</option>
									<option value="46">���󳲵�</option>
									<option value="47">���ϵ�</option>
									<option value="48">��󳲵�</option>
									<option value="50">����Ư����ġ��</option>
								</select>
								<select class="w3-select" name="tel2" id = "selectform2" size = "1">
									<option value="default">��/��/�� ����</option>
								</select>
								<select class="w3-select" name="tel3" id = "selectform3" size = "1">
									<option value="default">��ȭ�� ����</option>
								</select>	
			                    <button type="button" class="btn btn-link" onclick="location.href='/project_final/reservation/find_hall_sido.do' ">���������</button>
			                </div>	        			
	        			</div>
	        			<div class = "row">
	        				<div class="service wow fadeInUp">
			                    <div class="service-icon"><i class="fa fa-magic"></i></div>
			                    <h3>��������</h3>
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
			             </div>	        		
	        		</div>
	        		<div class="col-sm-6">
						  <a href = "/project_final/reservation/seat.do">
						  	<button type="button" class="btn btn-link" onclick="location.href='/project_final/reservation/seat.do' ">���Ź�ư / ���̵�/������¥, �ð�/������ ����Ѿ</button>
						  </a>     
	        		</div>
	    	</div>

</body>
</html>