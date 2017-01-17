package kitri.reservation.dao;

import java.util.List;

import kitri.performinfo.performance.dto.PerformanceDTO;
import kitri.performinfo.prfplace.dto.PrfplaceDTO;

public interface reservationDAO {
	//��, �� �������� Hall���� 
		List<PrfplaceDTO> call_hall_bySido(String sido);
		//�� �������� Hall����
		List<PrfplaceDTO> call_hall_bygungu(String gungu);
		//Hall���� �������� ����ID�������
		List<PerformanceDTO> call_performInfo_byhallId(String hallId);
		//���� ������
		PerformanceDTO perform_detail(String prfid);

}