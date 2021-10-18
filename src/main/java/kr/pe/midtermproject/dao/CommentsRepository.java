package kr.pe.midtermproject.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import kr.pe.midtermproject.model.domain.Board;
import kr.pe.midtermproject.model.domain.Comments;

public interface CommentsRepository extends CrudRepository<Comments, Long> {
	// 코멘트 역순 정렬
	List<Comments> findByBoardOrderByCommentIdxAsc(Board board);
	
	
//	OrderByCommentIdxDesc(Long boardIdx);
}
