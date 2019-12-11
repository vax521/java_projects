package com.taikang.guavademo.task;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AsyncTaskTest {
    @Autowired
    private AsyncTask asyncTask;
    @Test
    public void doTask1() throws InterruptedException {

        for(int i=0;i<1000;i++){
            asyncTask.doTask2(i);
        }
      log.info("All tasks finished!");
    }
}