package kitri.performinfo.boxweekly.dao;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import kitri.performinfo.boxweekly.dto.BoxWeeklyDTO;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONObject;
import org.json.XML;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository("boxdao")
public class BoxWeeklyDAOImpl implements BoxWeeklyDAO {
	@Autowired
	SqlSession sqlSession;

	@Override
	public void Add_BoxWeekly(String genre) {
		try {
			JSONParser parser = new JSONParser();
			getService service = new getService();
			URL url = new URL("http://www.kopis.or.kr/openApi/restful/boxWeekMonthly?service=8a86476387964df68be9acc29724006f&ststype=week&catecode="+genre);
			org.json.JSONObject json = XML.toJSONObject(service.getUrl(url.toString()));
			String it = json.toString();
			JSONObject rootObj = (JSONObject) parser.parse(it);
			JSONObject boxofsObj = (JSONObject) rootObj.get("boxofs");
			BoxWeeklyDTO box = null;
			try{
				JSONArray boxofArr = (JSONArray) boxofsObj.get("boxof");
					for (int i = 0; i < boxofArr.size(); i++) {
						JSONObject obj = (JSONObject) boxofArr.get(i);
						box = new BoxWeeklyDTO((String)obj.get("area"),(Long)obj.get("prfdtcnt"),
													(Long)obj.get("nmrs"),(String)obj.get("prfpd"),
													(String)obj.get("cate"),(String)obj.get("prfplcnm"),
													(String)obj.get("prfnm"),(Long)obj.get("rnum"),
													(Long)obj.get("seatcnt"),(String)obj.get("poster"),
													(String)obj.get("mt20id"));
						
					}
			}catch(ClassCastException e){
				JSONObject obj = (JSONObject) boxofsObj.get("boxof");
				box = new BoxWeeklyDTO((String)obj.get("area"),(Long)obj.get("prfdtcnt"),
						(Long)obj.get("nmrs"),(String)obj.get("prfpd"),
						(String)obj.get("cate"),(String)obj.get("prfplcnm"),
						(String)obj.get("prfnm"),(Long)obj.get("rnum"),
						(Long)obj.get("seatcnt"),(String)obj.get("poster"),
						(String)obj.get("mt20id"));
			}
			sqlSession.insert("kitri.boxweekly.Add_BoxWeekly",box);
		} catch (MalformedURLException e) {
		e.printStackTrace();
		}catch (ParseException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public List<BoxWeeklyDTO> Total_BoxWeekly(BoxWeeklyDTO dto) {
		return sqlSession.selectList("kitri.boxweekly.Total_BoxWeekly", dto);
	}
}
