package kosta.jpa.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
//@ToString(exclude="list")
public class Team {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_teamid" )
	@SequenceGenerator(sequenceName = "seq_teamid", allocationSize = 1, name="seq_teamid")
	private Long id; 
	private String teamName;
	
	@OneToMany(mappedBy = "team")
	private List<Member> list = new ArrayList<Member>();
}
