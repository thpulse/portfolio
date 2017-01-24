package kitri.performinfo.performance.controller;

import java.net.URLEncoder;
import java.util.List;

import kitri.performinfo.jpa.Performance;
import kitri.performinfo.jpa.PerformanceRepository;
import kitri.performinfo.performance.dto.PerformanceDTO;
import kitri.performinfo.performance.dto.PerformanceSogaeimgDTO;
import kitri.performinfo.performance.service.PerformanceService;
import kitri.review.Service.ReviewService;
import kitri.review.VO.ReviewVO;

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
public class PerformanceController {
	@Autowired
	PerformanceService service;

	@Autowired
	ReviewService service2;

	
	@Autowired
	PerformanceRepository repository;

	
	@RequestMapping("/perform/admin/index.do")
	public String Show_AdminView(){
		return "admin";
	}
	@RequestMapping("/perform/prfinfo/index.do")
	public String Show_Performance(){
		return "perform_main";
	}
	
	//�����ٷ� ���� (���� �� 12�� 15�� �������� ������Ʈ. �ߺ������� �޾ƿ��� ����)
	@RequestMapping("/perform/prfinfo/insert.do")
	@Scheduled(cron="0 15 12 * * *")
	public void Add_Performance(){
		service.Add_Performance();
	}
	
	@RequestMapping("/perform/prfinfo/select.do")
	public ModelAndView Total_Performance(PerformanceDTO prf){
		List<PerformanceDTO> prflist = service.Total_Performance(prf);
		return new ModelAndView("perform_prf","prflist",prflist);
	}
	
	//����¡
	@RequestMapping("/perform/prfinfo/select2.do/{page_no}/{genre}")
	public ModelAndView TotalPrf_Paging(@PathVariable int page_no,@PathVariable String genre) throws Exception{
		ModelAndView mav = new ModelAndView();
		Pageable req = new PageRequest(page_no, 20, new Sort(Direction.ASC,"prfpdto"));
		Page<Performance> page = null;
		if (genre.equals("all")) {
			page = repository.findAll(req);
		}else{
			page = repository.findByGenre(genre, req);
		}
		List<Performance> prflist = page.getContent();
		int current = page.getNumber()+1;
		int begin = Math.max(1, current-5);
		int end = Math.min(begin+10, page.getTotalPages());
		int totalPages = page.getTotalPages();
		mav.addObject("prflist",prflist);
		mav.addObject("beginIndex",begin);
		mav.addObject("endIndex",end);
		mav.addObject("currentIndex",current);
		mav.addObject("totalPages",totalPages);
		mav.addObject("genre",URLEncoder.encode(genre,"euc-kr"));
		mav.setViewName("perform_prf");
		return mav;
	}	
	
	@RequestMapping("/perform/prfinfo/read.do")
	public ModelAndView Performance_Info(PerformanceDTO prf){
		System.out.println(prf);
		PerformanceDTO prfRes = service.Performance_Info(prf);
		//�⿬��, ������ ������ null�ϰ��
		if (prfRes.getPrfcast() == null) {
			prfRes.setPrfcast("�ش� ������ �����ϴ�.");
		}else if (prfRes.getPrfcrew() == null){
			prfRes.setPrfcrew("�ش� ������ �����ϴ�.");
		}
		List<PerformanceSogaeimgDTO> imglist = service.PerformanceImg_Info(prf);
		String pfr_id = prf.getPrfid();
		List<ReviewVO> readall = service2.readall(pfr_id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("prf",prfRes);
		mav.addObject("sogaelist",imglist);
		mav.addObject("reviewlist", readall);
		mav.setViewName("perform_prf_info");		
		return mav;
	}
}
