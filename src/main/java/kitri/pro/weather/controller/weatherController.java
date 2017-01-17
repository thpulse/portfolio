package kitri.pro.weather.controller;

import java.util.Calendar;
import java.util.List;

import kitri.pro.area.dto.AreaVO;
import kitri.pro.weather.dto.WeatherVO;
import kitri.pro.weather.logic.WeatherLogic;
import kitri.pro.weather.service.WeatherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class weatherController {
	@Autowired
	WeatherService service;
	@Autowired
	WeatherLogic logic;
	
	@RequestMapping(value="/weather/insert.do",method=RequestMethod.POST)
	public ModelAndView insert(String year,String month){
		//System.out.println(year+","+month);
		String s_year=year;
		String s_month=month;
		
		
		List<AreaVO> arealist = service.areaList();
		//System.out.println(arealist.size());
		//System.out.println(arealist.get(0));
		
		Calendar calendar = Calendar.getInstance();
		String e_year = calendar.get(calendar.YEAR)+"";
		String e_month = (calendar.get(calendar.MONTH)+1)+"";
		String e_date = (calendar.get(calendar.DATE)-2)+"";
		//System.out.println(calendar.get(calendar.YEAR));
		//System.out.println(calendar.get(calendar.MONTH)+1);
		//System.out.println(calendar.get(calendar.DATE)-2);
		
		logic.weatherList(arealist,s_year,s_month,e_year,e_month,e_date);
/*		List<WeatherVO> weatherlist = logic.weatherList(arealist,s_year,s_month,e_year,e_month,e_date);
		System.out.println(weatherlist.size());
		System.out.println(weatherlist.get(0));*/
		return new ModelAndView("redirect:/admin/main.do");
	}	
}
