package kr.pe.midtermproject.model;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.pe.midtermproject.dao.BoardRepository;
import kr.pe.midtermproject.dao.CommentsRepository;
import kr.pe.midtermproject.dao.UserRepository;
import kr.pe.midtermproject.model.domain.Board;
import kr.pe.midtermproject.model.domain.Comments;
import kr.pe.midtermproject.model.domain.Users;
import kr.pe.midtermproject.model.dto.CommentsDTO;
import kr.pe.midtermproject.model.dto.NoticeResDTO;

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
	public Comments createComment(CommentsDTO commentDTO) {
		Board post = boardRepo.findById(commentDTO.getPostId()).get();
		Users writer = userRepo.findById(commentDTO.getWriterId()).get();
		
		return commentsRepo.save(new Comments(null, post, writer, commentDTO.getContent(), LocalDate.now()));
	}

	@Transactional(rollbackOn = Exception.class)
	public void createComment(Long id) {
		Comments comment = commentsRepo.findById(id).orElseThrow(()
				-> new IllegalArgumentException("해당 댓글이 존재하지 않습니다."));
		
		commentsRepo.delete(comment);
	}

	public List<NoticeResDTO> searchAllCommentsDesc() {
		return null;
	}
	
	
}
