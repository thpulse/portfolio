<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="/project_final/assets/css/Nwagon.css">
<script src="/project_final/assets/js/Nwagon.js"></script>
<title>Insert title here</title>
</head>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">

var arr=[0,0,0,0,0,0,0,0];

$(document).ready(function()
		{
		    $('#selectbox').change(function(){
		    	$( "#chart19" ).empty();
		    	var month = $('#selectbox option:selected').val();
		    	$.get("/project_final/stat/find2.do", {"month" : month},find_stats, "json");	  
		    });
		})
		function find_stats(data) {
			$("#month_show").html("");
			var month_obj_arr = data.month_list;	

			if(month_obj_arr.length ==0){
				$("#month_show").append("<h2>데이터가 없습니다.</h2>");
			}
			for(i = 0; i < month_obj_arr.length; i++){
				var obj = month_obj_arr[i];
				var addr1 = obj.addr1;
				var addr2= obj.addr2;
				var cate= obj.cate;
				var total=obj.total;
				if(cate=='연극'){
					arr[0]+=parseInt(total);
				}else if(cate=='뮤지컬'){
					arr[1]+=parseInt(total);
				}else if(cate=='클래식'){
					arr[2]+=parseInt(total);
				}else if(cate=='오페라'){
					arr[3]+=parseInt(total);
				}else if(cate=='무용'){
					arr[4]+=parseInt(total);
				}else if(cate=='발레'){
					arr[5]+=parseInt(total);
				}else if(cate=='국악'){
					arr[6]+=parseInt(total);
				}else if(cate=='복합'){
					arr[7]+=parseInt(total);
				}

 				$("#month_show").append("<div class = 'wrapper'>"
 						+"<table class= 'table'>"+
											"<tr>"+
											"<td>"+addr1+"</td>"+"<td>"+addr2+"</td>"+"<td>"+cate+"</td>"+"<td>"+total+"</td>"+
											"</tr>" +
											"</table>"+"</div>"
				) 	
			}
			var sum=arr[0]+arr[1]+arr[2]+arr[3]+arr[4]+arr[5]+arr[6]+arr[7];
			arr[0]=Math.round(arr[0]*100/sum);
			arr[1]=Math.round(arr[1]*100/sum);
			arr[2]=Math.round(arr[2]*100/sum);
			arr[3]=Math.round(arr[3]*100/sum);
			arr[4]=Math.round(arr[4]*100/sum);
			arr[5]=Math.round(arr[5]*100/sum);
			arr[6]=Math.round(arr[6]*100/sum);
			arr[7]=Math.round(arr[7]*100/sum);
			
		    var options = {
		    		'legend':{
		    			names: ['연극', '뮤지컬', '클래식', '오페라', '무용', '발레', '국악','복합'],
		    			hrefs: []
		    				},
		    		'dataset': {
		    			title: 'Web accessibility status',
		    			values: [arr], 
		    			bgColor: '#f9f9f9',
		    			fgColor: '#cc79a7'
		    		},
		    		'chartDiv': 'chart19',
		    		'chartType': 'radar',
		    		'chartSize': {width:600, height:450}
		    	};
		    Nwagon.chart(options);	
		}
		
</script>
	<h1>월별 장르 선호도</h1>
<h5>
	<select class="selectpicker" id="selectbox" data-size="5" >
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
	</h5>
		<div id="chart19"></div>
		<div id = "month_show">

	</div> 
</body>
</html>