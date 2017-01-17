<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		//��������
		var cnt_R = 0;
		var cnt_S = 0;
		var cnt_A = 0;
		var cnt_total = 0;
		//�¼�
		var row = 0;
		var col = 0;
		//�¼�����üũ
		var len_R=0;
		var len_S=0;
		var len_A=0;
		var len_total=0;
		//chk�� �¼�Arr
		var arrChk= new Array();
		var arrChk_R= new Array();	
		var arrChk_S= new Array();	
		var arrChk_A= new Array();	
		//���â ���
		var R_list;
		var S_list;
		var A_list;
		
		$(":checkbox").on("click",function(){	//üũ�ڽ� Ŭ���� ������ Ajax�� ���࿩�� üũ�ؼ� ����
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
			
			//$("#R_0_0").attr("disabled","disabled");//��Ȱ��ȭ
			//val�� �¼���ް� + ��Ų��.	
			arrChk.push($(this).val());
			
			//������ �ؿ� ��������  
			var R_list="";
			var S_list="";
			var A_list="";
			
			//R�� �����θ� üũ
			$("input[name=R]:checked").each(function(){					
				R_list = R_list + $(this).val();
			});
			$("input[name=R]").on("click",function(){
				arrChk_R.push($(this).val());
			});			
			//S�� �����θ� üũ
			$("input[name=S]:checked").each(function(){					
				S_list = S_list + $(this).val();
			});
			$("input[name=S]").on("click",function(){
				arrChk_S.push($(this).val());
			});
			//A�� �����θ� üũ
			$("input[name=A]:checked").each(function(){					
				A_list = A_list + $(this).val();
			});
			$("input[name=A]").on("click",function(){
				arrChk_A.push($(this).val());
			});
			//������ �ؿ� ����ǥ��
			$("#seatNum_R").html(); $("#seatNum_R").html(R_list);
			$("#seatNum_S").html(); $("#seatNum_S").html(S_list);
			$("#seatNum_A").html(); $("#seatNum_A").html(A_list);
			
			//�� ����			
			if(cnt_total < len_total){	//���� �ʰ��� ��� üũ�� �� ����ϵ���
				var uncheckedVal = arrChk[arrChk.length-1];
				//�����ʰ� �� ������ üũ�� �� ���
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
			//R�� üũ
			if(cnt_R < len_R){
				$("input[name=R]:checked").each(function(){
					var uncheckedVal_R = arrChk_R[arrChk_R.length-1];	
					if($(this).val()==uncheckedVal_R){
						$(this).attr("checked", false);	
					} 
				});					
			}
		})
	})

</script>
</head>
<body>	
		<div class="container-fluid">
		  <h1>Hello World!</h1>
			  <div class="row">	
			  		<div class="col-sm-3" style="background-color:yellow;"><p>����</p></div>
				    	<div class="col-sm-4" style="background-color:lavender;">
				    		<p>�ο�/�¼�����</p>
				    			
				    				<p>�¼�����</p>
				    				R��			 			
						    		<select class="selectpicker" id="num_R" data-size="5" >
						    			<option value="0">0</option>
						    			<option value="1">1</option>
						    			<option value="2">2</option>
						    			<option value="3">3</option>
						    			<option value="4">4</option>
						    			<option value="5">5</option>
						    		</select>
						    		S��
						    		<select class="selectpicker" id="num_S" data-size="5" >
						    			<option value="0">0</option>
						    			<option value="1">1</option>
						    			<option value="2">2</option>
						    			<option value="3">3</option>
						    			<option value="4">4</option>
						    			<option value="5">5</option>
						    		</select>
						    		A��
						    		<select class="selectpicker" id="num_A" data-size="5" >
						    			<option value="0">0</option>
						    			<option value="1">1</option>
						    			<option value="2">2</option>
						    			<option value="3">3</option>
						    			<option value="4">4</option>
						    			<option value="5">5</option>
						    		</select>
				    						    		
				    			<br/>				    			
				    			<p>��,�ķ� ��� 2�����迭�� ���ؼ� �¼����</p>
				    			<br/>
					    		<div class="chkbox">
					    			  <p>R��</p>
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
					    			  <p>S��</p>
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
					    			  <p>A��</p>
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
				    	<div class="col-sm-2" style="background-color:lavender;">
				    		<p><img src="http://www.kopis.or.kr/upload/pfmPoster/PF_PF134905_170110_100502.gif"/></p>
				    		�ѱݾ� : <div id="total_cash" >20000��</div>
				    		
				    		R�� : <div id="seatNum_R"></div>
				    		S�� : <div id="seatNum_S"></div>
				    		A�� : <div id="seatNum_A"></div>				    		
				    	</div>			    	
			    	<div class="col-sm-3" style="background-color:yellow;"><p>����</p></div>
			  </div>
		</div>
</body>
</html>