package spring.data.mongodb.taehyung_test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
@Repository
public class ScoreMongoDAOImpl implements ScoreMongoDAO {
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Override
	public void insertDocument(ScoreDTO doc) {
		mongoTemplate.insert(doc);			
	}

	@Override
	public void insertAllDocument(List<ScoreDTO> docs) {
		mongoTemplate.insertAll(docs);		
	}

	@Override
	public ScoreDTO findById(String key, String value) {
		//MongoDB에 조건을 모델링한 객체 - Criteria
		//어떤 필드에 대해서 어떤값을 조건을 적용할 것인지 지정
		//key = 필드명
		Criteria criteria = new Criteria(key);
		//조건데 대한 설정 - value값과 정확하게 일치하는 document를 조회
		criteria.is(value);
		//Criteria 이용해서 Query를 생성
		Query query = new Query(criteria);
		ScoreDTO doc = mongoTemplate.findOne(query,ScoreDTO.class,"score");
		return doc;
	}

	@Override
	public List<ScoreDTO> findCriteria(String key, String value) {
		String[] keys=key.split(",");
		Criteria criteria = new Criteria(keys[0]);
		if(keys[1].equals("is")){
			criteria.is(value);
		}else if(keys[1].equals("gt")){
			criteria.gt(new Integer(value));
		}		
		Query query = new Query(criteria);
		List<ScoreDTO> searchlist = mongoTemplate.find(query, ScoreDTO.class,"score");
		return searchlist;
	}

	@Override
	public void update(ScoreDTO document) {
		Criteria criteria = new Criteria("id");
		criteria.is(document.getId());
		Query query = new Query(criteria);
		
		Update update = new Update();
		update.set("addr", document.getAddr());
		update.set("dept", document.getDept());
		mongoTemplate.updateMulti(query,update,"score");
	}

	@Override
	public void test1() {
		// TODO Auto-generated method stub		
	}
}
