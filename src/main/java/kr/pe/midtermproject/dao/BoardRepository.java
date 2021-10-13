package kr.pe.midtermproject.dao;

import org.springframework.data.repository.CrudRepository;

import kr.pe.midtermproject.model.domain.Board;
import kr.pe.midtermproject.model.dto.BoardDTO;

public interface BoardRepository extends CrudRepository<Board, Long>{

//	Board save(BoardDTO boardDTO);
	
}
