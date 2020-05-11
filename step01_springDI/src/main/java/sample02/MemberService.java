package sample02;

public class MemberService {
	private MemberDAO memberDao;
	private Member member;
	
	public MemberService() {
		System.out.println("MemberService의 기본생성자");
	}

	public MemberService(MemberDAO memberDao, Member member) {
		System.out.println("MemberService(MemberDao memberDao, Member member)");
		this.memberDao = memberDao;
		this.member = member;
	}
	
	public void insert() {
		System.out.println("MemberService insert");
		memberDao.insert(member);
	}
	
}
