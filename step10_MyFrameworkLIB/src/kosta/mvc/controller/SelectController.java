package kosta.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class SelectController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		System.out.println("SelectController 요청 되었습니다...");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("selectResult");
		mv.addObject("message", "Select의 결과 입니다.");	
		return mv;
	}
}
