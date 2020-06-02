package kosta.mvc.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import kosta.mvc.domain.FreeBoard;

public interface FreeBoardService {
	/**
	 * 전체검색
	 */
	List<FreeBoard> selectAll();
	
	/**
	 * 전체검색 - paging처리
	 */
	Page<FreeBoard> selectAll(Pageable pageable);
	
	/**
	 * 등록하기
	 */
	void insert(FreeBoard board);
	
	/**
	 * 글번호로 검색하기 - 조회수 증가
	 * state : true이면 조회수 증가, false이면 증가안함
	 */
	FreeBoard selectById(int id, boolean state);
	
	/**
	 * 수정하기
	 */
	void update(FreeBoard board);
	
	/**
	 * 삭제하기
	 */
	void delete(FreeBoard board);
}
