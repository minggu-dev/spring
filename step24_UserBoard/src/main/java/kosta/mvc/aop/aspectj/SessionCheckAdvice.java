package kosta.mvc.aop.aspectj;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 사전에 session유무를 체크해서 세션이 없으면 예외를 발생시킨다.
 */
@Service
@Aspect
public class SessionCheckAdvice {
	@Before("execution(public * kosta.mvc.board.controller.BoardController.*(..))")
	public void sessionCheck(JoinPoint point) {
		//세션을 구하는 또 한가지의 방법
		RequestAttributes requestAttri = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes servletReq = (ServletRequestAttributes)requestAttri;
		HttpServletRequest request = servletReq.getRequest();
		
		HttpSession session = request.getSession();
		
		//세션 구하는 방법 2(인자로 session을 넘겨준다.)
//		Object params[] = point.getArgs();
//		HttpSession session = (HttpSession)params[0];
		if(session == null || session.getAttribute("loginUser") == null) {
			throw new RuntimeException("로그인하고 이용해주세요.");
		}
	}
}
