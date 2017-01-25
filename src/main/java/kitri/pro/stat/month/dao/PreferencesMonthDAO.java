package kitri.pro.stat.month.dao;

import java.util.List;
import java.util.Map;

import kitri.pro.stat.weather.dto.PreferencesVO;
import kitri.pro.stat.weather.dto.SelectStatVO;
import kitri.pro.stat.weather.dto.StatisticsVO;
import kitri.pro.weather.dto.WeatherVO;

public interface PreferencesMonthDAO {
	List<PreferencesVO> preferences(String month);
}
