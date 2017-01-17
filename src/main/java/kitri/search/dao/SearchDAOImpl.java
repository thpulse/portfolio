package kitri.search.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import kitri.search.vo.SearchVO;

@Repository("searchdao")
public class SearchDAOImpl implements SearchDAO {
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<SearchVO> search(String tag, String Sword) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("tag", tag);
		map.put("search", "%"+Sword+"%");
		
		return sqlSession.selectList("kitri.perform.search.list", map);
	}

}
