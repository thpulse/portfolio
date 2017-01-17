package kitri.stats.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kitri.stats.dao.StatsDAO;
import kitri.stats.vo.StatsVO;

@Service("statsService")
public class StatsServiceImpl implements StatsService {
	@Autowired
	StatsDAO dao;
	
	@Override
	public List<StatsVO> stats() {
		// TODO Auto-generated method stub
		return dao.stats();
	}

}
