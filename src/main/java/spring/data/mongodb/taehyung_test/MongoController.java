package spring.data.mongodb.taehyung_test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MongoController {
	@Autowired	
	MongoDAO dao;
	@RequestMapping("/score/list")
	public ModelAndView getDoclist(String pageNo){
		ModelAndView mav = new ModelAndView();
		int page= Integer.parseInt(pageNo);
		List<ScoreDTO> mongolist = dao.findAll(page);
		mav.setViewName("list_mongo");
		mav.addObject("mongolist", mongolist);		
		return mav;
	}	
}
