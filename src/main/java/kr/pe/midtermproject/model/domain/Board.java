package kr.pe.midtermproject.model.domain;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@Entity
@SequenceGenerator(name="board_idx_seq", sequenceName="board_idx_seq", initialValue=1, allocationSize=1)
public class Board {

	@Id
	@Column(name="board_idx")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="board_idx_seq")
	private Long boardIdx;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_idx")
	private Users writer;

	@Column(nullable=false)
	private String title;

	@Lob
	@Column(nullable=false)
	private String content;
	
	@CreationTimestamp
	@Column(nullable=false)
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm")
//	private LocalDate created;
	private Date created;

	@UpdateTimestamp
	@Column(nullable=false)
//	private LocalDate updated;
	private Date updated;
	
	@JsonIgnore
	@OneToMany(mappedBy="board",
			fetch=FetchType.LAZY,
			cascade=CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Comments> commentList;
	
	@Override
	public String toString() {
		return "Board [boardIdx=" + boardIdx + ", writer=" + writer.getUserId() + ", title=" + title + ", content=" + content
				+ ", created=" + created + ", updated=" + updated + "]";
	}
	
}
