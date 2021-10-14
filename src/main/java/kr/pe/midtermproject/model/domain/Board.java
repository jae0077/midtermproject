package kr.pe.midtermproject.model.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_idx")  
	private Users writer;
	
	@Column(nullable=false)
	private String title;
	
	@Column(nullable=false)
	private String content;
	
	@Temporal(TemporalType.DATE)
	@CreationTimestamp
	@Column(nullable=false)
	private Date created;
	
	@Temporal(TemporalType.DATE)
	@UpdateTimestamp
	private Date updated;
	
	@OneToMany(mappedBy="board",
			fetch=FetchType.LAZY,
			cascade=CascadeType.ALL)
	private List<Comments> commentList;
	
	public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

	@Override
	public String toString() {
		return "Board [boardIdx=" + boardIdx + ", writer=" + writer.getUserIdx() + ", title=" + title + ", content=" + content
				+ ", created=" + created + ", updated=" + updated + "]";
	}

	
	
	
}
