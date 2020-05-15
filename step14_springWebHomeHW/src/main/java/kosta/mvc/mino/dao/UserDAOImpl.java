package kosta.mvc.mino.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.mvc.mino.dto.UserDTO;
import kosta.mvc.mino.exception.NotFoundException;

@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	UserDTO user;
	
	@Override
	public UserDTO login(String id, String pwd) throws NotFoundException {
		if(!(user.getId().equals(id) && user.getPwd().equals(pwd))) {
			throw new NotFoundException("아이디 혹은 비밀번호가 일치하지 않습니다.");
		}
		
		return user;
	}

}
