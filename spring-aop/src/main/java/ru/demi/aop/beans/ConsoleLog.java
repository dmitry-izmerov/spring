package ru.demi.aop.beans;

import org.springframework.stereotype.Component;

@Component
public class ConsoleLog {
    public void print(String text) {
        System.out.println(text);
    }
}
