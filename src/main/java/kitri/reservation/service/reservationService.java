package kitri.reservation.service;

import java.util.List;

import kitri.reservation.vo.reservationVO;

public interface reservationService {
	//����
	void insert(reservationVO vo);
	//���̵�� �˻�
	List<reservationVO> findByid(String id);
	//�������
	reservationVO cancle(reservationVO vo);
	
}
