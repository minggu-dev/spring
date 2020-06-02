package kosta.mvc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kosta.mvc.domain.FreeBoard;
import kosta.mvc.repository.FreeBoardRepository;

@SpringBootTest
class Step31SpringBootElecBoardJpaApplicationTests {
	@Autowired
	private FreeBoardRepository rep;
	
	@Test
	void contextLoads() {
		for(int i = 0 ; i < 100; i++) {
			rep.save(new FreeBoard(0, "제목" + i, "user"+i, "내용" + i, "1234", null, 0));
		}
	}

}
