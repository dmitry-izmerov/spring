package ru.demi.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import ru.demi.aop.Config;
import ru.demi.aop.beans.DoCalculation;

@Aspect
@Component
public class AroundExample {

    @Around("execution(* ru.demi.aop.beans.DoCalculation.add(..))")
    public Object addAdviceAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long now = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        System.out.printf("Execution time is %d ms.%n", System.currentTimeMillis() - now);
        return result;
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class, AroundExample.class);
        DoCalculation bean = context.getBean(DoCalculation.class);
        bean.add(1, 0);
    }
}
