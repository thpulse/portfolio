package kitri.reservation.dao;

import java.util.List;

import kitri.performinfo.performance.dto.PerformanceDTO;
import kitri.performinfo.prfplace.dto.PrfplaceDTO;

public interface reservationDAO {
	//시, 도 기준으로 Hall정보 
		List<PrfplaceDTO> call_hall_bySido(String sido);
		//구 기준으로 Hall정보
		List<PrfplaceDTO> call_hall_bygungu(String gungu);
		//Hall정보 기준으로 공연ID물고오기
		List<PerformanceDTO> call_performInfo_byhallId(String hallId);
		//공연 상세정보
		PerformanceDTO perform_detail(String prfid);

}