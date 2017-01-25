package kitri.pro.weather.controller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kitri.pro.area.dto.AreaVO;
import kitri.pro.weather.dto.WeatherVO;
import kitri.pro.weather.logic.WeatherLogic;
import kitri.pro.weather.service.WeatherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Component
public class WeatherController {
	@Autowired
	WeatherService service;
	@Autowired
	WeatherLogic logic;

	@Scheduled(cron="0 0 15 * * *")
	//@RequestMapping("/insert_weather.do")
	public void insert(){
		List<AreaVO> arealist = service.areaList();
		//System.out.println(arealist.size());
		//System.out.println(arealist.get(0));
		
		Calendar calendar = Calendar.getInstance();
		String e_year = calendar.get(calendar.YEAR)+"";
		String e_month = (calendar.get(calendar.MONTH)+1)+"";
		String e_date = (calendar.get(calendar.DATE)-1)+"";
		
		logic.weatherInsert(arealist,e_year,e_month,e_date);
/*		
		ModelAndView mav=  new ModelAndView();
		Map<String, String> daylist = new HashMap<String, String>();
		WeatherVO last = service.last_select();
		mav.addObject("last",last);
		mav.setViewName("adminMain");
		return mav;*/
	}	
}
