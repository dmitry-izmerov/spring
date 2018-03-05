package ru.demi.aop.aspects;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import ru.demi.aop.Config;
import ru.demi.aop.beans.DoCalculation;

@Aspect
@Component
public class AfterReturningExample {

    @AfterReturning(pointcut = "execution(* ru.demi.aop.beans.DoCalculation.add(*, *))", returning = "result")
    public void addAfterReturningAdvice(int result){
        System.out.println("After returning advice.");
        System.out.printf("Caught result of method calling: %d.", result);
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class, AfterReturningExample.class);
        DoCalculation bean = context.getBean(DoCalculation.class);
        bean.add(1, 2);
    }
}
