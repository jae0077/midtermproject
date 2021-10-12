package kr.pe.midtermproject.model.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	@Column(name="comment_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "COMMENT_SEQ_GEN")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="board_id")
	@Column(nullable = false)
	private Board board;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	@Column(nullable = false)
	private Users writer;
	
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
