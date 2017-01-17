package kitri.reservation.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kitri.performinfo.performance.dto.PerformanceDTO;
import kitri.performinfo.prfplace.dto.PrfplaceDTO;
import kitri.reservation.service.reservationService;

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
	public String seat(){
		return "reservation_seat";
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
		PerformanceDTO dto = reservService.perform_detail(prf_id);
		System.out.println(dto);		
		JSONObject prf_json = new JSONObject();
		prf_json.put("tckprice", dto.getTckprice());
		prf_json.put("prfid", dto.getPrfid());
		prf_json.put("prfnm", dto.getPrfnm());
		prf_json.put("prfpdfrom", dto.getPrfpdfrom());
		prf_json.put("prfpdto", dto.getPrfpdto());
		prf_json.put("prfruntime", dto.getPrfruntime());
		prf_json.put("prfdaytime", dto.getPrfdaytime());
		System.out.println(prf_json.toJSONString());
		return prf_json.toJSONString();
	}
	
	
	
	
	
	
	
}
