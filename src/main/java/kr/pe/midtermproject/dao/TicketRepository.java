package kr.pe.midtermproject.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import kr.pe.midtermproject.model.domain.Ticket;
import kr.pe.midtermproject.model.domain.Users;

public interface TicketRepository extends CrudRepository<Ticket, Long>{
	
	//select * from Ticket where title=?
	//동일한 메소드명 fildByTitle
	List<Ticket> findTicketByTicketIdx(int ticketIdx);
	
	Ticket findTicketByUser(Users user);

}
