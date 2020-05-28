package kosta.mvc.model.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kosta.mvc.model.domain.Authority;
import kosta.mvc.model.domain.Member;
import kosta.mvc.model.repository.AuthoritiesDAO;
import kosta.mvc.model.repository.MemberDAO;

/**
 * 사용자가 로그인 정보를 입력 한 후 로그인을 클릭했을 때 인증처리를 해줄 class
 */
@Service
public class MemberAuthenticationProvider implements AuthenticationProvider {
	@Autowired
	private MemberDAO memberDao;
	
	@Autowired
	private AuthoritiesDAO authoritiesDao;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// 인수로 전달된 정보에서  id를 꺼내서 DB에 있는지 체크
		Member member = memberDao.selectMemberById(authentication.getName());
		if(member == null) {
			throw new UsernameNotFoundException("아이디가 존재하지 않습니다.");
		}
		
		// 있으면 비밀번호 체크
		if(!encoder.matches(authentication.getCredentials().toString(), member.getPassword())) {
			throw new UsernameNotFoundException("비밀번호가 틀렸습니다..");
		}
		
		//모든 정보가 정확하면 인증된 사용자의 권한을 검색
		List<Authority> authorityList = authoritiesDao.selectAuthorityByUserName(member.getId());
		
		if(authorityList == null || authorityList.size() == 0) {
			throw new UsernameNotFoundException("권한 찾기 실패");
		}
		
		List<SimpleGrantedAuthority> authList = new ArrayList<>();
		
		for(Authority auth : authorityList) {
			authList.add(new SimpleGrantedAuthority(auth.getRole()));
		}
		
		//인증된 정보와 권한을 Authentication에 저장하고 리턴.
		return new UsernamePasswordAuthenticationToken(member, null, authList);
	}

	/**
	 * 인수로 전달된 authentication이 인증을 할 수 있는 유효한 객체인지를 판단하는 메소드 - true인경우 authenticate메소드가 호출된다.
	 */
	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

}
