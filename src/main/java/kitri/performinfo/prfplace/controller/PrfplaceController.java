package kitri.performinfo.prfplace.controller;

import java.util.List;

import kitri.performinfo.jpa.Prf_Place;
import kitri.performinfo.jpa.Prf_PlaceRepository;
import kitri.performinfo.performance.dto.PerformanceDTO;
import kitri.performinfo.performance.service.PerformanceService;
import kitri.performinfo.prfplace.dto.PrfplaceDTO;
import kitri.performinfo.prfplace.service.PrfplaceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PrfplaceController {
	@Autowired
	PrfplaceService service;
	
	@Autowired
	PerformanceService prfservice;
	
	@Autowired
	Prf_PlaceRepository repository;
	
	@RequestMapping("/perform/prfplc/index.do")
	public ModelAndView Total_PrfPlace(){
		ModelAndView mav = new ModelAndView();
		List<PrfplaceDTO> plclist = service.Total_PrfPlace();
		mav.addObject("plclist",plclist);
		mav.setViewName("perform_place");
		return mav;
	}
	
	//페이징
	@RequestMapping("/perform/prfplc/select.do/{page_no}")
	public ModelAndView Total_PrfPlace_Paging(@PathVariable int page_no){
		ModelAndView mav = new ModelAndView();
		Pageable req = new PageRequest(page_no, 15, new Sort(Direction.ASC,"plcnm"));
		Page<Prf_Place> page = repository.findAll(req);
		List<Prf_Place> plclist = page.getContent();
		int current = page.getNumber()+1;
		int begin = Math.max(1, current-5);
		int end = Math.min(begin+10, page.getTotalPages());
		int totalPages = page.getTotalPages();
		mav.addObject("plclist",plclist);
		mav.addObject("beginIndex",begin);
		mav.addObject("endIndex",end);
		mav.addObject("currentIndex",current);
		mav.addObject("totalPages",totalPages);
		mav.setViewName("perform_place");
		return mav;
	}
	
	//공연장 정보 매일 낮 12시 20분에 자동 업데이트
	@Scheduled(cron="0 20 12 * * *")
	@RequestMapping("/perform/prfplc/insert.do")
	public void Add_Prfplace(){
		service.Add_Prfplace();
	}
	
	@RequestMapping("/perform/prfplc/read.do")
	public ModelAndView PrfPlace_Info(PrfplaceDTO plc){
		ModelAndView mav = new ModelAndView();
		
		//장소정보
		PrfplaceDTO plcinfo = service.PrfPlace_Info(plc);
		//System.out.println(plcinfo);
		
		//장소에 해당하는 공연정보
		List<PerformanceDTO> latestprf = prfservice.LatestPerform_Info(plc);
		//System.out.println(latestprf);
		
		mav.addObject("latestprflist",latestprf);
		mav.addObject("plc",plcinfo);
		mav.setViewName("perform_place_info");
		return mav;
	}
}
