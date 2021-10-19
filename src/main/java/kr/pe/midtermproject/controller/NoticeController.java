package kr.pe.midtermproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import kr.pe.midtermproject.model.NoticeService;
import kr.pe.midtermproject.model.domain.Notice;

@RestController
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
  	// 공지 디테일
	@ApiOperation(value = "공지게시판 게시글 상세 조회", notes = "공지게시판 1개 게시글 조회 API")
  	@GetMapping("notice/{noticeIdx}")
    public Notice getNoticeDetail(@PathVariable Long noticeIdx) {
  		Notice result = null;
    	result = noticeService.getNoticeDetail(noticeIdx);
    	
        return result;
    }
  	
  	// 공지 전체 조회(목록)
	@ApiOperation(value = "공지게시판 게시글 리스트 조회", notes = "공지게시판 게시글 전체 리스트 조회 API")
  	@GetMapping("notice")
  	public Page<Notice> getNoticeList(Pageable pageable) {
  		Page<Notice> result = null;
  		result = noticeService.getNoticeList(pageable);
  		
  		return result;
  	}
}
