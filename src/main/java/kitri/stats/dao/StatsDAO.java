package kitri.stats.dao;

import java.util.List;

import kitri.performinfo.performance.dto.PerformanceDTO;
import kitri.stats.vo.StatsVO;

public interface StatsDAO {
	List<StatsVO> stats(String prfid);
}
