package kitri.pro.weather.logic;

import java.util.List;

import kitri.pro.area.dto.AreaVO;
import kitri.pro.weather.dto.WeatherVO;
//처음 초기 데이터 삽입용
public interface WeatherLogic2 {
	void weatherInsert(List<AreaVO> arealist,String s_year,String s_month,String s_date,String e_year,String e_month,String e_date);
}
