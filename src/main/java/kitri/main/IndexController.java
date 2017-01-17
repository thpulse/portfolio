package kitri.main;


import java.util.List;

import kitri.performinfo.boxweekly.dto.BoxWeeklyDTO;
import kitri.performinfo.boxweekly.service.BoxWeeklyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController{
	@Autowired
	BoxWeeklyService service;
	
	@RequestMapping("/index.do")
	public ModelAndView main(BoxWeeklyDTO dto){
		// �ڽ����ǽ� �Ľ� ��� �Ѹ�
		List<BoxWeeklyDTO> boxlist = service.Total_BoxWeekly(dto);
		return new ModelAndView("index","boxlist",boxlist);
	}
}
