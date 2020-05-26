package kosta.mvc.model.repository;

import java.util.List;

import kosta.mvc.model.domain.Authority;

public interface AuthoritiesDAO {

	/**
	 * 사용자 권한 등록
	 * (한 USER(아이디)가 여러개의 권한을 가질 수 있다.
	 * */
	int insertAuthority(Authority authority);
	
	/**
	 * id에 해당하는 권한 검색.
	 * */
	List<Authority> selectAuthorityByUserName(String userName);
}






