package ru.demi.aop.beans;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class ResourcesConsumableObject {

    public int doCalculation(int a, int b) {
        try {
            TimeUnit.SECONDS.sleep(2);
            return a / b;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void unlockResources() {
        // unlock
        System.out.println("unlocking resources..");
    }
}
