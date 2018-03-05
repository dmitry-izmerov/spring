package ru.demi.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;

import ru.demi.aop.aspects.PointCuts;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "ru.demi.aop.beans", includeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = PointCuts.class))
// OR by xml - @ImportResource("classpath:aop.xml")
public class Config {
}
