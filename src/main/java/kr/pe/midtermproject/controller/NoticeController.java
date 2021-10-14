package kr.pe.midtermproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import kr.pe.midtermproject.model.NoticeService;
import kr.pe.midtermproject.model.domain.Notice;

@RestController
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
  	// 공지 디테일
  	@GetMapping("notice/{noticeIdx}")
    public Notice getNoticeDetail(@PathVariable Long noticeIdx) {
  		Notice result = null;
    	result = noticeService.getNoticeDetail(noticeIdx);
    	
        return result;
    }
  	
  	// 공지 전체 조회(목록)
  	@GetMapping("notice")
    public List<Notice> searchAllNoticeDesc() {
  		List<Notice> result = null;
    	result = noticeService.getNoticeList();
    	
        return result;
    }
}
