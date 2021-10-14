package kr.pe.midtermproject.model.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

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

@Entity
@SequenceGenerator(name="notice_idx_seq", sequenceName="notice_idx_seq", initialValue=1, allocationSize=1)
public class Notice {
	@Id
	@Column(name="notice_idx")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="notice_idx_seq")
	private Long noticeIdx;
	
	@Column(nullable=false)
	private String title;
	
	@Lob
	@Column(nullable=false)
	private String content;
	
	@CreationTimestamp
	@Column(nullable=false)
	private LocalDate created;
}
