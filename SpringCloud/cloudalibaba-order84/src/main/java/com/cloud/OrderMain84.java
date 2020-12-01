package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description:
 * @Author: cgq
 * @Date: 2020/12/1 16:04
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderMain84 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain84.class,args);
    }
}
