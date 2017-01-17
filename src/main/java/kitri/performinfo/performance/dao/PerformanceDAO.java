package kitri.performinfo.performance.dao;

import java.util.List;

import kitri.performinfo.performance.dto.PerformanceDTO;

public interface PerformanceDAO {

	void Add_Performance();

	List<PerformanceDTO> Total_Performance(PerformanceDTO prf);

}
