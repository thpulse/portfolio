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
var play=function (catenm){
	$( "#chart_detail" ).empty();
	var month = $('#selectbox option:selected').val();
	$.get("/project_final/stat/cate_find2.do", {month: encodeURI(month),cate: encodeURI(catenm)},find_play, "json");
}
function find_play(data1){
		var cate_obj_arr = data1.cate_list;
		var addr_arr=new Array(cate_obj_arr.length);
		var tot_arr=new Array(cate_obj_arr.length);
	 for(i = 0; i < cate_obj_arr.length; i++){
		var obj = cate_obj_arr[i];
		var addr1 = obj.addr1;
		var addr2= obj.addr2;
		var cate= obj.cate;
		var total=obj.total;
		addr_arr[i]=addr1+" "+addr2;
		tot_arr[i]=parseInt(total);
	}
		var sum=0;
	for (var len = 0; len < tot_arr.length; len++) {
		sum+=tot_arr[len]
	}
	for (var leng = 0; leng < tot_arr.length; leng++) {
		tot_arr[leng]=Math.ceil(tot_arr[leng]*100/sum);
	} 
	var options = {
			'legend': {
	            names: addr_arr,
	            hrefs: []
	        },
	        'dataset': {
	            title: 'Playing time per day',
	            values: tot_arr,
	            colorset: ['#56b4e9'],
	            fields:[cate]
	        },
	        'chartDiv': 'chart_detail',
	        'chartType': 'column',
	        'chartSize': { width: 1300, height: 550 },
	        'maxValue': 100,
	        'increment': 10
		};

		Nwagon.chart(options);	
}
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
		    			hrefs: ["javascript:play('연극')","javascript:play('뮤지컬')","javascript:play('클래식')","javascript:play('오페라')","javascript:play('무용')","javascript:play('발레')","javascript:play('국악')","javascript:play('복합')"]
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
		<div id = "chart_detail"></div> 
		<div id = "month_show">

	</div> 
</body>
</html>