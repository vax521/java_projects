package com.taikang.guavademo.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@Service
public interface AsyncService {
    String getTask();
}
