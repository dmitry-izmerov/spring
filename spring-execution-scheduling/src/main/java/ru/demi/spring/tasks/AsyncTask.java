package ru.demi.spring.tasks;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

@Component
public class AsyncTask {

    @Async
    public Future<String> runAsyncTask() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        return new AsyncResult<>("result from async task");
    }
}
