package kitri.search.service;

import java.util.List;

import kitri.search.vo.SearchLogVO;
import kitri.search.vo.SearchResultVO;
import kitri.search.vo.SearchVO;

public interface SearchService {
	// �˻�
	List<SearchVO> search(String tag,String Sword);
	
	// �˻��� �ܾ ����
	void insertSearch(String sword);
	
	// ���� ī��� �� �˻���
	List<SearchResultVO> searchResult();
}
