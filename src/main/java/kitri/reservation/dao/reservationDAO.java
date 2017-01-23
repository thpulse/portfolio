package kitri.reservation.dao;

import java.util.List;

import kitri.performinfo.performance.dto.PerformanceDTO;
import kitri.performinfo.prfplace.dto.PrfplaceDTO;
import kitri.reservation.vo.reservationDetailVO;
import kitri.reservation.vo.reservationVO;

public interface reservationDAO {
	//시, 도 기준으로 Hall정보 
		List<PrfplaceDTO> call_hall_bySido(String sido);
		//구 기준으로 Hall정보
		List<PrfplaceDTO> call_hall_bygungu(String gungu);
		//Hall정보 기준으로 공연ID물고오기
		List<PerformanceDTO> call_performInfo_byhallId(String hallId);
		//공연 상세정보
		PerformanceDTO perform_detail(String prfid);
		//공연예약하기
		int insert_reservation(reservationVO vo);
		int insert_reservationDeatil(reservationDetailVO vo);
		
		//공연 예약한거 체크
		List<String> reservation_chk_byTime(reservationVO vo);
		List<String> reservation_chk_byTime_detail(reservationVO vo);
		
		//
		int preChk_byTime_detail(reservationVO vo);
}