package kitri.performinfo.performance.service;

import java.util.List;

import kitri.performinfo.performance.dto.PerformanceDTO;

public interface PerformanceService {

	void Add_Performance();

	List<PerformanceDTO> Total_Performance(PerformanceDTO prf);

}
