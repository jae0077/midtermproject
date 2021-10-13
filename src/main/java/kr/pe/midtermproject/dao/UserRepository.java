package kr.pe.midtermproject.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import kr.pe.midtermproject.model.domain.Users;

public interface UserRepository extends CrudRepository<Users, Long>{
	// 해당 아이디의 정보 가져오기
	Users findUsersByUserId(String userId);
	
	List<Users> findAllUsersByUserId(String userId);
	
	// 로그인용 id pw 확인
	Users findUsersByUserIdAndUserPw(String userId, String userPw);
}
