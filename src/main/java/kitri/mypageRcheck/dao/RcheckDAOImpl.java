package kitri.mypageRcheck.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kitri.mypageRcheck.vo.RcheckVO;

@Repository("Rcheckdao")
public class RcheckDAOImpl implements RcheckDAO {
	@Autowired
	SqlSession sqlsession;
	
	@Override
	public List<RcheckVO> Rcheck(String userid) {
		// TODO Auto-generated method stub
		
		return sqlsession.selectList("kitri.perform.Rcheck.list", userid);
	}

}
