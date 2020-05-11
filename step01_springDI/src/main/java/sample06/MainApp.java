package sample06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("sample06/springDIList02.xml");
		
		System.out.println("======================================================");
		ListBean list = context.getBean("listBean", ListBean.class);
		for(int i : list.getIntList()) {
			System.out.println("listBean intList : " + i);
		}
		
		for(String str : list.getStrList()) {
			System.out.println("listBean strList : " + str);
		}
		
		for(Customer c : list.getCustomerList()) {
			System.out.println("listBean customerList : id = " + c.getId() + " / addr = " + c.getAddr() + " / age = " + c.getAge());
		}
	}
}
