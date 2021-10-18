package kr.pe.midtermproject.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import kr.pe.midtermproject.model.BoardService;
import kr.pe.midtermproject.model.CommentsService;
import kr.pe.midtermproject.model.JWT;
import kr.pe.midtermproject.model.UsersService;
import kr.pe.midtermproject.model.domain.Board;
import kr.pe.midtermproject.model.domain.Comments;
import kr.pe.midtermproject.model.domain.Users;
import kr.pe.midtermproject.model.dto.CommentsDTO;
import kr.pe.midtermproject.model.dto.CommentsLengthDTO;

@RestController
public class CommentController {
	
	@Autowired
	private CommentsService commentService;
	
	@Autowired
	private UsersService userService;
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private JWT JWT;
	
	//코멘트 작성
    @PostMapping("board/{boardIdx}/comment")
  	public boolean createComment(@RequestHeader("Authorization") String token, @PathVariable Long boardIdx, @RequestBody Comments comment) {		
    	boolean result = false;
		Map<String, Object> claimMap;
		Users user = null;
		Board board = null;
		
		try {
			claimMap = JWT.verifyJWT(token);
			user = userService.getUser(claimMap, Long.parseLong(String.valueOf(claimMap.get("user_idx"))));			
			board = boardService.getBoardDetail(boardIdx);
			result = commentService.createComment(user, board , comment);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
  	}
    
    // 게시글별 코멘트 전체 조회
    @GetMapping("board/{boardIdx}/comment")
    public CommentsLengthDTO getCommentList(@PathVariable Long boardIdx) {
    	List<Comments> result = null;
    	result = commentService.getCommentList(boardIdx);
    	
    	CommentsLengthDTO result2 = new CommentsLengthDTO();
    	result2.setBoardIdx(boardIdx);
    	result2.setCommentsList(result);
    	
    	return result2;
    }
    
    // 코멘트 수정 
  	@PutMapping("board/{boardIdx}/comment/{commentIdx}")
  	public boolean updateComment(@RequestHeader("Authorization") String token, @PathVariable Long commentIdx, @RequestBody CommentsDTO commentDTO) {
  		boolean result = false;
  		Map<String, Object> claimMap;
		Users user = null;
		
		try {
			claimMap = JWT.verifyJWT(token);
			user = userService.getUser(claimMap, Long.parseLong(String.valueOf(claimMap.get("user_idx"))));			
			commentDTO.setCommentIdx(commentIdx);
			result = commentService.updateComment(user, commentDTO);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
  		return result;
  	}
    
    //코멘트 삭제
    @DeleteMapping("board/{boardIdx}/comment/{commentIdx}")
    public boolean deleteComment(@RequestHeader("Authorization") String token, @PathVariable Long commentIdx){
    	boolean result = false;
		Map<String, Object> claimMap;
		Users user = null;
		
		try {
			claimMap = JWT.verifyJWT(token);
			user = userService.getUser(claimMap, Long.parseLong(String.valueOf(claimMap.get("user_idx"))));			
			result = commentService.deleteComment(user , commentIdx);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
    	return result;
    }
}
