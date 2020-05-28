package kosta.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kosta.mvc.model.domain.Member;
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
	public void joinForm() {}
	
	@PostMapping("member/join")
	public String join(Member member) {
		service.joinMember(member);
		return "member/joinSuccess";
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView error(Exception e) {
		return new ModelAndView("error/errorMessage", "errMsg", e.getMessage());
	}
	
	/**
	 * 로그인 폼
	 */
	@RequestMapping("/member/loginForm")
	public void loginForm() {}
	
	/**
	 * 회원/main
	 */
	@RequestMapping("/member/main")
	public void memberMain() {}
	
	/**
	 * 관리자/main
	 */
	@RequestMapping("/admin/main")
	public void adminMain() {}
	
	
}
