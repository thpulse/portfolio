package kitri.mypageRcheck.dao;

import java.util.List;
import kitri.mypageRcheck.vo.RcheckVO;

public interface RcheckDAO {
	List<RcheckVO> Rcheck(String userid);
}
