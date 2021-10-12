package kr.pe.midtermproject.dao;

import org.springframework.data.repository.CrudRepository;

import kr.pe.midtermproject.model.domain.Comments;

public interface NoticeRepository extends CrudRepository<Comments, Long>{
	
}
