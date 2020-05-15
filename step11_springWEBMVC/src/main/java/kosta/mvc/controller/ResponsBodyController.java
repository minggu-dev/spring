package kosta.mvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController	//이 클래스는 무조건 @ResponseBody만을 사용한다. -> 무조건 비동기화 통신만을 하게된다.   --> @Controller + @ResponseBody
public class ResponsBodyController {
	@RequestMapping(value = "/responseBody.do", produces = "text/html;charset=UTF-8")
	//@ResponseBody//리턴되는 값이 그대로 응답 객체가 된다.
	public String aa() {
		System.out.println("responseBody.do가 요청되었습니다....");
		return "점심 뭐먹? - hello?";	//페이지 이동을 하지 않고 그냥 뿌려주게 된다.
	}
	
	@RequestMapping(value = "responseBody2.do", produces = "text/html;charset=UTF-8")
	//@ResponseBody
	public String bb() {
		System.out.println("responseBody2.do 요청되었습니다...");
		return "존잼";
	}
}
