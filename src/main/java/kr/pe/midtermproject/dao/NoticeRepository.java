package kr.pe.midtermproject.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import kr.pe.midtermproject.model.domain.Notice;

public interface NoticeRepository extends CrudRepository<Notice, Long>, PagingAndSortingRepository<Notice, Long> {

}
