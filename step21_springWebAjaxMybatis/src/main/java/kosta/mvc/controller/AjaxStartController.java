package kosta.mvc.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kosta.mvc.model.domain.Member;

@RestController
public class AjaxStartController {
	@RequestMapping(value = "/load", produces = "text/html; charset=UTF-8;")
	public String load() {
		return "Hava a nice Day - 배고파";
	}
	
	@PostMapping(value = "/ajax", produces = "text/html; charset=UTF-8;")
	public String ajax(String name) {
		return name + "님 반가워요^^";
	}

	/**
	 * jackson LIB가 있으면 응답객체가 자바의 객체 타입인 경우에 중간에 JSON형태로 자동으로 변환해서 보내버림
	 */
	@RequestMapping("/array")
	public List<String> array(){
		List<String> menus = Arrays.asList("짜장", "짬뽕", "탕수육", "짬짜면");
		
		return menus;
	}
	
	@RequestMapping("/jsonDTO")
	public Member test() {
		return new Member("kim", 22, "수원", "010-8888-7777");
	}
	
	@RequestMapping("/jsonList")
	public List<Member> list(){
		List<Member> list = new ArrayList<Member>();
		list.add(new Member("min", 20, "판교", "010-8888-8888"));
		list.add(new Member("ho", 21, "서울", "010-8888-5555"));
		list.add(new Member("이", 22, "대전", "010-8888-4444"));
		list.add(new Member("응", 23, "대구", "010-8888-3333"));
		list.add(new Member("빙", 24, "부산", "010-8888-2222"));
		list.add(new Member("구", 25, "울산", "010-8888-1111"));
		return list;
	}
	
	
	@RequestMapping("/jsonMap")
	public Map<String, Object> map(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", "점심시간 얼마 안남았다.");
		map.put("pageNum", 10);
		List<Member> list = new ArrayList<Member>();
		list.add(new Member("min", 20, "판교", "010-8888-8888"));
		list.add(new Member("ho", 21, "서울", "010-8888-5555"));
		list.add(new Member("이", 22, "대전", "010-8888-4444"));
		list.add(new Member("응", 23, "대구", "010-8888-3333"));
		list.add(new Member("빙", 24, "부산", "010-8888-2222"));
		list.add(new Member("구", 25, "울산", "010-8888-1111"));
		map.put("memberList", list);
		map.put("dto", new Member("kim", 22, "수원", "010-8888-7777"));
		return map;
	}
}
