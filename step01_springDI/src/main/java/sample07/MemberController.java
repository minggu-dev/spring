package sample07;

public class MemberController {
	private Member member;

	private Member member2;
	public void setMember(Member member) {
		this.member = member;
		System.out.println("memberController의 setMember(Member member)호출 member = " + member);
	}
	
	public MemberController() {
		System.out.println("MemberController의 기본생성자 호출");
	}
	

	public MemberController(Member m) {
		this.member = m;
		System.out.println("MemberController(Member member) 호출 : member = " + m);
	}
	
	public MemberController(Member m, Member m2) {
		this.member = m;
		this.member2 = m2;
		System.out.println("MemberController(Member member, Member member2) 호출");
		System.out.println("member : " + m);
		System.out.println("member2 : " + m2);
	}

	public void setMember2(Member member2) {
		this.member2 = member2;
		System.out.println("memberController의 setMember2(Member member2)호출 member2 = " + member2);
	}
}
