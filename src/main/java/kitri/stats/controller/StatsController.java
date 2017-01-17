package kitri.stats.controller;

import java.util.List;

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
	
	@RequestMapping("")
	public ModelAndView stats(){
		ModelAndView mav = new ModelAndView();
		List<StatsVO> userinfo = service.stats();
		
		mav.addObject("userinfo", userinfo);
		mav.setViewName("");
		
		return mav;
	}
}
