package sample01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		/*기존방식
		MessageBean bean = new MessageBeanEnImpl();
		bean.sayHello("heejung");
		
		System.out.println("=====================");
		
		bean = new MessageBeanKoImpl();
		bean.sayHello("희정");*/
		/////////////////////////
		/*
		 * SpringContainer를 이용하여 객체 lifecycle 관리
		 * (xml문서 필요(@annotation변경) - Configration MetaData)
		 * Container를 이해하기위해 생성된 것을 꺼내온것 뿐이고 DI를 사용한 것이 아니다.
		 * 
		 * -SpringContainer의 종류
		 * 1. BeanFactory : 기본 객체의 생성과 소멸 관리
		 * 
		 * 2. ApplicationContext : BeanFactory의 확장개념
		 * 						다국어 지원 메시지 처리.... 부가기능 제공
		 * 					특징 : 객체를 사전 초기화(미리생성-scope = 싱글톤패턴
		 * 							scope="prototype"으로 설정하면 지연초기화
		 * 							즉, getBean()할 때마다 새로운 객체를 생성한다.
		 * 
		 * DI개념 
		 * 	1. 생성자
		 * 		- value : primitive타입
		 * 		- ref : 객체타입
		 *  2. setXxx()
		 *  	-value
		 *  	-ref
		 * */
		ApplicationContext context = new ClassPathXmlApplicationContext("sample01/applicationContext.xml");
//		
//		MessageBean bean = context.getBean("ko", MessageBean.class);
//		bean.sayHello("민호");
//		
//		System.out.println("========================");
//		
//		bean = context.getBean("en", MessageBean.class);
//		bean.sayHello("minho");
		System.out.println("================");
		MessageBean bean1 = context.getBean("ko", MessageBean.class);
		MessageBean bean2 = context.getBean("en", MessageBean.class);
		MessageBean bean3 = context.getBean("en2", MessageBean.class);
		MessageBean bean4 = context.getBean("en2", MessageBean.class);

		System.out.println("bean1 = " + bean1);
		System.out.println("bean2 = " + bean2);
		System.out.println("bean3 = " + bean3);
		System.out.println("bean4 = " + bean4);
	}
}
