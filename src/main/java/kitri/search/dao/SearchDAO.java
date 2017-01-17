package kitri.search.dao;

import java.util.List;
import kitri.search.vo.SearchVO;

public interface SearchDAO {
	List<SearchVO> search(String tag, String Sword);
}
