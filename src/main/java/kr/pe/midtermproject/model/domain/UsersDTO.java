package kr.pe.midtermproject.model.domain;

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
	private Long userIdx;
	private String userId;
	private String oldPw;
	private String newPw;
	private String name;
	private String phone;
	private String isAdmin;
}
