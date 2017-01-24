package kitri.recommend.controller;

import java.util.List;

import kitri.spring.data.mongodb.taehyung_test.ScoreDTO;



public interface recommendMongoService {
	public ScoreDTO findById(String key,String value);
	public void insertDocument(recommendDTO doc);
	
	public void insertAllDocument(List<ScoreDTO> docs);
	
	public List<ScoreDTO> findCriteria(String key,String value);
	public void update(ScoreDTO document);
	public void test1();
}
