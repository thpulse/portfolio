package kitri.pro.stat.weather.controller;

import java.util.List;

import kitri.performinfo.performance.dto.PerformanceDTO;
import kitri.pro.stat.weather.service.PreferencesWeatherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PreferencesWeatherController {
	@Autowired
	PreferencesWeatherService service;
	@RequestMapping("/stat/weather_main.do")
	public String main(){
		List<PerformanceDTO> performancelist = service.PerformanceList();
		System.out.println(performancelist.size());
		return "stat/weather";
	}
	
}