package kosta.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kosta.mvc.domain.Board;

@Controller
public class BoardController {
	@Autowired
	private List<Board> list = new ArrayList<Board>();
	
	/*아래로 변경
	@RequestMapping("list.kosta")
	public ModelAndView aa() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("list");
		mv.addObject("list",list);
		return mv;
	}*/

	@RequestMapping(value = "list.kosta")
	public void aa(Model model) {
		model.addAttribute("list", list);
	}
	
	@RequestMapping("insertForm.kosta")
	public String bb() {
		return "registerForm";
	}
	
	@PostMapping("insert.kosta")
	public ModelAndView cc(Board board) {
		ModelAndView mv = new ModelAndView();
		list.add(board);
		mv.setViewName("redirect:list.kosta");
		return mv;
	}
	
	@RequestMapping("delete.kosta")
	public ModelAndView dd(String board) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).toString().equals(board)) {
				list.remove(i);
				break;
			}
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:list.kosta");
		return mv;
	}
	
	@RequestMapping("/read.kosta")
	public ModelAndView ee(String board) {
		Board b = null;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).toString().equals(board)) {
				b = list.get(i);
			}
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("read");
		mv.addObject("board",b);
		
		return mv;
	}
	
	@RequestMapping("{url}.kosta")
	public void url() {}
}
