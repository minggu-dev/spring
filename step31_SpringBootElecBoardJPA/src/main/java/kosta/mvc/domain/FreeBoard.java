package kosta.mvc.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FreeBoard {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "free_seq_id")
	@SequenceGenerator(sequenceName = "free_seq_id", allocationSize = 1, name = "free_seq_id")
	private int id;
	private String subject;
	private String writer;
	private String content;
	private String password;
	
	@CreationTimestamp
	private LocalDateTime writeday;
	private int readnum;
}
