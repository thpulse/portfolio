package kitri.pro.weather.service;

import java.util.List;

import kitri.pro.area.dto.AreaVO;
import kitri.pro.weather.dto.WeatherVO;

public interface WeatherService {
	List<AreaVO> areaList();
	WeatherVO last_select();
}
