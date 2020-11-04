package com.cloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description:
 * @Author: cgq
 * @Date: 2020/11/4 14:02
 */
@SpringBootApplication
@EnableConfigServer
public class ConfingClientMain3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfingClientMain3344.class,args);
    }
}
