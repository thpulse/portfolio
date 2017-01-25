<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <%@ taglib prefix="se" uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script type="text/javascript">
	var cnt_R = 0;
	var cnt_S = 0;
	var cnt_A = 0;
	var cnt_total = 0;
	//좌석
	var row = 0;
	var col = 0;
	//좌석갯수체크
	var len_R=0;
	var len_S=0;
	var len_A=0;
	var len_total=0;
	//chk된 좌석Arr
	var arrChk= new Array();
	var arrChk_R= new Array();	
	var arrChk_S= new Array();	
	var arrChk_A= new Array();	
	//결과창 출력
	var R_list;
	var S_list;
	var A_list;
	
	$(document).ready(function(){
		//변수선언
		var cnt_R = 0;
		var cnt_S = 0;
		var cnt_A = 0;
		var cnt_total = 0;
		//좌석
		var row = 0;
		var col = 0;
		//좌석갯수체크
		var len_R=0;
		var len_S=0;
		var len_A=0;
		var len_total=0;
		//chk된 좌석Arr
		var arrChk= new Array();
		var arrChk_R= new Array();	
		var arrChk_S= new Array();	
		var arrChk_A= new Array();	
		//결과창 출력
		var R_list;
		var S_list;
		var A_list;
		
		$(":checkbox").on("click",function(){	//체크박스 클릭할 때마다 Ajax로 예약여부 체크해서 갱신
			var seatNum = $(this).val();
			row = seatNum.split("_")[1];
			col = seatNum.split("_")[2];
			seat_class = seatNum.split("_")[0];
			cnt_R = $("#num_R option:selected").val();
			cnt_S = $("#num_S option:selected").val();
			cnt_A = $("#num_A option:selected").val();
			cnt_total = parseInt(cnt_R) + parseInt(cnt_S) + parseInt(cnt_A);
			len_R = $("input[name=R]:checked").length;
			len_S = $("input[name=S]:checked").length;
			len_A = $("input[name=A]:checked").length;
			len_total = parseInt(len_R) + parseInt(len_S) + parseInt(len_A);
			
			//$("#R_0_0").attr("disabled","disabled");//비활성화
			//val얻어서 좌석등급과 + 시킨다.	
			arrChk.push($(this).val());
			
			//포스터 밑에 객석정보  
			var R_list="";
			var S_list="";
			var A_list="";
			
			//R석 갯수로만 체크
			$("input[name=R]:checked").each(function(){					
				R_list = R_list + $(this).val();
			});
			$("input[name=R]").on("click",function(){
				arrChk_R.push($(this).val());
			});			
			//S석 갯수로만 체크
			$("input[name=S]:checked").each(function(){					
				S_list = S_list + $(this).val();
			});
			$("input[name=S]").on("click",function(){
				arrChk_S.push($(this).val());
			});
			//A석 갯수로만 체크
			$("input[name=A]:checked").each(function(){					
				A_list = A_list + $(this).val();
			});
			$("input[name=A]").on("click",function(){
				arrChk_A.push($(this).val());
			});
			//포스터 밑에 객석표시
			$("#seatNum_R").html(); $("#seatNum_R").html(R_list);
			$("#seatNum_S").html(); $("#seatNum_S").html(S_list);
			$("#seatNum_A").html(); $("#seatNum_A").html(A_list);
			
			//총 갯수			
			if(cnt_total < len_total){	//갯수 초과시 방금 체크한 건 취소하도록
				var uncheckedVal = arrChk[arrChk.length-1];
				//갯수초과 후 마지막 체크한 것 취소
				$("input[name=R]:checked").each(function(){
					if($(this).val()==uncheckedVal){
						$(this).attr("checked", false);	
					} 
				});
				$("input[name=S]:checked").each(function(){
					if($(this).val()==uncheckedVal){
						$(this).attr("checked", false);
					}
				});	
				$("input[name=A]:checked").each(function(){
					if($(this).val()==uncheckedVal){
						$(this).attr("checked", false);
					}
				});	
			}
			//R석 체크
			if(cnt_R < len_R){
				$("input[name=R]:checked").each(function(){
					var uncheckedVal_R = arrChk_R[arrChk_R.length-1];	
					if($(this).val()==uncheckedVal_R){
						$(this).attr("checked", false);	
					} 
				});					
			}else if(cnt_S < len_S){
				$("input[name=S]:checked").each(function(){
					var uncheckedVal_S = arrChk_S[arrChk_S.length-1];	
					if($(this).val()==uncheckedVal_S){
						$(this).attr("checked", false);	
					} 
				});		
				
			}else if(cnt_A < len_A){
				$("input[name=A]:checked").each(function(){
					var uncheckedVal_A = arrChk_A[arrChk_A.length-1];	
					if($(this).val()==uncheckedVal_A){
						$(this).attr("checked", false);	
					} 
				});	
			}
		})
		
		//예약된 좌석 선별
		$.get("/project_final/reservation/seat_chk.do",
					{ 	
						"prf_day" : "${reserv_date}",
						"prf_starttime" : "${reserv_time}",
						"reserv_time_yo": "${reserv_time_yo}"
					},
					booked_chk, "json");
		//예약된 좌석 disabled처리	
		function booked_chk(obj){
			var obj_arr = obj.timeTable;
			var obj_arr_length = obj.timeTable.length;
			for(i=0; i < obj_arr_length;i++){
				var seat_num = obj_arr[i];
				$(":checkbox").each(function(){
					if($(this).val()==seat_num){
						$(this).attr("disabled","disabled");	
					} 
				});
				
			}
		}	
		
	})
	//체크되어있는 박스 선별
	function do_reserv(){
		var arrChk= new Array();
		$('input:checkbox[name="R"]').each(function() {
		     // this.checked = true; //checked 처리
		      if(this.checked){//checked 처리된 항목의 값
		    	  arrChk.push($(this).val()); 
		      }
		 });
		$('input:checkbox[name="S"]').each(function() {
		      //this.checked = true; //checked 처리
		      if(this.checked){//checked 처리된 항목의 값
		    	  arrChk.push($(this).val()); 
		      }
		 });
		$('input:checkbox[name="A"]').each(function() {
		      //this.checked = true; //checked 처리
		      if(this.checked){//checked 처리된 항목의 값
		    	  arrChk.push($(this).val()); 
		      }
		 });
		alert(arrChk);
		var formData ={
				user_id : "<se:authentication property="principal.username"/>",
				seat : arrChk.toString(),
				prfid:	"${prfid_val}",
				reserv_date : "${reserv_date}",
				reserv_time : "${reserv_time}",
				reserv_time_yo : "${reserv_time_yo}"
				
		};
		
		$.ajax({
		    url : "/project_final/reservation/booking.do",
		    type: "POST",
		    data : formData,
		    success: function(data, textStatus, jqXHR)
		    {
		    	setTimeout("location.href='/project_final/index.do'",100);
		        //data - response from server
		    },
		    error: function (jqXHR, textStatus, errorThrown)
		    {
		 
		    }
		});
		
	}

