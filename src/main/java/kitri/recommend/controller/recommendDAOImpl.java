package kitri.recommend.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import kitri.performinfo.prfplace.dto.PrfplaceDTO;
import kitri.reservation.service.reservationService;
import kitri.reservation.vo.reservationDetailVO;
import kitri.reservation.vo.reservationVO;
import kitri.user.vo.UserVO;
@Repository("recommenddao")
public class recommendDAOImpl {
	@Autowired
	SqlSession sqlSession;
	
	//모든 id반환
	public List<UserVO> allId(){
		return sqlSession.selectList("kitri.perform.user.list");
	}
	//id가 예약한 
	public List<reservationVO> reserv_cnt(UserVO vo) {
		return sqlSession.selectList("kitri.recommend.reserv_cnt",vo);
	}
	
	//user_id와 reserv_id를 변수로 해당공연의 count를 반환
	public int recommend_cnt(reservationVO vo) {
		List<reservationDetailVO> volist = sqlSession.selectList("kitri.recommend.searchBy_id_reserv",vo);
		return volist.size();
	}
	
	//recommend_byReserv 테이블에 저장
	public int insert_reserv(recommendReserveVO vo) {
		return sqlSession.insert("kitri.recommend.insert_recommend_reserv",vo);
	}
	
	
	//recommend_byReserv 테이블에 저장
	public List<recommendReserveVO> select_all() {
			return sqlSession.selectList("kitri.recommend.select_all");
	}
	//recommend_byReserv 테이블에 저장
	public void delete() {
			sqlSession.delete("kitri.recommend.delete");
	}
	
	//recommend_byReserv 테이블에 저장
	public void insertMahout(recommendResultVO vo) {
			sqlSession.insert("kitri.recommend.rcmd_result_insert", vo);
	}
	
	public void deleteMahout() {
		sqlSession.delete("kitri.recommend.rcmd_result_delete");
}
}
