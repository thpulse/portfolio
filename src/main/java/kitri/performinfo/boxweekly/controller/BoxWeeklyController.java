package kitri.performinfo.boxweekly.controller;

import java.util.List;

import kitri.performinfo.boxweekly.dto.BoxWeeklyDTO;
import kitri.performinfo.boxweekly.service.BoxWeeklyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoxWeeklyController {
	@Autowired
	BoxWeeklyService service;
	
	@RequestMapping("/perform/boxweekly/insert.do")
	public String Add_BoxWeekly(String genre){
		List<BoxWeeklyDTO> boxlist = service.Show_BoxWeekly(genre);
		System.out.println(boxlist);
		return "index";
	}
	
}
