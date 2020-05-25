package kosta.mvc.board.domain;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
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
	
	private MultipartFile file;
}
