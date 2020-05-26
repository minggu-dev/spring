package kosta.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kosta.mvc.model.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService service;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("member/joinForm")
	public void join() {}
}
