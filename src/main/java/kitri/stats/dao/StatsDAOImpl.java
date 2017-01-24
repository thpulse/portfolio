package kitri.stats.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kitri.performinfo.performance.dto.PerformanceDTO;
import kitri.stats.vo.StatsVO;

@Repository("statsdao")
public class StatsDAOImpl implements StatsDAO {
	@Autowired
	SqlSession sqlsession;
	
	@Override
	public List<StatsVO> stats(String prfid) {
		
		return sqlsession.selectList("kitri.perform.stats.list", prfid);
	}

}
