package ru.demi.resources;

import java.io.IOException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        ResourceHandler1 handler1 = context.getBean(ResourceHandler1.class);
        ResourceHandler2 handler2 = context.getBean(ResourceHandler2.class);

        System.out.println("resource1 is available: " + handler1.isAvailable());
        System.out.println("resource2 is available: " + handler2.isAvailable());

        System.out.println("resource1 content: " + handler1.getContent());
        System.out.println("resource2 content: " + handler2.getContent());
    }
}
