package kitri.pro.stat.weather.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kitri.performinfo.performance.dto.PerformanceDTO;
import kitri.pro.area.dto.AreaVO;
import kitri.pro.weather.dto.WeatherVO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("Preferencesweatherdao")
public class PreferencesWeatherDAOImpl implements PreferencesWeatherDAO {
	@Autowired
	SqlSession sqlSession;

	@Override
	public List<PerformanceDTO> PerformanceList() {
		return sqlSession.selectList("kitri.pro.preferences.performancelist");
	}
}