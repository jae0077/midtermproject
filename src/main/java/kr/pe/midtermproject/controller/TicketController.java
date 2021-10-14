package kr.pe.midtermproject.controller;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import kr.pe.midtermproject.model.JWT;
import kr.pe.midtermproject.model.TicketService;
import kr.pe.midtermproject.model.UsersService;
import kr.pe.midtermproject.model.domain.Users;
import kr.pe.midtermproject.model.dto.TicketDTO;

@RestController
public class TicketController {
	
	@Autowired
	private UsersService userService;
	
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private JWT JWT;
	
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
	public LocalDate getTicketDetail(@RequestHeader("Authorization") String token) {
		LocalDate result = null;
		Map<String, Object> claimMap;
		try {
			claimMap = JWT.verifyJWT(token);
			if (claimMap != null) {
				if (claimMap != null) {
					Users user = userService.getUser(claimMap, Long.parseLong(String.valueOf(claimMap.get("user_idx"))));
					result = ticketService.getTicketDetail(user);	
				}
			}
		} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
		}
		return result;
	}
}
