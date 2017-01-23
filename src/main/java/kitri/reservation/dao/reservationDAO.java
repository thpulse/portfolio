package kitri.reservation.dao;

import java.util.List;

import kitri.performinfo.performance.dto.PerformanceDTO;
import kitri.performinfo.prfplace.dto.PrfplaceDTO;
import kitri.reservation.vo.reservationDetailVO;
import kitri.reservation.vo.reservationVO;

public interface reservationDAO {
	//��, �� �������� Hall���� 
		List<PrfplaceDTO> call_hall_bySido(String sido);
		//�� �������� Hall����
		List<PrfplaceDTO> call_hall_bygungu(String gungu);
		//Hall���� �������� ����ID�������
		List<PerformanceDTO> call_performInfo_byhallId(String hallId);
		//���� ������
		PerformanceDTO perform_detail(String prfid);
		//���������ϱ�
		int insert_reservation(reservationVO vo);
		int insert_reservationDeatil(reservationDetailVO vo);
		
		//���� �����Ѱ� üũ
		List<String> reservation_chk_byTime(reservationVO vo);
		List<String> reservation_chk_byTime_detail(reservationVO vo);
		
		//
		int preChk_byTime_detail(reservationVO vo);
}