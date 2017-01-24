package kitri.review.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kitri.review.VO.ReviewVO;

@Repository("ReviewDAO")
public class ReviewDAOImpl implements ReviewDAO{
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void insert(ReviewVO review) {
		System.out.println(review);
		sqlSession.insert("kitri.review.write", review);
	}

	@Override
	public void delete(int revno) {
		System.out.println("여기서안되니");
		sqlSession.delete("kitri.review.delete", revno);
	}

	@Override
	public void update(ReviewVO review) {
		System.out.println("여기야여기");
		sqlSession.update("kitri.review.update", review);
	}

	@Override
	public ReviewVO readno(int revno) {
		return sqlSession.selectOne("kitri.review.read", revno);
	}
	
	@Override
	public List<ReviewVO> readall(String pfr_id) {
		System.out.println("이것도해조라");
		return sqlSession.selectList("kitri.review.list",pfr_id);
	}
	

	@Override
	public List<ReviewVO> readadmin() {
		return sqlSession.selectList("kitri.review.adminlist");
	}
	
	@Override
	public List<ReviewVO> readid(String tag, String search) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("tag", tag);
		map.put("search", search);
		return sqlSession.selectList("kitri.review.search", map);
	}

	@Override
	public int count() {
		return sqlSession.selectOne("kitri.review.count");
	}

}
