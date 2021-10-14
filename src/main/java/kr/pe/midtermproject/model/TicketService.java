package kr.pe.midtermproject.model;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.pe.midtermproject.dao.SeatRepository;
import kr.pe.midtermproject.dao.TicketRepository;
import kr.pe.midtermproject.model.domain.Ticket;
import kr.pe.midtermproject.model.domain.Users;

@Service
public class TicketService {
	
	@Autowired
	private TicketRepository ticketDao;
	
	@Autowired
	private SeatRepository seatDao;
	
//	public Ticket checkTicket(Users user) {
//		Ticket ticket = user.getTicket();
//
//		LocalDate today = LocalDate.now();
//		int day = 1;
//		
//		// 티켓 추가시 잔여시간 확인 로직
//		if (ticket != null && (ticket.getLimit().isAfter(today) || ticket.getLimit().isEqual(today))) { // 주석
//			// 잔여시간이 남아있을경우
//		}else {
//			// 잔여시간이 없을경우
//			ticket.setLimit(today.plusDays(day).minusDays(1));
//		}
//		
//			
//		return null;
//	}
	
	public boolean createTicket(Long userIdx, int limit) {
		boolean result = false;
		LocalDate today = LocalDate.now();
		Ticket ticket = ticketDao.findTicketByUser(userIdx);
		
		// 티켓 추가시 잔여시간 확인 로직
		if (ticket != null && (ticket.getLimit().isAfter(today) || ticket.getLimit().isEqual(today))) {
			// 잔여시간이 남아있을경우
			ticket.setLimit(ticket.getLimit().plusDays(limit).minusDays(1));
			result = true;
		}else {
			// 잔여시간이 없을경우
			ticket.setLimit(today.plusDays(limit).minusDays(1));
			result = true;
		}
		
		return result;
	}
}
 