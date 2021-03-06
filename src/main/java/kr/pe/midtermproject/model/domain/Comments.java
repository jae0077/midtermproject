package kr.pe.midtermproject.model.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

@Entity
@SequenceGenerator(name="comment_idx_seq", sequenceName="comment_idx_seq", initialValue=1, allocationSize=1)
public class Comments {
	@Id
	@Column(name="comment_idx")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="comment_idx_seq")
	@ApiModelProperty(example="3")
	private Long commentIdx;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="board_idx")
	private Board board;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_idx")  
	private Users writer;
	
	@Lob
	@Column(nullable=false)
	@ApiModelProperty(example="댓글 Text")
	private String content;
	
	@UpdateTimestamp
	@Column(nullable=false)
	@ApiModelProperty(example="2021-10-19 11:24")
	private LocalDate created;
	
}
