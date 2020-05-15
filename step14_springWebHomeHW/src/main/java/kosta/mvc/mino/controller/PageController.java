package kosta.mvc.mino.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kosta.mvc.mino.dto.UserDTO;
import kosta.mvc.mino.exception.NotFoundException;
import kosta.mvc.mino.service.UserService;

@Controller
public class PageController {
	@Autowired
	UserService service;
	
	@RequestMapping("/start.mino")
	public String aa() {
		return "index";
	}
	
	@RequestMapping("/loginForm.mino")
	public String bb() {
		return "loginForm";
	}
	
	@RequestMapping("/login.mino")
	public String cc(String id, String pwd, HttpSession session) throws NotFoundException {
		if(session.getAttribute("id") != null) {
			return "login";
		}
		UserDTO user = service.login(id, pwd);
		session.setAttribute("id", id);
		
		return "reload";
	}
	
	@RequestMapping("/logout.mino")
	public String dd(HttpSession session) {
		session.removeAttribute("id");
		return "reload";
	}
	
	@ExceptionHandler(NotFoundException.class)
	public ModelAndView dd(Exception e) {
		return new ModelAndView("error","errMessage",e.getMessage());
	}
}
