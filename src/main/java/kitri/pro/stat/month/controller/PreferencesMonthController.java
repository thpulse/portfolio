package kitri.pro.stat.month.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PreferencesMonthController {

	
	@RequestMapping("/stat/month_main.do")
	public String main(){
		return "stat/month";
	}
	
}
