package kr.pe.midtermproject.model.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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
public class Ticket {
	@Id
	@Column(name = "ticket_id", nullable = false, unique = true)
	private Long ticketId;
	
//	@Column(name = "user", length = 10, nullable = false, unique = false)  
//	private int user;
	
	@Column(name = "limit", nullable = false, unique = false)
	private Date limit;
	
	@Column(name = "price", nullable = false, unique = false)
	private int price;
}
