package kr.pe.midtermproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.pe.midtermproject.model.TicketService;
import kr.pe.midtermproject.model.UsersService;
import kr.pe.midtermproject.model.domain.Users;
import kr.pe.midtermproject.model.domain.UsersDTO;

@RestController
public class Controller {
	
	@Autowired
	private UsersService userService;
	
	@Autowired
	private TicketService ticketService;

	//회원가입
	@PostMapping("join")
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
	@PostMapping("login")
	public Users login(@RequestBody Users user) {
		boolean result = userService.login(user.getUserId(), user.getUserPw());
		System.out.println(result);
		Users u = null;
		
		if(result == true) {
			u = userService.findById(user.getUserId());
		}
		
		return u;
	}
	
	@GetMapping("user/{user_idx}")
	public Users userInfo(int user_idx) {
		return null;
	}
	
	// userId중복확인
	@PostMapping("checkedid")
	public boolean checkedUserId(@RequestBody String userId){
		boolean result = userService.checkedUserId(userId);
		
		return result;
	}
	
	//userId로 정보수정
	@PutMapping("user/{user_idx}")
	public void updateUser(@PathVariable Long user_idx, @RequestBody Users reqUser) {
		boolean result = userService.updateUser(user_idx, reqUser);
		System.out.println(result);
	}
	
	//userId로 삭제하기
	@DeleteMapping("user/{user_idx}")
	public void deleteUser(@PathVariable Long user_idx) {
		boolean result = userService.deleteUser(user_idx);
		System.out.println(result);
	}

}
