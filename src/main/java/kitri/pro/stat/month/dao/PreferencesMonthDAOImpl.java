package kitri.pro.stat.month.dao;

import java.util.List;

import kitri.pro.stat.weather.dto.PreferencesVO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("Preferencesmonthdao")
public class PreferencesMonthDAOImpl implements PreferencesMonthDAO {
	@Autowired
	SqlSession sqlSession;

	@Override
	public List<PreferencesVO> preferences(String month) {
		return sqlSession.selectList("kitri.pro.preferences.find2",month);
	}
}
