package kr.pe.midtermproject.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import kr.pe.midtermproject.model.domain.Users;

//상수, 주석, 미완성메소드 - 스펙
/* Spring Data JPA는 개발자도 interface로 개발
 * 내부적으로 선언한 메소드의 명명규칙에 맞게 완벽한 구현체를 생성 후에 실행하는 원리
 * 
 * * 사용자 정의 검색 및 메소드 구현 스펙[쿼리메소드]
 * 1. 네이밍 rule
 * 		find엔티티명By변수명 or findBy변수명
 */
public interface UserRepository extends CrudRepository<Users, Long>{

	//select * from book where title=?
	//동일한 메소드명 findByTitle
//	List<User> findBookByTitle(String title);
	
	//특정 title이 포함된 게시물 검색
	//select * from book where title like '%?%'
//	List<User> findBookByTitleContaining(String title);
	
//	User findBookBySeq(Long id);
	// 회원등록 쿼리
	
	
	// 로그인 쿼리
	
}
