package com.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.cloud.entities.CommonResult;
import com.cloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    //集群版
    public static final String SERVICE_URL = "http://nacos-payment-provider";


    @GetMapping("/comsumer/fallback/{id}")
    @SentinelResource(value = "fallback",fallback = "handlerFallback")
    public CommonResult fallback(@PathVariable("id") Integer id){

        CommonResult result = restTemplate.getForObject(SERVICE_URL + "/payment", CommonResult.class, id);

        if (id == 4){
            throw new IllegalArgumentException("非法参数异常.......");
        }else if (result.getData() == null){
            throw new NullPointerException("空指针异常........");
        }
        return result;
    }

    public CommonResult handlerFallback(@PathVariable("id") Integer id,Throwable throwable){
        Payment payment = new Payment(id,"null");
        return new CommonResult(444,"兜底异常handlerFallback：" + throwable.getMessage(),payment);

    }

}
