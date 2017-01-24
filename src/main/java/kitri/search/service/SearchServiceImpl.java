package kitri.search.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kitri.search.dao.SearchDAO;
import kitri.search.vo.SearchLogVO;
import kitri.search.vo.SearchResultVO;
import kitri.search.vo.SearchVO;

@Repository("searchservice")
public class SearchServiceImpl implements SearchService {
	@Autowired
	SearchDAO dao;
	
	@Override
	public List<SearchVO> search(String tag, String Sword) {
		
		return dao.search(tag, Sword);
	}

	@Override
	public void insertSearch(String Sword) {
		dao.insertSearch(Sword);
	}

	@Override
	public List<SearchResultVO> searchResult() {
		
		return dao.searchResult();
	}

}
