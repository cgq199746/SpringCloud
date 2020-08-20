package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//@EnableDiscoveryClient用于向使用consul或者zookeeper作为注册中心时的注册服务
@SpringBootApplication
@EnableDiscoveryClient
public class payment8004 {
    public static void main(String[] args) {
        SpringApplication.run(payment8004.class,args);
    }
}
