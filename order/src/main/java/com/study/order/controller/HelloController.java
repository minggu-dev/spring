package com.study.order.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RestController
public class HelloController {

	@GetMapping(path = "/hello")
	public void hello() {
		log.info("hello checked");
	}
}
