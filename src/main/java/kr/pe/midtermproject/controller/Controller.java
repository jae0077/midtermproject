package kr.pe.midtermproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.pe.midtermproject.model.Service2;

/* html -> Controller -> Service -> DAO ...
 * 
 */

@RestController
public class Controller {
	
	@Autowired
	private Service2 ser;
	
	//회원가입
	@PostMapping("addUsers")
	public void addUsers(HttpServletRequest request, HttpServletResponse response) {
		boolean result = ser.addUsers(request.getParameter("id"), request.getParameter("pw"), request.getParameter("name"), request.getParameter("phone"));
		System.out.println(result);
	}
	
	@PostMapping("addUsers2")
	public boolean addUsers2() {
		boolean result = ser.addUsers2();
		return result;
	}
	
	//로그인
	@PostMapping("login")
	public void login(HttpServletRequest request, HttpServletResponse response) {
		boolean result = ser.login(request.getParameter("id"), request.getParameter("pw"));
		System.out.println(result);
	}
	
	//userId로 정보수정
	@PutMapping("update")
	public void update(String userId, String pw, String pw2, String name, String phone) {
		boolean result = ser.update(userId, pw, pw2, name, phone);
		System.out.println(result);
	}
	
	//userId로 삭제하기
	@DeleteMapping("delete")
	public void delete(String userId) {
		boolean result = ser.delete(userId);
		System.out.println(result);
	}
}
