package sample02;

public class MemberDAO {
	public MemberDAO() {
		System.out.println("MemberDAO ");
	}
	public void insert(Member m) {
		System.out.println("MemberDao의 insert");
		System.out.println(m);
	}
}
