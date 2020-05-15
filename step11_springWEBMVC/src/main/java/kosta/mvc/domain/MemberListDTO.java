package kosta.mvc.domain;

import java.util.List;

public class MemberListDTO {
	private List<Member> list;

	public List<Member> getList() {
		System.out.println("getList() call..." + list);
		return list;
	}

	public void setList(List<Member> list) {
		System.out.println("setList(List<Member> list) call....	" + list);
		this.list = list;
	}
}
