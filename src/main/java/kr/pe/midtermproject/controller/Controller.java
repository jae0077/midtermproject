package kr.pe.midtermproject.controller;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
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

import kr.pe.midtermproject.model.NoticeService;
import kr.pe.midtermproject.model.SeatService;
import kr.pe.midtermproject.model.TicketService;
import kr.pe.midtermproject.model.UsersService;
import kr.pe.midtermproject.model.domain.Board;
import kr.pe.midtermproject.model.domain.Notice;
import kr.pe.midtermproject.model.domain.Seat;
import kr.pe.midtermproject.model.domain.Ticket;
import kr.pe.midtermproject.model.domain.Users;
import kr.pe.midtermproject.model.dto.BoardDTO;
import kr.pe.midtermproject.model.dto.BoardResDTO;
import kr.pe.midtermproject.model.dto.TicketDTO;
import kr.pe.midtermproject.model.dto.CommentsDTO;
import kr.pe.midtermproject.model.dto.CommentsResDTO;
import kr.pe.midtermproject.model.dto.NoticeDTO;
import kr.pe.midtermproject.model.dto.NoticeResDTO;

@RestController
public class Controller {
	
	@Autowired
	private UsersService userService;
	
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private SeatService seatService;
  
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private CommentsService commentsService;
  
  @Autowired
	private JWT JWT;
	
	//회원가입
	@PostMapping("user/join")
	public boolean createUser(@RequestBody Users user) {
		boolean check = userService.checkedUserId(user.getUserId());
		boolean result = false;
		
		if(!check) {
			result = userService.createUser(user);
			System.out.println(result);
			result = true;
		}
		
		return result;
	}

	//로그인
	@PostMapping("/login")
	public String login(@RequestBody Users reqUser) {
		Users user = userService.login(reqUser.getUserId(), reqUser.getUserPw());
		System.out.println(user);
		String token = null; 
		if (user != null) {
			token = JWT.createToken(user);
	        System.out.println(token);
		}
		
		return token;
	}
  
//	@GetMapping("user/{userIdx}")
//	public Users userInfo(@PathVariable Long userIdx) {
//		Users result = null;
//		result = userService.getUser(userIdx);
//		return result;
//	}
	
