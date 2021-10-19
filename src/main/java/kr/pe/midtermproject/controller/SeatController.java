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

import io.swagger.annotations.ApiOperation;
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
	
	@ApiOperation(value = "좌석선택 및 변경", notes = "좌석선택 및 변경 API, 'isUsed':null")
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
	
	@ApiOperation(value = "좌석 퇴실", notes = "좌석 가지고 있을 때, 퇴실 API")
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
	
	@ApiOperation(value = "좌석 전체목록 불러오기", notes = "좌석표 출력할 때 사용하는 API")
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
	
	@GetMapping("seat1")
	public List<Seat> getSeatList1(){
		return seatService.getSeatList();
	}
	
	@ApiOperation(value = "잔여 좌석 갯수 확인", notes = "좌석표 출력할 때 사용하는 API")
	@GetMapping("seat/remain")
	public int remainSeat() {
		return seatService.getRemainSeat();
	}
	
	@ApiOperation(value = "잔여 좌석 갯수 확인", notes = "좌석표 출력할 때 사용하는 API")
	@GetMapping("seat/check/{seat_idx}")
	public boolean checkSeat(@PathVariable Long seat_idx) {
		return seatService.checkSeat(seat_idx);
	}
}
