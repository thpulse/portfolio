package kitri.spring.data.mongodb.taehyung_test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController3{

	@RequestMapping("/mongo/main.do")
	public String main(){
		return "index_mongo";
	}
}