package ru.demi.spring.tasks;

import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

//    @Scheduled(fixedRate = 1000)
    public void runTaskWithFixedRate() throws InterruptedException {
        System.out.println("running task with fixed rate");
        TimeUnit.SECONDS.sleep(2);
    }

//    @Scheduled(fixedDelay = 1000)
    public void runTaskWithFixedDelay() throws InterruptedException {
        System.out.println("running task with fixed delay");
        TimeUnit.SECONDS.sleep(2);
    }

    @Scheduled(cron = "*/5 * * * * *")
    public void runCronTask() {
        System.out.println("running cron task");
    }
}
