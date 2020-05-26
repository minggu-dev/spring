package kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {
	@RequestMapping("/user.kosta")
	public void user() {
		System.out.println("user.kosta 요청되었습니다.");
	}
	
	@RequestMapping("/admin.kosta")
	public void admin() {
		System.out.println("admin.kosta 요청되었습니다.");
	}
	
	@RequestMapping("/guest.kosta")
	public void guest() {
		System.out.println("guest.kosta 요청되었습니다.");
	}
}
