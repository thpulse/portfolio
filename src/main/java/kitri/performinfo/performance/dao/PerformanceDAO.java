package kitri.performinfo.performance.dao;

import java.util.List;

import kitri.performinfo.performance.dto.PerformanceDTO;
import kitri.performinfo.performance.dto.PerformanceSogaeimgDTO;
import kitri.performinfo.prfplace.dto.PrfplaceDTO;

public interface PerformanceDAO {

	void Add_Performance();

	List<PerformanceDTO> Total_Performance(PerformanceDTO prf);

	PerformanceDTO Performance_Info(PerformanceDTO prf);

	List<PerformanceSogaeimgDTO> PerformaceImg_Info(PerformanceDTO prf);

	List<PerformanceDTO> LatestPerform_Info(PrfplaceDTO plc);

}
