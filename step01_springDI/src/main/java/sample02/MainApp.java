package sample02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		//기존방식 : 서비스의 insert를 호출한다.
//		Member member = new Member("minho","111", 29, "수원");
//		MemberDAO memberDao = new MemberDAO();
//		
//		MemberService service = new MemberService(memberDao, member);
//		service.insert();
		
		////////////////////////////////////////////
		//SpringContainer적용
		
		ApplicationContext context = new ClassPathXmlApplicationContext("sample02/springDIConstructor.xml");
		
		System.out.println("=======================================");
		MemberService service = context.getBean("service",MemberService.class);
		service.insert();
	}

}
