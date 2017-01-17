package kitri.pro.weather.dao;

import java.util.List;

import kitri.pro.area.dto.AreaVO;
import kitri.pro.weather.dto.WeatherVO;

public interface WeatherDAO {
	List<AreaVO> areaList();

}
