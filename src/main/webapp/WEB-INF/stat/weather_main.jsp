<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="/project_final/assets/css/Nwagon.css">

<title>Insert title here</title>
</head>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="/project_final/assets/js/Nwagon.js"></script>
<script type="text/javascript">

var arr=[0,0,0,0,0,0,0,0];
		function aaa(){
			alert("aaa")
		}
$(document).ready(function()
		{
		    $('#selectbox').change(function(){
		    	$( "#chart19" ).empty();
		    	var weather = $('#selectbox option:selected').val();
		    	$.get("/project_final/stat/find.do", {"weather" : weather},find_stats, "json");	  
		    });
		})
		function find_stats(data) {
			$("#weather_show").html("");
			var weather_obj_arr = data.weather_list;	

			if(weather_obj_arr.length ==0){
				$("#weather_show").append("<h2>�����Ͱ� �����ϴ�.</h2>");
			}
			for(i = 0; i < weather_obj_arr.length; i++){
				var obj = weather_obj_arr[i];
				var addr1 = obj.addr1;
				var addr2= obj.addr2;
				var cate= obj.cate;
				var total=obj.total;
				if(cate=='����'){
					arr[0]+=parseInt(total);
				}else if(cate=='������'){
					arr[1]+=parseInt(total);
				}else if(cate=='Ŭ����'){
					arr[2]+=parseInt(total);
				}else if(cate=='�����'){
					arr[3]+=parseInt(total);
				}else if(cate=='����'){
					arr[4]+=parseInt(total);
				}else if(cate=='�߷�'){
					arr[5]+=parseInt(total);
				}else if(cate=='����'){
					arr[6]+=parseInt(total);
				}else if(cate=='����'){
					arr[7]+=parseInt(total);
				}
  				$("#weather_show").append("<div class = 'wrapper'>"
 						+"<table class= 'table'>"+
											"<tr>"+
											"<td>"+addr1+"</td>"+"<td>"+addr2+"</td>"+"<td>"+cate+"</td>"+"<td>"+total+"</td>"+
											"</tr>" +
											"</table>"	+	"</div>"
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
		    			names: ['����', '������', 'Ŭ����', '�����', '����', '�߷�', '����','����'],
		    			hrefs: ['javascript:aaa()','javascript:aaa()','javascript:aaa()','javascript:aaa()','javascript:aaa()','javascript:aaa()','javascript:aaa()','javascript:aaa()']
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
	<h1>������ �帣 ��ȣ��</h1>
	<h5>
	<select class="selectpicker" id="selectbox" data-size="5" >
		<option value="default">���� ����</option>
		<option value="����">����</option>
		<option value="�帲">�帲</option>
		<option value="��������">��������</option>
		<option value="��������">��������</option>
		<option value="�Ȱ�">�Ȱ�</option>
		<option value="��">��</option>
		<option value="��">��</option>
		<option value="�ҳ���">�ҳ���</option>
		<option value="Ȳ��">Ȳ��</option>
	</select>
	</h5>

	<div id="chart19"></div>

	<div id = "weather_show">

	</div> 
</body>
</html>