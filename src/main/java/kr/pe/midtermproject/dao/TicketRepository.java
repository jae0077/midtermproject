package kr.pe.midtermproject.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import kr.pe.midtermproject.model.domain.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, Integer>{
	
	//select * from Ticket where title=?
	//동일한 메소드명 fildByTitle
	List<Ticket> findTicketByTitle(int ticketId);

}
