package com.taikang.guavademo.controller;

import com.taikang.guavademo.queue.DeferredResultHolder;
import com.taikang.guavademo.queue.MockQueue;
import com.taikang.guavademo.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Random;
import java.util.concurrent.Callable;

@RestController
@RequestMapping("async")
@EnableAsync
@Slf4j
public class AsyncController {

    @Autowired
    private AsyncService asyncService;
    //注入模拟消息队列类
    @Autowired
    private MockQueue mockQueue;
    @Autowired
    private DeferredResultHolder deferredResultHolder;


    @RequestMapping("")
    public String test(){
        asyncService.getTask();
        log.info("============>"+Thread.currentThread().getName());
        return "异步处理中===》";
    }
    /**
     * 单线程测试
     * @return
     * @throws InterruptedException
     */
    @RequestMapping("/order")
    public String order() throws InterruptedException {
        log.info("主线程开始");
        Thread.sleep(1000);
        log.info("主线程返回");
        return "success";
    }

    @RequestMapping("/orderAysnc")
    public Callable orderAsync(){
        log.info("主线程开始！");
        Callable result  = new Callable() {
            @Override
            public Object call() throws Exception {
                log.info("副线程开始！");
                Thread.sleep(5000);
                log.info("副线程结束！");
                return "副线程success!";
            }
        };
        log.info("主线程退出！");
        return result;
    }

    @RequestMapping("/orderMockQueue")
    public DeferredResult orderQueue() throws InterruptedException {
        log.info("主线程开始");
        Random random = new Random();
        //随机生成8位数
        String orderNumber = String.valueOf(random.nextInt(5000000));
        mockQueue.setPlaceOrder(orderNumber);

        DeferredResult result = new DeferredResult();
        deferredResultHolder.getMap().put(orderNumber,result);
        Thread.sleep(1000);
        log.info("主线程返回");
        return result;
    }

}
