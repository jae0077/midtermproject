package kr.pe.midtermproject.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

@Entity(name="seat")
@SequenceGenerator(name="seat_idx_seq", sequenceName="seat_idx_seq", initialValue=1, allocationSize=1)
public class Seat {
	@Id
	@Column(name="seat_idx", length=10, nullable=false, unique=true)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seat_idx_seq")
	private Long seatIdx;
	
	//좌석 true = 1, false = 0. 기본값은 true, 1
	@Column(name="is_used", length=1, nullable=false, unique=false)
	private String isUsed;
}