package kr.pe.midtermproject.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import kr.pe.midtermproject.model.domain.Seat;

public interface SeatRepository extends CrudRepository<Seat, Long>{
	
	List<Seat> findSeatByIsUsed(String isUsed);
	
	// 좌석리스트 정렬
	List<Seat> findAllByOrderBySeatIdxAsc();
}
