package spring.data.mongodb.taehyung_test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ScoreMongoController {
	@Autowired
	ScoreMongoService service;
	
	@RequestMapping(value="/score/insertform",method=RequestMethod.GET)
	public String insert(){
		return "insert_mongo";
	}
	
	@RequestMapping(value="/score/insert", method=RequestMethod.POST)
	public String insert(ScoreDTO document){
		service.insertDocument(document);
		return "redirect:/score/list?pageNo=0";
	}
	
	@RequestMapping(value="/score/multiinsert")
	public String multiinsert(){
		List<ScoreDTO> docs = new ArrayList<ScoreDTO>();
		ScoreDTO doc=null;
		for(int i=0; i<=5; i++){
			doc = new ScoreDTO();
			doc.setId("multi"+i);
			doc.setName("multi"+i);
			doc.setAddr("서울");
			doc.setDept("전산실");
			docs.add(doc);
		}
		service.insertAllDocument(docs);
		return "redirect:/score/list?pageNo=0";
	}
	@RequestMapping(value="/score/detail")
	public ModelAndView findById(String key, String value, String action){
		ScoreDTO document = service.findById(key, value);
		String view="";
		if(action.equals("read")){
			view="detail_mongo";
		}else{
			view="update_mongo";
		}
		return new ModelAndView(view, "document", document);
	}
	
	@RequestMapping("/score/searchform")
	public String searchform(){
		return "search_mongo";
	}
	@RequestMapping(value="/score/search")
	public ModelAndView search(String field, String value){
		ModelAndView mav = new ModelAndView();
		List<ScoreDTO> mongolist = service.findCriteria(field, value);
		mav.addObject("mongolist", mongolist);
		mav.setViewName("list_mongo");
		return mav;
	}
	@RequestMapping(value="/score/update")
	public String update(ScoreDTO document){
		service.update(document);
		return "redirect:/score/list?pageNo=0";
	}
	
}
