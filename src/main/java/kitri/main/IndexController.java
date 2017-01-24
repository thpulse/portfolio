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
	public ModelAndView main(String genre){
		// �ڽ����ǽ� �Ľ� ��� �Ѹ�
		if (genre==null) {
			genre = "YK";
		}
		List<BoxWeeklyDTO> boxlist = service.Show_BoxWeekly(genre);
		return new ModelAndView("index_normal","boxlist",boxlist);
	}
}
