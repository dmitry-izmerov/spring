package ru.demi.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import ru.demi.aop.Config;
import ru.demi.aop.beans.ConsoleLog;

@Aspect
@Component
public class BeforeExample {

//    @Before("ru.demi.aop.aspects.PointCuts.beansMethods()")
    @Before("execution(* ru.demi.aop.beans.*.*(..))")
    public void addBeforeAdvice() {
        System.out.println("Before advice.");
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class, BeforeExample.class);
        ConsoleLog log = context.getBean(ConsoleLog.class);
        log.print("method calling..");
    }
}
