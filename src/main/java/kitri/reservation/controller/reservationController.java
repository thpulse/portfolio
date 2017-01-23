package kitri.reservation.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kitri.performinfo.performance.dto.PerformanceDTO;
import kitri.performinfo.performance.service.PerformanceService;
import kitri.performinfo.prfplace.dto.PrfplaceDTO;
import kitri.reservation.service.reservationService;
import kitri.reservation.vo.reservationDetailVO;
import kitri.reservation.vo.reservationVO;
import oracle.net.aso.r;

@Controller
public class reservationController {
	@Autowired
	@Qualifier("reservationservice")
	reservationService reservService;
		
	@RequestMapping("/reservation/main.do")
	public String main(){
		return "reservationMain";
	}
	
	@RequestMapping("/reservation/seat.do")
	public ModelAndView seat(String time, String day,String year, String month,String day2, String id){
		//�ð�ǥ (18:00) ��ȣ ������ ��
		String week_Val = time.substring(1, time.length()-1);
		//day ������ ����
		//year, month, day2 , 19920707
		//���� ����id�� ������url
		PerformanceDTO dto = reservService.perform_detail(id);
		String poster = dto.getPoster();
		String price = dto.getTckprice();
		System.out.println(dto);
		String date = year + month + day2;	
		
		ModelAndView mav = new ModelAndView();
		//�������� �޾ƿ� �� ����ǥ���� ���� �� addObject�Ѵ�. 
		Map<String, String> priceMap = price_filter(price);
			
		//������ url
		mav.addObject("priceMap", priceMap);	
		mav.addObject("poster", poster);
		mav.addObject("prfnm", dto.getPrfnm());
		mav.addObject("plcnm", dto.getPlcnm());
		mav.addObject("reserv_date", date);
		mav.addObject("reserv_time", week_Val);
		mav.addObject("reserv_time_yo", day2);
		mav.addObject("prfid_val", dto.getPrfid());
		mav.setViewName("reservation_seat");
		return mav;		
	}
	
	//�����ư ������ ���� DB�� �ֱ�
	@RequestMapping(value = "/reservation/booking.do" ,method =RequestMethod.POST)
	public ModelAndView booking(String user_id, String seat, String prfid, String reserv_date,String reserv_time, String reserv_time_yo){
		ModelAndView mav = new ModelAndView();			
		//time �� ���� �ð� ex) 18:00
		//day ������ ����
		//day2 ������ ��¥ (��)
		SimpleDateFormat  formatter04 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String todayDate=  formatter04.format(new Date());
		//id���ǿ��� ����;���
		System.out.println("id: " + user_id + seat + prfid+reserv_date+reserv_time+reserv_time_yo);
		if(seat !=null){						
			reservationVO vo = new reservationVO();
			reservationDetailVO voDetail = new reservationDetailVO();
			String uniqe_num=todayDate+"_"+reserv_time+"_"+user_id+"_"+reserv_time_yo;
			if(seat.contains(",")){
				String[] seat_val = seat.split(",");
				vo.setReserv_num(uniqe_num);
				vo.setUser_id(user_id);
				vo.setPrf_id(prfid);//id�� ���ǿ��� ��������
				vo.setDel_flg("1");//1�� ��ҵ��� ���� �ʱⰪ
				vo.setPrf_day(reserv_date);
				vo.setReserv_date(todayDate);
				vo.setPrf_starttime(reserv_time);
				vo.setPrf_day_yo(reserv_time_yo);
				reservService.insert_reservation(vo);
				for(int i = 0; i< seat_val.length; i++){
					reservationDetailVO vo_multiDetail = new reservationDetailVO();
					//�¼���ȣ���� grade����
					String grade = seat_val[i].split("_")[0];
					vo_multiDetail.setReserv_num(uniqe_num);
					vo_multiDetail.setGrade(grade);
					vo_multiDetail.setSeat(seat_val[i]);
					//price ����
					PerformanceDTO dto = reservService.perform_detail(prfid);
					String price = dto.getTckprice();
					Map<String, String> priceMap = price_filter(price);
					if(priceMap.get(grade) != null){
						vo_multiDetail.setPrice(priceMap.get(grade));
					}else{
						vo_multiDetail.setPrice(priceMap.get("��"));
					}				
					reservService.insert_reservationDeatil(vo_multiDetail);					
				}
			}else {
				//�����ȣ ����� ���� (������ ��¥_���۽ð�_�ڸ���ȣ)			
				vo.setReserv_num(uniqe_num);
				vo.setPrf_id(user_id);//id�� ���ǿ��� ��������
				vo.setDel_flg("1");//1�� ��ҵ��� ���� �ʱⰪ
				vo.setPrf_day(reserv_date);
				vo.setReserv_date(todayDate);
				vo.setSeat(seat);
				vo.setUser_id(user_id);
				vo.setPrf_starttime(reserv_time);
				vo.setPrf_day_yo(reserv_time_yo);
				reservService.insert_reservation(vo);
				
				
				//�¼���ȣ���� grade����
				String grade = seat.split("_")[0];
				voDetail.setReserv_num(uniqe_num);
				voDetail.setGrade(grade);
				voDetail.setSeat(seat);
				//price ����
				PerformanceDTO dto = reservService.perform_detail(prfid);
				String price = dto.getTckprice();
				Map<String, String> priceMap = price_filter(price);
				if(priceMap.get(grade) != null){
					voDetail.setPrice(priceMap.get(grade));
				}else{
					voDetail.setPrice(priceMap.get("��"));
				}
				reservService.insert_reservationDeatil(voDetail);
			}
		}
		//������ �Ϸ�Ǹ� ����Ϸ�â���� �̵���Ų��.
		return mav;		
	}
	
