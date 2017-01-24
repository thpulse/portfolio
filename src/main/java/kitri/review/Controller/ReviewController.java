package kitri.review.Controller;

import java.util.List;

import kitri.review.Service.ReviewService;
import kitri.review.VO.ReviewVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReviewController {
	@Autowired
	ReviewService service;
	
	@RequestMapping(value="/review/write.do",method=RequestMethod.GET)
	public ModelAndView insert(String prf_id){		
		ModelAndView mav = new ModelAndView();
		mav.addObject("prf_id", prf_id);
		mav.setViewName("review_insert");
		return mav;
	}

	@RequestMapping(value="/review/write.do",method=RequestMethod.POST)
	public ModelAndView insert(ReviewVO user){
		System.out.println("확인");
		System.out.println(user);
		service.insert(user);
		return new ModelAndView("redirect:/perform/prfinfo/read.do?prfid="+user.getPrf_id());
	}
	
	@RequestMapping("/review/delete.do")
	public ModelAndView delete(int revno){
		service.delete(revno);
		
		return new ModelAndView("redirect:/perform/prfinfo/read.do");
	}
	
	@RequestMapping("/review/update.do")
	public ModelAndView update(ReviewVO review){
		service.update(review);
		
		return new ModelAndView("redirect:/perform/prfinfo/read.do");
	}
	
	@RequestMapping("/review/read.do")
	public ModelAndView read(int revno, String action){
		String view = "";
		
		if(action!=null){
			if(action.equals("READ")){
				view = "review/include/Reviewread";
			}else{
				view = "review/include/Reviewupdate";
			}
		}else{
			
		}	
		ReviewVO review = service.readno(revno);
		return new ModelAndView(view,"review",review);
	}
	
	/*@RequestMapping("/review/Reviewlist.do")
	public ModelAndView reviewlist(){ 
		ModelAndView mav = new ModelAndView();
		List<ReviewVO> readall = service.readall();
		mav.addObject("reviewlist", readall);
		mav.setViewName("review_list");
		System.out.println("이것도되나");
		return mav;
	}*/
}
