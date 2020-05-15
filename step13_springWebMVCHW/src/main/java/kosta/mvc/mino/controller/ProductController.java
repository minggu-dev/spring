package kosta.mvc.mino.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kosta.mvc.mino.domain.ProductDTO;
import kosta.mvc.mino.exception.DuplicatedException;
import kosta.mvc.mino.exception.PriceRangeException;
import kosta.mvc.mino.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService service;
	
	@RequestMapping("start.kosta")
	public ModelAndView aa() {
		List<ProductDTO> list = service.select(); 
		ModelAndView mv = new ModelAndView("productList","list",list);
		return mv;
	}
	
	@RequestMapping("insertForm.kosta")
	public String url() {
		return "insertForm";
	}
	
	@RequestMapping("insert.kosta")
	public ModelAndView bb(ProductDTO productDTO) throws DuplicatedException, PriceRangeException {
		service.insert(productDTO);	
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:start.kosta");
		return mv;
	}
	
	@ExceptionHandler({NumberFormatException.class,DuplicatedException.class, PriceRangeException.class})
	public ModelAndView er(Exception e) {
		ModelAndView mv = new ModelAndView("error","errMessage",e.getMessage());
		return mv;
	}
	
	@PostMapping("/{code}")
	public ModelAndView del(@PathVariable String code) {
		service.delete(code);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:../start.kosta");
		return mv;
	}
	
	@RequestMapping("read.kosta")
	public ModelAndView ggg(String code) throws DuplicatedException{
		ProductDTO product = service.detail(code);
		return new ModelAndView("read","product",product);
	}
}
