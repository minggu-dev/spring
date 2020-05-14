package kosta.mvc.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Board {
	private int no;
	private String subject;
	private String content;
	private String date;
	private String writer;
}
