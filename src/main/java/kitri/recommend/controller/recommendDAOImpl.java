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
	
	//��� id��ȯ
	public List<UserVO> allId(){
		return sqlSession.selectList("kitri.perform.user.list");
	}
	//id�� ������ 
	public List<reservationVO> reserv_cnt(UserVO vo) {
		return sqlSession.selectList("kitri.recommend.reserv_cnt",vo);
	}
	
	//user_id�� reserv_id�� ������ �ش������ count�� ��ȯ
	public int recommend_cnt(reservationVO vo) {
		List<reservationDetailVO> volist = sqlSession.selectList("kitri.recommend.searchBy_id_reserv",vo);
		return volist.size();
	}
	
	//recommend_byReserv ���̺� ����
	public int insert_reserv(recommendReserveVO vo) {
		return sqlSession.insert("kitri.recommend.insert_recommend_reserv",vo);
	}
	
	
	//recommend_byReserv ���̺� ����
	public List<recommendReserveVO> select_all() {
			return sqlSession.selectList("kitri.recommend.select_all");
	}
	//recommend_byReserv ���̺� ����
	public void delete() {
			sqlSession.delete("kitri.recommend.delete");
	}
	
	//recommend_byReserv ���̺� ����
	public void insertMahout(recommendResultVO vo) {
			sqlSession.insert("kitri.recommend.rcmd_result_insert", vo);
	}
	
	public void deleteMahout() {
		sqlSession.delete("kitri.recommend.rcmd_result_delete");
}
}
