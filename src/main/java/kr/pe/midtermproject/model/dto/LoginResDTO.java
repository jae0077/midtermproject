package kr.pe.midtermproject.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class LoginResDTO {
	private String token;
	private Long userIdx;
	private String name;
	
}
