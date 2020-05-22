package kosta.mvc.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosta.mvc.user.domain.UserDTO;
import kosta.mvc.user.repository.UserDAO;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO dao;
	
	@Override
	public UserDTO loginCheck(UserDTO userDTO) {
		return dao.loginCheck(userDTO);
	}
}
