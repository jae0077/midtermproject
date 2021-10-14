package kr.pe.midtermproject.model.dto;

import java.time.LocalDate;

import kr.pe.midtermproject.model.domain.Board;
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
public class BoardResDTO {
	private Long id;
    private String writer;
    private String title;
    private String content;
    private LocalDate created;
    private LocalDate updated;
    
    public BoardResDTO(Board entity) {
        this.id = entity.getBoardIdx();
        this.writer = entity.getWriter().getName();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.created = entity.getCreated();
        this.updated = entity.getUpdated();
    }
}
