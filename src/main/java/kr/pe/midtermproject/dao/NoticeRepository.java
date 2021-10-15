package kr.pe.midtermproject.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import kr.pe.midtermproject.model.domain.Notice;

public interface NoticeRepository extends CrudRepository<Notice, Long>, PagingAndSortingRepository<Notice, Long>{

	// 공지사항 역순 정렬
	List<Notice> findAllByOrderByNoticeIdxDesc();
	
}
