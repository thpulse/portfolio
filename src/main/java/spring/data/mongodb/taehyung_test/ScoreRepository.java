package spring.data.mongodb.taehyung_test;
import org.springframework.data.repository.PagingAndSortingRepository;
//�ƹ��͵� �������� ����
// - CRUD�� ������ �⺻ �޼ҵ带 �����ִ� Repository�� �ۼ��� ��
// 	=> Spring-data���ο��� �ڵ����� ����
//Serialiszable -> 
public interface ScoreRepository extends PagingAndSortingRepository<ScoreDTO, String>{

}
