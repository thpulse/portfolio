package kitri.user.controller;



import java.util.List;

import kitri.user.service.UserService;
import kitri.user.vo.UserVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DeleteController {
	
	@Autowired
	UserService service;
	
	@RequestMapping(value="/delete.do")
	public ModelAndView delete(String id){
		ModelAndView mav = new ModelAndView();
		List<UserVO> boardlist = service.delete(id);
		return new ModelAndView("list_member");
	}
	

}
