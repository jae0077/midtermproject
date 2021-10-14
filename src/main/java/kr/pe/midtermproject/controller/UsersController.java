package kr.pe.midtermproject.controller;

import java.io.UnsupportedEncodingException;
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

import kr.pe.midtermproject.model.JWT;
import kr.pe.midtermproject.model.UsersService;
import kr.pe.midtermproject.model.domain.Users;
import kr.pe.midtermproject.model.dto.UsersDTO;

@RestController
public class UsersController {
	
	@Autowired
	private UsersService userService;
	
	@Autowired
	private JWT JWT;
	
	//회원가입
	@PostMapping("user/join")
	public boolean createUser(@RequestBody Users user) {
		boolean check = userService.verifyUserId(user.getUserId());
		boolean result = false;
		
		if(!check) {
			result = userService.createUser(user);
			result = true;
		}
		
		return result;
	}

	// 로그인
	@PostMapping("/login")
	public String login(@RequestBody Users reqUser) {
		Users user = userService.login(reqUser.getUserId(), reqUser.getUserPw());
		String token = null; 
		if (user != null) {
			token = JWT.createToken(user);
		}
		
		return token;
	}

	// 유저 정보
	@GetMapping("user/{userIdx}")
	public Users getUserDetail(@RequestHeader("Authorization") String token, @PathVariable Long userIdx) {
		Map<String, Object> claimMap;
		Users result = null;
		try {
			claimMap = JWT.verifyJWT(token);
			result = userService.getUser(claimMap, userIdx);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// userId중복확인
	@PostMapping("user/verifyid")
	public boolean verifyUserId(@RequestBody UsersDTO reqUser){
		return userService.verifyUserId(reqUser.getUserId());
	}
	
	//userId로 정보수정
	@PutMapping("user/{userIdx}")
	public boolean updateUser(@RequestHeader("Authorization") String token, @PathVariable Long userIdx, @RequestBody UsersDTO reqUser) {
		Map<String, Object> claimMap;
		Users user = null;
		try {
			claimMap = JWT.verifyJWT(token);
			user = userService.getUser(claimMap, userIdx);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return userService.updateUser(user, reqUser);
	}
	
	//userId로 삭제하기
	@DeleteMapping("user/{userIdx}")
	public boolean deleteUser(@RequestHeader("Authorization") String token, @PathVariable Long userIdx) {
		Map<String, Object> claimMap;
		Users user = null;
		try {
			claimMap = JWT.verifyJWT(token);
			user = userService.getUser(claimMap, userIdx);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return userService.deleteUser(user);
	}
}
