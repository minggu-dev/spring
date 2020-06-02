package kosta.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kosta.mvc.domain.FreeBoard;
import kosta.mvc.service.FreeBoardService;

@Controller
public class FreeBoardController {
	@Autowired
	private FreeBoardService service;
	
	@RequestMapping("/")
	public String index() {
		return "redirect:board/list";
	}
	/**
	 * 전체 검색 - board/list.jsp
	 */
	@RequestMapping("/board/list")
	public ModelAndView list(@RequestParam(defaultValue="0") int nowPage) {
		//List<FreeBoard> list = service.selectAll();

		//페이징 처리하기
		Pageable pageable = PageRequest.of(nowPage, 10, Direction.DESC, "id");
		Page<FreeBoard> list = service.selectAll(pageable);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/list");
		mv.addObject("list", list.getContent());
		mv.addObject("totalPage", list.getSize());
		mv.addObject("nowPageNum", list.getNumber());
		return mv;
	}
	
	/**
	 * 등록폼 - board/write.jsp
	 */
	@RequestMapping("/board/{url}")
	public void url() {}
	
	/**
	 * 등록하기
	 */
	@RequestMapping("/board/insert")
	public String insert(FreeBoard board) {
		service.insert(board);
		return "redirect:list";
	}
	
	/**
	 * 상세보기 - board/read.jsp
	 */
	@RequestMapping("/board/read/{id}")
	public ModelAndView read(@PathVariable int id) {
		FreeBoard board = service.selectById(id, true);
		return new ModelAndView("board/read", "board", board);
	}
	
	/**
	 * 수정하기 폼으로
	 */
	@RequestMapping("/board/updateForm")
	public ModelAndView updateForm(Integer id) {
		FreeBoard board = service.selectById(id, false);
		return new ModelAndView("board/update","board",board);
	}
	
	/**
	 * 수정하기
	 */
	@RequestMapping("/board/update")
	public String update(FreeBoard board) {
		service.update(board);
		return "redirect:read/"+board.getId();
	}
	
	/**
	 * 삭제하기
	 */
	@RequestMapping("/board/delete")
	public String delete(FreeBoard board) {
		service.delete(board);
		return "redirect:list";
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView error(Exception err) {
		return new ModelAndView("error/errorPage","errMsg",err.getMessage());
	}
}
