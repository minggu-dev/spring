package com.study.goods.infrastructure.order;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class OrderApiCaller {
	private final static String url_order_List = "http://localhost:8081/hello"; //Order쪽..
	private final static RestTemplate restTemplate = new RestTemplate();//Spring 3부터 지원 되었고 REST API 호출이후 응답을 받을 때까지 기다리는 동기방식이다

	public boolean isOrderAvailable() {
		try {
			restTemplate.getForObject(url_order_List, Void.class);//주어진 URL 주소로 HTTP GET 메서드로 객체로 결과를 반환받는다
			
			
			return true;
		} catch(Exception e) {
			log.warn("order 서비스가 원활하지 않습니다.");
			return false;
		}
		
	}
}
