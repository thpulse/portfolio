package kitri.search.service;

import java.util.List;
import kitri.search.vo.SearchVO;

public interface SearchService {
	List<SearchVO> search(String tag,String Sword);
}
