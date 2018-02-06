package ru.demi.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

	private static final Logger LOG = Logger.getLogger(LoggingAspect.class.getSimpleName());

	@Pointcut("execution(* *.logEvent(..))")
	public void allLogEventMethods(){/*NOP*/}

	@Before("allLogEventMethods()")
	public void logBefore(JoinPoint joinPoint) {
		String className = joinPoint.getTarget().getClass().getSimpleName();
		String methodName = joinPoint.getSignature().getName();
		LOG.log(Level.INFO, "BEFORE: {0} {1}", new Object[]{className, methodName});
	}

	@AfterReturning(pointcut = "allLogEventMethods()", returning = "result")
	public void logAfter(Object result) {
		LOG.log(Level.INFO, "Returned value: {0}", result);
	}

	@AfterThrowing(pointcut = "allLogEventMethods()", throwing = "ex")
	public void logAfterThrown(Throwable ex) {
		LOG.log(Level.INFO, "Thrown: %s", ex);
	}
}
