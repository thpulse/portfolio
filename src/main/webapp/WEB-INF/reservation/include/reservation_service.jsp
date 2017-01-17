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
				                    <select class="w3-select" name="tel" id ="selectform1" size= "1">
										<option value="11">��/�� ����</option>
										<option value="11">����Ư����</option>
										<option value="26">�λ걤����</option>
										<option value="27">�뱸������</option>
										<option value="28">��õ������</option>
										<option value="29">���ֱ�����</option>
										<option value="30">����������</option>
										<option value="31">��걤����</option>
										<option value="36">����Ư����ġ��</option>
										<option value="42">������</option>
										<option value="43">��û�ϵ�</option>
										<option value="44">��û����</option>
										<option value="45">����ϵ�</option>
										<option value="46">���󳲵�</option>
										<option value="47">���ϵ�</option>
										<option value="48">��󳲵�</option>
										<option value="50">����Ư����ġ��</option>
									</select>
			                    <p>��ȭ���� ���⿡�ѷ������� �Ѵ�. / ���� ����</p>
			                </div>
	        			
	        			</div>
	        			<div class = "row">
	        				<div class="service wow fadeInUp">
			                    <div class="service-icon"><i class="fa fa-magic"></i></div>
			                    <h3>��������</h3>
			                    <p>������ + ��������</p>
			                </div>
	        			</div>
	        		</div>
	        		<div class="col-sm-6">
	        			 <div class="service wow fadeInDown">
			                    <div class="service-icon"><i class="fa fa-print"></i></div>
			                    <table class="table">
			                    	<thead>
			                    		<tr>
			                    			<th>�󿵽ð�</th>
			                    			<th>������</th>
			                    			<th>��/�����¼�</th>			                    		
			                    		</tr>			                    		
			                    	</thead>
			                    	<tbody>
			                    		<tr>
			                    			<td>19:00~21:00</td>
			                    			<td>��ζ�</td>
			                    			<td>30/100</td>			                    			
			                    		</tr>
			                    	</tbody>		                    
			                    </table>
			             </div>	        		
	        		</div>
	        		<div class="col-sm-6">
						  <a href = "/project_final/reservation/seat.do">
						  	<button type="button" class="btn btn-link" onclick="location.href='/project_final/reservation/seat.do' ">���Ź�ư / ���̵�/������¥, �ð�/������ ����Ѿ</button>
						  </a>     
	        		</div>
	        	</div>
	            
	            
	            <!-- <div class="row">
	            	<div class="col-sm-6">
		                
					</div>
					<div class="col-sm-12">
		                <div class="service wow fadeInDown">
		                    <div class="service-icon"><i class="fa fa-magic"></i></div>
		                    <h3>��ȭ������</h3>
		                    <p>��ȭ���� ���⿡�ѷ������� �Ѵ�. / ���� ����</p>
		                </div>
	                </div>	 
	                <div class="row">               
		                <div class="col-sm-6">
			                <div class="service wow fadeInUp">
			                    <div class="service-icon"><i class="fa fa-magic"></i></div>
			                    <h3>��������</h3>
			                    <p>������ + ��������</p>
			                </div>
		                </div>
		                <div class="col-sm-6">
			                <div class="service wow fadeInDown">
			                    <div class="service-icon"><i class="fa fa-print"></i></div>
			                    <h3>�����ð�����</h3>
			                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et...</p>
			                </div>
		                </div>
		            </div>
		              
	            </div> -->
	           
	        </div>
        </div>

</body>
</html>