package kr.pe.midtermproject.model.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

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

@Entity(name="ticket")
@SequenceGenerator(name="ticket_idx_seq", sequenceName="ticket_idx_seq", initialValue=1, allocationSize=1)
public class Ticket {
	@Id
	@Column(name="ticket_idx", nullable=false, unique=true)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ticket_idx_seq")
	private Long ticketIdx;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_idx")  
	private Users user;
	
	@Column(name="limit", nullable=false, unique=false)
	private Date limit;
}