package com.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @description:
 * @author: Administrator
 * @create: 2020-08-21
 **/
@RestController
@Slf4j
public class OrderConsulController {

    @Resource
    private RestTemplate restTemplate;

    //集群版
    public static final String INVOKE_URL = "http://consul-provider-payment";


    @GetMapping("consul/zk")
    public String paymentInfo(){

        String forObject = restTemplate.getForObject(INVOKE_URL + "/consul", String.class);

        return forObject;

    }

}
