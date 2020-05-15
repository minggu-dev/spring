package kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionController {
	@RequestMapping("/exception.do")
	public String exception(String no) {
		System.out.println("no = " + no);
		int converNo = Integer.parseInt(no);
		
		int result = 100/converNo;
		System.out.println("나눈 결과 : " + result);
		return "result";
	}
	
	/**
	 * 현재 Controller에서 예외가 발생하면 처리해줄 메소드
	 */
	//@ExceptionHandler(NumberFormatException.class)
	@ExceptionHandler({NumberFormatException.class, ArithmeticException.class})
	public ModelAndView error(Exception e) {
		System.out.println("예외가 났을 때 해야할 일을 합니다...");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("error/errorView");
		mv.addObject("errMsg", e.getMessage());
		mv.addObject("errInfo", e.getClass() + "에서 발생했어요.");
		return mv;
	}
}
