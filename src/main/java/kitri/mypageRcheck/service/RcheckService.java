package kitri.mypageRcheck.service;

import java.util.List;

import kitri.mypageRcheck.vo.RcheckVO;

public interface RcheckService {
	List<RcheckVO> Rcheck(String userid);
}
