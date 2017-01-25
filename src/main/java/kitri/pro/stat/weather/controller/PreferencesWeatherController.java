package kitri.pro.stat.weather.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kitri.pro.stat.weather.dto.PreferencesVO;
import kitri.pro.stat.weather.dto.SelectStatVO;
import kitri.pro.stat.weather.dto.StatisticsVO;
import kitri.pro.stat.weather.service.PreferencesWeatherService;
import kitri.pro.weather.dto.WeatherVO;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PreferencesWeatherController {
	@Autowired
	PreferencesWeatherService service;
	@RequestMapping("/stat/weather_main.do")
	public String main(){
		return "stat/weather";
	}
	@RequestMapping("/stat/insert.do")
	public String insert(){
		int count = service.insertStat();
		System.out.println(count);
		return "stat/weather";
	}
	
	@RequestMapping("/stat/insert_complete.do")
	public String insert_complete(){
		List<SelectStatVO> selectlist = service.selectStat();
		int size = selectlist.size();
		for(int i=0 ; i<size ;i++){
			SelectStatVO vo = selectlist.get(i);
			String address = vo.getAddress();
			String[] addrlist = address.split("\\s+");
			StatisticsVO statcom=new StatisticsVO(vo.getDays(), vo.getPrfnm(), vo.getCate(), vo.getFcltynm(), addrlist[0], addrlist[1], vo.getTotnmrs());
			System.out.println(statcom);
			int count = service.insertStatistics(statcom);
		}
		return "stat/weather";
	}
	@RequestMapping(value="/stat/find.do", method=RequestMethod.GET,produces="application/json;charset=utf-8")
	public @ResponseBody String find(@RequestParam String weather) throws Exception{
		List<PreferencesVO> preferences= service.preferences(URLDecoder.decode(weather,"UTF-8"));
		JSONObject weather_json = new JSONObject();
		JSONArray weather_list = new JSONArray();

		if(preferences.size()>0){
			for (int i = 1; i < preferences.size(); i++) {
				JSONObject weather_json_item = new JSONObject();
				weather_json_item.put("addr1", preferences.get(i).getAddr1());
				weather_json_item.put("addr2", preferences.get(i).getAddr2());
				weather_json_item.put("cate", preferences.get(i).getCate());
				weather_json_item.put("total", preferences.get(i).getTotnmrs());
				weather_list.add(weather_json_item);
			}
		}
		weather_json.put("weather_list", weather_list);
		return weather_json.toJSONString();
	}
	@RequestMapping(value="/stat/cate_find.do", method=RequestMethod.GET,produces="application/json;charset=utf-8")
	public @ResponseBody String cate_find(@RequestParam String weather,@RequestParam String cate) throws Exception{
		String cate_en=URLDecoder.decode(cate,"UTF-8");
		List<PreferencesVO> preferences= service.preferences(URLDecoder.decode(weather,"UTF-8"));
		JSONObject weather_json = new JSONObject();
		JSONArray weather_list = new JSONArray();
		if(preferences.size()>0){
			for (int i = 1; i < preferences.size(); i++) {
				if(cate_en.equals(preferences.get(i).getCate())){
				JSONObject weather_json_item = new JSONObject();
				weather_json_item.put("addr1", preferences.get(i).getAddr1());
				weather_json_item.put("addr2", preferences.get(i).getAddr2());
				weather_json_item.put("cate", preferences.get(i).getCate());
				weather_json_item.put("total", preferences.get(i).getTotnmrs());
				weather_list.add(weather_json_item);
				}
			}
		}
		weather_json.put("cate_list", weather_list);
		return weather_json.toJSONString();
	}
}