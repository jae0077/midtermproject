package kr.pe.midtermproject.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import kr.pe.midtermproject.model.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long>, PagingAndSortingRepository<Board, Long>{

}
