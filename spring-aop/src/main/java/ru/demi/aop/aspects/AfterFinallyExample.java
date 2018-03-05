package ru.demi.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import ru.demi.aop.Config;
import ru.demi.aop.beans.ResourcesConsumableObject;

@Aspect
@Component
public class AfterFinallyExample {

    @After("execution(* ru.demi.aop.beans.ResourcesConsumableObject.doCalculation(..))")
    public void addAdviceAfter(JoinPoint jointPoint) {
        ResourcesConsumableObject target = (ResourcesConsumableObject) jointPoint.getTarget();

        // just for example
        target.unlockResources();
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class, AfterFinallyExample.class);
        ResourcesConsumableObject bean = context.getBean(ResourcesConsumableObject.class);
        bean.doCalculation(1, 1);
        bean.doCalculation(1, 0);
    }
}
