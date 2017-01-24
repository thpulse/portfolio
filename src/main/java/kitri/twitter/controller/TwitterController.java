package kitri.twitter.controller;



import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;

@Controller
public class TwitterController {

	@RequestMapping("/twitter/test.do")
	public ModelAndView twitter() throws TwitterException{
		ModelAndView mav=  new ModelAndView();
		
		 try {
			 	AccessToken accesstoken = new AccessToken("822728982919401472-fEiHgYRBg00RtuUKcNjPyYZWrv1NWis","cxk7QkXTmUgZVqjgzg5RuZIXkbslMA0sNRLmupoXSdPDP");
			 	
	            // gets Twitter instance with default credentials
	            Twitter twitter = new TwitterFactory().getInstance();
		        twitter.setOAuthConsumer("WlQJ1JiTpB0pEA4VPaYRrM8ZO","wldvS7DHdhhBgsOq57Rl5OEi1z0u0InozTMK9i7kh5Lcl2y6Lm");
		        twitter.setOAuthAccessToken(accesstoken);
	            User user = twitter.verifyCredentials();
	            List<Status> statuses = twitter.getHomeTimeline();
	            System.out.println("Showing @" + user.getScreenName() + "'s home timeline.");
	            for (Status status : statuses) {
	                System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());
	            }
	        } catch (TwitterException te) {
	            te.printStackTrace();
	            System.out.println("Failed to get timeline: " + te.getMessage());
	            System.exit(-1);
	        }
		
		/*try {
	        AccessToken accesstoken = new AccessToken("822728982919401472-fEiHgYRBg00RtuUKcNjPyYZWrv1NWis","cxk7QkXTmUgZVqjgzg5RuZIXkbslMA0sNRLmupoXSdPDP");
	        Twitter twitter = TwitterFactory.getSingleton();
	        twitter.setOAuthConsumer("WlQJ1JiTpB0pEA4VPaYRrM8ZO","wldvS7DHdhhBgsOq57Rl5OEi1z0u0InozTMK9i7kh5Lcl2y6Lm");
	        twitter.setOAuthAccessToken(accesstoken);
	        User user = twitter.verifyCredentials();
	         
	        List<Status> list = twitter.getUserTimeline();
	        System.out.println("타임라인 계정:"+user.getScreenName());
	        for(Status status : list) {
	            System.out.println("작성자:"+status.getUser().getScreenName());
	            System.out.println("타임라인내용:"+status.getText());
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }*/
		
		mav.setViewName("twitter/list");
		return mav;
	}
}
