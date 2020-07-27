package com.cloud.controller;

import com.cloud.entities.CommonResult;
import com.cloud.entities.Payment;
import com.cloud.service.PaymentService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("******插入结果："+result);
        if(result > 0){
            return new CommonResult(200,"success:"+serverPort,result);
        }else {
            return new CommonResult(result,"fail:"+serverPort,null);
        }
    }


    @RequestMapping("/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Integer id){
        Payment paymentById = paymentService.getPaymentById(id);
        log.info("******插入结果："+paymentById);
        if(paymentById != null){
            return new CommonResult(200,"success:"+serverPort,paymentById);
        }else {
            return new CommonResult(404,"success:"+serverPort,null);
        }
    }

}
