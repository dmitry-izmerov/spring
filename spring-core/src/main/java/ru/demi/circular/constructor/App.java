package ru.demi.circular.constructor;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext("ru.demi.circular.constructor");
	}
}
