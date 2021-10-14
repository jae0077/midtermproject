package kr.pe.midtermproject.model.dto;

import kr.pe.midtermproject.model.domain.Users;
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
public class BoardDTO {
	private Users writer;
	private String title;
	private String content;
}
