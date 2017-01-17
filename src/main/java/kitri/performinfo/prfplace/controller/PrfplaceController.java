package kitri.performinfo.prfplace.controller;

import kitri.performinfo.prfplace.service.PrfplaceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PrfplaceController {
	@Autowired
	PrfplaceService service;
	
	@RequestMapping("/perform/prfplc/index.do")
	public String Show_Prfplace(){
		return "admin";
	}
	
	@RequestMapping("/perform/prfplc/insert.do")
	public String Add_Prfplace(){
		service.Add_Prfplace();
		return "admin";
	}
}
