package kitri.mypage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MypageController {
	@RequestMapping("/mypage/mypage.do")
	public ModelAndView mypagemain(){

		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("mypage");
		return mav;
	}
	
}
