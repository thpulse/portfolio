package kitri.user.controller;



import kitri.user.service.UserService;
import kitri.user.vo.UserVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InsertController {
	
	private ShaPasswordEncoder encoder = new ShaPasswordEncoder(256);
	
	@Autowired
	UserService service;
	

	@RequestMapping(value="/insert.do",method=RequestMethod.GET)
	public String showPage(){
		return "register_member";
	}
	
	@RequestMapping(value="/insert.do",method=RequestMethod.POST)
	public ModelAndView runInsert(UserVO user){
		System.out.println(user);
		String dbpw = encoder.encodePassword(user.getUser_pass(), null);
		
		System.out.println(dbpw);
	     //user.setUser_pass(dbpw);
		
		if(user.getUser_gerne()==null){
			user.setUser_gerne("none");
			user.setUser_pass(dbpw);
			service.insert(user);
		}else{
			user.setUser_pass(dbpw);
			service.insert(user);
		}
		return new ModelAndView("redirect:/index.do");
	}
}
