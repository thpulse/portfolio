package spring.data.mongodb.taehyung_test;

import java.util.List;

public interface ScoreMongoDAO {

	void insertDocument(ScoreDTO doc);

	void insertAllDocument(List<ScoreDTO> docs);

	ScoreDTO findById(String key, String value);

	List<ScoreDTO> findCriteria(String field, String value);

	void update(ScoreDTO document);

	void test1();

}
