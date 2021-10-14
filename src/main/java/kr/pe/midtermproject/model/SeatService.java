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
	
	//좌석선택
	public boolean selectSeat(Users user, SeatDTO seatDTO) {
		boolean result = false;
		Seat seat = null;
		
		try {
			seat = seatDao.findById(seatDTO.getSeatIdx()).get();
			
			boolean isUsed = seat.getIsUsed().equals("0");
			
			// 좌석 선택
			if (user.getSeat() == null && isUsed) {
				user.setSeat(seat);
				seat.setIsUsed("1");
				userDao.save(user);
				seatDao.save(seat);
				result = true;
			
			// 좌석 변경
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
	
	// 퇴실
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
	
	// 좌석리스트
	public List<Seat> getSeatList(){
		return (List<Seat>) seatDao.findAllByOrderBySeatIdxAsc();
	}
	
	// 잔여 좌석 개수
	public int getRemainSeat() {
		return seatDao.findSeatByIsUsed("0").size();
	}
	
//	//user가 좌석을 선택했는지
//	public boolean checkSeatSelect(String userId) {
//		boolean result = false;
//		Users user = userDao.findUsersByUserId(userId);
//		
//		if(user.getSeat() != null) {
//			result = true;
//		}
//		
//		return result;
//	}
//	
//	//좌석번호로 사용중인지 확인
//	public boolean checkSeat(Long seat_idx) {
//		boolean result = false;
//		Seat seat = new Seat();
//		
//		try {
//			seat = seatDao.findById(seat_idx).get();
//			
//			if(seat.getIsUsed().equals("1")) {
//				result = true;
//			}
//		}catch(Exception e) {
//			
//		}
//		
//		return result;
//	}
}
