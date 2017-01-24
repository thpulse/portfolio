package kitri.search.dao;

import java.util.List;

import kitri.search.vo.SearchLogVO;
import kitri.search.vo.SearchResultVO;
import kitri.search.vo.SearchVO;

public interface SearchDAO {
	// 검색
	List<SearchVO> search(String tag, String Sword);
	
	// 검색한 단어가 들어가는
	void insertSearch(String Sword);
	
	// 워드 카운드 된 검색어
	List<SearchResultVO> searchResult();
}
