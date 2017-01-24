package kitri.reservation.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import kitri.performinfo.performance.dto.PerformanceDTO;
import kitri.performinfo.prfplace.dto.PrfplaceDTO;
import kitri.reservation.service.reservationService;
import kitri.reservation.vo.reservationDetailVO;
import kitri.reservation.vo.reservationVO;
@Repository("reservationdao")
public class reservationDAOImpl implements reservationDAO{
	@Autowired
	SqlSession sqlSession;
	@Autowired
	@Qualifier("reservationservice")
	reservationService reservService;
	
	@Override
	public List<PrfplaceDTO> call_hall_bySido(String sido) {
		return sqlSession.selectList("kitri.reservation.call_hall_bySido",sido);
	}

	@Override
	public List<PrfplaceDTO> call_hall_bygungu(String gungu) {
		return sqlSession.selectList("kitri.reservation.call_hall_bygungu",gungu);
	}

	@Override
	public List<PerformanceDTO> call_performInfo_byhallId(String hallId) {
		return sqlSession.selectList("kitri.reservation.call_perform_byHall",hallId);
	}

	@Override
	public PerformanceDTO perform_detail(String prfid) {
		return sqlSession.selectOne("kitri.reservation.perform_detail", prfid);
	}

	@Override
	public int insert_reservation(reservationVO vo) {
		//예매 테이블		
		return sqlSession.insert("kitri.reservation.insert_reservation", vo);
			
	}

	@Override
	public int insert_reservationDeatil(reservationDetailVO vo) {		
		return sqlSession.insert("kitri.reservation.insert_reservation_detail",vo);
	}

	@Override
	public List<String> reservation_chk_byTime(reservationVO vo) {
		return sqlSession.selectList("kitri.reservation.reservation_chk_byTime", vo);
	}

	@Override
	public List<String> reservation_chk_byTime_detail(reservationVO vo) {
		return sqlSession.selectList("kitri.reservation.reservation_chk_byTime_detail",vo);
	}

	@Override
	public List<String> preChk_byTime_detail(reservationVO vo) {
		return sqlSession.selectList("kitri.reservation.preChk_byTime_detail",vo);
		
	}

	@Override
	public List<String> reservation_chk_byDayTime(reservationVO vo) {
		return sqlSession.selectList("kitri.reservation.reservation_chk_byDayTime",vo);
	}	
	

}
