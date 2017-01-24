package kitri.pro.stat.month.controller;

import java.util.List;

import kitri.pro.stat.month.service.PreferencesMonthService;
import kitri.pro.stat.weather.dto.PreferencesVO;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PreferencesMonthController {
	@Autowired
	PreferencesMonthService service;
	
	@RequestMapping("/stat/month_main.do")
	public String main(){
		return "stat/month";
	}
	
	@RequestMapping(value="/stat/find2.do", method=RequestMethod.GET,produces="application/json;charset=utf-8")
	public @ResponseBody String find(@RequestParam String month){
		List<PreferencesVO> preferences= service.preferences(month);
		
		JSONObject month_json = new JSONObject();
		JSONArray month_list = new JSONArray();

		if(preferences.size()>0){

			for (int i = 1; i < preferences.size(); i++) {
				JSONObject month_json_item = new JSONObject();
				month_json_item.put("addr1", preferences.get(i).getAddr1());
				month_json_item.put("addr2", preferences.get(i).getAddr2());
				month_json_item.put("cate", preferences.get(i).getCate());
				month_json_item.put("total", preferences.get(i).getTotnmrs());
				month_list.add(month_json_item);
			}
		}
		month_json.put("month_list", month_list);
		return month_json.toJSONString();
	}
}
