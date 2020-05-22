package kosta.mvc.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kosta.mvc.board.domain.ElectronicsDTO;
import kosta.mvc.board.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService service;
	
	@RequestMapping("/list")
	public String url(HttpServletRequest request) {
		List<ElectronicsDTO> list = service.selectAll();
		if(list != null) {
			request.setAttribute("list", list);
		}
		return "board/list";
	}
	
	@RequestMapping("read")
	public String read(String modelNum, HttpServletRequest request) {
		boolean state = true;
		ElectronicsDTO elec = service.selectByModelNum(modelNum, state);
		request.setAttribute("elec", elec);
		return "board/read";
	}
	
}
