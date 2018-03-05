package ru.demi.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Pointcut examples
 */
@Aspect
@Component
public class PointCuts {

    @Pointcut("execution(* method(..))")// the pointcut expression
    public void anyMethod() {}// the pointcut signature

    // using of bean PCD that is only supported in Spring AOP
    @Pointcut("bean(consoleLog)")
    public void beanBasedPointCut() {}

    @Pointcut("execution(public * * (..))")
    public void anyPublicMethod() {}

    @Pointcut("within(ru.demi.aop.beans..*)")
    public void inBeans() {}


    @Pointcut("anyPublicMethod() && inBeans()")
    public void beansMethods() {}


    // format of execution pointcut designator:
    // execution(modifiers-pattern? ret-type-pattern declaring-type-pattern?name-pattern(param-pattern) throws-pattern?)
}
