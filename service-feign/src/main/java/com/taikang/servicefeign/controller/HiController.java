package com.taikang.servicefeign.controller;

import com.taikang.servicefeign.service.ScheduledServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {
    @Autowired
    ScheduledServiceHi scheduledServiceHi;

    @GetMapping(value = "/hi")
    public String sayHi(String name){
        return scheduledServiceHi.sayHiFromClientOne(name);
    }
}
