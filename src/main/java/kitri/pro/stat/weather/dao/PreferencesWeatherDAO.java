package kitri.pro.stat.weather.dao;

import java.util.List;
import java.util.Map;

import kitri.pro.stat.weather.dto.PreferencesVO;
import kitri.pro.stat.weather.dto.SelectStatVO;
import kitri.pro.stat.weather.dto.StatisticsVO;
import kitri.pro.weather.dto.WeatherVO;

public interface PreferencesWeatherDAO {
	int insertStat();
	List<SelectStatVO> selectStat();
	int insertStatistics(StatisticsVO statistics);
	List<WeatherVO> weatherlist(String weather);
	List<PreferencesVO> preferences(String weather);
}
