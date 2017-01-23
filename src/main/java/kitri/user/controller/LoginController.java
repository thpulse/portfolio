package kitri.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kitri.user.service.UserService;
import kitri.user.vo.UserVO;
import kitri.user.vo.loginVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController {
	
	@Autowired
	UserService service;
	@RequestMapping(value ="/userlogin", method = RequestMethod.GET)
	   public String login(){
	      System.out.println("+++login 화면요청+++");
	      System.out.println("컨트롤러여기까지?");
	      return "userlogin";
	  }
	
	/*@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public ModelAndView runLogin(HttpServletRequest req, loginVO loginUser){
		loginVO checkUser = service.login(loginUser.getUser_id(),
													loginUser.getUser_pass());
		String url ="";
		System.out.println(loginUser);
		if(checkUser!=null){
			req.getSession().setAttribute("loginUser", checkUser);
			url="/index.do";
		}else{
			url="/insert.do";
		}
		return new ModelAndView("redirect:"+url);
	}*/
	
	@RequestMapping(value="/logout.do",method=RequestMethod.GET)
	public ModelAndView runLogout(HttpServletRequest req){
		HttpSession ses = req.getSession(false);
		if(ses!=null){
			ses.invalidate();
		}
		return new ModelAndView("redirect:/index.do");
	}
	  
}
