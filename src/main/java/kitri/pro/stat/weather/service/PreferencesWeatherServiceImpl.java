package kitri.pro.stat.weather.service;

import java.util.List;
import java.util.Map;

import kitri.pro.stat.weather.dao.PreferencesWeatherDAO;
import kitri.pro.stat.weather.dto.PreferencesVO;
import kitri.pro.stat.weather.dto.SelectStatVO;
import kitri.pro.stat.weather.dto.StatisticsVO;
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
	public int insertStat() {
		return dao.insertStat();
		
	}

	@Override
	public List<SelectStatVO> selectStat() {
		return dao.selectStat();
	}

	@Override
	public int insertStatistics(StatisticsVO statistics) {
		return dao.insertStatistics(statistics);
	}

	@Override
	public List<WeatherVO> weatherlist(String weather) {
		return dao.weatherlist(weather);
	}

	@Override
	public List<PreferencesVO> preferences(String weather) {
		return dao.preferences(weather);
	}




}
