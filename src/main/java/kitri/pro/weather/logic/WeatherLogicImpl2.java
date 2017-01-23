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
//초기 데이터 삽입용
//@Repository("weatherlogic")
public class WeatherLogicImpl2 implements WeatherLogic2 {

	@Override
	public void weatherInsert(List<AreaVO> arealist, String s_year,
			String s_month, String s_date, String e_year, String e_month,
			String e_date) {
		// TODO Auto-generated method stub
		
	}
	/*@Autowired
	SqlSession sqlSession;
	
	@Override
	public void weatherInsert(List<AreaVO> arealist, String s_year,
			String s_month,String s_date, String e_year, String e_month, String e_date) {
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
		
		try {
			for (int area = 0; area < size; area++) {
				String areacode=arealist.get(area).getAddr3();
			for (int year = 2012; year < 2017; year++) {
				if( (0 == (year % 4) && 0 != (year %100)) || 0 == year%400 ){
					months[1] = 29;
               }else{
            	    months[1] = 28;
               }
				for (int month = 1; month < 13; month++) {
					Document doc;
					if(month==10 || month==11 || month==12){
						doc = Jsoup.connect(
								"http://weather.naver.com/period/pastWetrMain.nhn?ym="
										+ year+ month + "&naverRgnCd="+areacode).get();
					}else{
						doc = Jsoup.connect(
								"http://weather.naver.com/period/pastWetrMain.nhn?ym="
										+ year+"0"+month + "&naverRgnCd="+areacode).get();
					}
					if (doc != null) {
						Elements elements = doc
								.select("table.tbl_calendar > tbody > tr >td:not(.no)");
						for (int j = 0; j < months[month-1]; j++) {
							Element element = elements.get(j);
							days=year+"."+month+"."+element.select("strong:not(span.temp_mn > strong,span.temp_mx > strong)").text();
							max_temp=element.select("span.temp_mx > strong").text();
							min_temp=element.select("span.temp_mn > strong").text();
							info=element.select("p > img").attr("alt");
							addr1=arealist.get(area).getAddr1();
							addr2=arealist.get(area).getAddr2();
							addr3=arealist.get(area).getAddr3();
							addr4=arealist.get(area).getAddr4();
							WeatherVO weather=new WeatherVO(days, max_temp, min_temp, info, addr1, addr2, addr3, addr4);
							sqlSession.insert("kitri.pro.weather.weatherinsert", weather);
						}
					}
				}
			}

					Document doc = Jsoup.connect(
								"http://weather.naver.com/period/pastWetrMain.nhn?ym=201701&naverRgnCd="+areacode).get();

					if (doc != null) {
						Elements elements = doc
								.select("table.tbl_calendar > tbody > tr >td:not(.no)");
						for (int j = 0; j < 8; j++) {
							Element element = elements.get(j);
							days="2017.01."+element.select("strong:not(span.temp_mn > strong,span.temp_mx > strong)").text();
							max_temp=element.select("span.temp_mx > strong").text();
							min_temp=element.select("span.temp_mn > strong").text();
							info=element.select("p > img").attr("alt");
							addr1=arealist.get(area).getAddr1();
							addr2=arealist.get(area).getAddr2();
							addr3=arealist.get(area).getAddr3();
							addr4=arealist.get(area).getAddr4();
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
*/
}
