package kr.pe.midtermproject.model.dto;

import java.util.List;

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
public class CommentsLengthDTO {
	private Long boardIdx;
	private List<Comments> commentsList;
}
