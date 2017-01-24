package kitri.performinfo.performance.controller;

import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import kitri.performinfo.jpa.Performance;
import kitri.performinfo.jpa.PerformanceRepository;
import kitri.performinfo.performance.dto.PerformanceDTO;
import kitri.performinfo.performance.dto.PerformanceSogaeimgDTO;
import kitri.performinfo.performance.service.PerformanceService;

import kitri.review.Service.ReviewService;
import kitri.review.VO.ReviewVO;

import kitri.stats.service.StatsService;
import kitri.stats.vo.StatsVO;


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

	
	@Autowired
	StatsService statsService;

	
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
	public ModelAndView Total_Performance(PerformanceDTO prf){
		List<PerformanceDTO> prflist = service.Total_Performance(prf);
		return new ModelAndView("perform_prf","prflist",prflist);
	}
	
	//페이징
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

	public ModelAndView Performance_Info(PerformanceDTO prf) throws ParseException{
		ModelAndView mav = new ModelAndView();
		PerformanceDTO prfRes = service.Performance_Info(prf);
		//출연진, 제작진 정보가 null일경우
		if (prfRes.getPrfcast() == null) {
			prfRes.setPrfcast("해당 정보가 없습니다.");
		}else if (prfRes.getPrfcrew() == null){
			prfRes.setPrfcrew("해당 정보가 없습니다.");
		}
		List<PerformanceSogaeimgDTO> imglist = service.PerformanceImg_Info(prf);

		String pfr_id = prf.getPrfid();
		int count1 = 0;
		int count2 = 0;
		
		List<ReviewVO> readall = service2.readall(pfr_id);
		
		for (int i = 0; i < readall.size(); i++) {
			int revgb = readall.get(i).getRevgb();
			if(revgb==1){
				count1+=1;
			}else if(revgb==0){
				count2+=1;
			}
		}
		List<StatsVO> userinfo = statsService.stats(prf.getPrfid());
		System.out.println(userinfo);
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
		System.out.println("test " + teens+","+twenty+","+thirty+","+forty);
		System.out.println(male + "," + female);
		mav.addObject("teens", teens);
		mav.addObject("twenty", twenty);
		mav.addObject("thirty", thirty);
		mav.addObject("forty", forty);
		mav.addObject("male", male);
		mav.addObject("female", female);

		mav.addObject("prf",prfRes);
		mav.addObject("sogaelist",imglist);
		mav.addObject("reviewlist", readall);
		mav.addObject("count1",count1);
		mav.addObject("count2",count2);
		mav.setViewName("perform_prf_info");		
		return mav;
	}
}