</script>
</head>
<body>	
		<div class="container-fluid">
		  <h1>좌석예약페이지!</h1>
			  <div class="row">	
			  		<div class="col-sm-2" style="background-color:yellow;"><p>여백</p></div>
				    	<div class="col-sm-5" style="background-color:lavender;">
				    		<p>인원/좌석선택</p>
				    			
				    				<p>좌석갯수</p>
				    				R석			 			
						    		<select class="selectpicker" id="num_R" data-size="5" >
						    			<option value="0">0</option>
						    			<option value="1">1</option>
						    			<option value="2">2</option>
						    			<option value="3">3</option>
						    			<option value="4">4</option>
						    			<option value="5">5</option>
						    		</select>
						    		S석
						    		<select class="selectpicker" id="num_S" data-size="5" >
						    			<option value="0">0</option>
						    			<option value="1">1</option>
						    			<option value="2">2</option>
						    			<option value="3">3</option>
						    			<option value="4">4</option>
						    			<option value="5">5</option>
						    		</select>
						    		A석
						    		<select class="selectpicker" id="num_A" data-size="5" >
						    			<option value="0">0</option>
						    			<option value="1">1</option>
						    			<option value="2">2</option>
						    			<option value="3">3</option>
						    			<option value="4">4</option>
						    			<option value="5">5</option>
						    		</select>
				    						    		
				    			<br/>				    			
				    			<br/>
					    		<div class="chkbox">
					    			  <p>R석</p>
								      <input type="checkbox" name="R" id="R_0_0" value="R_0_0">
								      <input type="checkbox" name="R" id="R_0_1" value="R_0_1">
								      <input type="checkbox" name="R" id="R_0_2" value="R_0_2">
								      <input type="checkbox" name="R" id="R_0_3" value="R_0_3">
								      <input type="checkbox" name="R" id="R_0_4" value="R_0_4">
								      <input type="checkbox" name="R" id="R_0_5" value="R_0_5">
								      <input type="checkbox" name="R" id="R_0_6" value="R_0_6">
								      <input type="checkbox" name="R" id="R_0_7" value="R_0_7">
								      <input type="checkbox" name="R" id="R_0_8" value="R_0_8">
								      <input type="checkbox" name="R" id="R_0_9" value="R_0_9">
								      <input type="checkbox" name="R" id="R_0_10"value="R_0_10">
								</div>
								<div class="chkbox">
								      <input type="checkbox" name="R" id="R_1_0" value="R_1_0">
								      <input type="checkbox" name="R" id="R_1_1" value="R_1_1">
								      <input type="checkbox" name="R" id="R_1_2" value="R_1_2">
								      <input type="checkbox" name="R" id="R_1_3" value="R_1_3">
								      <input type="checkbox" name="R" id="R_1_4" value="R_1_4">
								      <input type="checkbox" name="R" id="R_1_5" value="R_1_5">
								      <input type="checkbox" name="R" id="R_1_6" value="R_1_6">
								      <input type="checkbox" name="R" id="R_1_7" value="R_1_7">
								      <input type="checkbox" name="R" id="R_1_8" value="R_1_8">
								      <input type="checkbox" name="R" id="R_1_9" value="R_1_9">
								      <input type="checkbox" name="R" id="R_1_10" value="R_1_10">
								</div>		
								<div class="chkbox">
								      <input type="checkbox" name="R" id="R_2_0" value="R_2_0">
								      <input type="checkbox" name="R" id="R_2_1" value="R_2_1">
								      <input type="checkbox" name="R" id="R_2_2" value="R_2_2">
								      <input type="checkbox" name="R" id="R_2_3" value="R_2_3">
								      <input type="checkbox" name="R" id="R_2_4" value="R_2_4">
								      <input type="checkbox" name="R" id="R_2_5" value="R_2_5">
								      <input type="checkbox" name="R" id="R_2_6" value="R_2_6">
								      <input type="checkbox" name="R" id="R_2_7" value="R_2_7">
								      <input type="checkbox" name="R" id="R_2_8" value="R_2_8">
								      <input type="checkbox" name="R" id="R_2_9" value="R_2_9">
								      <input type="checkbox" name="R" id="R_2_10" value="R_2_10">
								</div>	
								<br/>
								<div class="chkbox">
					    			  <p>S석</p>
								      <input type="checkbox" name="S" id="S_0_0" value="S_0_0">
								      <input type="checkbox" name="S" id="S_0_1" value="S_0_1">
								      <input type="checkbox" name="S" id="S_0_2" value="S_0_2">
								      <input type="checkbox" name="S" id="S_0_3" value="S_0_3">
								      <input type="checkbox" name="S" id="S_0_4" value="S_0_4">
								      <input type="checkbox" name="S" id="S_0_5" value="S_0_5">
								      <input type="checkbox" name="S" id="S_0_6" value="S_0_6">
								      <input type="checkbox" name="S" id="S_0_7" value="S_0_7">
								      <input type="checkbox" name="S" id="S_0_8" value="S_0_8">
								      <input type="checkbox" name="S" id="S_0_9" value="S_0_9">
								      <input type="checkbox" name="S" id="S_0_10" value="S_0_10">
								</div>
								<div class="chkbox">
								      <input type="checkbox" name="S" id="S_1_0" value="S_1_0">
								      <input type="checkbox" name="S" id="S_1_1" value="S_1_1">
								      <input type="checkbox" name="S" id="S_1_2" value="S_1_2">
								      <input type="checkbox" name="S" id="S_1_3" value="S_1_3">
								      <input type="checkbox" name="S" id="S_1_4" value="S_1_4">
								      <input type="checkbox" name="S" id="S_1_5" value="S_1_5">
								      <input type="checkbox" name="S" id="S_1_6" value="S_1_6">
								      <input type="checkbox" name="S" id="S_1_7" value="S_1_7">
								      <input type="checkbox" name="S" id="S_1_8" value="S_1_8">
								      <input type="checkbox" name="S" id="S_1_9" value="S_1_9">
								      <input type="checkbox" name="S" id="S_1_10" value="S_1_10">
								</div>
								<div class="chkbox">
								      <input type="checkbox" name="S" id="S_2_0" value="S_2_0">
								      <input type="checkbox" name="S" id="S_2_1" value="S_2_1">
								      <input type="checkbox" name="S" id="S_2_2" value="S_2_2">
								      <input type="checkbox" name="S" id="S_2_3" value="S_2_3">
								      <input type="checkbox" name="S" id="S_2_4" value="S_2_4">
								      <input type="checkbox" name="S" id="S_2_5" value="S_2_5">
								      <input type="checkbox" name="S" id="S_2_6" value="S_2_6">
								      <input type="checkbox" name="S" id="S_2_7" value="S_2_7">
								      <input type="checkbox" name="S" id="S_2_8" value="S_2_8">
								      <input type="checkbox" name="S" id="S_2_9" value="S_2_9">
								      <input type="checkbox" name="S" id="S_2_10" value="S_2_10">
								</div>
								<div class="chkbox">
					    			  <p>A석</p>
								      <input type="checkbox" name="A" id="A_0_0" value="A_0_0">
								      <input type="checkbox" name="A" id="A_0_1" value="A_0_1">
								      <input type="checkbox" name="A" id="A_0_2" value="A_0_2">
								      <input type="checkbox" name="A" id="A_0_3" value="A_0_3">
								      <input type="checkbox" name="A" id="A_0_4" value="A_0_4">
								      <input type="checkbox" name="A" id="A_0_5" value="A_0_5">
								      <input type="checkbox" name="A" id="A_0_6" value="A_0_6">
								      <input type="checkbox" name="A" id="A_0_7" value="A_0_7">
								      <input type="checkbox" name="A" id="A_0_8" value="A_0_8">
								      <input type="checkbox" name="A" id="A_0_9" value="A_0_9">
								      <input type="checkbox" name="A" id="A_0_10" value="A_0_10">
								</div>
								<div class="chkbox">
								      <input type="checkbox" name="A" id="A_1_0" value="A_1_0">
								      <input type="checkbox" name="A" id="A_1_1" value="A_1_1">
								      <input type="checkbox" name="A" id="A_1_2" value="A_1_2">
								      <input type="checkbox" name="A" id="A_1_3" value="A_1_3">
								      <input type="checkbox" name="A" id="A_1_4" value="A_1_4">
								      <input type="checkbox" name="A" id="A_1_5" value="A_1_5">
								      <input type="checkbox" name="A" id="A_1_6" value="A_1_6">
								      <input type="checkbox" name="A" id="A_1_7" value="A_1_7">
								      <input type="checkbox" name="A" id="A_1_8" value="A_1_8">
								      <input type="checkbox" name="A" id="A_1_9" value="A_1_9">
								      <input type="checkbox" name="A" id="A_1_10" value="A_1_10">
								</div>
								<div class="chkbox">
								      <input type="checkbox" name="A" id="A_2_0" value="A_2_0">
								      <input type="checkbox" name="A" id="A_2_1" value="A_2_1">
								      <input type="checkbox" name="A" id="A_2_2" value="A_2_2">
								      <input type="checkbox" name="A" id="A_2_3" value="A_2_3">
								      <input type="checkbox" name="A" id="A_2_4" value="A_2_4">
								      <input type="checkbox" name="A" id="A_2_5" value="A_2_5">
								      <input type="checkbox" name="A" id="A_2_6" value="A_2_6">
								      <input type="checkbox" name="A" id="A_2_7" value="A_2_7">
								      <input type="checkbox" name="A" id="A_2_8" value="A_2_8">
								      <input type="checkbox" name="A" id="A_2_9" value="A_2_9">
								      <input type="checkbox" name="A" id="A_2_10" value="A_2_10">
								</div>																					    		
				    	</div>				    	
				    	<div class="col-sm-3" style="background-color:lavender;">
				    		<p><img src="${poster}"/></p>
				    		
				    		<!-- 총금액 : <div id="total_cash" >20000원</div> -->
				    		<table class="table">
				    		<tr>
				    			<td>공연명</td>
				    			<td>${prfnm}</td>
				    		</tr>
				    		<tr>
				    			<td>공연장소</td>
				    			<td>${plcnm}</td>
				    		</tr>
				    		<tr>
				    			<td>예약날짜</td>
				    			<td>${reserv_date} / ${reserv_time}</td>
				    		</tr>
				    		</table>
				    	<table class="table">
						 <!-- request 영역의 map으로 forEach문 실행한다. -->
						 <c:forEach var="list" items="${priceMap}" varStatus="num">
						 <tr>						
						<!--map.key는 key값을 출력한다...  --> 
						 <td id="${list.key}">${list.key}석</td>
						<!--map.value로 이중 forEach문을 실행한다..  --> 
						  <c:forEach var="item" items="${list.value}">
						 <td id="${item}">${item} 원</td>
						  </c:forEach>
						 </tr>  
						 </c:forEach>
						 </table>
						 선택한 좌석
						 <table class="table">
						 <tr>
						 	<td>R석</td>
						 	<td id="seatNum_R"></td>		 	
						 </tr> 
						 <tr>
						 	<td>S석</td>
						 	<td id="seatNum_S"></td>		 	
						 </tr> 
						 <tr>
						 	<td>A석</td>
						 	<td id="seatNum_A"></td>		 	
						 </tr> 
						 </table>
						 					
				    	<button type="button" class="btn btn-success" onclick="javascript:do_reserv()">예약하기</button>					    		
				    	</div>
				    	 	    	
			    	<div class="col-sm-2" style="background-color:yellow;"><p>여백</p></div>
			  </div>
		</div>
</body>
</html>