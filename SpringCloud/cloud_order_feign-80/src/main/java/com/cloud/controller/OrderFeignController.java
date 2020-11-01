package com.cloud.controller;

import com.cloud.entities.CommonResult;
import com.cloud.servcie.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: Administrator
 * @create: 2020-09-07
 **/
@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/getPaymentById/{id}")
    public CommonResult get(@PathVariable("id")int id){
        return paymentFeignService.getId(id);
    }



}
