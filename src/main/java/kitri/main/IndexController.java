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
		//�ڽ����ǽ� �Ľ� ��� �Ѹ�
		if (genre==null) {
			genre = "YK";
		}
		List<BoxWeeklyDTO> boxlist = service.Show_BoxWeekly(genre);
		
		//��õ���񽺿� ���� ���� ������ ����
		//�α��� ���� �Ǵ�
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();		
		//anonymousUser�� �α��ε��� ���� �����		
		String loginUser = auth.getName();
		List<PerformanceDTO> poster = new ArrayList<PerformanceDTO>();
		if(loginUser.equals("anonymousUser")){			
		}else{
			List<recommendResultVO> list = dao.selectResultByid(loginUser);
			for(int i=0; i < list.size(); i++){
				recommendResultVO vo = list.get(i);
				String item = vo.getItem_id();
				if(item.startsWith("PF")){
					//������ ���;���					
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
