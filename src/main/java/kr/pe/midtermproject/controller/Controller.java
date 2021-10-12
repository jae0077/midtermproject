package kr.pe.midtermproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.pe.midtermproject.model.TicketService;
import kr.pe.midtermproject.model.UsersService;
import kr.pe.midtermproject.model.domain.Users;

@RestController
public class Controller {
	
	@Autowired
	private UsersService userService;
	
	@Autowired
	private TicketService ticketService;

	//회원가입
	@PostMapping("join")
	public boolean createUser(@RequestBody Users user) {
		boolean result = userService.addUsers(user);
		System.out.println(result);
		
		return result;
	}

	//로그인
	@PostMapping("login")
	public void login(HttpServletRequest request, HttpServletResponse response) {
		boolean result = userService.login(request.getParameter("id"), request.getParameter("pw"));
		System.out.println(result);
		
//		return token
	}
	
	@GetMapping("user/{user_idx}")
	public Users userInfo(int user_idx) {
		return null;
	}
	
	//userId로 정보수정
	@PutMapping("user/{user_idx}")
	public void updateUser(String userId, String pw, String pw2, String name, String phone) {
		boolean result = userService.update(userId, pw, pw2, name, phone);
		System.out.println(result);
	}
	
	//userId로 삭제하기
	@DeleteMapping("user/{user_idx}")
	public void delete(String userId) {
		boolean result = userService.delete(userId);
		System.out.println(result);
	}

}
