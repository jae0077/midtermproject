package kr.pe.midtermproject.model.dto;

import java.util.Date;

import kr.pe.midtermproject.model.domain.Board;
import kr.pe.midtermproject.model.domain.Notice;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class NoticeResDTO {
	private Long id;
	private String title;
	private String content;
	private Date created;
	
	public NoticeResDTO(Notice entity) {
        this.id = entity.getNoticeIdx();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.created = entity.getCreated();
    }
}
