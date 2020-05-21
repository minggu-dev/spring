package kosta.mvc.repository;

import java.util.List;

import kosta.mvc.model.domain.Student;

public interface StudentDAO {
	/**
	 * Student 전체 검색
	 */
	List<Student> selectAll();
	
	/**
	 * 학번 중복체크
	 */
	Student selectByStNo(String stNo);
	
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
