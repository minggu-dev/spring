package kosta.exam;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

/**
 * 공통기능 구현 - 사전, 사후 처리 (around방식)
 * 
 * around방식 : 매개변수로 ProceedingJoinPoint 선언
 *
 */
public class TimerAdvice {
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		//사전처리
		//타겟대상의 메소드이름 구하기
		String methodName = joinPoint.getSignature().getName();
		System.out.println("[LOG] " + methodName + "호출되기 전....");
		
		//스프링에서 제공하는 타이머
		StopWatch sw = new StopWatch();
		sw.start();
		
		//실제 타켓 대상 호출(joinPoint call)
		Object obj = joinPoint.proceed();//타겟 대상이 반환하는 값을 뜻한다.
		
		//사후처리
		sw.stop();
		System.out.println("[LOG] " + methodName + "의 리턴값 = " + obj);
		System.out.println("[LOG] " + methodName + "의 총 걸린 시간 : " + sw.getTotalTimeMillis() + "ms");
		System.out.println("[LOG] " + methodName + "의 호출완료\n");
		
		return obj;
	}
}
