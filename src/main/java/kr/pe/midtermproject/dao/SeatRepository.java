package kr.pe.midtermproject.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import kr.pe.midtermproject.model.domain.Seat;

public interface SeatRepository extends CrudRepository<Seat, Integer>{
	
	//select * from seat where title=?
	//동일한 메소드명 fildByTitle
	List<Seat> findSeatByTitle(String isUsed);

}
