package kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kosta.mvc.domain.TransferDTO;
import kosta.mvc.service.TransferService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TransactionController {
	private final TransferService service;
	
	@RequestMapping("/")
	public String index() {
		return "transaction";
	}
	
	@PostMapping("/transfer")
	public String transfer(TransferDTO dto) {
		service.transfer(dto);
		return "result";
	}
	
	@ExceptionHandler
	public ModelAndView error(Exception e) {
		return new ModelAndView("error", "errMessage", e.getMessage());
	}
}
