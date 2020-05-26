package kosta.mvc.model.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.mvc.model.domain.Authority;

@Repository
public class AuthoritiesDAOImpl implements AuthoritiesDAO {
	@Autowired
	private SqlSession session;
	@Override
	public int insertAuthority(Authority authority) {
		return session.insert("authoritiesMapper.insertAuthority", authority);
	}

	@Override
	public List<Authority> selectAuthorityByUserName(String userName) {
		return session.selectList("authoritiesMapper.selectAuthorityByUserName", userName);
	}

}
