package kosta.exam;

import org.springframework.stereotype.Service;

@Service("service")
public class MessageServiceImpl implements MessageService {

	@Override
	public void korHello() {
		// 핵심로직
		System.out.println("MessageServiceImpl의 korHello()메소드 핵심기능입니다.");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("*******************");
		//현재 ProxyServer를 구해서 호출한다.
		//MessageService service = (MessageService)AopContext.currentProxy();
		//service.engHello();
		//this.engHello(); 이렇게하면 aop적용 안 받음
		System.out.println("*******************");

	}

	@Override
	public void engHello() {
		// 핵심로직
		System.out.println("MessageServiceImpl의 engHello()메소드 핵심기능입니다.");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String hello() {
		// 핵심로직
		System.out.println("MessageServiceImpl의 hello()메소드 핵심기능입니다.");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "배고프다.";
	}

	@Override
	public int hello(String name) {
		// 핵심로직
		System.out.println("MessageServiceImpl의 hello(String name)메소드 핵심기능입니다.");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return 50;
	}

}
