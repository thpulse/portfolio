package kitri.performinfo.performance.service;

import java.util.List;

import kitri.performinfo.performance.dao.PerformanceDAO;
import kitri.performinfo.performance.dto.PerformanceDTO;
import kitri.performinfo.performance.dto.PerformanceSogaeimgDTO;
import kitri.performinfo.prfplace.dto.PrfplaceDTO;

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

	@Override
	public PerformanceDTO Performance_Info(PerformanceDTO prf) {
		return dao.Performance_Info(prf);
	}

	@Override
	public List<PerformanceSogaeimgDTO> PerformanceImg_Info(PerformanceDTO prf) {
		return dao.PerformaceImg_Info(prf);
	}

	//공연장 상세정보 pg에서 최근공연
	@Override
	public List<PerformanceDTO> LatestPerform_Info(PrfplaceDTO plc) {
		return dao.LatestPerform_Info(plc);
	}

}
