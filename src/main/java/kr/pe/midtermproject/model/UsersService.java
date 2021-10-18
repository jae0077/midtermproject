package kr.pe.midtermproject.model;

import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.pe.midtermproject.dao.TicketRepository;
import kr.pe.midtermproject.dao.UserRepository;
import kr.pe.midtermproject.model.domain.Ticket;
import kr.pe.midtermproject.model.domain.Users;
import kr.pe.midtermproject.model.dto.UsersDTO;

@Service
public class UsersService {

	@Autowired
	private UserRepository userDao;
	
	@Autowired
	private TicketRepository ticketDao;
	
	// 회원가입
	public boolean createUser(Users user) {
		boolean result = false;
		System.out.println(user + " ---------------------------------------");
		try {
			userDao.save(user);
			result = true;
		}catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
	// 로그인
	public Users login(String userId, String userPw) {
		Users user = userDao.findUsersByUserIdAndUserPw(userId, userPw);

		return user;
	}
	
	// 유저 정보
	public Users getUser(Map<String, Object> claimMap, Long userIdx) {
		Users result = null;
		if (Long.parseLong(String.valueOf(claimMap.get("user_idx"))) == userIdx) {
			result = userDao.findById(userIdx).get();
		}
		
		return result;
	}

	// 해당 userId가 존재하는지 확인
	public boolean verifyUserId(String userId){
		boolean result = false;
		Users users = userDao.findUsersByUserId(userId);
		if(users == null) {
			result = true;
		}
		return result;
	}

	// userId로 정보수정하기
	public boolean updateUser(Users user, UsersDTO reqUser) {
		boolean result = false;

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
	@Transactional(rollbackOn = Exception.class)
	public boolean deleteUser(Users user) {
		boolean result = false;

		if (user != null) {
			Ticket ticket = ticketDao.findTicketByUser(user);
			if (ticket != null) {
				ticketDao.delete(ticket);				
			}
			userDao.delete(user);
			result = true;
		}
		return result;
	}
}
