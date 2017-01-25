package kitri.pro.weather.logic;

import java.io.IOException;
import java.util.List;

import kitri.pro.area.dto.AreaVO;
import kitri.pro.weather.dto.WeatherVO;

import org.apache.ibatis.session.SqlSession;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository("weatherlogic")
public class WeatherLogicImpl implements WeatherLogic {
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void weatherInsert(List<AreaVO> arealist,String e_year, String e_month, String e_date) {
		int size = arealist.size();
		int[] months = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		String days;
		String max_temp;
		String min_temp;
		String info;
		String addr1;
		String addr2;
		String addr3;
		String addr4;
/*		int year = Integer.parseInt(e_year);
		int month = Integer.parseInt(e_month);
		int date = Integer.parseInt(e_date);*/
		int year = 2017;
		int month = 1;
		int date = 1;

		try {
			for (int area = 0; area < size; area++) {
				String areacode=arealist.get(area).getAddr3();
				Document doc;
				if(month==10 || month==11 || month==12){
					doc = Jsoup.connect(
								"http://weather.naver.com/period/pastWetrMain.nhn?ym="
										+ year+ month + "&naverRgnCd="+areacode).timeout(30000).get();
				}else{
					doc = Jsoup.connect(
								"http://weather.naver.com/period/pastWetrMain.nhn?ym="
										+ year+"0"+month + "&naverRgnCd="+areacode).timeout(30000).get();
				}
					if (doc != null) {
						Elements elements = doc
								.select("table.tbl_calendar > tbody > tr >td:not(.no)");
							Element element = elements.get(date-1);
							days=year+"."+month+"."+element.select("strong:not(span.temp_mn > strong,span.temp_mx > strong)").text();
							max_temp=element.select("span.temp_mx > strong").text();
							min_temp=element.select("span.temp_mn > strong").text();
							info=element.select("p > img").attr("alt");
							addr1=arealist.get(area).getAddr1();
							addr2=arealist.get(area).getAddr2();
							addr3=arealist.get(area).getAddr3();
							addr4=arealist.get(area).getAddr4();
							if(addr4.equals("안산시 단원구")){
								addr4="안산시";
							}
							if(addr4.equals("성남시 분당구")){
								addr4="성남시";
							}
							if(addr4.equals("용인시 수지구")){
								addr4="용인시";
							}
							if(addr4.equals("고양시 일산동구")){
								addr4="고양시";
							}
							if(addr4.equals("수원시 영통구")){
								addr4="수원시";
							}
							if(addr4.equals("안양시 동안구")){
								addr4="안양시";
							}
							if(addr4.equals("안산시 상록구") || addr4.equals("성남시 수정구") ||addr4.equals("성남시 중원구") ||addr4.equals("용인시 기흥구") ||addr4.equals("수원시 장안구") ||addr4.equals("고양시 일산서구") ||addr4.equals("수원시 권선구") ||addr4.equals("안양시 만안구") ||addr4.equals("수원시 팔달구") ||addr4.equals("고양시 덕양구") ||addr4.equals("용인시 처인구")){
								
							}else{
								WeatherVO weather=new WeatherVO(days, max_temp, min_temp, info, addr1, addr2, addr3, addr4);
								sqlSession.insert("kitri.pro.weather.weatherinsert", weather);
							}	
						}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("삽입 완료");
	}

}
