package com.cloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description:
 * @Author: cgq
 * @Date: 2020/11/4 14:02
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfingClientMain3366 {
    public static void main(String[] args) {
        SpringApplication.run(ConfingClientMain3366.class,args);
    }
}
