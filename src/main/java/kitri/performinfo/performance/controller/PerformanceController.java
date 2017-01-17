package kitri.performinfo.performance.controller;

import java.util.List;

import kitri.performinfo.performance.dto.PerformanceDTO;
import kitri.performinfo.performance.dto.PerformanceSogaeimgDTO;
import kitri.performinfo.performance.service.PerformanceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PerformanceController {
	@Autowired
	PerformanceService service;
	
	@RequestMapping("/perform/admin/index.do")
	public String Show_AdminView(){
		return "admin";
	}
	@RequestMapping("/perform/prfinfo/index.do")
	public String Show_Performance(){
		return "perform_main";
	}
	
	@RequestMapping("/perform/prfinfo/insert.do")
	public String Add_Performance(){
		service.Add_Performance();
		return "admin";
	}
	
	@RequestMapping("/perform/prfinfo/select.do")
	public ModelAndView Total_Performance(PerformanceDTO prf){
		List<PerformanceDTO> prflist = service.Total_Performance(prf);
		return new ModelAndView("perform_prf","prflist",prflist);
	}
	
	@RequestMapping("/perform/prfinfo/read.do")
	public ModelAndView Performance_Info(PerformanceDTO prf){
		PerformanceDTO prfRes = service.Performance_Info(prf);
		List<PerformanceSogaeimgDTO> imglist = service.PerformanceImg_Info(prf);
		ModelAndView mav = new ModelAndView();
		mav.addObject("prf",prfRes);
		mav.addObject("sogaelist",imglist);
		mav.setViewName("perform_prf_info");
		return mav;
	}
}
