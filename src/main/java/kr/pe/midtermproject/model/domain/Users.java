package kr.pe.midtermproject.model.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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

//@SequenceGenerator(name="no_seq", sequenceName="user_no_seq", initialValue=1, allocationSize=1)
@Entity(name="users")
public class Users {
	@Id
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="no_seq")
	private Long id;	//pk
//	private int seat;
	@Column(name="user_id", length=10, nullable=false, unique=true)
	private String userId;
	
	@Column(name="user_pw", length=20, nullable=false, unique=false)
	private String userPw;
	
	@Column(length=20, nullable=false, unique=false)
	private String name;
	
	@Column(length=11, nullable=false, unique=false)
	private String phone;
	
	@Column(length=1, nullable=false, unique=false)
	private String isAdmin;
	
	@OneToMany(mappedBy = "users")
	private List<Board> boardList;
	
	@OneToMany(mappedBy="users")
	private List<Comments> commentList;
}
