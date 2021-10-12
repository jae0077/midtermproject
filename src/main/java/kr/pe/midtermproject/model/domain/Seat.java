package kr.pe.midtermproject.model.domain;

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

@Entity(name="seat")
public class Seat {
	@Id
	@Column(name = "seat_id", length = 10, nullable = false, unique = true)
	private int seatId;
	
	@Column(name = "is_used", length = 1, nullable = false, unique = false)
	private String isUsed;
}