package kosta.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kosta.mvc.model.domain.Student;
import kosta.mvc.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService service;
	
	@RequestMapping("/select")
	public List<Student> all(){
		return service.selectAll();
	}
	
	@RequestMapping(value = "/check", produces = "text/html; charset=UTF-8")
	public String check(String stNo) {
		return service.stNoCheck(stNo);
	}
	
	@PostMapping("/insert")
	public int register(Student student) {
		return service.insert(student);
	}
	
	@PostMapping("/update")
	public int update(Student student) {
		return service.update(student);
	}
	
	@RequestMapping("/delete")
	public int delete(String stNo) {
		return service.delete(stNo);
	}
}
