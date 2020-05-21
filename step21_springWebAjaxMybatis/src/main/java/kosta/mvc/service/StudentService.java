package kosta.mvc.service;

import java.util.List;

import kosta.mvc.model.domain.Student;

public interface StudentService {
	/**
	 * 전체검색
	 */
	List<Student> selectAll();
	
	/**
	 * 학번 중복체크
	 * @return : 만약 stNo이 존재한다면 "사용할 수 없습니다."
	 * 			 			 없다면 "사용 가능합니다."
	 */
	String stNoCheck(String stNo);
	
	/**
	 * 등록하기
	 */
	int insert(Student student);
	
	/**
	 * 수정하기
	 */
	int update(Student student);
	
	
	/**
	 * 삭제하기
	 */
	int delete(String stNo);
}
