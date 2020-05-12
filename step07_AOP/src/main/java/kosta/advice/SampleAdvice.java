package kosta.advice;

import org.aspectj.lang.JoinPoint;

public class SampleAdvice {
	/**
	 * before : 사전처리
	 */
	public void before(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		Object[] params = joinPoint.getArgs();

		System.out.println(methodName + "에서 before의 사전처리 중 입니다.");
		System.out.println("인수의 개수 : " + params.length);
		
		for(Object param : params) {
			System.out.println("인자로 들어온 값 : " + param);
		}
		
		System.out.println(methodName + "호출되기전 before....\n");
	}
	
	
	/**
	 * after : 예외가 발생하든 안 하든 무조건 사후처리
	 */
	public void afterFinally() {
		System.out.println("afterFinally() 예외 발생여부 상관없이 호출됩니다.\n");
	}
	
	
	/**
	 * after-returning : 예외가 없이 정상적으로 동작했을 때 사후처리
	 */
	public void afterReturning(JoinPoint joinPoint, Object obj) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println(methodName + "의 리턴 값 : " + obj);
		System.out.println("afterReturning 정상동작 사후 처리 입니다....\n");
	}
	
	/**
	 * after-throwing : 예외가 발생할 때 사후처리
	 */
	public void afterThrowing(Throwable e) {
		System.out.println("afterThrowing 예외가 발생한 후 처리.... e : " + e + "\n");
	}
}
