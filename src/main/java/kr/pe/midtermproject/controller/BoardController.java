package kr.pe.midtermproject.controller;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
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
	@ApiOperation(value = "자유게시판 게시글 작성", notes = "자유게시판 게시글 작성 API")
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
	@ApiOperation(value = "자유게시판 게시글 수정", notes = "자유게시판 게시글 수정 API - 작성자에 한함")
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
	@ApiOperation(value = "자유게시판 게시글 상세 조회", notes = "자유게시판 1개 게시글 조회 API")
    @GetMapping("board/{boardIdx}")
    public Board getBoardDetail(@PathVariable Long boardIdx) {
    	Board result = null;
    	result = boardService.getBoardDetail(boardIdx);
    	System.out.println(result);
        return result;
    }
    
    // 게시글 리스트 조회(목록)
	@ApiOperation(value = "자유게시판 게시글 리스트 조회", notes = "자유게시판 게시글 전체 리스트 조회 API")
    @GetMapping("board")
    public Page<Board> getBoardList(Pageable pageable) {
    	Page<Board> result = null;
    	result = boardService.getBoardList(pageable);
    	
        return result;
    }
    
    // 게시글 삭제
	@ApiOperation(value = "자유게시판 게시글 삭제", notes = "자유게시판 게시글 삭제 API - 작성자에 한함")
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
