package kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PathvariableController {
	@RequestMapping(value = "{type}/{id}.do")
	public String aa(@PathVariable String type,@PathVariable String id) {
		System.out.println("PathvariableController 실행");
		System.out.println("type = " + type);
		System.out.println("id = " + id);
		return "result";
	}
	
	/**
	 *   /blog/*설정
	 */
	@RequestMapping(value = "/{id}")
	public String bb(@PathVariable String id) {
		System.out.println("blog/" + id + " 요청 되었습니다.");
		return "result";
	}
	
	@RequestMapping("/{board}/{type}/{page}")
	public String cc(@PathVariable("type") String typeName, @PathVariable String page) {
		System.out.println(typeName + "게시판의 " + page + "페이지");
		return "result";
	}
	
	/**
	 *	들어온 주소(url)이 view의 이름이 된다.
	 */
	@RequestMapping("{url}.do")
	public void url() {}
}
