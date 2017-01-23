package kitri.review.DAO;

import java.util.List;

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
		System.out.println("���⼭�ȵǴ�");
		sqlSession.delete("kitri.review.delete", revno);
	}

	@Override
	public void update(ReviewVO review) {
		System.out.println("����߿���");
		sqlSession.update("kitri.review.update", review);
	}

	@Override
	public ReviewVO readno(int revno) {
		return sqlSession.selectOne("kitri.review.read", revno);
	}
	
	@Override
	public List<ReviewVO> readall(String pfr_id) {
		System.out.println("�̰͵�������");
		return sqlSession.selectList("kitri.review.list",pfr_id);
	}
	

	@Override
	public List<ReviewVO> readpfr(String pfr_id) {
	
		return null;
	}

	@Override
	public List<ReviewVO> readid(String mem_id) {
		
		return null;
	}

	

}
