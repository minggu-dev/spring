package kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller	//생성이면서 Controller의 역할이 된다.
public class StartController {
	/**
	 * 리턴이 문자열이면 리턴값이 뷰이름이 된다.
	 * @return
	 */
	@RequestMapping("/a.do")
	public String aaa() {
		System.out.println("a.do가 요청되었습니다.....");
		return "result";	//WEB-INF/views/result.jsp로 이동하라는 의미
	}
}
