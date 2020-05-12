package kosta.service;

public interface MemberService {
	void register(int no, String name) throws Exception;
	boolean update(String id);
}
