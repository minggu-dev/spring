package sample10;

import org.springframework.stereotype.Repository;

//@Component	//<bean class="~~~"/>을 대신한다., id는 자동으로 클래스의 이름을 그대로 따오고 첫 글자는 소문자로 해서 가져온다. boardDAOImpl
@Repository
public class BoardDAOImpl implements BoardDAO {
	@Override
	public void select() {
		System.out.println("BoardDAOImpl의 select호출");
	}
}
