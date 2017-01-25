package kitri.review.Controller;

import java.util.List;

import kitri.review.Service.ReviewService;
import kitri.review.VO.ReviewVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
		System.out.println("Ȯ��");
		System.out.println(user);
		service.insert(user);
		return new ModelAndView("redirect:/perform/prfinfo/read.do?prfid="+user.getPrf_id());
	}
	
	@RequestMapping("/review/delete.do")
	public ModelAndView delete(int revno,String prfid){
		System.out.println(revno);
		service.delete(revno);
		return new ModelAndView("redirect:/perform/prfinfo/read.do?prfid="+prfid);
	}
	
	@RequestMapping("/review/update.do")
	public ModelAndView update(ReviewVO review){
		service.update(review);
		
		return new ModelAndView("redirect:/perform/prfinfo/read.do");
	}
	
	@RequestMapping("/review/read.do")
	public ModelAndView read(int revno,String prfid, String action){
		String view = "";
		ModelAndView mav = new ModelAndView();
		if(action!=null){
			if(action.equals("READ")){
				view = "review/include/Reviewread";
			}else{
				view = "review/include/Reviewupdate";
			}
		}else{
			
		}	
		ReviewVO review = service.readno(revno);
		mav.addObject("review",review);
		mav.addObject("prfid",prfid);
		mav.setViewName(view);
		return mav;
	}
	
	@RequestMapping("/review/adminlist.do")
	public ModelAndView adminlist(){ 
		ModelAndView mav = new ModelAndView();
		List<ReviewVO> readadmin = service.readadmin();
		mav.addObject("readadmin", readadmin);
		mav.setViewName("review_admin");
		System.out.println("�̰͵��ǳ�");
		return mav;
	}

	@RequestMapping("/review/search2.do")
	public ModelAndView search(@RequestParam String search, @RequestParam String tag){		
		ModelAndView mav = new ModelAndView();
		List<ReviewVO> readid = service.readid(tag, search);
		mav.addObject("readadmin", readid);
		mav.setViewName("review_admin");
		System.out.println("�ȴٰ���");
		return mav;
	}

	
}
