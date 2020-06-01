package kosta.mvc;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import kosta.mvc.domain.Board;
import kosta.mvc.repository.BoardRepository;

@SpringBootTest
@Transactional
@Commit
class BoardRepositoryTests {
	@Autowired
	private BoardRepository rep;
	
	/**
	 * 등록
	 */
	@Test
	public void insert() {
		System.out.println("insert.......");
		for(int i = 0; i <= 200; i++) {
			rep.save(new Board(null, "제목" + i, "user" + i, "springJPA" + i, null));
		}
	}
	
	/**
	 * 전체 검색
	 */
	@Test
	public void selectAll() {
		List<Board> list = rep.findAll();
//		for(Board b : list) {
//			System.out.println(b);
//		}
		list.forEach(b->System.out.println(b));
	}
	
	/**
	 * 글번호에 해당하는 검색
	 */
	@Test
	public void find() {
		Board board = rep.findById(20L).orElse(null);
		System.out.println(board);
	}
	
	
	/**
	 * 삭제....
	 */
	@Test
	public void delete() {
		rep.deleteById(21L);
	}
	
	/**
	 * 수정하기
	 */
	@Test
	public void update() {
		Board board = rep.findById(30L).orElse(null);
		if(board != null) {
			board.setContent("집에 가고싶다.");
			board.setTitle("내일 안와야겠다.");
			rep.save(board);
		}
	}
	
	/**
	 * JPQL문법....
	 */
	@Test
	public void del() {
		rep.deleteByBno(190L);
		//rep.updateTest(new Board(190L, null, "가능?", null, null));
	}
	
	/**
	 * 메소드 기반 쿼리
	 */
	@Test
	public void findTest() {
		//bno보다 큰 레코드 검색하기
		List<Board> list = rep.findByBnoGreaterThan(790L);
		list.forEach(b->System.out.println(b));
	}
	
	@Test
	public void findTest2() {
		List<Board> list = rep.findByTitleEndingWith("19");
		list.forEach(b->System.out.println(b));
	}

	@Test
	public void findTest3() {
		List<Board> list = rep.findByBnoBetween(50L, 60L);
		list.forEach(b->System.out.println(b));
	}
	
	
	/**
	 * 페이징 처리하기
	 */
	@Test
	public void page() {
		Pageable page = PageRequest.of(0, 10);
		Page<Board> pageList = rep.findAll(page);
		
		pageList.getContent().forEach(b->System.out.println(b));
		
		System.out.println("getNumber : " + pageList.getNumber());
		System.out.println("getSize : " + pageList.getSize());
	}
}
