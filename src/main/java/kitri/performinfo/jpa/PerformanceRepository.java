package kitri.performinfo.jpa;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface PerformanceRepository extends PagingAndSortingRepository<Performance, String> {
	@Query("Select p from Performance p where p.prfpdto >= CURRENT_DATE")
	Page<Performance> findAll(Pageable pageable);
	
	@Query("Select p from Performance p where p.prfpdto >= CURRENT_DATE AND p.genre=:genre")
	Page<Performance> findByGenre(@Param("genre") String genre,Pageable pageable);
}
