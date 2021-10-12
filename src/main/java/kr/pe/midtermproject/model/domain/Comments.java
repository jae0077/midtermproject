package kr.pe.midtermproject.model.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
@SequenceGenerator(name = "COMMENT_SEQ_GEN", sequenceName = "COMMENT_SEQ", initialValue = 1, allocationSize = 1)
public class Comments {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "COMMENT_SEQ_GEN")
	private Long id;
	
	@Column(nullable = false)
	private Long board;
	
	@Column(nullable = false)
	private Long writer;
	
	@Column(nullable = false)
	private String content;
	
	@Temporal(TemporalType.DATE)
	@CreationTimestamp
	@Column(nullable = false)
	private Date created;
	
	@Temporal(TemporalType.DATE)
	@UpdateTimestamp
	private Date updated;
}
