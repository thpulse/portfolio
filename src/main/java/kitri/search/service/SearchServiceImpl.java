package kitri.search.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kitri.search.dao.SearchDAO;
import kitri.search.vo.SearchVO;

@Repository("searchservice")
public class SearchServiceImpl implements SearchService {
	@Autowired
	SearchDAO dao;
	
	@Override
	public List<SearchVO> search(String tag, String Sword) {
		// TODO Auto-generated method stub
		return dao.search(tag, Sword);
	}

}
