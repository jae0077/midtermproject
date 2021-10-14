package kr.pe.midtermproject.model;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.pe.midtermproject.dao.SeatRepository;
import kr.pe.midtermproject.dao.TicketRepository;
import kr.pe.midtermproject.dao.UserRepository;
import kr.pe.midtermproject.model.domain.Ticket;
import kr.pe.midtermproject.model.domain.Users;

@Service
public class TicketService {
	
	@Autowired
	private TicketRepository ticketDao;
	
	@Autowired
	private SeatRepository seatDao;

	// 이용권 구매
	public boolean createTicket(Users user, int limit) {
		boolean result = false;
		LocalDate today = LocalDate.now();
		Ticket ticket = ticketDao.findTicketByUser(user);
		// 티켓 추가시 잔여시간 확인 로직
		if (ticket != null && (ticket.getLimit().isAfter(today) || ticket.getLimit().isEqual(today))) {
			// 잔여시간이 남아있을경우
			ticket.setLimit(ticket.getLimit().plusDays(limit));
		}else if (ticket == null) {
			ticket = new Ticket();
			ticket.setUser(user);
			ticket.setLimit(today.plusDays(limit).minusDays(1));
		}else {
			// 잔여시간이 없을경우
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
	
	// 잔여시간 확인
	public LocalDate SearchByticketLimit(Users user) {
		LocalDate today = LocalDate.now();
		Ticket ticket = ticketDao.findTicketByUser(user);
		LocalDate result = null;
		if (ticket != null && (ticket.getLimit().isAfter(today) || ticket.getLimit().isEqual(today))) {
			result = ticket.getLimit();
		}
		return result;
	}
}
 