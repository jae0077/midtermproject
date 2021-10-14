package kr.pe.midtermproject.model;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.pe.midtermproject.dao.NoticeRepository;
import kr.pe.midtermproject.model.domain.Notice;
import kr.pe.midtermproject.model.dto.NoticeDTO;
import kr.pe.midtermproject.model.dto.NoticeResDTO;

@Service
public class NoticeService {

	@Autowired
	private NoticeRepository noticeRepo;

	//공지 작성
	@Transactional(rollbackOn = Exception.class)
	public Notice createNotice(NoticeDTO noticeDTO) {
		
		return noticeRepo.save(new Notice(null, noticeDTO.getTitle(), noticeDTO.getContent(), LocalDate.now()));
	}

	//공지 수정
	@Transactional(rollbackOn = Exception.class)
	public Notice updateNotice(Long id, NoticeDTO noticeDTO) {
		Notice notice = noticeRepo.findById(id).orElseThrow(() 
				-> new IllegalArgumentException("해당 공지글이 존재하지 않습니다."));
		
		notice.setTitle(noticeDTO.getTitle());
		notice.setContent(noticeDTO.getContent());
		
		return notice;
	}
	
	//공지 1개 조회
	@Transactional(rollbackOn = Exception.class)
	public NoticeResDTO searchByNoticeId(Long id) {
		Notice notice = noticeRepo.findById(id).orElseThrow(() 
				-> new IllegalArgumentException("해당 공지글이 존재하지 않습니다."));
		
		return new NoticeResDTO(notice);
	}
	
	//공지 전체 조회
	public List<NoticeResDTO> searchAllNoticeDesc() {
		
		return noticeRepo.findAllByOrderByNoticeIdxDesc().stream()
                .map(NoticeResDTO::new)
                .collect(Collectors.toList());
	}
	

	//공지 삭제
	@Transactional(rollbackOn = Exception.class)
	public void createNotice(Long id) {
		Notice notice = noticeRepo.findById(id).orElseThrow(() 
				-> new IllegalArgumentException("해당 공지글이 존재하지 않습니다."));
		
		noticeRepo.delete(notice);
	}


	
}
