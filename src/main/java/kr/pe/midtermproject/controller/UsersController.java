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

import io.swagger.annotations.ApiOperation;
import kr.pe.midtermproject.model.JWT;
import kr.pe.midtermproject.model.SeatService;
import kr.pe.midtermproject.model.UsersService;
import kr.pe.midtermproject.model.domain.Users;
import kr.pe.midtermproject.model.dto.LoginResDTO;
import kr.pe.midtermproject.model.dto.UsersDTO;

@RestController
public class UsersController {
	
	@Autowired
	private UsersService userService;
	
	@Autowired
	private SeatService seatService;
	
	@Autowired
	private JWT JWT;
	
	@ApiOperation(value = "회원가입", notes = "회원가입 API")
	@PostMapping("user/join")
	public boolean createUser(@RequestBody Users user) {
		boolean result = false;
		
		try {
			result = userService.createUser(user);
					
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@ApiOperation(value = "로그인", notes = "로그인 API")
	@PostMapping("/login")
	public LoginResDTO login(@RequestBody Users reqUser) {
		Users user = userService.login(reqUser.getUserId(), reqUser.getUserPw());
		String token = null;
		LoginResDTO response = null;
		if (user != null) {
			token = JWT.createToken(user);
			response = new LoginResDTO();
			response.setUserIdx(user.getUserIdx());
			response.setName(user.getName());
			response.setToken(token);
		}
		return response;
	}

	@ApiOperation(value = "유저정보 출력", notes = "내 정보에서 출력하는 API")
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
		System.out.println(result);
		return result;
	}
	
	@ApiOperation(value = "ID중복 확인", notes = "회원가입 시 조건")
	@PostMapping("user/verifyid")
	public boolean verifyUserId(@RequestBody UsersDTO reqUser){
		return userService.verifyUserId(reqUser.getUserId());
	}
	
	@ApiOperation(value = "유저정보 UPDATE", notes = "내 정보 수정 API")
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
	
	@ApiOperation(value = "회원 탈퇴", notes = "내 정보에서 클릭 시 탈퇴 API")
	@DeleteMapping("user/{userIdx}")
	public boolean deleteUser(@RequestHeader("Authorization") String token, @PathVariable Long userIdx) {
		Map<String, Object> claimMap;
		Users user = null;
		boolean result = false;
		try {
			claimMap = JWT.verifyJWT(token);
			user = userService.getUser(claimMap, userIdx);

			if (user != null) {
				seatService.checkoutSeat(user);
				result = userService.deleteUser(user);					
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
}
