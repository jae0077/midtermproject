package kr.pe.midtermproject.dao;

import org.springframework.data.repository.CrudRepository;

import kr.pe.midtermproject.model.domain.Notice;

public interface NoticeRepository extends CrudRepository<Notice, Long>{
	
}
