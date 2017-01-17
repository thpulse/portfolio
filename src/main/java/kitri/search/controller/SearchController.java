package kitri.search.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import kitri.search.service.SearchService;
import kitri.search.vo.SearchVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchController {
	@Autowired
	SearchService service;
	
	@RequestMapping("/search/searchResult.do")
	public ModelAndView search(String tag, String Sword) throws Exception{
		System.out.println(tag + ", " + Sword);
		ModelAndView mav = new ModelAndView();
		List<SearchVO> Plist = service.search(tag ,Sword);
		
		System.out.println(Plist);
		mav.addObject("Plist", Plist);
		mav.setViewName("searchResult/list");
		
		return mav;
	}
}
