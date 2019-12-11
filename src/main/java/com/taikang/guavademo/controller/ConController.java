package com.taikang.guavademo.controller;

import com.taikang.guavademo.service.AsyncTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("con")
@EnableAsync
public class ConController implements ApplicationContextAware {
    private final static Logger logger = LoggerFactory.getLogger("ConController.class");
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
    @RequestMapping(value = "test")
    public void  test1(){

        AsyncTaskService asyncTaskService = applicationContext.getBean(AsyncTaskService.class);

        for(int i = 0; i < 10; i++){
            asyncTaskService.executeAsyncTask(i);
            asyncTaskService.executeAsyncTaskPlus(i);
        }
    }

}
