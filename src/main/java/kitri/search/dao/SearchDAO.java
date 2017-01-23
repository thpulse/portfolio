package kitri.search.dao;

import java.util.List;

import kitri.search.vo.SearchLogVO;
import kitri.search.vo.SearchResultVO;
import kitri.search.vo.SearchVO;

public interface SearchDAO {
	// �˻�
	List<SearchVO> search(String tag, String Sword);
	
	// �˻��� �ܾ ����
	void insertSearch(String Sword);
	
	// ���� ī��� �� �˻���
	List<SearchResultVO> searchResult();
}
