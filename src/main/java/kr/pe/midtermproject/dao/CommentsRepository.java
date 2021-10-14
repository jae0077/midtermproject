package kr.pe.midtermproject.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import kr.pe.midtermproject.model.domain.Comments;
import kr.pe.midtermproject.model.dto.CommentsResDTO;

public interface CommentsRepository extends CrudRepository<Comments, Long> {

	// 코멘트 역순 정렬
//	List<Board> findAllByOrderByBoardIdxDesc();
//	List<CommentsResDTO> findByBoardId(Long boardId);
	List<Comments> findAll();
}
