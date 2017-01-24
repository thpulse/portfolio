package kitri.performinfo.performance.service;

import java.util.List;

import kitri.performinfo.performance.dto.PerformanceDTO;
import kitri.performinfo.performance.dto.PerformanceSogaeimgDTO;
import kitri.performinfo.prfplace.dto.PrfplaceDTO;

public interface PerformanceService {

	void Add_Performance();

	List<PerformanceDTO> Total_Performance(PerformanceDTO prf);

	PerformanceDTO Performance_Info(PerformanceDTO prf);

	List<PerformanceSogaeimgDTO> PerformanceImg_Info(PerformanceDTO prf);

	List<PerformanceDTO> LatestPerform_Info(PrfplaceDTO plc);

}
