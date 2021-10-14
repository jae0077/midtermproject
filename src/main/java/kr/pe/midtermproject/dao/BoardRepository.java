package kr.pe.midtermproject.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import kr.pe.midtermproject.model.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long>{

	// 게시글 역순 정렬
	List<Board> findAllByOrderByBoardIdxDesc();
	
}
