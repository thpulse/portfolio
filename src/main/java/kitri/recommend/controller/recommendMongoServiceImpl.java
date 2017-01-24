package kitri.recommend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kitri.spring.data.mongodb.taehyung_test.ScoreDTO;
import kitri.spring.data.mongodb.taehyung_test.ScoreMongoService;
@Service
@Qualifier("recommendmongoservice")
public class recommendMongoServiceImpl implements recommendMongoService {
	@Autowired
	recommendMongoDAO dao;

	@Override
	public void insertDocument(recommendDTO doc) {
		dao.insertDocument(doc);		
	}

	@Override
	public void insertAllDocument(List<ScoreDTO> docs) {
		dao.insertAllDocument(docs);				
	}

	@Override
	public ScoreDTO findById(String key, String value) {
		return dao.findById(key, value);
	}

	@Override
	public List<ScoreDTO> findCriteria(String field, String value) {
		return dao.findCriteria(field,value);
	}

	@Override
	public void update(ScoreDTO document) {
		dao.update(document);		
	}

	@Override
	public void test1() {
		dao.test1();
		
	}

	
}
