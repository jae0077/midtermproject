package kr.pe.midtermproject.model.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@Entity(name="ticket")
@SequenceGenerator(name="ticket_idx_seq", sequenceName="ticket_idx_seq", initialValue=1, allocationSize=1)
public class Ticket {
	@Id
	@Column(name="ticket_idx", nullable=false, unique=true)
	@ApiModelProperty(example="1")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ticket_idx_seq")
	private Long ticketIdx;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_idx")  
	@ApiModelProperty(example="2")
	private Users user;
	
	@Column(name="limit", nullable=false, unique=false)
	@ApiModelProperty(example="2021-10-25")
	private LocalDate limit;
}