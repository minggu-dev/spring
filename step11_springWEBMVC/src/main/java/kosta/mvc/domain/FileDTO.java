package kosta.mvc.domain;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileDTO {
	private String name;
	private MultipartFile file;
	private long fileSize;
	private String fileName;
	private String path;
}
