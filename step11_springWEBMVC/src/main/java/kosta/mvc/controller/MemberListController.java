package kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kosta.mvc.domain.MemberListDTO;

@Controller
public class MemberListController {
	@RequestMapping("/list/memberMulti.do")
	public ModelAndView setList(@ModelAttribute("listDTO")MemberListDTO list) {
		System.out.println("MemberListController의 setList(MemberListDTO list) call");
		
		return new ModelAndView("listResult", "message","오늘은 목요일...");
	}
}
