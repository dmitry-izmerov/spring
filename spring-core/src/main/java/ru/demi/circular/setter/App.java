package ru.demi.circular.setter;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext("ru.demi.circular.setter");
		DepA beanA = context.getBean(DepA.class);
		DepB beanB = context.getBean(DepB.class);
		System.out.println(beanA.getDepB());
		System.out.println(beanB.getDepA());
	}
}
