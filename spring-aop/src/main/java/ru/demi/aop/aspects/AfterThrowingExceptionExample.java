package ru.demi.aop.aspects;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import ru.demi.aop.Config;
import ru.demi.aop.beans.DoCalculation;

@Aspect
@Component
public class AfterThrowingExceptionExample {

    @AfterThrowing(pointcut = "execution(* ru.demi.aop.beans.DoCalculation.divide(..))", throwing = "exception")
    public void addAdviceAfterException(ArithmeticException exception) {
        System.out.printf("You should pass correct parameters into methods, got exception: %s.%n", exception.getMessage());
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class, AfterThrowingExceptionExample.class);
        DoCalculation bean = context.getBean(DoCalculation.class);
        bean.divide(1, 0);
    }
}
