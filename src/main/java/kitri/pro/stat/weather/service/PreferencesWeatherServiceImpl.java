package kitri.pro.stat.weather.service;

import java.util.List;

import kitri.performinfo.performance.dto.PerformanceDTO;
import kitri.pro.area.dto.AreaVO;
import kitri.pro.stat.weather.dao.PreferencesWeatherDAO;
import kitri.pro.weather.dao.WeatherDAO;
import kitri.pro.weather.dto.WeatherVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PreferencesWeatherServiceImpl implements PreferencesWeatherService {
	@Autowired
	@Qualifier("Preferencesweatherdao")
	PreferencesWeatherDAO dao;

	@Override
	public List<PerformanceDTO> PerformanceList() {
		return dao.PerformanceList();
	}


}
