package kr.pe.midtermproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import kr.pe.midtermproject.dao.SeatRepository;
import kr.pe.midtermproject.dao.TicketRepository;

@RestController
public class Controller {
	
	@Autowired
	private SeatRepository seatDao;

	@Autowired
	private TicketRepository ticketDao;
	
}
