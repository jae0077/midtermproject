package kr.pe.midtermproject.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.pe.midtermproject.dao.UserRepository;
import kr.pe.midtermproject.model.domain.Users;

@Service
public class Service2 {

	@Autowired
	private UserRepository dao;

	// 회원가입
	
	public boolean addUsers(Long seq, String userId, String pw, String name, String phone) {
		boolean result = false;
		Users user = dao.findUsersByUserId(userId);

		if (user == null) {
			dao.save(new Users(seq, userId, pw, name, phone, "0"));
			result = true;
		}

		return result;
	}
	
	
	public boolean addUsers2() {
		boolean result = false;
		Long i = (long) 2;
		Users user = new Users(i, "userId", "userPw", "name", "phone", "0");
		System.out.println(user);

		if(dao == null) {
			System.out.println("null");
		}else {
			
			dao.save(user);
		}
		
		return result;
	}

	// 로그인
	
	public boolean login(String userId, String pw) {
		boolean result = false;
		Users user = dao.findUsersByUserId(userId);

		if (user != null && user.getUserPw().equals(pw)) {
			result = true;
		}

		return result;
	}

	// userId로 users정보 가져오기
	
	public Users findById(String userId) {
		Users user = dao.findUsersByUserId(userId);

		return user;
	}

	
	// userId로 정보수정하기
	public boolean update(String userId, String pw, String pw2, String name, String phone) {
		boolean result = false;
		Users user = dao.findUsersByUserId(userId);

		if (user.getUserPw().equals(pw)) {
			user.setUserPw(pw2);
			user.setName(name);
			user.setPhone(phone);
			dao.save(user);
			result = true;
		}

		return result;
	}

	// userId로 삭제하기
	
	public boolean delete(String userId) {
		boolean result = false;
		Users user = dao.findUsersByUserId(userId);

		if (user != null) {
			dao.delete(user);
			result = true;
		}

		return result;
	}
}
