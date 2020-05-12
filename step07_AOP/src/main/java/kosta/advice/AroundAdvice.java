package kosta.advice;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundAdvice {
	/**
	 * 사전, 사후처리
	 * 
	 * @return
	 * @throws Throwable 
	 */
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		//사전처리
		String methodName = joinPoint.getSignature().getName();
		System.out.println(methodName + "에서 around의 사전처리 중입니다....\n");
		
		Object obj = joinPoint.proceed();
		//사후처리
		System.out.println(methodName + "에서 around의 사후처리 중입니다....\n");
		
		return obj;
	}
}
