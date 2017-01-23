package kitri.reservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kitri.performinfo.performance.dao.PerformanceDAO;
import kitri.performinfo.performance.dto.PerformanceDTO;
import kitri.performinfo.prfplace.dto.PrfplaceDTO;
import kitri.reservation.dao.reservationDAO;
import kitri.reservation.vo.reservationDetailVO;
import kitri.reservation.vo.reservationVO;
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

	@Override
	public int insert_reservation(reservationVO vo) {
		return dao.insert_reservation(vo);
	}

	@Override
	public int insert_reservationDeatil(reservationDetailVO vo) {
		return dao.insert_reservationDeatil(vo);
	}

	@Override
	public List<String> reservation_chk_byTime(reservationVO vo) {
		return dao.reservation_chk_byTime(vo);
	}

	@Override
	public List<String> reservation_chk_byTime_detail(reservationVO vo) {
		return dao.reservation_chk_byTime_detail(vo);
	}

	@Override
	public List<String> preChk_byTime_detail(reservationVO vo) {
		return dao.preChk_byTime_detail(vo);
	}

	@Override
	public List<String> reservation_chk_byDayTime(reservationVO vo) {
		return dao.reservation_chk_byDayTime(vo);
	}
	
	
	
}
