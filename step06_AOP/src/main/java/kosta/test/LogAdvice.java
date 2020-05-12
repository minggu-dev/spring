package kosta.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Aspect
@Service("advice")
public class LogAdvice {
	@Around("execution(public * kosta.test.*Impl.*(..))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		Log log = LogFactory.getLog(this.getClass());
		
		StopWatch sw = new StopWatch();
		sw.start();
		
		Object obj = joinPoint.proceed();
		sw.stop();
		
		String methodName = joinPoint.getSignature().getName();
		int paramNum = joinPoint.getArgs().length;
		
		String message = methodName + "호출 / 인수 개수 : " + paramNum + "개 / 리턴 값 : " + obj + " / 총 실행 시간 : " + sw.getTotalTimeMillis() + "ms";
		log.fatal(message);
		
		return obj;
	}
}
