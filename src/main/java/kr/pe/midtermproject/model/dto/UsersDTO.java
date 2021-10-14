package kr.pe.midtermproject.model.dto;

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
public class UsersDTO {
	private String userId;
	private String userPw;
	private String name;
	private String phone;
}
