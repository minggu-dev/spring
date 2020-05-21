package kosta.mvc.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SuggestDAOImpl implements SuggestDAO {
	@Autowired
	private SqlSession session;
	
	@Override
	public List<String> suggest(String word) {
		List<String> list = session.selectList("suggestMapper.suggestSelect", word);
		return list;
	}

}
