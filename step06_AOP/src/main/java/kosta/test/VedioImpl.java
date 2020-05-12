package kosta.test;

import org.springframework.stereotype.Component;

@Component("video")
public class VedioImpl implements Player {

	public void start(int volumn) {
		System.out.println("VedioImpl start(int volumn)");

	}

	public String pause() {
		System.out.println("VedioImpl pause() 호출");
		return "Vedio 리턴값!!";
	}

	public void stop() {
		System.out.println("VedioImpl stop() 호출");

	}

}
