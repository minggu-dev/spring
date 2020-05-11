package sample10;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Component
@Service
public class BoardServiceImpl implements BoardService {
	@Resource(name="boardDAOImpl")
	private BoardDAO boardDao;
	
	@Autowired
	private BoardDAO boardMyBatisDAO;
	
	@Override
	public void select() {
		System.out.println("BoardServiceImpl의 select호출됨");
		
		boardDao.select();
		boardMyBatisDAO.select();
	}

}
