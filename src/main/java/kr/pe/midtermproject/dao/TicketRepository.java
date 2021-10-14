package kr.pe.midtermproject.dao;

import org.springframework.data.repository.CrudRepository;

import kr.pe.midtermproject.model.domain.Ticket;
import kr.pe.midtermproject.model.domain.Users;

public interface TicketRepository extends CrudRepository<Ticket, Long>{
	
	Ticket findTicketByUser(Users user);

}
