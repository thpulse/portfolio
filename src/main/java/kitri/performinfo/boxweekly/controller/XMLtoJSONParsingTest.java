package kitri.performinfo.boxweekly.controller;

import java.net.MalformedURLException;
import java.net.URL;

import kitri.performinfo.boxweekly.dao.getService;

import org.json.XML;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class XMLtoJSONParsingTest {

	public static void main(String[] args) {
		JSONParser parser = new JSONParser();
		try {
			getService service = new getService();
			URL url = new URL("http://www.kopis.or.kr/openApi/restful/boxWeekMonthly?service=8a86476387964df68be9acc29724006f&ststype=week&catecode=YK");
			org.json.JSONObject json = XML.toJSONObject(service.getUrl(url.toString()));
			String it = json.toString();
			JSONObject rootObj = (JSONObject) parser.parse(it);
			JSONObject boxofsObj = (JSONObject) rootObj.get("boxofs");
			JSONArray boxofObj = (JSONArray) boxofsObj.get("boxof");
				for (int i = 0; i < boxofObj.size(); i++) {
					JSONObject obj = (JSONObject) boxofObj.get(i);
					Long nmrs = (Long)obj.get("nmrs");
					System.out.println(nmrs);
				}
		} catch (MalformedURLException e) {
		e.printStackTrace();
		}catch (ParseException e) {
			e.printStackTrace();
		}
	}

}