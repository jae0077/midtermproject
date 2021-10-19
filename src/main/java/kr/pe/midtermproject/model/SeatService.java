package kr.pe.midtermproject.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.pe.midtermproject.dao.SeatRepository;
import kr.pe.midtermproject.dao.UserRepository;
import kr.pe.midtermproject.model.domain.Seat;
import kr.pe.midtermproject.model.domain.Users;
import kr.pe.midtermproject.model.dto.SeatDTO;

@Service
public class SeatService {
	
	@Autowired
	private SeatRepository seatDao;
	
	@Autowired
	private UserRepository userDao;
	
	public boolean selectSeat(Users user, SeatDTO seatDTO) {
		boolean result = false;
		Seat seat = null;
		try {
			seat = seatDao.findById(seatDTO.getSeatIdx()).get();
			
			boolean isUsed = seat.getIsUsed().equals("0");
			
			if (user.getSeat() == null && isUsed) {
				user.setSeat(seat);
				seat.setIsUsed("1");
				userDao.save(user);
				seatDao.save(seat);
				result = true;
			
			}else if (user.getSeat() != null && isUsed) {
				Seat usedSeat = user.getSeat();
				user.setSeat(seat);
				usedSeat.setIsUsed("0");
				seat.setIsUsed("1");
				
				userDao.save(user);
				seatDao.save(usedSeat);
				seatDao.save(seat);
				result = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean checkoutSeat(Users user) {
		boolean result = false;
		
		try {
			if (user.getSeat() != null) {
				Seat seat = user.getSeat();
				user.setSeat(null);
				seat.setIsUsed("0");
				userDao.save(user);
				seatDao.save(seat);
				result = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<Seat> getSeatList(){
		return (List<Seat>) seatDao.findAllByOrderBySeatIdxAsc();
	}
	
	public int getRemainSeat() {
		return seatDao.findSeatByIsUsed("0").size();
	}
	
	public boolean checkSeat(Long seat_idx) {
		boolean result = false;
		Seat seat = new Seat();
		
		try {
			seat = seatDao.findById(seat_idx).get();
			
			if(seat.getIsUsed().equals("1")) {
				result = true;
			}
		}catch(Exception e) {
			
		}
		
		return result;
	}
}
