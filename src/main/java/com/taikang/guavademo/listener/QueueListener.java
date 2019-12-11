package com.taikang.guavademo.listener;

import com.taikang.guavademo.queue.DeferredResultHolder;
import com.taikang.guavademo.queue.MockQueue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Slf4j
@Component
public class QueueListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private MockQueue mockQueue;

    @Autowired
    private DeferredResultHolder deferredResultHolder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        new Thread(()->{
            while(true){
                //判断CompleteOrder字段是否是空
                if (StringUtils.isEmpty(mockQueue.getCompleteOrder())){

                    String orderNumber = mockQueue.getCompleteOrder();

                    deferredResultHolder.getMap().get(orderNumber).setResult("place order success");

                    log.info("返回订单处理结果");

                    //将CompleteOrder设为空，表示处理成功
                    mockQueue.setCompleteOrder(null);
                }else {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
