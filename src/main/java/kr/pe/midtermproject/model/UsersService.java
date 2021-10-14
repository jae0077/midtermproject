package kr.pe.midtermproject.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.pe.midtermproject.dao.UserRepository;
import kr.pe.midtermproject.model.domain.Users;

@Service
public class UsersService {

	@Autowired
	private UserRepository userDao;

	// 회원가입
	public boolean createUser(Users user) {
		boolean result = false;

		try {
			if (user.getIsAdmin() == null) {
				user.setIsAdmin("0");
				userDao.save(user);
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
		Users user = userDao.findUsersByUserId(userId);

		if (user != null && user.getUserPw().equals(pw)) {
			result = true;
		}

		return result;
	}

	// userId로 users정보 가져오기
	public Users findById(String userId) {
		Users user = userDao.findUsersByUserId(userId);

		return user;
	}
	
	// 해당 userId가 존재하는지 확인
	public boolean checkedUserId(String userId){
		boolean result = false;
		Users users = userDao.findUsersByUserId(userId);
		
		if(users != null) {
			result = true;
		}
		
		return result;
	}

	
	// userId로 정보수정하기
	public boolean updateUser(Long user_idx, Users reqUser) {
		boolean result = false;
		Users user = userDao.findById(user_idx).get();

		try {
			user.setUserPw(reqUser.getUserPw());
			user.setName(reqUser.getName());
			user.setPhone(reqUser.getPhone());
			userDao.save(user);
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	// userId로 삭제하기
	public boolean deleteUser(Long user_idx) {
		boolean result = false;
		Users user = userDao.findById(user_idx).get();

		if (user != null) {
			userDao.delete(user);
			result = true;
		}

		return result;
	}
}