	@RequestMapping("/reservation/pre_chk.do")
	public String pre_chk(String time, String day,String year, String month,String day2, String id){
		System.out.println(time+day+year+month+day2+id);
		return "";
		
	}
	@RequestMapping(value = "/reservation/seat_chk.do",method=RequestMethod.GET,
			produces="application/json;charset=utf-8")
	public @ResponseBody String seat_chk_ajax(String prf_day, String prf_starttime, String reserv_time_yo){
		reservationVO vo = new reservationVO();
		vo.setPrf_day(prf_day);
		vo.setPrf_starttime(prf_starttime);
		vo.setPrf_day_yo(reserv_time_yo);
		
		//�ð������� ���̺� 
		JSONObject chk_json = new JSONObject();
		JSONArray timeTable_list = new JSONArray();
		//����,�ð�,��¥ ���� �ش��ϴ� �����ȣ����
		if(prf_day !=null){
			List<String> reservation_list = reservService.reservation_chk_byTime(vo);
			//����� �¼���ȣ ���� list
			List<String> time_list = new ArrayList<String>();
			
			for(int i=0; i < reservation_list.size();i++){
				String time_val = reservation_list.get(i);
				reservationVO unique_num_reserv = new reservationVO();
				//���� �����ȣ ���� ����� �¼�����Ʈ ȣ��
				unique_num_reserv.setReserv_num(time_val);
				time_list = reservService.preChk_byTime_detail(unique_num_reserv);
				for(int j=0; j< time_list.size();j++){
					timeTable_list.add(time_list.get(j));
					
				}
			}
			chk_json.put("timeTable", timeTable_list);
		}				
		return chk_json.toJSONString();
	}
	@RequestMapping(value="/reservation/find_hall_sido.do",
					method=RequestMethod.GET,
					produces="application/json;charset=utf-8")
	public @ResponseBody String find_hall_bysido(@RequestParam String sido_Val){
		//��, ���� �޾ƿ´� ���� ���ڵ带 ��� �������� ���.
		HashMap<String, String> sido = new HashMap<String, String>();
		sido.put("11", "����");
		sido.put("41", "���");
		sido.put("26", "�λ�");
		sido.put("27", "�뱸");
		sido.put("28", "��õ");
		sido.put("29", "����");
		sido.put("30", "����");
		sido.put("31", "���");
		sido.put("36", "����");
		sido.put("42", "����");
		sido.put("43", "���");
		sido.put("44", "�泲");
		sido.put("45", "����");
		sido.put("46", "����");
		sido.put("47", "���");
		sido.put("48", "�泲");
		sido.put("50", "����");
		String sidoName=sido.get(sido_Val);
		//��, ���� ������ ������ �޾ƿ´�.
		List<PrfplaceDTO> dtolist = new ArrayList<PrfplaceDTO>();
		//Ajax �ʱ� null�� �����°� ����
		if(sidoName !=null){
			dtolist = reservService.call_hall_bySido(sidoName);
		}
		//��,���� �������� �����ϴ� ��,���� ��ȯ���ش�.
		JSONObject gungu_json = new JSONObject();
		JSONArray gungu_json_list = new JSONArray();
		JSONArray gungu_plc_list = new JSONArray();
		JSONArray gungu_plcId_list = new JSONArray();
		List<String> placeList = new ArrayList<String>();
		for(int i=0; i < dtolist.size(); i++){
			PrfplaceDTO dto = dtolist.get(i);
			//�Է¹��� ��, ���� ���� �����常 �ɷ�����.
			if(dto.getSidonm().equals(sidoName)){
				placeList.add(dto.getGugunnm());
				gungu_plcId_list.add(dto.getPlcid());
				gungu_plc_list.add(dto.getPlcnm());
			}			
		}
		//�ߺ��� ��,�� ����
		List<String> uniqueItems = new ArrayList<String>(new HashSet<String>(placeList));
		for(int i=0; i < uniqueItems.size(); i++){
			gungu_json_list.add(uniqueItems.get(i));
		}
		gungu_json.put("gungu_json_list", gungu_json_list);
		gungu_json.put("gungu_plc_list", gungu_plc_list);
		gungu_json.put("gungu_plcId_list",gungu_plcId_list);
		//���� ������ ������ JSON���� ��ȯ�ؼ� �������ش�. 
		return gungu_json.toJSONString();
	}
	
