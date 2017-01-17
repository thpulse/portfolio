package spring.data.mongodb.taehyung_test;

import java.util.List;



public interface ScoreMongoService {
	public ScoreDTO findById(String key,String value);
	public void insertDocument(ScoreDTO doc);
	public void insertAllDocument(List<ScoreDTO> docs);
	public List<ScoreDTO> findCriteria(String key,String value);
	public void update(ScoreDTO document);
	public void test1();
}