	@GetMapping("user/info/{userIdx}")
	public Users userInfo(@RequestHeader("Authorization") String token, @PathVariable Long userIdx) {
		Map<String, Object> claimMap;
		Users result = null;
		try {
			// 토큰 검증 만료되었거나 문제가 있을시 null
			claimMap = JWT.verifyJWT(token);
			result = userService.getUser(claimMap, userIdx);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// userId중복확인
	@PostMapping("user/checkedid")
	public boolean checkedUserId(@RequestBody Users reqUser){
		return userService.checkedUserId(reqUser.getUserId());
	}
	
	//userId로 정보수정
	@PutMapping("user/{user_idx}")
	public boolean updateUser(@PathVariable Long user_idx, @RequestBody Users reqUser) {
		return userService.updateUser(user_idx, reqUser);
	}
	
	//userId로 삭제하기
	@DeleteMapping("user/{user_idx}")
	public boolean deleteUser(@PathVariable Long user_idx) {
		return userService.deleteUser(user_idx);
	}
	
	//좌석 선택
	@PostMapping("seat/{seat_idx}")
	public boolean seatSelect(@RequestBody Users reqUser, @PathVariable Long seat_idx) {
		return seatService.seatSelect(reqUser.getUserId(), seat_idx);
	}
	
	//좌석 변경
	@PutMapping("seat/{seat_idx}")
	public boolean seatChange(@RequestBody Users reqUser, @PathVariable Long seat_idx) {
		return seatService.seatChange(reqUser.getUserId(), seat_idx);
	}
	
	//퇴실
	@PutMapping("seat/checkout")
	public boolean checkout(@RequestBody Users reqUser) {
		return seatService.checkout(reqUser.getUserId());
	}
	
	//좌석 리스트
	@GetMapping("seat/all")
	public List<Seat> allSeat(){
		return seatService.allSeat();
	}
	
	//잔여 좌석 개수
	@GetMapping("seat/remain")
	public int remainSeat() {
		return seatService.remainSeat();
	}
	
	//user가 좌석을 선택했는지
	@GetMapping("seat")
	public boolean checkSeatSelect(@RequestBody Users reqUser) {
		return seatService.checkSeatSelect(reqUser.getUserId());
	}
	
	//좌석번호로 사용중인지 확인
	@GetMapping("seat/check/{seat_idx}")
	public boolean checkSeat(@PathVariable Long seat_idx) {
		return seatService.checkSeat(seat_idx);
	}
	
	//사용중인 좌석 or 사용하지 않는 좌석 리스트
	@GetMapping("seat/used/{isUsed}")
	public List<Seat> usedSeat(@PathVariable String isUsed){
		return seatService.usedSeat(isUsed);
	}
	
	//나중에 삭제할거
	@PostMapping("addseat")
	public void addSeat() {
		boolean result = seatService.addSeat();
		System.out.println(result);
	}
	
	//post 작성 POST board // 게시글 작성api
	@PostMapping("board")
	public Board createPost(@RequestBody BoardDTO board) {		
		
		return boardService.createBoard(board);
	}
	
	//post 수정
	@PutMapping("board/{id}")
	public Long updatePost(@PathVariable Long id, @RequestBody BoardDTO board) {
		
		return boardService.updateBoard(id, board);
	}
	
	 //post 개별 조회
    @GetMapping("board/{id}")
    public BoardResDTO searchByPostId(@PathVariable Long id) {
    	
        return boardService.searchByPostId(id);
    }
    
    //post 전체 조회(목록)
    @GetMapping("board")
    public List<BoardResDTO> searchAllPostDesc() {
    	
        return boardService.searchAllDesc();
    }
    
    //post 삭제
    @DeleteMapping("board/{id}")
    public void deletePost(@PathVariable Long id){
    	
        boardService.deletePost(id);
    }

    //notice 작성
  	@PostMapping("notice")
  	public Notice createNotice(@RequestBody NoticeDTO notice) {		
  		
  		return noticeService.createNotice(notice);
  	}
  	
  	//notice 수정
  	@PutMapping("notice/{id}")
	public Notice updateNotice(@PathVariable Long id, @RequestBody NoticeDTO notice) {
  		
		return noticeService.updateNotice(id, notice);
	}
  	
  	//notice 1개 조회
  	@GetMapping("notice/{id}")
    public NoticeResDTO searchByNoticeId(@PathVariable Long id) {
    	
        return noticeService.searchByNoticeId(id);
    }
  	
  	//notice 전체 조회(목록)
  	@GetMapping("notice")
    public List<NoticeResDTO> searchAllNoticeDesc() {
    	
        return noticeService.searchAllNoticeDesc();
    }
  	
  	//notice 삭제
    @DeleteMapping("notice/{id}")
    public void deleteNotice(@PathVariable Long id){
    	
    	noticeService.createNotice(id);
    }
    
    //코멘트 작성
    @PostMapping("comment")
  	public Boolean createComment(@RequestBody CommentsDTO comment) {		
  		
  		return commentsService.createComment(comment);
  	}
    
    //코멘트 
  	@PutMapping("comment/{id}")
  	public Boolean updateComment(@PathVariable Long id, @RequestBody CommentsDTO comment) {
  		
  		return commentsService.updateComment(id, comment);
  	}
    
    //코멘트 전체 조회 (post 별로)
  	@GetMapping("board/{boardId}/comment")
    public List<CommentsResDTO> searchCommentsDesc(@PathVariable Long boardId) {
    	
        return commentsService.searchCommentsDesc(boardId);
    }
    
    //코멘트 삭제
    @DeleteMapping("comment/{id}")
    public void deleteComment(@PathVariable Long id){
    	
    	commentsService.deleteComment(id);
    }

  // 이용권 구매
	@PostMapping("ticket")
	public boolean createTicket(@RequestHeader("Authorization") String token, @RequestBody TicketDTO ticket) {
		boolean result = false;
		Map<String, Object> claimMap;
		try {
			claimMap = JWT.verifyJWT(token);
			if (claimMap != null) {
				Users user = userService.getUser(claimMap, Long.parseLong(String.valueOf(claimMap.get("user_idx"))));
				result = ticketService.createTicket(user, ticket.getLimit());				
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	// 잔여시간
	@GetMapping("ticket/{user_idx}")
	public LocalDate SearchByticketLimit(@RequestHeader("Authorization") String token) {
		LocalDate result = null;
		Map<String, Object> claimMap;
		try {
			claimMap = JWT.verifyJWT(token);
			if (claimMap != null) {
				if (claimMap != null) {
					Users user = userService.getUser(claimMap, Long.parseLong(String.valueOf(claimMap.get("user_idx"))));
					result = ticketService.SearchByticketLimit(user);	
				}
			}
		} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
		}
			
		return result;
	}
}
