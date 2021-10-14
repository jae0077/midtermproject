package kr.pe.midtermproject.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import kr.pe.midtermproject.model.JWT;
import kr.pe.midtermproject.model.SeatService;
import kr.pe.midtermproject.model.TicketService;
import kr.pe.midtermproject.model.UsersService;
import kr.pe.midtermproject.model.domain.Seat;
import kr.pe.midtermproject.model.domain.Users;
import kr.pe.midtermproject.model.dto.SeatDTO;

@RestController
public class SeatController {
	
	@Autowired
	private SeatService seatService;
	
	@Autowired
	private UsersService userService;
	
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private JWT JWT;
	
	// 좌석선택 및 변경
	@PostMapping("seat")
	public boolean selectSeat(@RequestHeader("Authorization") String token, @RequestBody SeatDTO seat) {
		boolean result = false; 
		Map<String, Object> claimMap;
		Users user = null;
		try {
			claimMap = JWT.verifyJWT(token);
			user = userService.getUser(claimMap, Long.parseLong(String.valueOf(claimMap.get("user_idx"))));
			if (ticketService.getTicketDetail(user) != null) {
				result = seatService.selectSeat(user, seat);				
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//퇴실
	@PostMapping("seat/checkout")
	public boolean checkoutSeat(@RequestHeader("Authorization") String token) {
		boolean result = false; 
		Map<String, Object> claimMap;
		Users user = null;
		try {
			claimMap = JWT.verifyJWT(token);
			user = userService.getUser(claimMap, Long.parseLong(String.valueOf(claimMap.get("user_idx"))));
			result = seatService.checkoutSeat(user);
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result; 
	}
	
	// 좌석 리스트
	@GetMapping("seat")
	public List<Seat> getSeatList(@RequestHeader("Authorization") String token){
		List<Seat> result = null; 
		Map<String, Object> claimMap;
		Users user = null;
		try {
			claimMap = JWT.verifyJWT(token);
			user = userService.getUser(claimMap, Long.parseLong(String.valueOf(claimMap.get("user_idx"))));
			if (user != null ) {
				result = seatService.getSeatList();				
			}
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// 잔여 좌석 개수
	@GetMapping("seat/remain")
	public int remainSeat() {
		return seatService.getRemainSeat();
	}
	
	//user가 좌석을 선택했는지
//	@GetMapping("seat")
//	public boolean checkSeatSelect(@RequestBody Users reqUser) {
//		return seatService.checkSeatSelect(reqUser.getUserId());
//	}
	
//	//좌석번호로 사용중인지 확인
//	@GetMapping("seat/check/{seat_idx}")
//	public boolean checkSeat(@PathVariable Long seat_idx) {
//		return seatService.checkSeat(seat_idx);
//	}
}
