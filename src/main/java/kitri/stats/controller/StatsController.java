package kitri.stats.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kitri.search.vo.SearchVO;
import kitri.stats.service.StatsService;
import kitri.stats.vo.StatsVO;

@Controller
public class StatsController {
	
	@Autowired
	StatsService service;
	
	@RequestMapping("/stats/statsResult.do")
	public ModelAndView stats() throws ParseException{
		ModelAndView mav = new ModelAndView();
		List<StatsVO> userinfo = service.stats();
		
		int teens=0;
		int twenty=0;
		int thirty=0;
		int forty=0;
		int male = 0;
		int female = 0;
		StatsVO sta = new StatsVO();

		for(int i = 0; i<userinfo.size(); i++){
			sta = userinfo.get(i);
			//System.out.println(sta.getUser_ssn());
			
			String birthStr2 = sta.getUser_ssn().substring(7, 8);
			if(birthStr2.charAt(0)=='1' || birthStr2.charAt(0)=='3'){
				male++;
			}else if(birthStr2.charAt(0)=='2' || birthStr2.charAt(0)=='4'){
				female++;
			}
			
			int jumingubun = sta.getUser_ssn().indexOf("-");
			String birthStr = sta.getUser_ssn().substring(0, jumingubun);		
			int century = Integer.parseInt(sta.getUser_ssn().substring(jumingubun+1,jumingubun+2));
			if(century == 9 || century == 0){
				birthStr = birthStr + "18";
			}else if(century == 1 || century == 2 || century == 5 || century == 6) {
				   birthStr = "19" + birthStr;
			} else if(century == 3 || century == 4 || century == 7 || century == 8) {
			   birthStr = "20" + birthStr;
			}
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd", Locale.KOREAN);
			Date birthDay = sdf.parse(birthStr);
 
			GregorianCalendar today = new GregorianCalendar();
			GregorianCalendar birth = new GregorianCalendar();
			birth.setTime(birthDay);
			
			int factor = 0;
			String age = null;
			
			if(today.get(Calendar.DAY_OF_YEAR)<birth.get(Calendar.DAY_OF_YEAR)) {
			   factor = 1;
			 }
			 age = (today.get(Calendar.YEAR) - birth.get(Calendar.YEAR) + factor) + "";
			 
			if(age.charAt(0) == '1'){
				teens++;
			}else if(age.charAt(0) == '2'){
				twenty++;
			}else if(age.charAt(0) == '3'){
				thirty++;
			}else if(age.charAt(0) == '4'){
				forty++;
			}
			
			 
			
		}
		System.out.println(teens+","+twenty+","+thirty+","+forty);
		//System.out.println(male + "," + female);
		mav.addObject("teens", teens);
		mav.addObject("twenty", twenty);
		mav.addObject("thirty", thirty);
		mav.addObject("forty", forty);
		mav.addObject("male", male);
		mav.addObject("female", female);
		mav.setViewName("stats/list");

		
		return mav;
	}
}
