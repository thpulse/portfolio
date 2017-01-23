package kitri.pro.weather.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kitri.pro.area.dto.AreaVO;
import kitri.pro.weather.dto.WeatherVO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("weatherdao")
public class WeatherDAOImpl implements WeatherDAO {
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<AreaVO> areaList() {
		return sqlSession.selectList("kitri.pro.weather.arealist");
	}

	@Override
	public WeatherVO last_select() {
		return sqlSession.selectOne("kitri.pro.weather.lastweather");
	}
}
