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
		ModelAndView mav = new ModelAndView();
		//List<RcheckVO> Rlist = service.Rcheck(userid);
		
		//mav.addObject("Rlist", Rlist);
		mav.setViewName("mypageRcheck/list");
		return mav;
	}
}
