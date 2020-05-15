package kosta.mvc.mino.dao;

import kosta.mvc.mino.dto.UserDTO;
import kosta.mvc.mino.exception.NotFoundException;

public interface UserDAO {
	public UserDTO login (String id, String pwd) throws NotFoundException;
}
