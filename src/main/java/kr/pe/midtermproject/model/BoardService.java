package kr.pe.midtermproject.model;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.pe.midtermproject.dao.BoardRepository;
import kr.pe.midtermproject.dao.UserRepository;
import kr.pe.midtermproject.model.domain.Board;
import kr.pe.midtermproject.model.domain.Users;
import kr.pe.midtermproject.model.dto.BoardDTO;
import kr.pe.midtermproject.model.dto.BoardResDTO;

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
		
		return boardRepo.save(new Board(null, writer, boardDTO.getTitle(), boardDTO.getContent(), LocalDate.now(), LocalDate.now()));
	}

	//글 수정
	@Transactional(rollbackOn = Exception.class)
	public Long updateBoard(Long id, BoardDTO board) {
		Board post = boardRepo.findById(id).orElseThrow(() 
				-> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));
		
		post.update(board.getTitle(), board.getContent());
		
		return id;
	}

	//글 1개 조회
	@Transactional(rollbackOn = Exception.class)
	public BoardResDTO searchByPostId(Long id) {
		Board board = boardRepo.findById(id).orElseThrow(()
                -> new IllegalArgumentException("해당 게시물이 존재하지 않습니다."));
		
		return new BoardResDTO(board);
	}
	
	//글 전체 조회
	@Transactional(rollbackOn = Exception.class)
	public List<BoardResDTO> searchAllDesc() {
		
		return boardRepo.findAllByOrderByBoardIdxDesc().stream()
                .map(BoardResDTO::new)
                .collect(Collectors.toList());
	}

	//글 삭제
	@Transactional(rollbackOn = Exception.class)
	public void deletePost(Long id) {
		Board board = boardRepo.findById(id).orElseThrow(()
				-> new IllegalArgumentException("해당 게시물이 존재하지 않습니다."));

		boardRepo.delete(board);
	}	
	
}
