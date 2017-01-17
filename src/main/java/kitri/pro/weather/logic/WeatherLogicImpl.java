package kitri.pro.weather.logic;

import java.io.IOException;
import java.util.List;

import kitri.pro.area.dto.AreaVO;
import kitri.pro.weather.dto.WeatherVO;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
@Service
public class WeatherLogicImpl implements WeatherLogic {

	@Override
	public void weatherList(List<AreaVO> arealist, String s_year,
			String s_month, String e_year, String e_month, String e_date) {
		int size = arealist.size();
		int[] months = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30,
				31 };
		try {
			for (int area = 0; area < size; area++) {
				String areacode=arealist.get(area).getAddr3();
			for (int year = 2000; year < 2017; year++) {
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
							System.out.print(year+ "년"+month+ "월"
											+ element.select("strong:not(span.temp_mn > strong,span.temp_mx > strong)").text() + "일, ");
							System.out.print(element.select("p > img").attr("alt")+ ",\t");
							System.out.print("최저기온:"
									+ element.select("span.temp_mn > strong").text());
							System.out.println(", 최고기온:"
									+ element.select("span.temp_mx > strong").text());
							System.out.println("지역 :"+arealist.get(area).getAddr1()+arealist.get(area).getAddr2()+arealist.get(area).getAddr3()+arealist.get(area).getAddr4());
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
							System.out.print("2017년 1월"
											+ element.select("strong:not(span.temp_mn > strong,span.temp_mx > strong)").text() + "일, ");
							System.out.print(element.select("p > img").attr("alt")+ ",\t");
							System.out.print("최저기온:"
									+ element.select("span.temp_mn > strong").text());
							System.out.println(", 최고기온:"
									+ element.select("span.temp_mx > strong").text());
							System.out.println("지역 :"+arealist.get(area).getAddr1()+arealist.get(area).getAddr2()+arealist.get(area).getAddr3()+arealist.get(area).getAddr4());
						}
					}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
