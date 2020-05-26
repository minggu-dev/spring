package kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	@RequestMapping("/main")
	public void main() {
		System.out.println("user/main이동");
	}
	
	@RequestMapping("/login")
	public void login() {
		System.out.println("user/login이동");
	}
	
	@RequestMapping("/loginForm")
	public void loginForm() {
		System.out.println("user/loginForm이동");
	}
	
	@RequestMapping("/board")
	public void board() {
		System.out.println("user/board이동");
	}
}
