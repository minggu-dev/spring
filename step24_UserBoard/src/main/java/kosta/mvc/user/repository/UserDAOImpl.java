package kosta.mvc.user.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.mvc.user.domain.UserDTO;

@Repository
public class UserDAOImpl implements UserDAO{
	@Autowired
	private SqlSession session;
	
	@Override
	public UserDTO loginCheck(UserDTO userDTO) {
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		return mapper.loginCheck(userDTO);
	}
}
