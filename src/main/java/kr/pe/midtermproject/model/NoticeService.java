package kr.pe.midtermproject.model;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	
	// 공지 전체 조회
	public Page<Notice> getNoticeList(Pageable pageable) {
		Page<Notice> result = null;
		try {
			result = noticeDao.findAll(pageable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
