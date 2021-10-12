package kr.pe.midtermproject.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.pe.midtermproject.dao.UserRepository;
import kr.pe.midtermproject.model.domain.Users;

@Service
public class UsersService {

	@Autowired
	private UserRepository dao;

	// 회원가입
	public boolean addUsers(Users user) {
		boolean result = false;
		System.out.println(user);
		try {
			if (user.getIsAdmin() == null) {
				user.setIsAdmin("0");
				dao.save(user);
			}
			result = true;
		}catch (Exception e) {
			e.printStackTrace();
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
