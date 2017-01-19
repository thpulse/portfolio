package kitri.performinfo.prfplace.controller;

import java.util.List;

import kitri.performinfo.prfplace.dto.PrfplaceDTO;
import kitri.performinfo.prfplace.service.PrfplaceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PrfplaceController {
	@Autowired
	PrfplaceService service;
	
	@RequestMapping("/perform/prfplc/index.do")
	public ModelAndView Total_PrfPlace(){
		ModelAndView mav = new ModelAndView();
		List<PrfplaceDTO> plclist = service.Total_PrfPlace();
		mav.addObject("plclist",plclist);
		mav.setViewName("perform_place");
		return mav;
	}
	
	@RequestMapping("/perform/prfplc/mapIndex.do")
	public String Show_mPrfplace(){
		return "perform_mplace";
	}
	
	@RequestMapping("/perform/prfplc/insert.do")
	public String Add_Prfplace(){
		service.Add_Prfplace();
		return "admin";
	}
	
	@RequestMapping("/perform/prfplc/read.do")
	public ModelAndView PrfPlace_Info(PrfplaceDTO plc){
		PrfplaceDTO plcinfo = service.PrfPlace_Info(plc);
		//System.out.println(plcinfo);
		return new ModelAndView("perform_place_info","plc",plcinfo);
	}
}
