package sample10;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")//지연 초기화
public class BoardDTO {
	@Value("10")
	private int no;
	
	@Value("spring")
	private String subject;
	
	@Value("신기하고 재밌다.")
	private String content;
	
	public BoardDTO() {
		super();
	}
	
	public BoardDTO(int no, String subject, String content) {
		super();
		this.no = no;
		this.subject = subject;
		this.content = content;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
