package kosta.mvc.mino.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosta.mvc.mino.dao.UserDAO;
import kosta.mvc.mino.dto.UserDTO;
import kosta.mvc.mino.exception.NotFoundException;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDAO dao;
	
	@Override
	public UserDTO login(String id, String pwd) throws NotFoundException {
		UserDTO user = dao.login(id, pwd);
		return user;
	}

}
