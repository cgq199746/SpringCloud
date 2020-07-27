package com.cloud.controller;

import com.cloud.entities.CommonResult;
import com.cloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    //单机版
    //public static final String PAYMENT_URL = "http://localhost:8001";

    //集群版
    public static final String PAYMENT_URL = "http://CGQ-CLOUD-PAYMENT-SERVCIE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/create",payment,CommonResult.class);
    }


    @GetMapping("/consumer/getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Integer id){
        return restTemplate.getForObject(PAYMENT_URL+"/getPaymentById/"+id,CommonResult.class);
    }

}
