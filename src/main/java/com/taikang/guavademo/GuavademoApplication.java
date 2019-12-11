package com.taikang.guavademo;

import com.taikang.guavademo.config.TaskThreadPoolConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@EnableConfigurationProperties({TaskThreadPoolConfig.class} ) // 开启配置属性支持
public class GuavademoApplication {

    public static void main(String[] args) {
        SpringApplication.run(GuavademoApplication.class, args);
    }
}