	@RequestMapping(value="/reservation/find_hall_gungu.do",
						method=RequestMethod.GET,
						produces="application/json;charset=utf-8")
	public @ResponseBody String find_hall_bygungu(@RequestParam String gungu_Val) throws IOException {
		//�� �� �޾ƿ´�.
		String result = URLDecoder.decode(gungu_Val,"UTF-8");
		//�� �� ������ ������ �޾ƿ´�.
		List<PrfplaceDTO> dtolist = reservService.call_hall_bygungu(result);
		JSONObject plc_json = new JSONObject();
		JSONArray plc_list = new JSONArray();
		JSONArray plcId_list = new JSONArray();
		for(int i=0; i < dtolist.size(); i++){
			PrfplaceDTO dto = dtolist.get(i);
			//�Է¹��� "��"�� ���� �����常 �ɷ�����.
			if(dto.getGugunnm().equals(result)){
				plc_list.add(dto.getPlcnm());
				plcId_list.add(dto.getPlcid());
			}			
		}
		plc_json.put("plc_list",plc_list);
		plc_json.put("plcId_list",plcId_list);
		//���� ������ ������ JSON���� ��ȯ�ؼ� �������ش�. 
		return plc_json.toJSONString();
	}
	
	//��ȭ�� ���� �� 
	@RequestMapping(value="/reservation/find_prf.do",
			method=RequestMethod.GET,
			produces="application/json;charset=utf-8")
	public @ResponseBody String find_prf(@RequestParam String plcId_Val){
		List<PerformanceDTO> dtolist = reservService.call_performInfo_byhallId(plcId_Val);
		JSONObject plc_json = new JSONObject();
		JSONArray plc_list = new JSONArray();
		
		if(dtolist.size() > 0) {
			for(int i=0; i < dtolist.size(); i++){
				JSONObject plc_json_item = new JSONObject();
				plc_json_item.put("poster", dtolist.get(i).getPoster());
				plc_json_item.put("prfnm", dtolist.get(i).getPrfnm());
				plc_json_item.put("plcid", dtolist.get(i).getPrfid());
				plc_list.add(plc_json_item);
			}
		}	
		plc_json.put("plc_list", plc_list);
		return plc_json.toJSONString();
	}
	@RequestMapping(value="/reservation/find_prf_detail.do",
			method=RequestMethod.GET,
			produces="application/json;charset=utf-8")
	public @ResponseBody String find_prf_detail(@RequestParam String prf_id){
		/*String date = year_val + month_val + day_val;
		reservationVO vo = new reservationVO();
		vo.setPrf_day(date);
		//2017011�� �ش��ϴ� ��¥�� reserv_num�� ȹ��
		List<String> volist  = reservService.reservation_chk_byDayTime(vo);
		//reserv_num�� ���� reservation_detail������ �ش� �ð��� reservationVO�� ������
		//���� reserv_num�� ������ ��ȸ�Ѵ�.
		*/		
		PerformanceDTO dto = reservService.perform_detail(prf_id);	
		JSONObject prf_json = new JSONObject();
		JSONObject timeTable = new JSONObject();
		JSONArray timeTable_arr = new JSONArray();
		prf_json.put("tckprice", dto.getTckprice());
		prf_json.put("prfid", dto.getPrfid());
		prf_json.put("prfnm", dto.getPrfnm());
		prf_json.put("prfpdfrom", dto.getPrfpdfrom());
		prf_json.put("prfpdto", dto.getPrfpdto());
		prf_json.put("prfruntime", dto.getPrfruntime());
		
		//�����ð� ���͸� �� JSON�迭�� ����
		List<List<String>> dtolist = filter_timeTable(dto.getPrfdaytime());
		for(int i=0; i< dtolist.size();i++){
			timeTable_arr.add(dtolist.get(i));
		}
		timeTable.put("timeTable_arr", timeTable_arr);
		prf_json.put("timeTable", timeTable);		
		return prf_json.toJSONString();
	}
	public List<List<String>> filter_timeTable(String pass_str){
		String useStr=pass_str;
		String parts="[��-�R]..\\([0-9][0-9]\\:[0-9][0-9]\\)";	//1
		String parts2="[��-�R]..\\([0-9][0-9]\\:[0-9][0-9]\\,[0-9][0-9]\\:[0-9][0-9]\\)";	//2
		String parts3="[��-�R].. ~ [��-�R]..\\([0-9][0-9]\\:[0-9][0-9]\\)";	//3
		String parts4="[��-�R].. ~ [��-�R]..\\([0-9][0-9]\\:[0-9][0-9]\\,[0-9][0-9]\\:[0-9][0-9]\\)";//4
		
		List<List<String>> indexArr = new ArrayList<List<String>>();
		List<String> day0 = new ArrayList<String>();//��
		List<String> day1 = new ArrayList<String>();//��
		List<String> day2 = new ArrayList<String>();//ȭ
		List<String> day3 = new ArrayList<String>();//��
		List<String> day4 = new ArrayList<String>();//��
		List<String> day5 = new ArrayList<String>();//��
		List<String> day6 = new ArrayList<String>();//��
		indexArr.add(day0);
		indexArr.add(day1);
		indexArr.add(day2);
		indexArr.add(day3);
		indexArr.add(day4);
		indexArr.add(day5);
		indexArr.add(day6);
		
		//1. parts1������ ������ �ϳ� , �ð��뵵 �ϳ�
		//�� ���Ͽ�
		Pattern pattern = Pattern.compile(parts);
		Matcher match = pattern.matcher(useStr);
		while(match.find()){
			//System.out.println("1:"+match.group());
			String output= match.group();//ȭ����(20:00)
			String[] output2 = output.split("\\(");
			if(output2.length > 0){	//���� üũ
				if(output.split("\\(") !=null){	   //��ȣ ����
					String criteria = output2[0];//��������
					String input_val = output2[1].substring(0, output2[1].length()-1);//�ð�����
					if(criteria.equals("�Ͽ���")){
						day0.add(input_val);
					}else if(criteria.equals("������")){
						day1.add(input_val);
					}else if(criteria.equals("ȭ����")){
						day2.add(input_val);
					}else if(criteria.equals("������")){
						day3.add(input_val);
					}else if(criteria.equals("�����")){
						day4.add(input_val);
					}else if(criteria.equals("�ݿ���")){
						day5.add(input_val);
					}else if(criteria.equals("�����")){
						day6.add(input_val);
					}
				}				
			}			
		}
		//2. parts2������ ������ �ϳ�, �ð��� �ټ�
		Pattern pattern2 = Pattern.compile(parts2);
		Matcher match2 = pattern2.matcher(useStr);		
		while(match2.find()){
			//System.out.println("2:"+match2.group());	
			String output= match2.group();//������(16:00,20:00)
			String[] output2 = output.split("\\(");
			if(output2.length > 0){	//���� üũ
				if(output.split("\\(") !=null){	   //��ȣ ����
					String criteria = output2[0];//��������, ����!
					String str = output2[1].substring(0, output2[1].length()-1);// ','�� �и��ؾ��� �ð�
					String[] strArr = str.split(",");
					if(strArr.length > 0){						
						for(int i =0; i < strArr.length; i++){//�� ���Ϻ��� �迭�� ����
							if(criteria.equals("�Ͽ���")){
								day0.add(strArr[i]);
							}else if(criteria.equals("������")){
								day1.add(strArr[i]);
							}else if(criteria.equals("ȭ����")){
								day2.add(strArr[i]);
							}else if(criteria.equals("������")){
								day3.add(strArr[i]);
							}else if(criteria.equals("�����")){
								day4.add(strArr[i]);
							}else if(criteria.equals("�ݿ���")){
								day5.add(strArr[i]);
							}else if(criteria.equals("�����")){
								day6.add(strArr[i]);
							}
						}
					}
				}
			}
		}
		
		//3. part3������ ������ ����� ������ �ð��� �ϳ�
		Pattern pattern3 = Pattern.compile(parts3);
		Matcher match3 = pattern3.matcher(useStr);		
		while(match3.find()){
			//System.out.println("3:"+match3.group());
			String output= match3.group();//����� ~ �ݿ���(20:00)
			String[] output2 = output.split("\\(");
			if(output2.length > 0){
				String init = output2[0].replaceAll("\\p{Z}", "");//��������
				String time_Val = output2[1].substring(0, output2[1].length()-1);
				String arr = init.replace("�Ͽ���", "7").replace("������", "1").replace("ȭ����", "2").replace("������", "3");//�� ������ ��~���� ������ ġȯ
				String arr2 = arr.replace("�����", "4").replace("�ݿ���", "5").replace("�����", "6");
				String[] stan_val = arr2.split("~");//4~6
				int start =0;
				int end =0;				
				int stand_first = Integer.parseInt(stan_val[0]);
				int stand_second = Integer.parseInt(stan_val[1]);
				if(stand_first < stand_second){//���� �� �۰� ������ش�.
					start = stand_first;
					end = stand_second;
				}else if(stand_first > stand_second){
					start = stand_second;
					end = stand_first;							
				}
				for(int i = start; i <= end; i++){//ex 4~6������ ���� List<String>�� �ִ´�. 
					indexArr.get(i).add(time_Val);
				}				
			}			
		}
		
		//4. part3������ ������ ����� ������ �ð��� ������
		Pattern pattern4 = Pattern.compile(parts4);
		Matcher match4 = pattern4.matcher(useStr);	
		while(match4.find()){
			String output = match4.group();
			//System.out.println("4:"+match4.group());
			String[] output2 = output.split("\\(");
			if(output2.length > 0){
				String init = output2[0].replaceAll("\\p{Z}", "");//��������
				String time_Val = output2[1].substring(0, output2[1].length()-1);
				String[] strArr = time_Val.split(",");
				List<String> list = new ArrayList<String>();//�ð��븦 ������. ex 18:00,19:00�� ����
				for(int i=0; i < strArr.length; i++){
					list.add(strArr[i]);
				}
				String arr = init.replace("�Ͽ���", "7").replace("������", "1").replace("ȭ����", "2").replace("������", "3");//�� ������ ��~���� ������ ġȯ
				String arr2 = arr.replace("�����", "4").replace("�ݿ���", "5").replace("�����", "6");
				String[] stan_val = arr2.split("~");//4~6 
				int stand_first = Integer.parseInt(stan_val[0]);
				int stand_second = Integer.parseInt(stan_val[1]);
				int start =0;
				int end =0;
				if(stand_first < stand_second){//���� �� �۰� ������ش�.
					start = stand_first;
					end = stand_second;
				}else if(stand_first > stand_second){
					start = stand_second;
					end = stand_first;							
				}
				for(int i = start; i < end; i++){//ex 4~6������ ���� List<String>�� �ִ´�. 
					for(int j=0; j < list.size();j++){
						indexArr.get(i).add(list.get(j));//4~6������ ���� List<String>�� 16:00,17:00 �ð�ǥ �������� �ִ´�.
					}					
				}
				
			}
		}	
		List<String> unique_day0 = new ArrayList<String>(new HashSet<String>(day0));
		List<String> unique_day1 = new ArrayList<String>(new HashSet<String>(day1));
		List<String> unique_day2 = new ArrayList<String>(new HashSet<String>(day2));
		List<String> unique_day3 = new ArrayList<String>(new HashSet<String>(day3));
		List<String> unique_day4 = new ArrayList<String>(new HashSet<String>(day4));
		List<String> unique_day5 = new ArrayList<String>(new HashSet<String>(day5));
		List<String> unique_day6 = new ArrayList<String>(new HashSet<String>(day6));
		List<List<String>> unique_indexArr = new ArrayList<List<String>>();
		unique_indexArr.add(unique_day0);
		unique_indexArr.add(unique_day1);
		unique_indexArr.add(unique_day2);
		unique_indexArr.add(unique_day3);
		unique_indexArr.add(unique_day4);
		unique_indexArr.add(unique_day5);
		unique_indexArr.add(unique_day6);
		//System.out.println(unique_indexArr);
		/*for(int i=0; i<unique_indexArr.size(); i++){
			System.out.println(i);
			for(int j=0;j<unique_indexArr.get(i).size();j++){				
				System.out.println(unique_indexArr.get(i).get(j));
			}
		}*/		
		return unique_indexArr;
	}
	public Map<String,String> price_filter(String str_Val){
		String useStr=str_Val;
		String regex="([a-zA-Z]{1,}��|��{1,}��) \\d{1,}\\,\\d{1,}��";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher match = pattern.matcher(useStr);
		List<String> priceList = new ArrayList<String>();
		while(match.find()){
			//System.out.println(match.group());
			String part =match.group();
			priceList.add(part);
		}
		String grade ="";
		String price="";
		Map<String, String> priceMap = new HashMap<String, String>();
		for(int i =0; i < priceList.size(); i++){
			String[] str = priceList.get(i).split("��");
			for(int j =0; j < str.length; j++){
				grade = str[0];
				price = str[1].substring(0, str[1].length()-1).replace(",", "");
				//System.out.println(grade + " : " + price);
				priceMap.put(grade, price);
			}
		}
		return priceMap;	
	}	
}
