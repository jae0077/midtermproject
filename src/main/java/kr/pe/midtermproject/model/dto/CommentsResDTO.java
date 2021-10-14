package kr.pe.midtermproject.model.dto;

import java.time.LocalDate;

import kr.pe.midtermproject.model.domain.Comments;
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
public class CommentsResDTO {
	private Long boardId;
	private String writer;
	private String content;
	private LocalDate created;
	
	public CommentsResDTO(Comments entity) {
		this.boardId = entity.getBoard().getBoardIdx();
        this.writer = entity.getWriter().getName();
        this.content = entity.getContent();
        this.created = entity.getCreated();
    }
}
