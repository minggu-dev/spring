package kosta.mvc.model.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kosta.mvc.model.domain.Member;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MemberDAOImpl implements MemberDAO {
	private final SqlSession session;
	
	@Override
	public int insertMember(Member member) {
		return session.insert("memberMapper.insertMember", member);
	}

	@Override
	public Member selectMemberById(String id) {
		return session.selectOne("memberMapper.selectMemberById",id);
	}

}
