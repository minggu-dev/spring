package kosta.mvc.board.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ElectronicsDTO {
	private String modelNum;
	private String modelName;
	private int price;
	private String description;
	private String password;
	private String writeday;
	private int readnum;
	private String fname;
	private int fsize;
}
