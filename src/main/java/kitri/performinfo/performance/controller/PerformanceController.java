package kitri.performinfo.performance.controller;

import java.util.List;

import kitri.performinfo.performance.dto.PerformanceDTO;
import kitri.performinfo.performance.dto.PerformanceSogaeimgDTO;
import kitri.performinfo.performance.service.PerformanceService;
import oracle.jdbc.proxy.annotation.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
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
	
	//스케줄러 생성 (매일 낮 12시 15분 공연정보 업데이트. 중복정보는 받아오지 않음)
	@RequestMapping("/perform/prfinfo/insert.do")
	@Scheduled(cron="0 15 12 * * *")
	public void Add_Performance(){
		service.Add_Performance();
	}
	
	@RequestMapping("/perform/prfinfo/select.do")
	public ModelAndView Total_Performance(PerformanceDTO prf, Pageable pageable){
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
