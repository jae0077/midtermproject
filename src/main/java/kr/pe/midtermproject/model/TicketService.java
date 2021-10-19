package kr.pe.midtermproject.model;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.pe.midtermproject.dao.TicketRepository;
import kr.pe.midtermproject.model.domain.Ticket;
import kr.pe.midtermproject.model.domain.Users;

@Service
public class TicketService {
	
	@Autowired
	private TicketRepository ticketDao;

	public boolean createTicket(Users user, int limit) {
		boolean result = false;
		LocalDate today = LocalDate.now();
		Ticket ticket = ticketDao.findTicketByUser(user);

		if (ticket != null && (ticket.getLimit().isAfter(today) || ticket.getLimit().isEqual(today))) {
			ticket.setLimit(ticket.getLimit().plusDays(limit));
		}else if (ticket == null) {
			ticket = new Ticket();
			ticket.setUser(user);
			ticket.setLimit(today.plusDays(limit).minusDays(1));
		}else {
			ticket.setLimit(today.plusDays(limit).minusDays(1));
		}
		
		try {
			ticketDao.save(ticket);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public LocalDate getTicketDetail(Users user) {
		LocalDate today = LocalDate.now();
		Ticket ticket = ticketDao.findTicketByUser(user);
		LocalDate result = null;
		if (ticket != null && (ticket.getLimit().isAfter(today) || ticket.getLimit().isEqual(today))) {
			result = ticket.getLimit();
		}
		return result;
	}
}
 