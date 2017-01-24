package kitri.stats.service;

import java.util.List;

import kitri.performinfo.performance.dto.PerformanceDTO;
import kitri.stats.vo.StatsVO;

public interface StatsService {
	List<StatsVO> stats(String prfid);
}
