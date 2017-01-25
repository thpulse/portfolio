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
	@RequestMapping("/reservation/confirm.do")
	public ModelAndView confirm(String poster){
		ModelAndView mav = new ModelAndView();
		mav.addObject("poster", poster);
		mav.setViewName("reservation_confirm");
		System.out.println(poster);
		return mav;
	}
	
	@RequestMapping("/reservation/seat.do")
	public ModelAndView seat(String time, String day,String year, String month,String day2, String id){
		//시간표 (18:00) 괄호 제거한 것
		String week_Val = time.substring(1, time.length()-1);
		//day 에약한 요일
		//year, month, day2 , 19920707
		//받은 공연id로 포스터url
		PerformanceDTO dto = reservService.perform_detail(id);
		String poster = dto.getPoster();
		String price = dto.getTckprice();
		System.out.println(dto);
		String date = year + month + day2;	
		
		ModelAndView mav = new ModelAndView();
		//가격정보 받아온 것 정규표현식 필터 후 addObject한다. 
		Map<String, String> priceMap = price_filter(price);
			
		//포스터 url
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
	
	//예약버튼 누르면 예매 DB에 넣기
	@RequestMapping(value = "/reservation/booking.do" ,method =RequestMethod.POST)
	public ModelAndView booking(String user_id, String seat, String prfid, String reserv_date,String reserv_time, String reserv_time_yo){
		ModelAndView mav = new ModelAndView();			
		//time 그 날의 시간 ex) 18:00
		//day 예약한 요일
		//day2 예약한 날짜 (일)
		System.out.println("%%%%"+prfid);
		SimpleDateFormat  formatter04 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String todayDate=  formatter04.format(new Date());
		//id세션에서 끌어와야함
		System.out.println("id: " + user_id + seat + prfid+reserv_date+reserv_time+reserv_time_yo);
		if(seat !=null){						
			reservationVO vo = new reservationVO();
			reservationDetailVO voDetail = new reservationDetailVO();
			String uniqe_num=todayDate+"_"+reserv_time+"_"+user_id+"_"+reserv_time_yo;
			if(seat.contains(",")){
				String[] seat_val = seat.split(",");
				vo.setReserv_num(uniqe_num);
				vo.setUser_id(user_id);
				vo.setPrf_id(prfid);//id는 세션에서 만들어야함
				vo.setDel_flg("1");//1이 취소되지 않은 초기값
				vo.setPrf_day(reserv_date);
				vo.setReserv_date(todayDate);
				vo.setPrf_starttime(reserv_time);
				vo.setPrf_day_yo(reserv_time_yo);
				reservService.insert_reservation(vo);
				for(int i = 0; i< seat_val.length; i++){
					reservationDetailVO vo_multiDetail = new reservationDetailVO();
					//좌석번호에서 grade추출
					String grade = seat_val[i].split("_")[0];
					vo_multiDetail.setReserv_num(uniqe_num);
					vo_multiDetail.setGrade(grade);
					vo_multiDetail.setSeat(seat_val[i]);
					//price 셋팅
					PerformanceDTO dto = reservService.perform_detail(prfid);
					String price = dto.getTckprice();
					Map<String, String> priceMap = price_filter(price);
					if(priceMap.get(grade) != null){
						vo_multiDetail.setPrice(priceMap.get(grade));
					}else{
						vo_multiDetail.setPrice(priceMap.get("전"));
					}				
					reservService.insert_reservationDeatil(vo_multiDetail);					
				}
			}else {
				//예약번호 만드는 조건 (예약한 날짜_시작시간_자리번호)			
				vo.setReserv_num(uniqe_num);
				vo.setPrf_id(user_id);//id는 세션에서 만들어야함
				vo.setDel_flg("1");//1이 취소되지 않은 초기값
				vo.setPrf_day(reserv_date);
				vo.setReserv_date(todayDate);
				vo.setSeat(seat);
				vo.setUser_id(user_id);
				vo.setPrf_starttime(reserv_time);
				vo.setPrf_day_yo(reserv_time_yo);
				reservService.insert_reservation(vo);
				
				
				//좌석번호에서 grade추출
				String grade = seat.split("_")[0];
				voDetail.setReserv_num(uniqe_num);
				voDetail.setGrade(grade);
				voDetail.setSeat(seat);
				//price 셋팅
				PerformanceDTO dto = reservService.perform_detail(prfid);
				String price = dto.getTckprice();
				Map<String, String> priceMap = price_filter(price);
				if(priceMap.get(grade) != null){
					voDetail.setPrice(priceMap.get(grade));
				}else{
					voDetail.setPrice(priceMap.get("전"));
				}
				reservService.insert_reservationDeatil(voDetail);
			}
		}
		//예약이 완료되면 예약완료창으로 이동시킨다.
		mav.setViewName("index_normal");
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
		
		//시간저장할 테이블 
		JSONObject chk_json = new JSONObject();
		JSONArray timeTable_list = new JSONArray();
		//요일,시간,날짜 토대로 해당하는 예약번호추출
		if(prf_day !=null){
			List<String> reservation_list = reservService.reservation_chk_byTime(vo);
			//예약된 좌석번호 받을 list
			List<String> time_list = new ArrayList<String>();
			
			for(int i=0; i < reservation_list.size();i++){
				String time_val = reservation_list.get(i);
				reservationVO unique_num_reserv = new reservationVO();
				//받은 예약번호 토대로 예약된 좌석리스트 호출
				unique_num_reserv.setReserv_num(time_val);
				time_list = reservService.preChk_byTime_detail(unique_num_reserv);
				for(int j=0; j< time_list.size();j++){
					timeTable_list.add(time_list.get(j));					
				}
			}
			chk_json.put("timeTable", timeTable_list);
			System.out.println(chk_json);
		}				
		return chk_json.toJSONString();
	}
	@RequestMapping(value="/reservation/find_hall_sido.do",
					method=RequestMethod.GET,
					produces="application/json;charset=utf-8")
	public @ResponseBody String find_hall_bysido(@RequestParam String sido_Val){
		//시, 도를 받아온다 받은 시코드를 기반 지역명을 얻기.
		HashMap<String, String> sido = new HashMap<String, String>();
		sido.put("11", "서울");
		sido.put("41", "경기");
		sido.put("26", "부산");
		sido.put("27", "대구");
		sido.put("28", "인천");
		sido.put("29", "광주");
		sido.put("30", "대전");
		sido.put("31", "울산");
		sido.put("36", "세종");
		sido.put("42", "강원");
		sido.put("43", "충북");
		sido.put("44", "충남");
		sido.put("45", "전북");
		sido.put("46", "전남");
		sido.put("47", "경북");
		sido.put("48", "경남");
		sido.put("50", "제주");
		String sidoName=sido.get(sido_Val);
		//시, 도에 공연장 정보를 받아온다.
		List<PrfplaceDTO> dtolist = new ArrayList<PrfplaceDTO>();
		//Ajax 초기 null값 들어오는거 필터
		if(sidoName !=null){
			dtolist = reservService.call_hall_bySido(sidoName);
		}
		//시,도에 공연장이 존재하는 구,동을 반환해준다.
		JSONObject gungu_json = new JSONObject();
		JSONArray gungu_json_list = new JSONArray();
		JSONArray gungu_plc_list = new JSONArray();
		JSONArray gungu_plcId_list = new JSONArray();
		List<String> placeList = new ArrayList<String>();
		for(int i=0; i < dtolist.size(); i++){
			PrfplaceDTO dto = dtolist.get(i);
			//입력받은 시, 도와 같은 공연장만 걸러낸다.
			if(dto.getSidonm().equals(sidoName)){
				placeList.add(dto.getGugunnm());
				gungu_plcId_list.add(dto.getPlcid());
				gungu_plc_list.add(dto.getPlcnm());
			}			
		}
		//중복된 구,군 제거
		List<String> uniqueItems = new ArrayList<String>(new HashSet<String>(placeList));
		for(int i=0; i < uniqueItems.size(); i++){
			gungu_json_list.add(uniqueItems.get(i));
		}
		gungu_json.put("gungu_json_list", gungu_json_list);
		gungu_json.put("gungu_plc_list", gungu_plc_list);
		gungu_json.put("gungu_plcId_list",gungu_plcId_list);
		//받은 공연장 정보를 JSON으로 변환해서 리턴해준다. 
		return gungu_json.toJSONString();
	}
	
	@RequestMapping(value="/reservation/find_hall_gungu.do",
						method=RequestMethod.GET,
						produces="application/json;charset=utf-8")
	public @ResponseBody String find_hall_bygungu(@RequestParam String gungu_Val) throws IOException {
		//구 를 받아온다.
		String result = URLDecoder.decode(gungu_Val,"UTF-8");
		//구 에 공연장 정보를 받아온다.
		List<PrfplaceDTO> dtolist = reservService.call_hall_bygungu(result);
		JSONObject plc_json = new JSONObject();
		JSONArray plc_list = new JSONArray();
		JSONArray plcId_list = new JSONArray();
		for(int i=0; i < dtolist.size(); i++){
			PrfplaceDTO dto = dtolist.get(i);
			//입력받은 "구"와 같은 공연장만 걸러낸다.
			if(dto.getGugunnm().equals(result)){
				plc_list.add(dto.getPlcnm());
				plcId_list.add(dto.getPlcid());
			}			
		}
		plc_json.put("plc_list",plc_list);
		plc_json.put("plcId_list",plcId_list);
		//받은 공연장 정보를 JSON으로 변환해서 리턴해준다. 
		return plc_json.toJSONString();
	}
	
	//영화관 선택 후 
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
		//2017011로 해당하는 날짜의 reserv_num을 획득
		List<String> volist  = reservService.reservation_chk_byDayTime(vo);
		//reserv_num을 통해 reservation_detail에서의 해당 시간의 reservationVO를 저장함
		//얻은 reserv_num을 꺼내서 조회한다.
		*/		
		PerformanceDTO dto = reservService.perform_detail(prf_id);	
		System.out.println(dto);
		JSONObject prf_json = new JSONObject();
		JSONObject timeTable = new JSONObject();
		JSONArray timeTable_arr = new JSONArray();
		prf_json.put("tckprice", dto.getTckprice());
		prf_json.put("prfid", dto.getPrfid());
		prf_json.put("prfnm", dto.getPrfnm());
		prf_json.put("prfpdfrom", dto.getPrfpdfrom());
		prf_json.put("prfpdto", dto.getPrfpdto());
		prf_json.put("prfruntime", dto.getPrfruntime());
		
		//공연시간 필터링 후 JSON배열에 저장
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
		String parts="[가-힣]..\\([0-9][0-9]\\:[0-9][0-9]\\)";	//1
		String parts2="[가-힣]..\\([0-9][0-9]\\:[0-9][0-9]\\,[0-9][0-9]\\:[0-9][0-9]\\)";	//2
		String parts3="[가-힣].. ~ [가-힣]..\\([0-9][0-9]\\:[0-9][0-9]\\)";	//3
		String parts4="[가-힣].. ~ [가-힣]..\\([0-9][0-9]\\:[0-9][0-9]\\,[0-9][0-9]\\:[0-9][0-9]\\)";//4
		
		List<List<String>> indexArr = new ArrayList<List<String>>();
		List<String> day0 = new ArrayList<String>();//일
		List<String> day1 = new ArrayList<String>();//월
		List<String> day2 = new ArrayList<String>();//화
		List<String> day3 = new ArrayList<String>();//수
		List<String> day4 = new ArrayList<String>();//목
		List<String> day5 = new ArrayList<String>();//금
		List<String> day6 = new ArrayList<String>();//토
		indexArr.add(day0);
		indexArr.add(day1);
		indexArr.add(day2);
		indexArr.add(day3);
		indexArr.add(day4);
		indexArr.add(day5);
		indexArr.add(day6);
		
		//1. parts1에서는 요일이 하나 , 시간대도 하나
		//각 요일에
		Pattern pattern = Pattern.compile(parts);
		Matcher match = pattern.matcher(useStr);
		while(match.find()){
			//System.out.println("1:"+match.group());
			String output= match.group();//화요일(20:00)
			String[] output2 = output.split("\\(");
			if(output2.length > 0){	//길이 체크
				if(output.split("\\(") !=null){	   //괄호 제거
					String criteria = output2[0];//요일추출
					String input_val = output2[1].substring(0, output2[1].length()-1);//시간추출
					if(criteria.equals("일요일")){
						day0.add(input_val);
					}else if(criteria.equals("월요일")){
						day1.add(input_val);
					}else if(criteria.equals("화요일")){
						day2.add(input_val);
					}else if(criteria.equals("수요일")){
						day3.add(input_val);
					}else if(criteria.equals("목요일")){
						day4.add(input_val);
					}else if(criteria.equals("금요일")){
						day5.add(input_val);
					}else if(criteria.equals("토요일")){
						day6.add(input_val);
					}
				}				
			}			
		}
		//2. parts2에서는 요일이 하나, 시간대 다수
		Pattern pattern2 = Pattern.compile(parts2);
		Matcher match2 = pattern2.matcher(useStr);		
		while(match2.find()){
			//System.out.println("2:"+match2.group());	
			String output= match2.group();//수요일(16:00,20:00)
			String[] output2 = output.split("\\(");
			if(output2.length > 0){	//길이 체크
				if(output.split("\\(") !=null){	   //괄호 제거
					String criteria = output2[0];//요일추출, 기준!
					String str = output2[1].substring(0, output2[1].length()-1);// ','로 분리해야할 시간
					String[] strArr = str.split(",");
					if(strArr.length > 0){						
						for(int i =0; i < strArr.length; i++){//각 요일별로 배열에 삽입
							if(criteria.equals("일요일")){
								day0.add(strArr[i]);
							}else if(criteria.equals("월요일")){
								day1.add(strArr[i]);
							}else if(criteria.equals("화요일")){
								day2.add(strArr[i]);
							}else if(criteria.equals("수요일")){
								day3.add(strArr[i]);
							}else if(criteria.equals("목요일")){
								day4.add(strArr[i]);
							}else if(criteria.equals("금요일")){
								day5.add(strArr[i]);
							}else if(criteria.equals("토요일")){
								day6.add(strArr[i]);
							}
						}
					}
				}
			}
		}
		
		//3. part3에서는 요일이 물결로 여러개 시간대 하나
		Pattern pattern3 = Pattern.compile(parts3);
		Matcher match3 = pattern3.matcher(useStr);		
		while(match3.find()){
			//System.out.println("3:"+match3.group());
			String output= match3.group();//목요일 ~ 금요일(20:00)
			String[] output2 = output.split("\\(");
			if(output2.length > 0){
				String init = output2[0].replaceAll("\\p{Z}", "");//공백제거
				String time_Val = output2[1].substring(0, output2[1].length()-1);
				String arr = init.replace("일요일", "7").replace("월요일", "1").replace("화요일", "2").replace("수요일", "3");//각 요일을 일~월의 순서로 치환
				String arr2 = arr.replace("목요일", "4").replace("금요일", "5").replace("토요일", "6");
				String[] stan_val = arr2.split("~");//4~6
				int start =0;
				int end =0;				
				int stand_first = Integer.parseInt(stan_val[0]);
				int stand_second = Integer.parseInt(stan_val[1]);
				if(stand_first < stand_second){//앞이 더 작게 만들어준다.
					start = stand_first;
					end = stand_second;
				}else if(stand_first > stand_second){
					start = stand_second;
					end = stand_first;							
				}
				for(int i = start; i <= end; i++){//ex 4~6번까지 요일 List<String>에 넣는다. 
					indexArr.get(i).add(time_Val);
				}				
			}			
		}
		
		//4. part3에서는 요일이 물결로 여러개 시간대 여러개
		Pattern pattern4 = Pattern.compile(parts4);
		Matcher match4 = pattern4.matcher(useStr);	
		while(match4.find()){
			String output = match4.group();
			//System.out.println("4:"+match4.group());
			String[] output2 = output.split("\\(");
			if(output2.length > 0){
				String init = output2[0].replaceAll("\\p{Z}", "");//공백제거
				String time_Val = output2[1].substring(0, output2[1].length()-1);
				String[] strArr = time_Val.split(",");
				List<String> list = new ArrayList<String>();//시간대를 나눈다. ex 18:00,19:00를 저장
				for(int i=0; i < strArr.length; i++){
					list.add(strArr[i]);
				}
				String arr = init.replace("일요일", "7").replace("월요일", "1").replace("화요일", "2").replace("수요일", "3");//각 요일을 일~월의 순서로 치환
				String arr2 = arr.replace("목요일", "4").replace("금요일", "5").replace("토요일", "6");
				String[] stan_val = arr2.split("~");//4~6 
				int stand_first = Integer.parseInt(stan_val[0]);
				int stand_second = Integer.parseInt(stan_val[1]);
				int start =0;
				int end =0;
				if(stand_first < stand_second){//앞이 더 작게 만들어준다.
					start = stand_first;
					end = stand_second;
				}else if(stand_first > stand_second){
					start = stand_second;
					end = stand_first;							
				}
				for(int i = start; i < end; i++){//ex 4~6번까지 요일 List<String>에 넣는다. 
					for(int j=0; j < list.size();j++){
						indexArr.get(i).add(list.get(j));//4~6번까지 요일 List<String>에 16:00,17:00 시간표 여러개를 넣는다.
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
		String regex="([a-zA-Z]{1,}석|전{1,}석) \\d{1,}\\,\\d{1,}원";
		
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
			String[] str = priceList.get(i).split("석");
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
