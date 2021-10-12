package kr.pe.midtermproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.pe.midtermproject.model.Service2;
import kr.pe.midtermproject.dao.SeatRepository;
import kr.pe.midtermproject.dao.TicketRepository;

/* html -> Controller -> Service -> DAO ...
 * 
 */

@RestController
public class Controller {
	
	@Autowired
	private Service2 ser;
	
	@Autowired
	private SeatRepository seatDao;

	@Autowired
	private TicketRepository ticketDao;
  
	//회원가입
	@PostMapping("addUsers")
	public void addUsers(Long seq, String userId, String pw, String name, String phone) {
		boolean result = ser.addUsers(seq, userId, pw, name, phone);
		System.out.println(result);
	}
	
	@PostMapping("addUsers2")
	public boolean addUsers2() {
		boolean result = ser.addUsers2();
		return result;
	}
	
	//로그인
	@GetMapping("login")
	public void login(String userId, String pw) {
		boolean result = ser.login(userId, pw);
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
