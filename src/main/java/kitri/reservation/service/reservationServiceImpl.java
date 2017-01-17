package kitri.reservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kitri.performinfo.performance.dao.PerformanceDAO;
import kitri.performinfo.performance.dto.PerformanceDTO;
import kitri.performinfo.prfplace.dto.PrfplaceDTO;
import kitri.reservation.dao.reservationDAO;
@Service("reservationservice")
public class reservationServiceImpl implements reservationService {
	@Autowired
	reservationDAO dao;
	
	@Override
	public List<PrfplaceDTO> call_hall_bySido(String sido) {
		return dao.call_hall_bySido(sido);		
	}

	@Override
	public List<PrfplaceDTO> call_hall_bygungu(String gungu) {
		return dao.call_hall_bygungu(gungu);
	}

	@Override
	public List<PerformanceDTO> call_performInfo_byhallId(String hallId) {
		return dao.call_performInfo_byhallId(hallId);
	}

	@Override
	public PerformanceDTO perform_detail(String prfid) {
		return dao.perform_detail(prfid);
	}
}
