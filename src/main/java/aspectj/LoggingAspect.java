package aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {
	
	@Before("execution (* aspectj.Target.test*(..))")
	public void advice(JoinPoint joinPoint) {
		System.out.printf("LoggingAspect.advice() called on %s %n", joinPoint);
	}
}
