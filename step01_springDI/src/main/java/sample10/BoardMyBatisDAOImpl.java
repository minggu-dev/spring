package sample10;

import org.springframework.stereotype.Repository;

//@Component("boardMyBatisDAO")
@Repository("boardMyBatisDAO")
public class BoardMyBatisDAOImpl implements BoardDAO {
	@Override
	public void select() {
		System.out.println("BoardMyBatisDAOImpl의 select호출");
	}
}
