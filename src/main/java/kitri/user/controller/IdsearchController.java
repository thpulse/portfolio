package kitri.user.controller;



import javax.servlet.http.HttpServletRequest;

import kitri.user.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IdsearchController {
	
	@Autowired
	UserService service;
	
	@RequestMapping(value ="/idsearch.do", method = RequestMethod.GET)
	   public String showPage(){
	      System.out.println("++++++++++++++++아이디찾기 화면요청+++");
	      System.out.println("컨트롤러여기까지?");
	      return "idsearch";
	  }
	
	@RequestMapping(value="/idsearch.do", method=RequestMethod.POST)
	@ResponseBody
	public String runidsearch(HttpServletRequest req, String user_name,String user_tel){
		System.out.println(user_name+user_tel);
		String id = service.idsearch(user_name, user_tel);
		System.out.println(id);
		return id;
	}
	
	@ResponseBody
	@RequestMapping(value="/passsearch.do", method=RequestMethod.POST)
	public String runpasssearch(HttpServletRequest req, String user_id, String user_ssn){
		
		String pass = service.passsearch(user_id, user_ssn);
		System.out.println(pass);
		return pass;
	}
	
}
