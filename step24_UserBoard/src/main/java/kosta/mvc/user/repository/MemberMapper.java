package kosta.mvc.user.repository;

import org.apache.ibatis.annotations.Select;

import kosta.mvc.user.domain.UserDTO;

public interface MemberMapper {
	@Select("select * from member where user_id=#{userId} and pwd=#{pwd}")
	UserDTO loginCheck(UserDTO user);
}
