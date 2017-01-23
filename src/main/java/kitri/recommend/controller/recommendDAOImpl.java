package kitri.recommend.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import kitri.performinfo.prfplace.dto.PrfplaceDTO;
import kitri.reservation.service.reservationService;
import kitri.reservation.vo.reservationVO;
import kitri.user.vo.UserVO;
@Repository("recommenddao")
public class recommendDAOImpl {
	@Autowired
	SqlSession sqlSession;
		
	public int reserv_cnt(reservationVO vo) {
		List<String> list = sqlSession.selectList("kitri.recommend.reserv_cnt",vo);
		return list.size();
	}
	
	public List<UserVO> allId(){
		return sqlSession.selectList("kitri.perform.user.list");
	}
}
