package kitri.reservation.service;

import java.util.List;

import kitri.performinfo.performance.dto.PerformanceDTO;
import kitri.performinfo.prfplace.dto.PrfplaceDTO;
import kitri.reservation.vo.reservationDetailVO;
import kitri.reservation.vo.reservationVO;

public interface reservationService {
	//시, 도 기준으로 Hall정보 
	List<PrfplaceDTO> call_hall_bySido(String sido);
	//구 기준으로 Hall정보
	List<PrfplaceDTO> call_hall_bygungu(String gungu);
	//Hall정보 기준으로 공연ID물고오기
	List<PerformanceDTO> call_performInfo_byhallId(String hallId);
	
	//공연 상세정보
	PerformanceDTO perform_detail(String prfid);
	int insert_reservation(reservationVO vo);
	int insert_reservationDeatil(reservationDetailVO vo);
	
	//공연예약체크
	List<String> reservation_chk_byTime(reservationVO vo);
	List<String> reservation_chk_byTime_detail(reservationVO vo);
	
	//공연예약 몇석인지
	List<String> preChk_byTime_detail(reservationVO vo);
	//공연좌석 테이블뷰에서 체크, id와
	List<String> reservation_chk_byDayTime(reservationVO vo);
}
