package kitri.pro.stat.weather.dao;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kitri.performinfo.boxweekly.dao.getService;
import kitri.pro.stat.weather.dto.PreferencesVO;
import kitri.pro.stat.weather.dto.SelectStatVO;
import kitri.pro.stat.weather.dto.StatVO;
import kitri.pro.stat.weather.dto.StatisticsVO;
import kitri.pro.weather.dto.WeatherVO;

import org.apache.ibatis.session.SqlSession;
import org.json.XML;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("Preferencesweatherdao")
public class PreferencesWeatherDAOImpl implements PreferencesWeatherDAO {
	@Autowired
	SqlSession sqlSession;
	int count=0;
	@Override
	public int insertStat() {
		try {
			JSONParser parser = new JSONParser();
			getService service = new getService();
			int year;
			int month;
			int date;
			int[] months = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
			for (int i = 2014; i < 2017; i++) {
				if ((0 == (i % 4) && 0 != (i % 100)) || 0 == i % 400) {
					months[1] = 29;
				} else {
					months[1] = 28;
				}
				for (int j = 1; j < 13; j++) {
					for (int k = 1; k <= months[j - 1]; k++) {
						year = i;
						month = j;
						date = k;
						URL url;
						String days;
						if (month == 10 || month == 11 || month == 12) {
							days = year + "." + month + "." + date;
							if (date == 1 || date == 2 || date == 3
									|| date == 4 || date == 5 || date == 6
									|| date == 7 || date == 8 || date == 9) {
								url = new URL(
										"http://www.kopis.or.kr/openApi/restful/prfstsPrfBy?service=a9461f6b770f45d8a93c5457eaeb7838&cpage=1&rows=1000&stdate="
												+ year
												+ month
												+ "0"
												+ date
												+ "&eddate="
												+ year
												+ month
												+ "0" + date);
							} else {
								url = new URL(
										"http://www.kopis.or.kr/openApi/restful/prfstsPrfBy?service=a9461f6b770f45d8a93c5457eaeb7838&cpage=1&rows=1000&stdate="
												+ year
												+ month
												+ date
												+ "&eddate="
												+ year
												+ month
												+ date);
							}
						} else {
							days = year + "." + month + "." + date;
							if (date == 1 || date == 2 || date == 3
									|| date == 4 || date == 5 || date == 6
									|| date == 7 || date == 8 || date == 9) {
								url = new URL(
										"http://www.kopis.or.kr/openApi/restful/prfstsPrfBy?service=a9461f6b770f45d8a93c5457eaeb7838&cpage=1&rows=1000&stdate="
												+ year
												+ "0"
												+ month
												+ "0"
												+ date
												+ "&eddate="
												+ year
												+ "0" + month + "0" + date);
							} else {
								url = new URL(
										"http://www.kopis.or.kr/openApi/restful/prfstsPrfBy?service=a9461f6b770f45d8a93c5457eaeb7838&cpage=1&rows=1000&stdate="
												+ year
												+ "0"
												+ month
												+ date
												+ "&eddate="
												+ year
												+ "0"
												+ month + date);
							}
						}
						org.json.JSONObject json = XML.toJSONObject(service.getUrl(url.toString()));
						String it = json.toString();
						JSONObject rootObj = (JSONObject) parser.parse(it);
						if(rootObj.get("prfsts") instanceof JSONObject){
						JSONObject prfstsObj = (JSONObject) rootObj.get("prfsts");
						if(prfstsObj.get("prfst") instanceof JSONArray){
						JSONArray prfstArr = (JSONArray) prfstsObj.get("prfst");
						for (int p = 0; p < prfstArr.size(); p++) {
							JSONObject obj = (JSONObject) prfstArr.get(p);
							String prfid = (String)obj.get("mt20id");
							String fcltynm = (String)obj.get("fcltynm");
							String prfnm = (String)obj.get("prfnm");
							String totnmrs = obj.get("totnmrs").toString();
							String cate = (String) obj.get("cate");
							StatVO stat = new StatVO(days,prfid, prfnm, cate,fcltynm, totnmrs);
							System.out.println(stat);
							if(!(totnmrs.equals("0"))){
								sqlSession.insert("kitri.pro.preferences.statinsert", stat);
								count++;
							}
						}
						}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(count);
		return 1;
	}
	@Override
	public List<SelectStatVO> selectStat() {
		return sqlSession.selectList("kitri.pro.preferences.selectstat");
	}
	@Override
	public int insertStatistics(StatisticsVO statistics) {
		return sqlSession.insert("kitri.pro.preferences.insertstatistics", statistics);
	}
	@Override
	public List<WeatherVO> weatherlist(String weather) {
		return sqlSession.selectList("kitri.pro.preferences.selectdays",weather);
	}
	@Override
	public List<PreferencesVO> preferences(String weather) {
		return sqlSession.selectList("kitri.pro.preferences.find",weather);
	}
}
