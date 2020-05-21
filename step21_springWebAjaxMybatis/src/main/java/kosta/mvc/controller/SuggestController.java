package kosta.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kosta.mvc.service.SuggestService;

@RestController
public class SuggestController {
	@Autowired
	private SuggestService service;
	
	/**
	 * jackson lib가 있기 때문에 리턴되는 List객체를 json으로 변환하여 응답한다.
	 * */
	@RequestMapping("/suggest")
	public List<String> suggest(String word){
		return service.suggest(word);
	}
}
