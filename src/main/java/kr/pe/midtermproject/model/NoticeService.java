package kr.pe.midtermproject.model;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.pe.midtermproject.dao.NoticeRepository;
import kr.pe.midtermproject.model.domain.Notice;

@Service
public class NoticeService {

	@Autowired
	private NoticeRepository noticeDao;

	//공지 상세 조회
	@Transactional(rollbackOn = Exception.class)
	public Notice getNoticeDetail(Long noticeIdx) {
		Notice result = null;
		try {
			result = noticeDao.findById(noticeIdx).get();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//공지 전체 조회
	public List<Notice> getNoticeList() {
		
		List<Notice>result = null;
		try {
			result = noticeDao.findAllByOrderByNoticeIdxDesc();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
