package kitri.search.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import kitri.search.service.SearchService;
import kitri.search.vo.SearchResultVO;
import kitri.search.vo.SearchVO;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;

@Controller
public class SearchController extends HttpServlet{
	@Autowired
	SearchService service;
	
	@RequestMapping("/search/searchResult.do")
	public ModelAndView search(HttpServletRequest req, HttpServletResponse res,String tag, String Sword) throws Exception{
		//System.out.println(tag + ", " + Sword);
		String url = "searchResult/list";
		
		ModelAndView mav = new ModelAndView();
		List<SearchVO> Plist = service.search(tag ,Sword);
		List<SearchResultVO> resultList = service.searchResult();
		System.out.println(Plist);
		service.insertSearch(Sword);
		
		mav.addObject("resultList", resultList);
		mav.addObject("Plist", Plist);
		
		try {
			 	AccessToken accesstoken = new AccessToken("822728982919401472-fEiHgYRBg00RtuUKcNjPyYZWrv1NWis","cxk7QkXTmUgZVqjgzg5RuZIXkbslMA0sNRLmupoXSdPDP");

	            // gets Twitter instance with default credentials
	            Twitter twitter = new TwitterFactory().getInstance();
		        twitter.setOAuthConsumer("WlQJ1JiTpB0pEA4VPaYRrM8ZO","wldvS7DHdhhBgsOq57Rl5OEi1z0u0InozTMK9i7kh5Lcl2y6Lm");
		        twitter.setOAuthAccessToken(accesstoken);
	            User user = twitter.verifyCredentials();
	            List<Status> statuses = twitter.getHomeTimeline();
	            //System.out.println("Showing @" + user.getScreenName() + "'s home timeline.");
	            
	            List<Status> staList = new ArrayList<Status>();
	            for (Status status : statuses) {
	        		if((status.getText()).contains(Sword)){
	        			System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());
	        			staList.add(status);
	        			
	        		} else if(!(status.getText()).contains(Sword)){
	        			mav.setViewName(url);
	        		}
	         
	            }
	            
	            //System.out.println(staList.size());
    			mav.addObject("twitterList", staList);
    			mav.setViewName(url);
	       } catch (TwitterException te) {
	            te.printStackTrace();
	            System.out.println("Failed to get timeline: " + te.getMessage());
	            System.exit(-1);
	        }
		
		return mav;
	}
	

	
	
}
