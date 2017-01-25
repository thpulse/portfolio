package kitri.mypageRcheck.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kitri.mypageRcheck.dao.RcheckDAO;
import kitri.mypageRcheck.vo.RcheckVO;

@Service("RcheckService")
public class RcheckServiceImpl implements RcheckService {
	@Autowired
	RcheckDAO dao;
	
	@Override
	public List<RcheckVO> Rcheck(String userid) {
		
		return dao.Rcheck(userid);
	}

	@Override
	public void Rcancel(String reserv_num) {
		dao.Rcancel(reserv_num);
	}
	
}
