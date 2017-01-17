package kitri.reservation.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kitri.performinfo.performance.dto.PerformanceDTO;
import kitri.performinfo.prfplace.dto.PrfplaceDTO;
@Repository("reservationdao")
public class reservationDAOImpl implements reservationDAO{
	@Autowired
	SqlSession sqlSession;
	
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

}
