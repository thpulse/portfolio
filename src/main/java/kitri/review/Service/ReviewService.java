package kitri.review.Service;

import java.util.List;

import kitri.review.VO.ReviewVO;

public interface ReviewService {
	public void insert(ReviewVO review);
	public void delete(int revno);
	public void update(ReviewVO review);
	ReviewVO readno(int revno);
	List<ReviewVO> readall(String pfr_id);
	List<ReviewVO> readadmin();
	List<ReviewVO> readid(String tag, String search);
	int count();
}
