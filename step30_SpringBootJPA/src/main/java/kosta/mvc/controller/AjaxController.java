package kosta.mvc.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AjaxController {

	@RequestMapping("/test1")
	public String test1() {
		return "Spring Boot 신기하다";
	}
	
	@RequestMapping("/test2")
	public List<String> test2(){
		List<String> list = Arrays.asList(new String [] {"짬뽕", "짜장", "탕수육", "팔보채"});
		
		return list;
	}
}
