package kosta.mvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import kosta.mvc.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
	
	/**
	 * 수정
	 *  : 제목, 작정자만 변경한다.
	 */
//	@Query("update Board b set b.writer=:#{writer} where b.bno=:#{bno}")
//	@Modifying
//	void updateTest(Board board);
	
	/**
	 * 메소드 기반 쿼리 만들기 - 교재 89page 참고
	 *  : findByXxx() - select전용(조건을 좀더 다양하게 설정)
	 */
	List<Board> findByBnoGreaterThan(Long bno);
	List<Board> findByTitleEndingWith(String title);
	List<Board> findByBnoBetween(Long min, Long max);
	
	/**
	 * 삭제 deleteById, 수정 save, 등록 save  - DML
	 * => JPQL문법 사용(java의 Object를 기준으로 쿼리를 작성)
	 */
	/**
	 * 삭제
	 *  : bno가 190이상 삭제한다.
	 */
	@Query("delete Board b where b.bno>=?1")
	@Modifying
	void deleteByBno(Long bno);
}
