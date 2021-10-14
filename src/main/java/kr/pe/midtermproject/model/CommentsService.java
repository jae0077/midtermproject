package kr.pe.midtermproject.model;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.pe.midtermproject.dao.BoardRepository;
import kr.pe.midtermproject.dao.CommentsRepository;
import kr.pe.midtermproject.dao.UserRepository;
import kr.pe.midtermproject.model.domain.Board;
import kr.pe.midtermproject.model.domain.Comments;
import kr.pe.midtermproject.model.domain.Users;
import kr.pe.midtermproject.model.dto.BoardResDTO;
import kr.pe.midtermproject.model.dto.CommentsDTO;
import kr.pe.midtermproject.model.dto.CommentsResDTO;

@Service
public class CommentsService {
	
	@Autowired
	private CommentsRepository commentsRepo;
	
	@Autowired
	private BoardRepository boardRepo;
	
	@Autowired
	private UserRepository userRepo;

	//댓글 작성
	@Transactional(rollbackOn = Exception.class)
	public Boolean createComment(CommentsDTO commentDTO) {
		Board post = boardRepo.findById(commentDTO.getPostId()).get();
		Users writer = userRepo.findById(commentDTO.getWriterId()).get();
		
		try {
			commentsRepo.save(new Comments(null, post, writer, commentDTO.getContent(), LocalDate.now()));
			return true;
		} catch (Exception e){
			return false;
		}
		
	}
	
	@Transactional(rollbackOn = Exception.class)
	public Boolean updateComment(Long id, CommentsDTO commentDTO) {
		
		Comments comment = commentsRepo.findById(id).orElseThrow(() 
				-> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));
		try {
			comment.setContent(commentDTO.getContent());
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	//post id별 댓글 리스트
	@Transactional(rollbackOn = Exception.class)
	public List<CommentsResDTO> searchCommentsDesc(Long boardId) {
		return commentsRepo.findAll().stream()
				.map(CommentsResDTO::new).filter(x -> x.getBoardId() == boardId)
				.collect(Collectors.toList());
	}

	//댓글 삭제
	@Transactional(rollbackOn = Exception.class)
	public void deleteComment(Long id) {
		Comments comment = commentsRepo.findById(id).orElseThrow(()
				-> new IllegalArgumentException("해당 댓글이 존재하지 않습니다."));
		
		commentsRepo.delete(comment);
	}


	
	
}
