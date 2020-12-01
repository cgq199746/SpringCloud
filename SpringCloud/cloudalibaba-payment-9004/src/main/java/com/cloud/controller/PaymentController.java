package com.cloud.controller;

import com.cloud.entities.CommonResult;
import com.cloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @Description:
 * @Author: cgq
 * @Date: 2020/12/1 15:38
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String port;

    public static HashMap<Integer, Payment> hashMap = new HashMap<>();

    static {
        hashMap.put(1,new Payment(1,"a"));
        hashMap.put(2,new Payment(2,"b"));
        hashMap.put(3,new Payment(3,"c"));
    }

    @GetMapping("/payment/{id}")
    public CommonResult<Payment> payment(@PathVariable("id") Integer id){
        Payment payment = hashMap.get(id);
        CommonResult<Payment> paymentCommonResult = new CommonResult<>(200, "port:" + port, payment);
        return paymentCommonResult;

    }
}
