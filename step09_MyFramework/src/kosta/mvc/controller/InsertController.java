package kosta.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertController implements Controller {

	@Override
	public ModelAndView handlerRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		System.out.println("InsertController 요청 되었습니다...");
		
		request.setAttribute("message", "Insert의 결과 입니다.");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("insertResult.jsp");
		return mv;
	}

}
