package sample10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

//@Component("controller")
@Controller("controller")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private BoardDTO dto1;
	
	@Autowired
	private BoardDTO dto2;
	
	public void test() {
		System.out.println("BoardController의 test호출");
		System.out.println("BoardDTO : " + dto1);
		System.out.println("BoardDTO2 : " + dto2);
		boardService.select();
	}
}
