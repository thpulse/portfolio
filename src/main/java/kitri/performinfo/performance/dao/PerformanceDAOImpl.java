package kitri.performinfo.performance.dao;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import kitri.performinfo.boxweekly.dao.getService;
import kitri.performinfo.performance.dto.PerformanceDTO;
import kitri.performinfo.performance.dto.PerformanceSogaeimgDTO;

import org.apache.ibatis.session.SqlSession;
import org.json.XML;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

@Repository("prfdao")
public class PerformanceDAOImpl implements PerformanceDAO {
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void Add_Performance() {
		try {
			JSONParser parser = new JSONParser();
			getService service = new getService();
			//��������� ��ȸ, ���������� �������� url�� �ʿ��� ����id�������� 
			//======================================================================��¥���
			SimpleDateFormat form = new SimpleDateFormat("yyyyMMdd"); //��¥����
			Calendar cal = Calendar.getInstance();
			String thisM = form.format(cal.getTime()); //����
			cal.add(Calendar.MONTH, 1); //1�޵ڷ� ����
			String nextM = form.format(cal.getTime()); //1�޵�
			//======================================================================��¥���
			URL url = new URL("http://www.kopis.or.kr/openApi/restful/pblprfr?service=8a86476387964df68be9acc29724006f&stdate="+thisM+"&eddate="+nextM+"&cpage=1&rows=500");
			org.json.JSONObject json = XML.toJSONObject(service.getUrl(url.toString()));
			String it = json.toString();
			JSONObject rootObj = (JSONObject) parser.parse(it);
			JSONObject dbsObj = (JSONObject) rootObj.get("dbs");
			JSONArray dbArr = (JSONArray) dbsObj.get("db");
			for (int i = 0; i < dbArr.size(); i++) {
				JSONObject obj = (JSONObject)dbArr.get(i);
				String prfid = (String)obj.get("mt20id"); //������ url�� �� id
				//����id�� ���Ե� url�� ���� �������� �Ľ�
				URL prfurl = new URL("http://www.kopis.or.kr/openApi/restful/pblprfr/"+prfid+"?service=8a86476387964df68be9acc29724006f");
				org.json.JSONObject prfjson = XML.toJSONObject(service.getUrl(prfurl.toString()));
				String prfit = prfjson.toString();
				//System.out.println(prfit);
				JSONObject prfrootObj = (JSONObject)parser.parse(prfit);
				JSONObject prfdbsObj = (JSONObject) prfrootObj.get("dbs");
				JSONObject dbObj = (JSONObject) prfdbsObj.get("db");
				List<String> styurls = new ArrayList<String>();
				String styurl = "";
				//System.out.println(dbObj.get("styurls").toString().length());
				if (dbObj.get("styurls").toString().length()==0) {
					styurls = null;
				}else if(dbObj.get("styurls") instanceof JSONObject){
					JSONObject styurlsObj = (JSONObject) dbObj.get("styurls");
					if (styurlsObj.get("styurl").toString().length()==74) {
						styurl = (String) styurlsObj.get("styurl");
						styurls.add(styurl);
					}else if(styurlsObj.get("styurl") instanceof JSONArray){
						JSONArray styurlArr = (JSONArray) styurlsObj.get("styurl");
						for (int j = 0; j < styurlArr.size(); j++) {
							styurl = (String) styurlArr.get(j);
							styurls.add(styurl);
						}	
					}
				}
				//�Ұ��̹���(styurl)�� ������ �������� insert
				try{
					String story = (String) dbObj.get("sty");
					if (story.length() > 200) {
						story = story.substring(0, 200);
					}
					
					PerformanceDTO prfinfo = new PerformanceDTO((String)dbObj.get("mt20id"),(String)dbObj.get("prfnm"),
																(String)dbObj.get("prfpdfrom"),(String)dbObj.get("prfpdto"),
																(String)dbObj.get("mt10id"),(String)dbObj.get("prfcast"),
																(String)dbObj.get("prfcrew"),(String)dbObj.get("prfruntime"),
																(String)dbObj.get("prfage"),
																(String)dbObj.get("pcseguidance"),(String)dbObj.get("poster"),
																story,(String)dbObj.get("genrenm"),
																(String)dbObj.get("prfstate"),(String)dbObj.get("openrun"),
																(String)dbObj.get("dtguidance"));
					sqlSession.insert("kitri.performanceinfo.Add_performance",prfinfo);
					System.out.println(prfinfo);
				}catch(DuplicateKeyException e){
					System.out.println("�̹� DB�� ����� �����Դϴ�.");
				}
				
				//�Ұ��̹���(styurl) insert
				PerformanceSogaeimgDTO sogae = null;
				try{
					for (int j = 0; j < styurls.size(); j++) {
						styurl = styurls.get(j);
						sogae = new PerformanceSogaeimgDTO(prfid, styurl);
						sqlSession.insert("kitri.performanceinfo.Add_performance_sogaeimgs",sogae);
					}
				}catch(NullPointerException e){
					sogae = new PerformanceSogaeimgDTO(prfid, "");
					sqlSession.insert("kitri.performanceinfo.Add_performance_sogaeimgs",sogae);
				}
				
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}catch (ParseException e) {
			e.printStackTrace();
		}
			
	}

	@Override
	public List<PerformanceDTO> Total_Performance(PerformanceDTO prf) {
		return sqlSession.selectList("kitri.performanceinfo.Total_performance",prf);
	}

}
