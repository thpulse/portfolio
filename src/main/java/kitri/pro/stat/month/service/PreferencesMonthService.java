package kitri.pro.stat.month.service;

import java.util.List;

import kitri.pro.stat.weather.dto.PreferencesVO;

public interface PreferencesMonthService {
	List<PreferencesVO> preferences(String month);
}
