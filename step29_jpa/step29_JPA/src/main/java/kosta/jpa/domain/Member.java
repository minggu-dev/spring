package kosta.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude="team")
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO , generator = "seq_memberid")
	@SequenceGenerator(sequenceName = "seq_memberid", name ="seq_memberid", allocationSize = 1)
	private Long id;
	private String name;
	private int age;
	
	//@OneToOne //즉시로딩
	
	@ManyToOne(fetch= FetchType.LAZY)//지연로딩 //기본값 : 즉시로딩
	@JoinColumn(name = "teamId")
	private Team team;
}	

