package kosta.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import kosta.mvc.domain.FreeBoard;

public interface FreeBoardRepository extends JpaRepository<FreeBoard, Integer> {
	/**
	 * 글번호에 해당하는 조회수 증가시키기
	 */
	@Query("update FreeBoard b set b.readnum = b.readnum + 1 where b.id = ?1")
	@Modifying
	int increaseNum(int id);
}
