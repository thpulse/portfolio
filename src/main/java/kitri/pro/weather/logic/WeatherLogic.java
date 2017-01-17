package kitri.pro.weather.logic;

import java.util.List;

import kitri.pro.area.dto.AreaVO;
import kitri.pro.weather.dto.WeatherVO;

public interface WeatherLogic {
	void weatherList(List<AreaVO> arealist,String s_year,String s_month,String e_year,String e_month,String e_date);
}
