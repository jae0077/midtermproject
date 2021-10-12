package kr.pe.midtermproject.dao;

import org.springframework.data.repository.CrudRepository;

import kr.pe.midtermproject.model.domain.Notice;

public interface BoardRepository extends CrudRepository<Notice, Long>{
	
}
