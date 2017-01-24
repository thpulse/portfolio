package kitri.pro.stat.month.service;

import java.util.List;

import kitri.pro.stat.month.dao.PreferencesMonthDAO;
import kitri.pro.stat.weather.dto.PreferencesVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PreferencesMonthServiceImpl implements PreferencesMonthService {
	@Autowired
	@Qualifier("Preferencesmonthdao")
	PreferencesMonthDAO dao;

	@Override
	public List<PreferencesVO> preferences(String month) {
		return dao.preferences(month);
	}




}
