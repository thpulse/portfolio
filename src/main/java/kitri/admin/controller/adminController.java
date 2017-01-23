package kitri.admin.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import kitri.pro.weather.dto.WeatherVO;
import kitri.pro.weather.service.WeatherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class adminController {
	@Autowired
	WeatherService service;
	
	@RequestMapping("/admin/main.do")
	public ModelAndView main(){
		ModelAndView mav=  new ModelAndView();
		Map<String, String> daylist = new HashMap<String, String>();
		WeatherVO last = service.last_select();
		mav.addObject("last",last);
		mav.setViewName("adminMain");
		return mav;
	}
	
}
