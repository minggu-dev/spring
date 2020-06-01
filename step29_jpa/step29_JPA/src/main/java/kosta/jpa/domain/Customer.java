package kosta.jpa.domain;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity //테이블 생성
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {
	
	@Id //PK 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false, length=100, name="user_name")
	private String userName;
	
	//@Transient // db필드명에서 제외.
	private int age;
	
	
	private String addr;
	
	@CreationTimestamp //java.sql.date
	//@Temporal(TemporalType.TIME) // java.util.date
	private LocalDateTime regDate;
	
}
