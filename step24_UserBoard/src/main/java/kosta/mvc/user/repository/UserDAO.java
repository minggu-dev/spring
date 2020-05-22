package kosta.mvc.user.repository;

import kosta.mvc.user.domain.UserDTO;

public interface UserDAO {
  /**
   * 로그인 기능
   * */
	UserDTO loginCheck(UserDTO userDTO);
}
