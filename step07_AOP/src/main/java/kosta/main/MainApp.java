package kosta.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kosta.service.MemberService;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("kosta/main/applicationContext.xml");
		
		MemberService service = context.getBean("service", MemberService.class);
		try {
			service.register(0, "dd");
		} catch (Exception e) {
			//e.printStackTrace();
		}
		System.out.println("=============================================================");
		
		boolean re = service.update("rka");
		System.out.println("리턴값 : " + re);
	}
}
