package com.taikang.guavademo.task;

import com.taikang.guavademo.model.Building;

public class runnableTask implements Runnable {

    @Override
    public void run() {
        Building building = new Building();
        synchronized (building){
            try {
                for (int i = 1;i <= 100;i++){
                    System.out.println(Thread.currentThread().getName()+"----------异步：>"+i);
                    building.wait(200);
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
