package ru.demi.spring;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ru.demi.spring.tasks.AsyncTask;

public class App {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        AsyncTask asyncTask = context.getBean(AsyncTask.class);
        Future<String> future = asyncTask.runAsyncTask();
        System.out.println(future.get());

        Scanner scanner = new Scanner(System.in);
        while (!"stop".equalsIgnoreCase(scanner.next())){}

        System.out.println("Program finished.");
        System.exit(0);
    }
}
