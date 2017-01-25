package kitri.main;


import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.SecurityContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kitri.performinfo.boxweekly.dto.BoxWeeklyDTO;
import kitri.performinfo.boxweekly.service.BoxWeeklyService;
import kitri.performinfo.performance.dto.PerformanceDTO;
import kitri.recommend.controller.recommendDAOImpl;
import kitri.recommend.controller.recommendResultVO;
import kitri.reservation.service.reservationService;

@Controller
public class IndexController{
	@Autowired
	BoxWeeklyService service;
	@Autowired
	@Qualifier("recommenddao")
	recommendDAOImpl dao;
	@Autowired
	@Qualifier("reservationservice")
	reservationService reservService;
	
	@RequestMapping("/index.do")
	public ModelAndView main(String genre,String userid, String hello){
		ModelAndView mav = new ModelAndView();
		//박스오피스 파싱 결과 뿌림
		if (genre==null) {
			genre = "YK";
		}
		List<BoxWeeklyDTO> boxlist = service.Show_BoxWeekly(genre);
		
		//추천서비스에 의한 메인 포스터 생성
		//로그인 여부 판단
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();		
		//anonymousUser은 로그인된지 않은 사용자		
		String loginUser = auth.getName();
		List<PerformanceDTO> poster = new ArrayList<PerformanceDTO>();
		if(loginUser.equals("anonymousUser")){			
		}else{
			List<recommendResultVO> list = dao.selectResultByid(loginUser);
			for(int i=0; i < list.size(); i++){
				recommendResultVO vo = list.get(i);
				String item = vo.getItem_id();
				if(item.startsWith("PF")){
					//포스터 얻어와야함					
					PerformanceDTO dto = reservService.perform_detail(item);	
					poster.add(dto);
				}				
			}				
		}		
		System.out.println(poster);
		mav.addObject("id_val", loginUser);
		mav.addObject("boxlist",boxlist);
		mav.addObject("posterlist", poster);
		mav.setViewName("index_normal");
		return mav;
	}
}
