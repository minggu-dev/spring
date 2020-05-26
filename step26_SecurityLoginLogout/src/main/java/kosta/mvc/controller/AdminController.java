package kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@RequestMapping("/main")
	public void main() {
		System.out.println("admin/main이동");
	}
	
	@RequestMapping("/board")
	public void board() {
		System.out.println("admin/board이동");
	}
}
