package kitri.reservation.service;

import java.util.List;

import kitri.performinfo.performance.dto.PerformanceDTO;
import kitri.performinfo.prfplace.dto.PrfplaceDTO;
import kitri.reservation.vo.reservationDetailVO;
import kitri.reservation.vo.reservationVO;

public interface reservationService {
	//��, �� �������� Hall���� 
	List<PrfplaceDTO> call_hall_bySido(String sido);
	//�� �������� Hall����
	List<PrfplaceDTO> call_hall_bygungu(String gungu);
	//Hall���� �������� ����ID�������
	List<PerformanceDTO> call_performInfo_byhallId(String hallId);
	
	//���� ������
	PerformanceDTO perform_detail(String prfid);
	int insert_reservation(reservationVO vo);
	int insert_reservationDeatil(reservationDetailVO vo);
	
	//��������üũ
	List<String> reservation_chk_byTime(reservationVO vo);
	List<String> reservation_chk_byTime_detail(reservationVO vo);
	
	//�������� �����
	int preChk_byTime_detail(reservationVO vo);
}
