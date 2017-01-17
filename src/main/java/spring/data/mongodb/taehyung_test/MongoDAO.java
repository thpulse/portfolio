package spring.data.mongodb.taehyung_test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

@Repository
public class MongoDAO {
	@Autowired
	ScoreRepository repository;
	
	public List<ScoreDTO> findAll(){
		List<ScoreDTO> mongolist= (List<ScoreDTO>)repository.findAll();
		return mongolist;		
	}
	//�ڵ����� ����¡ó���ؼ� �����ش�.
	public List<ScoreDTO> findAll(int pageNo){
		Page<ScoreDTO> page= repository.findAll(new PageRequest(pageNo, 8));
		List<ScoreDTO> mongolist = page.getContent();
		return mongolist;		
	}
}
