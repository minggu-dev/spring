package kosta.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteController implements Controller {

	@Override
	public ModelAndView handlerRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		System.out.println("DeleteController 요청 되었습니다...");
		
		request.setAttribute("message", "Delete의 결과 입니다.");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("deleteResult.jsp");
		return mv;
	}

}
