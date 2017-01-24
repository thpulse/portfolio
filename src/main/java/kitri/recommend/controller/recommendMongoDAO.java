package kitri.recommend.controller;

import java.util.List;

import kitri.spring.data.mongodb.taehyung_test.ScoreDTO;

public interface recommendMongoDAO {

	void insertDocument(recommendDTO doc);

	void insertAllDocument(List<ScoreDTO> docs);

	ScoreDTO findById(String key, String value);

	List<ScoreDTO> findCriteria(String field, String value);

	void update(ScoreDTO document);

	void test1();

}
