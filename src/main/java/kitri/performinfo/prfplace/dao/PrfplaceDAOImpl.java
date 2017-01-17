package kitri.performinfo.prfplace.dao;

import java.net.MalformedURLException;
import java.net.URL;

import kitri.performinfo.boxweekly.dao.getService;
import kitri.performinfo.prfplace.dto.PrfplaceDTO;

import org.apache.ibatis.session.SqlSession;
import org.json.XML;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("prfplacedao")
public class PrfplaceDAOImpl implements PrfplaceDAO {
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void Add_Prfplace() {
		try {
			JSONParser parser = new JSONParser();
			getService service = new getService();
			URL url = new URL("http://www.kopis.or.kr/openApi/restful/prfplc?service=8a86476387964df68be9acc29724006f&cpage=1&rows=1000");
			org.json.JSONObject json = XML.toJSONObject(service.getUrl(url.toString()));
			String it = json.toString();
			JSONObject rootObj = (JSONObject) parser.parse(it);
			JSONObject dbsObj = (JSONObject) rootObj.get("dbs");
			JSONArray dbArr = (JSONArray) dbsObj.get("db");
			for (int i = 0; i < dbArr.size(); i++) {
				JSONObject obj = (JSONObject)dbArr.get(i);
				String plcid = (String)obj.get("mt10id"); //공연시설정보 url에 들어갈 id
				String sidonm = (String)obj.get("sidonm");
				String gugunnm = (String)obj.get("gugunnm");
				URL plcurl = new URL("http://www.kopis.or.kr/openApi/restful/prfplc/"+plcid+"?service=8a86476387964df68be9acc29724006f");
				org.json.JSONObject plcjson = XML.toJSONObject(service.getUrl(plcurl.toString()));
				String plcit = plcjson.toString();
				System.out.println(plcit);
				JSONObject plcrootObj = (JSONObject) parser.parse(plcit);
				JSONObject plcdbsObj = (JSONObject) plcrootObj.get("dbs");
				JSONObject plcdbObj = (JSONObject) plcdbsObj.get("db");
				String plcnm = (String)plcdbObj.get("fcltynm");
				String plcnum = plcdbObj.get("mt13cnt").toString();
				String plcchar = (String)plcdbObj.get("fcltychartr");
				String seatscale = plcdbObj.get("seatscale").toString();
				String tel = (String)plcdbObj.get("telno");
				String relateurl = (String)plcdbObj.get("relateurl");
				String address = (String)plcdbObj.get("adres");
				String la = plcdbObj.get("la").toString();
				String lo = plcdbObj.get("lo").toString();
				PrfplaceDTO plc = new PrfplaceDTO(plcid,sidonm,gugunnm,plcnm,plcnum,plcchar,
													seatscale,tel,relateurl,address,la,lo);
				System.out.println(plc);
				sqlSession.insert("kitri.prfplaceinfo.Add_prfplace", plc);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
