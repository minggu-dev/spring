package kosta.exam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("kosta/exam/springAopContext.xml");
		
		MessageService service = context.getBean("service",MessageService.class);
		UserService userService = context.getBean("userService", UserService.class);
		
		service.korHello();
		/*
		 * System.out.println("================================");
		 * 
		 * service.engHello();
		 * 
		 * System.out.println("================================");
		 * 
		 * String result = service.hello(); System.out.println("리턴값 : " + result);
		 * 
		 * System.out.println("================================");
		 * 
		 * int re = service.hello("mino"); System.out.println("리턴값 : " + re);
		 * 
		 * System.out.println("================================"); boolean resultbool =
		 * userService.examHello(); System.out.println("리턴값 : " + resultbool);
		 * 
		 * System.out.println("================================");
		 * userService.testHello();
		 */
	}
}
