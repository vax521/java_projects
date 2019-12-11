package com.taikang.guavademo.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AsyncTask {
    // myTaskAsynPool即配置线程池的方法名，此处如果不写自定义线程池的方法名，会使用默认的线程池
//    @Async("myTaskAsyncPool")
//    public void doTask1(int i) throws InterruptedException{
//        Thread.sleep(1000);
//        log.info("Task"+i+" started.");
//    }
    @Async
    public void doTask2(int i) throws InterruptedException{
        Thread.sleep(1000);
        log.info("Task "+i+" started.");
    }
}
