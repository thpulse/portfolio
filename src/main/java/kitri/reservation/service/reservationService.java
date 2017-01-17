package kitri.reservation.service;

import java.util.List;

import kitri.reservation.vo.reservationVO;

public interface reservationService {
	//예약
	void insert(reservationVO vo);
	//아이디로 검색
	List<reservationVO> findByid(String id);
	//예약취소
	reservationVO cancle(reservationVO vo);
	
}
