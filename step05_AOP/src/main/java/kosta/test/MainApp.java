package kosta.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("kosta/test/applicationContext.xml");

		Player p1 = context.getBean("tv", Player.class);
		Player p2 = context.getBean("audio", Player.class);
		Player p3 = context.getBean("video", Player.class);

		p1.start(5);
		p1.pause();
		p1.stop();
		System.out.println("====================");
		
		p2.start(5);
		p2.pause();
		p2.stop();
		System.out.println("====================");
		
		p3.start(5);
		p3.pause();
		p3.stop();
	}
}
