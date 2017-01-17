package kitri.pro.weather.controller;

import java.util.Calendar;
import java.util.List;

import kitri.pro.area.dto.AreaVO;
import kitri.pro.weather.dto.WeatherVO;
import kitri.pro.weather.logic.WeatherLogic;
import kitri.pro.weather.service.WeatherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WeatherController {
	@Autowired
	WeatherService service;
	@Autowired
	WeatherLogic logic;

	@Scheduled(cron="0 0 15 * * *")
	public void insert(){
		
		List<AreaVO> arealist = service.areaList();
		//System.out.println(arealist.size());
		//System.out.println(arealist.get(0));
		
		Calendar calendar = Calendar.getInstance();
		String e_year = calendar.get(calendar.YEAR)+"";
		String e_month = (calendar.get(calendar.MONTH)+1)+"";
		String e_date = (calendar.get(calendar.DATE)-1)+"";
		//System.out.println(calendar.get(calendar.YEAR));
		//System.out.println(calendar.get(calendar.MONTH)+1);
		//System.out.println(calendar.get(calendar.DATE)-1);
		//System.out.println(e_year);
		//System.out.println(e_month);
		//System.out.println(e_date);
		
		logic.weatherInsert(arealist,e_year,e_month,e_date);
	}	
}
