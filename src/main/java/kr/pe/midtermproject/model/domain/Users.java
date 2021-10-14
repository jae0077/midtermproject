package kr.pe.midtermproject.model.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@SequenceGenerator(name="users_idx_seq", sequenceName="users_idx_seq", initialValue=1, allocationSize=1)
@Entity(name="users")
public class Users {

	@Id
	@Column(name="user_idx")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="users_idx_seq")
	private Long userIdx;
	
	@Column(name="user_id", length=10, nullable=false, unique=true)
	private String userId;
	
	@Column(name="user_pw", length=20, nullable=false, unique=false)
	private String userPw;
	
	@Column(name="name", length=20, nullable=false, unique=false)
	private String name;
	
	@Column(name="phone", length=11, nullable=false, unique=false)
	private String phone;
	
	@Column(name="is_admin", length=1, nullable=false, unique=false)
	private String isAdmin;
	
	@OneToOne
	@JoinColumn(name="seat_idx", nullable=true)
	private Seat seat;
	
//	@OneToOne
//	@JoinColumn(name="ticket_idx", nullable=true)
//	private Ticket ticket;
	
//	@OneToMany(mappedBy="users",
//			fetch=FetchType.LAZY,
//			cascade=CascadeType.ALL)
//	private List<Ticket> ticketList;
	
	@JsonIgnore
	@OneToMany(mappedBy="writer",
			fetch=FetchType.LAZY,
			cascade=CascadeType.ALL)
	private List<Board> boardList;
	
	@JsonIgnore
	@OneToMany(mappedBy="writer",
			fetch=FetchType.LAZY,
			cascade=CascadeType.ALL)
	private List<Comments> commentList;
	
}
