package kosta.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sun.org.glassfish.gmbal.ParameterNames;

@Controller
@RequestMapping("/rem")
public class RequestMappingController {
	@RequestMapping("/a.do")
	public ModelAndView bb() {
		System.out.println("rem/a.do 요청되었습니다...");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");	//WEB-INF/views/result.jsp
		mv.addObject("message", "신기하구만");	//view에서 ${requestScope.message}로 사용
		mv.addObject("id","jang");
		
		return mv;
	}
	
	/**
	 * 여러개의 요청이 같은 메소드(Controller)를 호출
	 * 
	 * @param : Model은 뷰에 전달될 객체
	 * @return : String은 뷰의 이름이 된다.
	 */
	@RequestMapping(value = {"/b.do", "/c.do"})
	public String cc(Model model) {
		System.out.println("여러개의 요청이 같은 메소드(Controller)를 호출하기");
		
		model.addAttribute("message", "졸림?");
		model.addAttribute("id", "min");
		
		return "result";
	}
	
	/**
	 * 요청방식(get or post, put, delete)에 따라 다른 메소드 호출
	 * @return : void인 경우 요청 이름이 뷰의 이름이 된다.
	 * 			 예를들어 rem/test.do 요청되면 WEB-INF/views/rem/test.jsp이동을 한다. 
	 */
	@PostMapping("/test.do")
	public void aa(HttpServletRequest request) {
		String name = request.getParameter("name");
		System.out.println("post방식 test.do가 요청되었습니다.  name : " + name);
	}
	
	@GetMapping("/test.do")
	public void dd(String name) {
		System.out.println("get방식 test.do가 요청되었습니다.  name : " + name);
	}

	/**
	 * parameter정보에 따라 Mapping처리하기
	 */
	@RequestMapping(value = "/a.do", params = {"id!=jang"})
	public void ee() {
		System.out.println("a.do의 parameter정보에 따른 Mapping....");
	}
}
