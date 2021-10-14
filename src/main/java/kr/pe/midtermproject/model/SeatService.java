package kr.pe.midtermproject.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.pe.midtermproject.dao.SeatRepository;
import kr.pe.midtermproject.dao.UserRepository;
import kr.pe.midtermproject.model.domain.Seat;
import kr.pe.midtermproject.model.domain.Users;

@Service
public class SeatService {
	
	@Autowired
	private SeatRepository seatDao;
	
	@Autowired
	private UserRepository userDao;
	
	//좌석선택
	public boolean seatSelect(String userId, Long seat_idx) {
		boolean result = false;
		Users user = userDao.findUsersByUserId(userId);
		Seat seat = new Seat();
		
		try {
			seat = seatDao.findById(seat_idx).get();
			
			if(user.getSeat() == null && seat.getIsUsed().equals("0")) {
				user.setSeat(seat);
				seat.setIsUsed("1");
				userDao.save(user);
				seatDao.save(seat);
				result = true;
			}
		}catch(Exception e) {
			
		}
		
		return result;
	}
	
	//좌석변경
	public boolean seatChange(String userId, Long seat_idx) {
		boolean result = false;
		Users user = userDao.findUsersByUserId(userId);
		Seat newSeat = new Seat();
		
		try {
			newSeat = seatDao.findById(seat_idx).get();
			
			if(user.getSeat() != null && newSeat.getIsUsed().equals("0")) {
				Seat oldSeat = user.getSeat();
				user.setSeat(newSeat);
				oldSeat.setIsUsed("0");
				newSeat.setIsUsed("1");
				userDao.save(user);
				seatDao.save(oldSeat);
				seatDao.save(newSeat);
				result = true;
			}
		}catch(Exception e) {
			
		}
		
		return result;
	}
	
	//퇴실
	public boolean checkout(String userId) {
		boolean result = false;
		Users user = userDao.findUsersByUserId(userId);
		
		try {
			Seat seat = user.getSeat();
			user.setSeat(null);
			seat.setIsUsed("0");
			userDao.save(user);
			seatDao.save(seat);
			result = true;
		}catch(Exception e) {
			
		}
		
		return result;
	}
	
	//좌석리스트
	public List<Seat> allSeat(){
		return (List<Seat>) seatDao.findAll();
	}
	
	//잔여 좌석 개수
	public int remainSeat() {
		return seatDao.findSeatByIsUsed("0").size();
	}
	
	//user가 좌석을 선택했는지
	public boolean checkSeatSelect(String userId) {
		boolean result = false;
		Users user = userDao.findUsersByUserId(userId);
		
		if(user.getSeat() != null) {
			result = true;
		}
		
		return result;
	}
	
	//좌석번호로 사용중인지 확인
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
	
	//사용중인 좌석 or 사용하지 않는 좌석 리스트
	public List<Seat> usedSeat(String isUsed){
		return seatDao.findSeatByIsUsed(isUsed);
	}
	
	//나중에 지울거
	public boolean addSeat() {
		boolean result = false;
		Seat seat = new Seat();
		
		try {
			seat.setIsUsed("0");
			seatDao.save(seat);
			result = true;
		}catch(Exception e) {
			
		}
		
		return result;
	}
}
