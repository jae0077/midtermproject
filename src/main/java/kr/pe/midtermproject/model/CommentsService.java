package kr.pe.midtermproject.model;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.pe.midtermproject.dao.BoardRepository;
import kr.pe.midtermproject.dao.CommentsRepository;
import kr.pe.midtermproject.model.domain.Board;
import kr.pe.midtermproject.model.domain.Comments;
import kr.pe.midtermproject.model.domain.Users;
import kr.pe.midtermproject.model.dto.CommentsDTO;

@Service
public class CommentsService {
	
	@Autowired
	private CommentsRepository commentsDao;
	
	@Autowired
	private BoardRepository boardDao;
	
	//댓글 작성
	@Transactional(rollbackOn = Exception.class)
	public boolean createComment(Users user, Board board, Comments comment) {
		boolean result = false;
		comment.setBoard(board);
		comment.setWriter(user);
		try {
			commentsDao.save(comment);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// 댓글 수정
	@Transactional(rollbackOn = Exception.class)
	public boolean updateComment(Users user, CommentsDTO commentDTO) {
		boolean result = false;
		Comments comment = commentsDao.findById(commentDTO.getCommentIdx()).get();
		if (comment != null) {
			if (comment.getWriter().getUserId().equals(user.getUserId()) ) {
				comment.setContent(commentDTO.getContent());
				commentsDao.save(comment);
				result = true;
			}
		}
		return result;
	}
	
	// 게시글별 댓글 리스트
	public List<Comments> getCommentList(Long boardIdx) {
		List<Comments> result = null;
		try {
			Board board = boardDao.findById(boardIdx).get();
			if (board != null) {
				result = commentsDao.findByBoardOrderByCommentIdxAsc(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	//댓글 삭제
	@Transactional(rollbackOn = Exception.class)
	public boolean deleteComment(Users user, Long commentIdx) {
		boolean result = false;
		
		try {
			Comments comment = commentsDao.findById(commentIdx).get();
			
			if (comment.getWriter().getUserId().equals(user.getUserId()) ) {
				if (comment != null) {
					commentsDao.delete(comment);
					result = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}
}
