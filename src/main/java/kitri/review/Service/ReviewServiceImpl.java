package kitri.review.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kitri.review.DAO.ReviewDAO;
import kitri.review.VO.ReviewVO;

@Service("ReviewService")
public class ReviewServiceImpl implements ReviewService{
	@Autowired
	@Qualifier("ReviewDAO")
	ReviewDAO dao;
	
	@Override
	public void insert(ReviewVO review) {
		dao.insert(review);
	}

	@Override
	public void delete(int revno) {
		System.out.println("되니안되니");
		dao.delete(revno);
	}

	@Override
	public void update(ReviewVO review) {
		System.out.println("여기가문제구만");
		dao.update(review);
	}

	@Override
	public ReviewVO readno(int revno) {
		System.out.println("해주라제발");
		return dao.readno(revno);
	}
	
	@Override
	public List<ReviewVO> readall() {
		System.out.println("실행해조라");
		return dao.readall();
	}
	
	@Override
	public List<ReviewVO> readpfr(String pfr_id) {
		return dao.readpfr(pfr_id);
	}

	@Override
	public List<ReviewVO> readid(String mem_id) {
		return dao.readid(mem_id);
	}

	
}
