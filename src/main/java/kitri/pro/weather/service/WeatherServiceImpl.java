package kitri.pro.weather.service;

import java.util.List;

import kitri.pro.area.dto.AreaVO;
import kitri.pro.weather.dao.WeatherDAO;
import kitri.pro.weather.dto.WeatherVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl implements WeatherService {
	@Autowired
	@Qualifier("weatherdao")
	WeatherDAO dao;
	
	@Override
	public List<AreaVO> areaList() {
		return dao.areaList();
	}


}
