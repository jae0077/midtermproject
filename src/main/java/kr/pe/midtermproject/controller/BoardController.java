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
import kr.pe.midtermproject.model.JWT;
import kr.pe.midtermproject.model.UsersService;
import kr.pe.midtermproject.model.domain.Board;
import kr.pe.midtermproject.model.domain.Users;
import kr.pe.midtermproject.model.dto.BoardDTO;

@RestController
public class BoardController {
	
	@Autowired
	private UsersService userService;
  
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private JWT JWT;
	
	// 게시글 작성
	@PostMapping("board")
	public Board createPost(@RequestHeader("Authorization") String token, @RequestBody Board board) {		
		Board result = null;
		Map<String, Object> claimMap;
		Users user = null;
		
		try {
			claimMap = JWT.verifyJWT(token);
			user = userService.getUser(claimMap, Long.parseLong(String.valueOf(claimMap.get("user_idx"))));
			result = boardService.createBoard(user, board);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// 게시글 수정
	@PutMapping("board/{boardIdx}")
	public Board updatePost(@RequestHeader("Authorization") String token, @PathVariable Long boardIdx, @RequestBody BoardDTO board) {
		Board result = null;
		Map<String, Object> claimMap;
		Users user = null;
		
		try {
			claimMap = JWT.verifyJWT(token);
			user = userService.getUser(claimMap, Long.parseLong(String.valueOf(claimMap.get("user_idx"))));
			result = boardService.updateBoard(user, boardIdx, board);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// 게시글 상세 조회
    @GetMapping("board/{boardIdx}")
    public Board getBoardDetail(@PathVariable Long boardIdx) {
    	Board result = null;
    	result = boardService.getBoardDetail(boardIdx);
    	
        return result;
    }
    
    // 게시글 리스트 조회(목록)
    @GetMapping("board")
    public List<Board> getBoardList() {
    	List<Board> result = null;
    	result = boardService.getBoardList();
    	
        return result;
    }
    
    // 게시글 삭제
    @DeleteMapping("board/{boardIdx}")
    public boolean deleteBoard(@RequestHeader("Authorization") String token, @PathVariable Long boardIdx){
        boolean result = false;
        Map<String, Object> claimMap;
		Users user = null;
		
		try {
			claimMap = JWT.verifyJWT(token);
			user = userService.getUser(claimMap, Long.parseLong(String.valueOf(claimMap.get("user_idx"))));
			result = boardService.deleteBoard(user, boardIdx);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
    	return result;
    }
}
