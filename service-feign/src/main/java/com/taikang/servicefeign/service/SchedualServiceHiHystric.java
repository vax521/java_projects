package com.taikang.servicefeign.service;

import org.springframework.stereotype.Component;

@Component
public class SchedualServiceHiHystric implements ScheduledServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry,"+name;
    }
}
