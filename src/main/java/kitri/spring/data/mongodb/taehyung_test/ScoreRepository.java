package kitri.spring.data.mongodb.taehyung_test;
import org.springframework.data.repository.PagingAndSortingRepository;
//아무것도 정의하지 않음
// - CRUD를 접근할 기본 메소드를 갖고있는 Repository를 작성한 것
// 	=> Spring-data내부에서 자동으로 맵핑
//Serialiszable -> 
public interface ScoreRepository extends PagingAndSortingRepository<ScoreDTO, String>{

}
