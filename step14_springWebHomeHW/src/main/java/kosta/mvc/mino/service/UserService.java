package kosta.mvc.mino.service;

import kosta.mvc.mino.dto.UserDTO;
import kosta.mvc.mino.exception.NotFoundException;

public interface UserService {
	public UserDTO login(String id, String pwd) throws NotFoundException;
}
