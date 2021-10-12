package kr.pe.midtermproject.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.pe.midtermproject.dao.SeatRepository;
import kr.pe.midtermproject.dao.TicketRepository;

@Service
public class TicketService {
	
	@Autowired
	private TicketRepository ticketDao;
	
	@Autowired
	private SeatRepository seatDao;
}
