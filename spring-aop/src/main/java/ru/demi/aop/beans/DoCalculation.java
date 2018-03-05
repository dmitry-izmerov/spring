package ru.demi.aop.beans;

import org.springframework.stereotype.Component;

@Component
public class DoCalculation {
    public int add(int a, int b) {
        return a + b;
    }

    public double divide(int a, int b) {
        return a / b;
    }
}
