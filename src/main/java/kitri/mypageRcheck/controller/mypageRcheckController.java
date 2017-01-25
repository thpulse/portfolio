package kitri.mypageRcheck.controller;

import java.util.List;

import kitri.mypageRcheck.service.RcheckService;
import kitri.mypageRcheck.vo.RcheckVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class mypageRcheckController {
	@Autowired
	RcheckService service;

	@RequestMapping("/mypageRcheck/list.do")
	public ModelAndView mypagemain(String userid){
		//System.out.println(userid);
		ModelAndView mav = new ModelAndView();
		List<RcheckVO> Rlist = service.Rcheck(userid);
		System.out.println(Rlist);
		
		mav.addObject("Rlist", Rlist);
		mav.setViewName("mypageRcheck/list");
		return mav;
	}
	
	
	@RequestMapping("/mypageRcheck/Rcancel.do")
	public ModelAndView Rcancel(String reserv_num,String userid){
		System.out.println(reserv_num);
		ModelAndView mav = new ModelAndView();
		
		service.Rcancel(reserv_num);
		
		mav.setViewName("redirect:/mypageRcheck/list.do?userid="+userid);
		return mav;
	}
}
