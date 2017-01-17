package kitri.performinfo.performance.service;

import java.util.List;

import kitri.performinfo.performance.dao.PerformanceDAO;
import kitri.performinfo.performance.dto.PerformanceDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("prfservice")
public class PerformanceServiceImpl implements PerformanceService {
	@Autowired
	PerformanceDAO dao;
	
	@Override
	public void Add_Performance() {
		dao.Add_Performance();
	}

	@Override
	public List<PerformanceDTO> Total_Performance(PerformanceDTO prf) {
		return dao.Total_Performance(prf);
	}

}
