package kosta.mvc.user.service;

import kosta.mvc.user.domain.UserDTO;

public interface UserService {
	/**
	 * 로그인 체크
	 * */
   UserDTO loginCheck(UserDTO userDTO);
}
