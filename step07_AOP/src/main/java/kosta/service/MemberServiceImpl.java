package kosta.service;

public class MemberServiceImpl implements MemberService {

	@Override
	public void register(int no, String name) throws Exception {
		System.out.println("MemberServiceImpl의 register(int no, String name) 호출");
		if(no == 0l)
			throw new Exception("예외가 발생했습니다.");
	}

	@Override
	public boolean update(String id) {
		System.out.println("MemberServiceImpl의 update(String id) 호출");
		return false;
	}

}
