package kitri.user.controller;

import java.util.List;

import kitri.user.service.UserService;
import kitri.user.vo.UserVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ListController {

	@Autowired
	UserService service;
	
	@RequestMapping(value="/list.do")
	public ModelAndView list(){
		ModelAndView mav = new ModelAndView();
		List<UserVO> userlist = service.userList();
		mav.addObject("userlist", userlist);
		mav.setViewName("list_member");
		System.out.println(userlist);
		return mav;
	}
}
