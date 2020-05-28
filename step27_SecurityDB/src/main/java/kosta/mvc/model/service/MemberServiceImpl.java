package kosta.mvc.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kosta.mvc.model.domain.Authority;
import kosta.mvc.model.domain.Member;
import kosta.mvc.model.repository.AuthoritiesDAO;
import kosta.mvc.model.repository.MemberDAO;
import kosta.mvc.util.Constants;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDAO memberDao;
	@Autowired
	private AuthoritiesDAO authoritiesDao;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	@Transactional
	public int joinMember(Member member) {
		//가입하기전에 평문을 암호화해서 등록
		member.setPassword(passwordEncoder.encode(member.getPassword()));
		int result = memberDao.insertMember(member);
		//insert는 sql문이 오류가 있지 않는 이상 오류 발생할일이 없기 때문에 오류처리 따로 안해줘도 된다. --> 근데 해주시네.. 나도 하자 그냥
		if(result == 0) {
			throw new RuntimeException("가입 실패");
		}
		
		//가입이 성공하면 권한 부여...
		if(member.getUserType() == null) {
			throw new RuntimeException("userType오류");
		}
		
		if(Constants.ROLE_ADMIN.equals(member.getUserType())) {
			result = authoritiesDao.insertAuthority(new Authority(member.getId(), member.getUserType()));
			if(result == 0) {
				throw new RuntimeException("권한부여 실패(admin)");
			}
		}
		result = authoritiesDao.insertAuthority(new Authority(member.getId(), Constants.ROLE_USER));
		if(result == 0) {
			throw new RuntimeException("권한부여 실패(user)");
		}
		return result;
	}

}
