package sample09;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("sample09/springDIAnnotation.xml");
		
		System.out.println("=====================");
		EmpController controller = context.getBean("control", EmpController.class);
		controller.test();
		
		System.out.println("==========================");
		ResourceBean bean = context.getBean("resourceBean", ResourceBean.class);
		bean.test();
	}
}
