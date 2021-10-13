package kr.pe.midtermproject.model;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.pe.midtermproject.dao.BoardRepository;
import kr.pe.midtermproject.dao.UserRepository;
import kr.pe.midtermproject.model.domain.Board;
import kr.pe.midtermproject.model.domain.Users;
import kr.pe.midtermproject.model.dto.BoardDTO;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepo;
	
	@Autowired
	private UserRepository userRepo;

	//글 작성
	@Transactional(rollbackOn = Exception.class)
	public Board createBoard(BoardDTO boardDTO) {
		Users writer = userRepo.findById(boardDTO.getWriterId()).get();
		
//		return boardRepo.save(new Board(null, writer, boardDTO.getTitle(), boardDTO.getContent(), null, null, null)).getBoardIdx();
		return boardRepo.save(new Board(null, writer, boardDTO.getTitle(), boardDTO.getContent(), null, null, null));
	}

	//글 수정
	@Transactional(rollbackOn = Exception.class)
	public Long updateBoard(Long id, BoardDTO board) {
		Board post = boardRepo.findById(id)
				.orElseThrow(() -> new
			            IllegalArgumentException("해당 게시글이 존재하지 않습니다."));
		
		post.update(board.getTitle(), board.getContent());
		
		return id;
	}
	

	
	//글 조회
	
	
	//글 삭제
	
	//댓글 작성
	
	//댓글 삭제
	
	
}
