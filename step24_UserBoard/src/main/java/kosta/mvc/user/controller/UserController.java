package kosta.mvc.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kosta.mvc.user.domain.UserDTO;
import kosta.mvc.user.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService service;
	
	@RequestMapping("/user/{url}")
	public String url(@PathVariable String url) {
		return "user/" + url;
	}
	
	@RequestMapping("/user/loginCheck")
	public String login(UserDTO userDTO, HttpSession session){
		UserDTO user = service.loginCheck(userDTO);
		if(user != null) {
			session.setAttribute("loginUser", user.getUserId());
			session.setAttribute("loginName", user.getName());
		}
		return "redirect:/";
	}
	
	@RequestMapping("/user/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
