package kr.pe.midtermproject.model;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import kr.pe.midtermproject.dao.BoardRepository;
import kr.pe.midtermproject.model.domain.Board;
import kr.pe.midtermproject.model.domain.Users;
import kr.pe.midtermproject.model.dto.BoardDTO;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardDao;
	
	//글 작성
	@Transactional(rollbackOn = Exception.class)
	public Board createBoard(Users user, Board board) {
		board.setWriter(user);
		return boardDao.save(board); 
	}

	//글 수정
	@Transactional(rollbackOn = Exception.class)
	public Board updateBoard(Users user, Long boardIdx, BoardDTO board) {
		Board result = null;
		Board post = boardDao.findById(boardIdx).get();
		if (post.getWriter().getUserId().equals(user.getUserId()) ) {
			post.setTitle(board.getTitle());
			post.setContent(board.getContent());
			result = boardDao.save(post);
		}
		return result;
	}

	// 게시글 상세 조회
	public Board getBoardDetail(Long boardIdx) {
		Board result = null;
		try {
			result = boardDao.findById(boardIdx).get();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// 게시글 전체 조회
	public Page<Board> getBoardList(Pageable pageable) {
		Page<Board> result = null;
		try {
			result = boardDao.findAll(pageable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//글 삭제
	public boolean deleteBoard(Users user, Long boardIdx) {
		boolean result = false;

		try {
			Board post = boardDao.findById(boardIdx).get();
			if (post.getWriter().getUserId().equals(user.getUserId()) ) {
				boardDao.delete(post);		
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}	
}
