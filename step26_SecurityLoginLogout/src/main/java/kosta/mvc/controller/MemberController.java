package kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {
	@RequestMapping("/main")
	public void main() {
		System.out.println("member/main 이동");
	}
	
	@RequestMapping("/myPage")
	public void myPage() {
		System.out.println("member/myPage 이동");
	}
}
