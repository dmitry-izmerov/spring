package ru.demi.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class StatisticsAspect {

	private Map<Class<?>, Long> counters = new HashMap<>();

	@AfterReturning("ru.demi.aspect.LoggingAspect.allLogEventMethods()")
	public void count(JoinPoint joinPoint) {
		Class<?> clazz = joinPoint.getTarget().getClass();

		counters.putIfAbsent(clazz, 1L);
		counters.computeIfPresent(clazz, (key, oldValue) -> oldValue + 1);
	}

	public Map<Class<?>, Long> getCounters() {
		return counters;
	}
}
